package courseweb.controller;


import courseweb.controller.data.DataLayerException;
import courseweb.controller.security.SecurityLayer;
import courseweb.model.interfacce.Corso;
import courseweb.model.interfacce.Docente;
import courseweb.model.interfacce.IgwDataLayer;
import courseweb.view.FailureResult;
import courseweb.view.TemplateManagerException;
import courseweb.view.TemplateResult;
import courseweb.view.StreamResult;
import java.io.File;
import java.net.URL;
import java.net.URLConnection;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Toni & Tony
 */
public class DetailsDocente extends BaseController {

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
            Docente doc=((IgwDataLayer)request.getAttribute("datalayer")).getDocente(id);
            request.setAttribute("page_title", doc.getNome() + " " + doc.getCognome() );
                    
            request.setAttribute("docente", doc);
            request.setAttribute("docentecorsi", doc.getCorsi());
            request.setAttribute("servlet","dettaglidocente?k="+id+"&");
            request.setAttribute("change","y");
            if(lingua.equals("it")||lingua.equals("")){
                request.setAttribute("lingua","it");
                res.activate("teacher_profile.ftl.html", request, response); 
            }
            else{
                request.setAttribute("lingua","en");
                res.activate("teacher_profile_en.ftl.html", request, response);
            }
           
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
            action_default(request, response, k,lin);
    
        } catch (NumberFormatException ex) {
            request.setAttribute("message", "Teacher key not specified");
            action_error(request, response);
        } catch (IOException ex) {
            request.setAttribute("exception", ex);
            action_error(request, response);
               
        } catch (TemplateManagerException ex) {
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
