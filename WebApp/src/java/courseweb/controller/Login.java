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
import courseweb.model.classi.CDLImpl;
import courseweb.model.interfacce.Corso;
import courseweb.model.interfacce.Docente;
import courseweb.model.interfacce.Utente;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Giuseppe Della Penna
 */
public class Login extends BaseController {
   
    private void action_error(HttpServletRequest request, HttpServletResponse response) {
        if (request.getAttribute("exception") != null) {
            (new FailureResult(getServletContext())).activate((Exception) request.getAttribute("exception"), request, response);
        } else {
            (new FailureResult(getServletContext())).activate((String) request.getAttribute("message"), request, response);
        }
    }

    private void action_default(HttpServletRequest request, HttpServletResponse response, String lingua) throws IOException, ServletException, TemplateManagerException {
        TemplateResult res = new TemplateResult(getServletContext());
        request.setAttribute("servlet","Login?");
            if(lingua.equals("it")||lingua.equals("")){
                request.setAttribute("lingua","it");
        
        request.setAttribute("page_title", "Login");
        res.activate("login.ftl.html", request, response);
    }
    }

    private void action_login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, TemplateManagerException {
        
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            
             if (!username.isEmpty() && !password.isEmpty()){
                
                try {
                    Utente utente;
                    utente = ((IgwDataLayer)request.getAttribute("datalayer")).getUtenti(username, password);
                    
                    int userid = utente.getID();
                    SecurityLayer.createSession(request, username, userid);
                    //se è stato trasmesso un URL di origine, torniamo a quell'indirizzo
                    //if an origin URL has been transmitted, return to it
                    {
                        response.sendRedirect("Backoffice");
                    }
                } catch (DataLayerException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, "Login errato", ex);
                }
            } else {
                request.setAttribute("exception", new Exception("Login vuoto"));
                action_error(request, response);
            }
        } 

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        String lin;
        try{
            if (request.getParameter("login") != null) {
                action_login(request, response);
            } else {
            
            if(request.getParameter("lin")==null)
                lin="it";
            else
                lin=request.getParameter("lin");
                action_default(request, response,lin);
            }
        } catch (IOException ex) {
            request.setAttribute("exception", ex);
            action_error(request, response);
        } catch (TemplateManagerException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        }
