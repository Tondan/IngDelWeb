package courseweb.controller;

import courseweb.controller.data.DataLayerException;
import courseweb.controller.security.SecurityLayer;
import courseweb.model.interfacce.Corso;
import courseweb.model.interfacce.Descrizione_it;
import courseweb.model.interfacce.Docente;
import courseweb.model.interfacce.Dublino_it;
import courseweb.model.interfacce.IgwDataLayer;
import courseweb.model.interfacce.Libro;
import courseweb.view.FailureResult;
import courseweb.view.TemplateManagerException;
import courseweb.view.TemplateResult;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Toni & Tony
 */
public class DetailsCorso extends BaseController {

    private void action_error(HttpServletRequest request, HttpServletResponse response) {
        if (request.getAttribute("exception") != null) {
            (new FailureResult(getServletContext())).activate((Exception) request.getAttribute("exception"), request, response);
        } else {
            (new FailureResult(getServletContext())).activate((String) request.getAttribute("message"), request, response);
        }
    }

    private void action_default(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException, TemplateManagerException {
        try {
            TemplateResult res = new TemplateResult(getServletContext());
            
            Corso corso = ((IgwDataLayer)request.getAttribute("datalayer")).getCorso(id);
            Descrizione_it des = ((IgwDataLayer)request.getAttribute("datalayer")).getDescrizione_it(corso);
            Dublino_it dub = ((IgwDataLayer)request.getAttribute("datalayer")).getDublino_it(corso);
            List<Docente> doc=((IgwDataLayer)request.getAttribute("datalayer")).getDocentiCorso(corso);
            List<Libro> lib=((IgwDataLayer)request.getAttribute("datalayer")).getLibriCorso(corso);
            
            request.setAttribute("page_title", corso.getNome_it());
            request.setAttribute("corso", corso);
            request.setAttribute("descrizione_it", des);
            request.setAttribute("dublino_it", dub);
            request.setAttribute("docenti", doc);
            request.setAttribute("libri", lib);
            res.activate("course_details_4.ftl.html", request, response);
        } catch (DataLayerException ex) {
            request.setAttribute("message", "Data access exception: " + ex.getMessage());
            action_error(request, response);
        }
    }
    
    
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {

        int n;
        try {
            n = SecurityLayer.checkNumeric(request.getParameter("n"));
            action_default(request, response, n);
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
