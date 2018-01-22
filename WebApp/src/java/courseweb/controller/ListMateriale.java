package courseweb.controller;


import courseweb.controller.data.DataLayerException;
import courseweb.controller.security.SecurityLayer;
import courseweb.model.interfacce.IgwDataLayer;
import courseweb.model.interfacce.Materiale;
import courseweb.view.FailureResult;
import courseweb.view.TemplateManagerException;
import courseweb.view.TemplateResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Toni & Tony
 */
public class ListMateriale extends BaseController {

    private void action_error(HttpServletRequest request, HttpServletResponse response) {
        if (request.getAttribute("exception") != null) {
            (new FailureResult(getServletContext())).activate((Exception) request.getAttribute("exception"), request, response);
        } else {
            (new FailureResult(getServletContext())).activate((String) request.getAttribute("message"), request, response);
        }
    }

    private void action_default(HttpServletRequest request, HttpServletResponse response,int id, String lingua) throws IOException, ServletException, TemplateManagerException {
        try {
            List<Materiale> mat=((IgwDataLayer)request.getAttribute("datalayer")).getMaterialeCorso(id);
            List<Integer> pesi=new ArrayList();
            File file;
            
            Iterator<Materiale> itr=mat.iterator();
            Materiale m;
            String relativePath = getServletContext().getRealPath("");
            String filePath;
            while (itr.hasNext()){
                m=itr.next();
                filePath=relativePath+"/"+m.getLink();
                file=new File(filePath);
                pesi.add((int)(file.length()/1024));
            }
            Map<Materiale,Integer> materiale=new HashMap();
            Iterator<Materiale> itrm=mat.iterator();
            Iterator<Integer> itrp=pesi.iterator();
            while(itrm.hasNext())
                materiale.put(itrm.next(), itrp.next());
            
            TemplateResult res = new TemplateResult(getServletContext());
            request.setAttribute("page_title", "Lista Materiale");
            request.setAttribute("materiale", materiale);
            request.setAttribute("corso",((IgwDataLayer)request.getAttribute("datalayer")).getCorso(id));
            
            //request.setAttribute("pesofile",pesi);
            
            request.setAttribute("servlet","listmateriale?k="+id+"&");
            if(lingua.equals("it")||lingua.equals("")){
                request.setAttribute("lingua","it"); 
            }
            else{
                request.setAttribute("lingua","en");
            }
            res.activate("materiale.ftl.html", request, response);
        } catch (DataLayerException ex) {
            request.setAttribute("message", "Data access exception: " + ex.getMessage());
            action_error(request, response);
        }
    }

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {

        int k;
        String lin;
        try {
            if(request.getParameter("lin")==null)
                lin="it";
            else
                lin=request.getParameter("lin");
            k = SecurityLayer.checkNumeric(request.getParameter("k"));
            action_default(request, response, k, lin);
    
        } catch (NumberFormatException ex) {
            request.setAttribute("message", "Course key not specified");
            action_error(request, response);
        } catch (IOException | TemplateManagerException ex) {
            request.setAttribute("exception", ex);
            action_error(request, response);
               
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Main Login servlet";
    }// </editor-fold>

}
