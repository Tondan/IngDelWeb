package courseweb.controller;

import courseweb.controller.data.DataLayerException;
import courseweb.controller.security.SecurityLayer;
import courseweb.model.interfacce.CDL;
import courseweb.model.interfacce.Corso;
import courseweb.model.interfacce.IgwDataLayer;
import courseweb.view.FailureResult;
import courseweb.view.TemplateManagerException;
import courseweb.view.TemplateResult;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

public class Corsianno extends BaseController {
    

    private void action_error(HttpServletRequest request, HttpServletResponse response) {
        if (request.getAttribute("exception") != null) {
            (new FailureResult(getServletContext())).activate((Exception) request.getAttribute("exception"), request, response);
        } else {
            (new FailureResult(getServletContext())).activate((String) request.getAttribute("message"), request, response);
        }
    }

    private void action_default(HttpServletRequest request, HttpServletResponse response, String lingua) throws IOException, ServletException, TemplateManagerException {
        TemplateResult res = new TemplateResult(getServletContext());
        request.setAttribute("servlet","Corsianno?");
            if(lingua.equals("it")||lingua.equals("")){
            try {
                request.setAttribute("lingua","it");
                request.setAttribute("page_title", "Backoffice");
                
                
                
                List<CDL> cdl= ((IgwDataLayer)request.getAttribute("datalayer")).getCDL();
                
                request.setAttribute("cdl", cdl);
                
                
                
                HttpSession s = request.getSession(false);
                String a = (String) s.getAttribute("username");
                request.setAttribute("nome",a);
                
                
                res.activate("corsianno.ftl.html", request, response);
            } catch (DataLayerException ex) {
                Logger.getLogger(Backoffice.class.getName()).log(Level.SEVERE, "CIAOOOO", ex);
            }
       

    }
    }
    
@Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {
            String lin;
           
        try {
            if(request.getParameter("lin")==null){
                lin="it";}
            else{
                lin=request.getParameter("lin");}
            
            if (request.getParameter("n") != null) {
            int n;
            n = SecurityLayer.checkNumeric(request.getParameter("n"));
            action_special(request, response, n, lin);
            }
            else {
                action_default(request, response,lin);
            }

        } catch (IOException | TemplateManagerException ex) {
            request.setAttribute("exception", ex);
            action_error(request, response);

        }
    }

   

    private void action_special(HttpServletRequest request, HttpServletResponse response, int id, String lingua) throws TemplateManagerException {
        
                TemplateResult res = new TemplateResult(getServletContext());
                request.setAttribute("servlet","Corsianno?lin=it");
                if(lingua.equals("it")||lingua.equals("")){
                try {
                request.setAttribute("lingua","it");
                request.setAttribute("page_title", "Backoffice");
                
                List<CDL> cdl1= ((IgwDataLayer)request.getAttribute("datalayer")).getCDL();
                
                CDL cdl =((IgwDataLayer)request.getAttribute("datalayer")).getCDL(id);
                
                
                List<Corso> corso = ((IgwDataLayer)request.getAttribute("datalayer")).getCorsiInCdlNoAnno(cdl);
                
                Map<Integer, List<Corso>> b= new HashMap();
                
                List<Corso> c=new ArrayList();
                for(Corso corso1: corso){
                    int anno=corso1.getAnno();
                    if(b.containsKey(anno)){
                        c=b.get(anno);
                        c.add(corso1);
                        b.put(anno,c);
                    }
                    else{
                        c=new ArrayList();
                        c.add(corso1);
                        b.put(anno,c);
                    
                    }
 
                    }
                
                
                request.setAttribute("corso",b);
                request.setAttribute("cdl",cdl1);
                
                
                HttpSession s = request.getSession(false);
                String a = (String) s.getAttribute("username");
                request.setAttribute("nome",a);
                
                
                res.activate("corsianno.ftl.html", request, response);
            } catch (DataLayerException ex) {
                Logger.getLogger(Backoffice.class.getName()).log(Level.SEVERE,"ciaooo", ex);
            }
       

    }
    }


}
 
