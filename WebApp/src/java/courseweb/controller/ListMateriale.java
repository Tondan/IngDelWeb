package courseweb.controller;


import courseweb.controller.data.DataLayerException;
import courseweb.controller.security.SecurityLayer;
import courseweb.model.interfacce.IgwDataLayer;
import courseweb.view.FailureResult;
import courseweb.view.TemplateManagerException;
import courseweb.view.TemplateResult;
import java.io.IOException;
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

    private void action_default(HttpServletRequest request, HttpServletResponse response,int id) throws IOException, ServletException, TemplateManagerException {
        try {
            
            long PesoFile;
            PesoFile = Download.getPesofile();
            
            TemplateResult res = new TemplateResult(getServletContext());
            request.setAttribute("page_title", "Lista Materiale");
            request.setAttribute("materiale", ((IgwDataLayer)request.getAttribute("datalayer")).getMaterialeCorso(id));
            request.setAttribute("corso",((IgwDataLayer)request.getAttribute("datalayer")).getCorso(id));
            
            request.setAttribute("pesofile",PesoFile);
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
        try {
            k = SecurityLayer.checkNumeric(request.getParameter("k"));
            action_default(request, response, k);
    
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
