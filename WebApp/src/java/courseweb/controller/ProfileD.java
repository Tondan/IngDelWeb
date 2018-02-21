package courseweb.controller;

import courseweb.controller.data.DataLayerException;
import courseweb.controller.security.SecurityLayer;
import courseweb.model.interfacce.Docente;
import courseweb.model.interfacce.IgwDataLayer;
import courseweb.model.interfacce.Utente;
import courseweb.model.interfacce.Log;
import courseweb.view.FailureResult;
import courseweb.view.TemplateManagerException;
import courseweb.view.TemplateResult;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


@MultipartConfig
/**
 *
 * @author Toni & Tony
 */
public class ProfileD extends BaseController {
    

    private void action_error(HttpServletRequest request, HttpServletResponse response) {
        if (request.getAttribute("exception") != null) {
            (new FailureResult(getServletContext())).activate((Exception) request.getAttribute("exception"), request, response);
        } else {
            (new FailureResult(getServletContext())).activate((String) request.getAttribute("message"), request, response);
        }
    }

    
    
    private void action_modifica(HttpServletRequest request, HttpServletResponse response) throws DataLayerException, IOException, ServletException, TemplateManagerException {
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
                String currPath;
                if(doc.getCurriculum().length()!=0)
                    currPath=doc.getCurriculum();
                else
                    currPath=null;
                if(curriculum.getSize()!=0){
                    fileName=nome+cognome;
                    currPath=Upload.Up(context,curriculum,"curriculum",fileName,currPath);
                }
                String ricevimento= request.getParameter("ricevimento");
                
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
                if(!doc.getImmagine().equals(imgPath))
                    doc.setImmagine(imgPath);
                if(!doc.getCurriculum().equals(currPath))
                    doc.setCurriculum(currPath);
                
                ((IgwDataLayer)request.getAttribute("datalayer")).storeDocente(doc);
                
                HttpSession session= request.getSession(false);
                int id1 = (int) session.getAttribute("userid");
        //int id = (int) session.getAttribute("docenteid");
        
            Log log=((IgwDataLayer)request.getAttribute("datalayer")).CreateLog();
            log.setIDUtente(id1);
            log.setDescrizione("Ha modificato il docente "+" "+ nome +" "+cognome);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            log.setData(timestamp);
            ((IgwDataLayer)request.getAttribute("datalayer")).storeLog(log);
        
                response.sendRedirect("BackofficeD");
                
        } catch (DataLayerException ex) {
            request.setAttribute("message", "Data access exception: " + ex.getMessage());
            action_error(request, response);
        }
        
        
        
        /*
        String nome=request.getParameter("nome");
        String cognome=request.getParameter("cognome");
        String email=request.getParameter("email");
        
        String old=request.getParameter("old");
        String password=request.getParameter("password");
        int id=Integer.parseInt(request.getParameter("id"));
        Utente utente=((IgwDataLayer)request.getAttribute("datalayer")).getUtente(id);
        if(!nome.trim().isEmpty()&&((IgwDataLayer)request.getAttribute("datalayer")).existUtente(nome)&&!utente.getUsername().equals(nome)){
            request.setAttribute("message", "Nome già esistente");
            action_default(request,response,"");
        }
        if(((IgwDataLayer)request.getAttribute("datalayer")).getUtenti(nome, old)==null){
            request.setAttribute("message", "Password errata");
            action_default(request,response,"");
        }
        
        utente.setUsername(nome);
        if(!utente.getPassword().equals(password))
            utente.setPassword(password);
        ((IgwDataLayer)request.getAttribute("datalayer")).storeUtente(utente);
        HttpSession session= request.getSession(false);
        int id1 = (int) session.getAttribute("userid");
        //int id = (int) session.getAttribute("docenteid");
        
        Log log=((IgwDataLayer)request.getAttribute("datalayer")).CreateLog();
        log.setIDUtente(id1);
        log.setDescrizione("Ha modifica il suo profilo");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        log.setData(timestamp);
        ((IgwDataLayer)request.getAttribute("datalayer")).storeLog(log);
        response.sendRedirect("Login");*/
    }
     
     
     
     
     
     
    private void action_default(HttpServletRequest request, HttpServletResponse response,String lingua) throws IOException, ServletException, TemplateManagerException {
        TemplateResult res = new TemplateResult(getServletContext());
        request.setAttribute("servlet","Profile?");
            if(lingua.equals("it")||lingua.equals("")){
            try {
                request.setAttribute("lingua","it");
                request.setAttribute("page_title", "Profilo");
                
                HttpSession session= request.getSession(false);
                
                String a = (String) session.getAttribute("username");
                request.setAttribute("nome",a);
                
                int id = (int) session.getAttribute("docenteid");
                
                Docente docente = ((IgwDataLayer)request.getAttribute("datalayer")).getDocente(id);
                
                request.setAttribute("docente", docente);
                
                request.setAttribute("utente", ((IgwDataLayer)request.getAttribute("datalayer")).getUtente(id));
                request.setAttribute("corso", ((IgwDataLayer)request.getAttribute("datalayer")).getCorso(id));
                
                res.activate("profiled.ftl.html", request, response);
            } catch (DataLayerException ex) {
                Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
            }
       

    }
    }

 
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        try{
        String lin;
        if(request.getParameter("lin")==null)
                lin="it";
            else
                lin=request.getParameter("lin");
        HttpSession s = SecurityLayer.checkSession(request);
            String username=(String)s.getAttribute("username");
        if (((IgwDataLayer)request.getAttribute("datalayer")).getAccessUtente(username,"BackOfficeD")) {
            if (request.getParameter("profilo") != null)
                    action_modifica(request, response);
            action_default(request, response,lin);
            }else {
                SecurityLayer.disposeSession(request);
                response.sendRedirect("Login?referrer=" + URLEncoder.encode(request.getRequestURI(), "UTF-8"));
            }
            
        /*
        try {
            String lin;
            int n=0;
            if(request.getParameter("lin")==null)
                lin="it";
            else
                lin=request.getParameter("lin");
            HttpSession s = SecurityLayer.checkSession(request);
            String username=(String)s.getAttribute("username");
            if (((IgwDataLayer)request.getAttribute("datalayer")).getAccessUtente(username,"BackOfficeD")) {
                if (request.getParameter("profile") != null)
                    action_modifica(request, response);
                action_default(request, response,lin);
                           
            }else {
                SecurityLayer.disposeSession(request);
                response.sendRedirect("Login?referrer=" + URLEncoder.encode(request.getRequestURI(), "UTF-8"));
            }                
        } catch (DataLayerException ex) {
            Logger.getLogger(CreateCorsoD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CreateCorsoD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TemplateManagerException ex) {
            Logger.getLogger(CreateCorsoD.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }   catch (DataLayerException ex) {
            Logger.getLogger(ProfileD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProfileD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TemplateManagerException ex) {
            Logger.getLogger(ProfileD.class.getName()).log(Level.SEVERE, null, ex);
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
