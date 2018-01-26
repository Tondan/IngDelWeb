package courseweb.controller;


import courseweb.controller.data.DataLayerException;
import courseweb.model.interfacce.IgwDataLayer;
import courseweb.view.FailureResult;
import courseweb.view.TemplateManagerException;
import courseweb.view.TemplateResult;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import courseweb.model.classi.CDLImpl;
import courseweb.model.interfacce.Corso;
import courseweb.model.interfacce.Docente;
import java.util.List;

/**
 *
 * @author Giuseppe Della Penna
 */
public class ListCorsi extends BaseController {
   
    private void action_error(HttpServletRequest request, HttpServletResponse response) {
        if (request.getAttribute("exception") != null) {
            (new FailureResult(getServletContext())).activate((Exception) request.getAttribute("exception"), request, response);
        } else {
            (new FailureResult(getServletContext())).activate((String) request.getAttribute("message"), request, response);
        }
    }

    private void action_default(HttpServletRequest request, HttpServletResponse response,String lingua) throws IOException, ServletException, TemplateManagerException {
        try {
            TemplateResult res = new TemplateResult(getServletContext());
            

            
            request.setAttribute("corsi", ((IgwDataLayer)request.getAttribute("datalayer")).getCorsiByAnno());
            request.setAttribute("cdl",((IgwDataLayer)request.getAttribute("datalayer")).getCDLNoMag());
            request.setAttribute("cdlm",((IgwDataLayer)request.getAttribute("datalayer")).getCDLMag());
            request.setAttribute("servlet","listcorsi?");
            request.setAttribute("change","y");
            if(lingua.equals("it")||lingua.equals("")){
                request.setAttribute("lingua","it");
                request.setAttribute("page_title", "Lista Corsi");
                res.activate("courses_list.ftl.html", request, response); 
            }
            else{
                request.setAttribute("lingua","en");
                request.setAttribute("page_title", "Courses List");
                res.activate("courses_list_en.ftl.html", request, response);
            }
        } catch (DataLayerException ex) {
            request.setAttribute("message", "Data access exception: " + ex.getMessage());
            action_error(request, response);
        }
    }

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
            String lin;
        try {
            if(request.getParameter("lin")==null)
                lin="it";
            else
                lin=request.getParameter("lin");
            action_default(request, response,lin);

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
        return "Main Corso servlet";
    }// </editor-fold>

}
