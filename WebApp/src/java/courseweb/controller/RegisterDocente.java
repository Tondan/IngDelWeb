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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Toni & Tony
 */
public class RegisterDocente extends BaseController {

    private void action_error(HttpServletRequest request, HttpServletResponse response) {
        if (request.getAttribute("exception") != null) {
            (new FailureResult(getServletContext())).activate((Exception) request.getAttribute("exception"), request, response);
        } else {
            (new FailureResult(getServletContext())).activate((String) request.getAttribute("message"), request, response);
        }
    }

    private void action_default(HttpServletRequest request, HttpServletResponse response, String lingua) throws IOException, ServletException, TemplateManagerException {
        HttpSession session= request.getSession(false);
        String a = (String) session.getAttribute("username");
        request.setAttribute("nome",a);
        TemplateResult res = new TemplateResult(getServletContext());
        request.setAttribute("page_title", "Backoffice");
    
        if(lingua.equals("it")||lingua.equals("")){
                request.setAttribute("lingua","it");
                res.activate("register_docente.ftl.html", request, response); 
            }
  
    }
    
    
    private void action_registra(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, TemplateManagerException{
                try{
                    
                String nome= request.getParameter("nome");
                String cognome= request.getParameter("cognome");
                   
                   
                   
                Docente docente=((IgwDataLayer)request.getAttribute("datalayer")).createDocente();
                    
                docente.setNome(nome);
                docente.setCognome(cognome);
                
        
            ((IgwDataLayer)request.getAttribute("datalayer")).storeDocente(docente);
                response.sendRedirect("Backoffice");
            
            } catch (DataLayerException ex) {
            request.setAttribute("message", "Data access exception: " + ex.getMessage());
            action_error(request, response);
        }
                
        
    }

        
        
        
        
        
        
    
    
    
@Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
            String lin;
             if (request.getParameter("registra") != null) {
                try {
                    action_registra(request, response);
                } catch (IOException | TemplateManagerException ex) {
                    Logger.getLogger(RegisterDocente.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
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
