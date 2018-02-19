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
import javax.servlet.http.Part;

/**
 *
 * @author Toni & Tony
 */
public class ModificaDocente extends BaseController {
    

    private void action_error(HttpServletRequest request, HttpServletResponse response) {
        if (request.getAttribute("exception") != null) {
            (new FailureResult(getServletContext())).activate((Exception) request.getAttribute("exception"), request, response);
        } else {
            (new FailureResult(getServletContext())).activate((String) request.getAttribute("message"), request, response);
        }
    }

    private void action_default(HttpServletRequest request, HttpServletResponse response,String lingua) throws IOException, ServletException, TemplateManagerException {
        TemplateResult res = new TemplateResult(getServletContext());
        request.setAttribute("servlet","ModificaCorso?");
            if(lingua.equals("it")||lingua.equals("")){
            try {
                request.setAttribute("lingua","it");
                request.setAttribute("page_title", "Backoffice");
                
                request.setAttribute("docenti",((IgwDataLayer)request.getAttribute("datalayer")).getDocente());

                HttpSession s = request.getSession(false);
                String a = (String) s.getAttribute("username");
                request.setAttribute("nome",a);
                
                
                res.activate("modificadocente.ftl.html", request, response);
            } catch (DataLayerException ex) {
                Logger.getLogger(Backoffice.class.getName()).log(Level.SEVERE, "CIAOOOO", ex);
            }
       

    }
    }
    
    private void action_modifica(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, TemplateManagerException{
        try{
            int id=Integer.parseInt(request.getParameter("id"));
            String nome= request.getParameter("nome");
            String cognome= request.getParameter("cognome");
            Docente doc=((IgwDataLayer)request.getAttribute("datalayer")).getDocente(id);
                String imgPath=doc.getImmagine();
                String fileName;
                String context=request.getServletContext().getRealPath("");
                Part immagine=request.getPart("immagine");
                if(immagine.getSize()!=0){
                    fileName=nome+cognome;
                    imgPath=Upload.Up(context,immagine,"imgDocenti",fileName,imgPath);
                }
                String email= request.getParameter("email");
                String ufficio= request.getParameter("ufficio");
                String telefono= request.getParameter("telefono");
                String specializzazione= request.getParameter("specializzazione");
                String ricerche= request.getParameter("ricerche");
                String pubblicazioni= request.getParameter("pubblicazioni");
                
                Part curriculum=request.getPart("curriculum");
                String currPath=doc.getCurriculum();
                if(curriculum.getSize()!=0){
                    fileName=nome+cognome;
                    currPath=Upload.Up(context,curriculum,"curriculum",fileName,currPath);
                }
                String ricevimento= request.getParameter("ricevimento");
                String password=request.getParameter("password");
                
                if(!doc.getNome().equals(nome))
                    doc.setNome(nome);
                if(!doc.getCognome().equals(cognome))
                    doc.setCognome(cognome);
                if(!doc.getEmail().equals(email))
                    doc.setEmail(email);
                if(!doc.getUfficio().equals(ufficio))
                    doc.setUfficio(ufficio);
                if(!doc.getTelefono().equals(telefono))
                    doc.setTelefono(telefono);
                if(!doc.getSpecializzazione().equals(specializzazione))
                    doc.setSpecializzazione(specializzazione);
                if(!doc.getRicerche().equals(ricerche))
                    doc.setRicerche(ricerche);
                if(!doc.getPubblicazione().equals(pubblicazioni))
                    doc.setPubblicazioni(pubblicazioni);
                if(!doc.getRicevimento().equals(ricevimento))
                    doc.setRicevimento(ricevimento);
                
                
            
            
    }    
    
    
    
   @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String lin;
        try{
            HttpSession s = SecurityLayer.checkSession(request);
            String username=(String)s.getAttribute("username");   
        try {
            if (((IgwDataLayer)request.getAttribute("datalayer")).getAccessUtente(username,"ModificaDocente")) {
            if(request.getParameter("lin")==null){
                lin="it";}
            else{
                lin=request.getParameter("lin");
            }
            
            
            if (request.getParameter("n") != null) {
            int n;
            n = SecurityLayer.checkNumeric(request.getParameter("n"));
            action_seldocente(request, response, n, lin);
            }
            if(request.getParameter("cancella")!=null)
                action_cancella(request,response);
            if(request.getParameter("modifica")!=null)
                action_modifica(request,response);
            action_default(request, response,lin);
            }
            else {
                SecurityLayer.disposeSession(request);
                    response.sendRedirect("Login?referrer=" + URLEncoder.encode(request.getRequestURI(), "UTF-8"));
            }
            } catch (DataLayerException ex) {
                Logger.getLogger(Corsianno.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (IOException | TemplateManagerException ex) {
            request.setAttribute("exception", ex);
            action_error(request, response);

        }
    }

    private void action_seldocente(HttpServletRequest request, HttpServletResponse response,int id ,String lin) throws IOException, TemplateManagerException {
        
                TemplateResult res = new TemplateResult(getServletContext());
        request.setAttribute("servlet","ModificaDocente?");
            if(lin.equals("it")||lin.equals("")){
            try {
                request.setAttribute("lingua","it");
                request.setAttribute("page_title", "Backoffice");
                
                
                request.setAttribute("docente",((IgwDataLayer)request.getAttribute("datalayer")).getDocente(id));
             
                request.setAttribute("docenti",((IgwDataLayer)request.getAttribute("datalayer")).getDocente());
               
    
                HttpSession s = request.getSession(false);
                String a = (String) s.getAttribute("username");
                request.setAttribute("nome",a);
                

                
                request.setAttribute("utente",((IgwDataLayer)request.getAttribute("datalayer")).getUtenteD());   //query nuova dato iddocente prendi idutente nella tabella utenti
                
                res.activate("modificadocente.ftl.html", request, response);
            } catch (DataLayerException ex) {
                Logger.getLogger(Backoffice.class.getName()).log(Level.SEVERE, "CIAOOOO", ex);
            }
       

    }
    }
    

}

 
