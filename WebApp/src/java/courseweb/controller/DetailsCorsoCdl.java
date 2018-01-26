package courseweb.controller;

import courseweb.controller.data.DataLayerException;
import courseweb.controller.security.SecurityLayer;
import courseweb.model.interfacce.CDL;
import courseweb.model.interfacce.Corso;
import courseweb.model.interfacce.Descrizione_it;
import courseweb.model.interfacce.Dublino_it;
import courseweb.model.interfacce.IgwDataLayer;
import courseweb.view.FailureResult;
import courseweb.view.TemplateManagerException;
import courseweb.view.TemplateResult;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Toni & Tony
 */
public class DetailsCorsoCdl extends BaseController {

    private void action_error(HttpServletRequest request, HttpServletResponse response) {
        if (request.getAttribute("exception") != null) {
            (new FailureResult(getServletContext())).activate((Exception) request.getAttribute("exception"), request, response);
        } else {
            (new FailureResult(getServletContext())).activate((String) request.getAttribute("message"), request, response);
        }
    }

    private void action_default(HttpServletRequest request, HttpServletResponse response, int id, String lingua) throws IOException, ServletException, TemplateManagerException {
        try {
            TemplateResult res = new TemplateResult(getServletContext());
            CDL Cdl =((IgwDataLayer)request.getAttribute("datalayer")).getCDL(id);
            request.setAttribute("cdl",((IgwDataLayer)request.getAttribute("datalayer")).getCDLNoMag());
            request.setAttribute("cdlm",((IgwDataLayer)request.getAttribute("datalayer")).getCDLMag());
            request.setAttribute("corsi",Cdl.getCorsiInCdl());
            request.setAttribute("servlet","listcorsi?");
            
            HttpSession session= request.getSession(false);
            if(session!=null && request.isRequestedSessionIdValid()){
            String a = (String) session.getAttribute("username");
            request.setAttribute("nome",a);}
            
            if(lingua.equals("it")||lingua.equals("")){
                request.setAttribute("lingua","it");
                request.setAttribute("page_title", Cdl.getNome_it());
                request.setAttribute("info", Cdl.getNome_it());
                res.activate("courses_list+.ftl.html", request, response); 
            }
            else{
                request.setAttribute("lingua","en");
                request.setAttribute("page_title", Cdl.getNome_en());
                request.setAttribute("info", Cdl.getNome_en());
                res.activate("courses_list_en+.ftl.html", request, response);
            }
        } catch (DataLayerException ex) {
            request.setAttribute("message", "Data access exception: " + ex.getMessage());
            action_error(request, response);
        }
    }
    
    
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {

        int n;
        String lin;
        try {
            if(request.getParameter("lin")==null)
                lin="it";
            else
                lin=request.getParameter("lin");
            n = SecurityLayer.checkNumeric(request.getParameter("n"));
            action_default(request, response, n, lin);
        } catch (NumberFormatException ex) {
            request.setAttribute("message", "Chiave corso non specificata");
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
