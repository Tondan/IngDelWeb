package courseweb.controller;

import courseweb.controller.data.DataLayerException;
import courseweb.controller.security.SecurityLayer;
import courseweb.model.interfacce.CDL;
import courseweb.model.interfacce.Corso;
import courseweb.model.interfacce.Docente;
import courseweb.model.interfacce.IgwDataLayer;
import courseweb.view.FailureResult;
import courseweb.view.TemplateManagerException;
import courseweb.view.TemplateResult;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
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
public class CreateCorso extends BaseController {

    private void action_error(HttpServletRequest request, HttpServletResponse response) {
        if (request.getAttribute("exception") != null) {
            (new FailureResult(getServletContext())).activate((Exception) request.getAttribute("exception"), request, response);
        } else {
            (new FailureResult(getServletContext())).activate((String) request.getAttribute("message"), request, response);
        }
    }

    private void action_default(HttpServletRequest request, HttpServletResponse response, String lingua) throws IOException, ServletException, TemplateManagerException {
        try {
            HttpSession session= request.getSession(false);
            String a = (String) session.getAttribute("username");
            request.setAttribute("nome",a);
            TemplateResult res = new TemplateResult(getServletContext());
            
            request.setAttribute("docenti", ((IgwDataLayer)request.getAttribute("datalayer")).getDocente());
            request.setAttribute("cdl", ((IgwDataLayer)request.getAttribute("datalayer")).getCDL());
            
            
             
            request.setAttribute("corsi",((IgwDataLayer)request.getAttribute("datalayer")).getCorsiByAnno());
            
            request.setAttribute("page_title", "Backoffice");
              
            if(lingua.equals("it")||lingua.equals("")){
                request.setAttribute("lingua","it");
                res.activate("create_corso.ftl.html", request, response); 
            }
        } catch (DataLayerException ex) {
            Logger.getLogger(CreateCorso.class.getName()).log(Level.SEVERE, "CIAONE", ex);
        }
  
    }
    
    
    private void action_crea(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, TemplateManagerException{
                try{
                    
                         
                String nome= request.getParameter("nome");
                String nomeEN= request.getParameter("nome_en");
                String ssd= request.getParameter("ssd");
                String linguac= request.getParameter("linguac");
                int semestre=0;
                if(request.getParameter("semestre").length()!=0)
                    semestre= Integer.parseInt(request.getParameter("semestre"));
                int cfu=0;
                if(request.getParameter("cfu").length()!=0)
                    cfu=Integer.parseInt( request.getParameter("cfu"));
                String tipologia= request.getParameter("tipologia");
                
                String[] docente=request.getParameterValues("docenti");
                List<Docente> docenti=new ArrayList();
                if(!docenti.isEmpty())
                    for(int i=0,a=0; i<docente.length; i++){
                       a=Integer.parseInt(docente[i]);
                       docenti.add(((IgwDataLayer)request.getAttribute("datalayer")).getDocente(a));  
                    }
                
                String[] c=request.getParameterValues("cdl");
                List<CDL> cdl=new ArrayList();
                    for(int i=0,a=0; i<c.length; i++){
                       a=Integer.parseInt(c[i]);
                       cdl.add(((IgwDataLayer)request.getAttribute("datalayer")).getCDL(a));  
                    }
                
                Corso corso=((IgwDataLayer)request.getAttribute("datalayer")).createCorso();
                    
                corso.setNome_it(nome);
                corso.setNome_en(nomeEN);
                corso.setSSD(ssd);
                corso.setLingua(linguac);
                corso.setSemestre(semestre);
                corso.setCfu(cfu);
                corso.setTipologia(tipologia.charAt(0));
                
                corso.setDocenti(docenti);
                corso.setCDLInCorso(cdl);
                
                
                
                
        
            ((IgwDataLayer)request.getAttribute("datalayer")).storeCorso(corso);
                response.sendRedirect("Backoffice");
            
            } catch (DataLayerException ex) {
            request.setAttribute("message", "Data access exception: " + ex.getMessage());
            action_error(request, response);
        }
                
        
    }


    
@Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {
            String lin;
            try{
            HttpSession s = SecurityLayer.checkSession(request);
            String username=(String)s.getAttribute("username");
            try {
                if (((IgwDataLayer)request.getAttribute("datalayer")).getAccessUtente(username,"CreateCorso")) {
             if (request.getParameter("crea") != null) {
                try {
                    action_crea(request, response);
                } catch (IOException | TemplateManagerException ex) {
                    Logger.getLogger(CreateCorso.class.getName()).log(Level.SEVERE, null, ex);
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
           }else {
                    SecurityLayer.disposeSession(request);
                    response.sendRedirect("Login?referrer=" + URLEncoder.encode(request.getRequestURI(), "UTF-8")); 
                }
            } catch (DataLayerException ex) {
                Logger.getLogger(CreateCorso.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
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
