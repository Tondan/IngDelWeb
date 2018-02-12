package courseweb.controller;

import courseweb.controller.data.DataLayerException;
import courseweb.controller.security.SecurityLayer;
import courseweb.model.interfacce.Docente;
import courseweb.model.interfacce.IgwDataLayer;
import courseweb.view.FailureResult;
import courseweb.view.TemplateManagerException;
import courseweb.view.TemplateResult;
import java.io.IOException;
import java.net.URLEncoder;
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
public class CreateCorsoD extends BaseController {
    

    private void action_error(HttpServletRequest request, HttpServletResponse response) {
        if (request.getAttribute("exception") != null) {
            (new FailureResult(getServletContext())).activate((Exception) request.getAttribute("exception"), request, response);
        } else {
            (new FailureResult(getServletContext())).activate((String) request.getAttribute("message"), request, response);
        }
    }

    private void action_default(HttpServletRequest request, HttpServletResponse response,String lingua) throws IOException, ServletException, TemplateManagerException {
        TemplateResult res = new TemplateResult(getServletContext());
        request.setAttribute("servlet","CreateCorsoD?");
            if(lingua.equals("it")||lingua.equals("")){
            try {
                request.setAttribute("lingua","it");
                request.setAttribute("page_title", "Backoffice");
                
                
                
                request.setAttribute("docente",((IgwDataLayer)request.getAttribute("datalayer")).getDocente());
                
                HttpSession s = request.getSession(false);
                String a = (String) s.getAttribute("username");
                request.setAttribute("nome",a);
                
                
                
                
                
                res.activate("create_corsoD.ftl.html", request, response);
            } catch (DataLayerException ex) {
                Logger.getLogger(Backoffice.class.getName()).log(Level.SEVERE, null, ex);
            }
       

    }
    }

 
    @Override
     protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String lin;
        try{
           HttpSession s = SecurityLayer.checkSession(request);
            String username=(String)s.getAttribute("username");
            try {
                if (((IgwDataLayer)request.getAttribute("datalayer")).getAccessUtente(username,"CreateCorsoD")) {
                if(request.getParameter("lin")==null){
                lin="it";}
                else{
                lin=request.getParameter("lin");
            }
                
                action_default(request, response, lin);
            }else {
                    SecurityLayer.disposeSession(request);
                    response.sendRedirect("Login?referrer=" + URLEncoder.encode(request.getRequestURI(), "UTF-8"));
                }
            } catch (DataLayerException ex) {
                Logger.getLogger(CreateCorsoD.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (IOException ex) {
            request.setAttribute("exception", ex);
            action_error(request, response);
        
        } catch (TemplateManagerException ex) {
            Logger.getLogger(CreateCorsoD.class.getName()).log(Level.SEVERE, null, ex);
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
