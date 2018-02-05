package courseweb.controller;

import courseweb.controller.data.DataLayerException;
import courseweb.model.interfacce.Docente;
import courseweb.model.interfacce.IgwDataLayer;
import courseweb.model.interfacce.Utente;
import courseweb.view.FailureResult;
import courseweb.view.TemplateManagerException;
import courseweb.view.TemplateResult;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
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
    
    
    private void action_registraD(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, TemplateManagerException{
                try{
                
                    

                    
               /* Part filePart = request.getPart("curriculum"); //ho il file
                String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
                
                
                
                File uploads = new File("/UploadFiles");
                File file = new File(uploads, "somefilename.ext");

               InputStream fileContent = filePart.getInputStream();
               Files.copy(fileContent, file.toPath());
                
*/
                
                RandomString random = new RandomString();
                
                String password=random.nextString();

                String username1=null ,username2=null;
                
                String immagine= request.getParameter("immagine");
                String nome= request.getParameter("nome");
                String cognome= request.getParameter("cognome");
                String email= request.getParameter("email");
                String ufficio= request.getParameter("ufficio");
                String telefono= request.getParameter("telefono");
                String specializzazione= request.getParameter("specializzazione");
                String ricerche= request.getParameter("ricerche");
                String pubblicazioni= request.getParameter("pubblicazioni");
                String curriculum= request.getParameter("curriculum");
                String ricevimento= request.getParameter("ricevimento");
                
                   
                  if(nome.length()>=3){
                  username1=nome.toLowerCase().substring(0, 2);}
                  else{
                      username1=nome.toLowerCase();
                    }
                  
                  if(cognome.length()>=3){
                  username2=cognome.toLowerCase().substring(0, 2);
                  }else{
                      username2=nome.toLowerCase();
                    }
                  
                  String username=username1.concat(username2);
                  
                Docente docente=((IgwDataLayer)request.getAttribute("datalayer")).createDocente();
                Utente utente=((IgwDataLayer)request.getAttribute("datalayer")).createUtente();
                
                docente.setImmagine(immagine);
                docente.setNome(nome);
                docente.setCognome(cognome);
                docente.setEmail(email);
                docente.setUfficio(ufficio);
                docente.setTelefono(telefono);
                docente.setSpecializzazione(specializzazione);
                
                docente.setRicerche(ricerche);
                docente.setPubblicazioni(pubblicazioni);
                
                docente.setCurriculum(curriculum);
                docente.setRicevimento(ricevimento);
  
                
            ((IgwDataLayer)request.getAttribute("datalayer")).storeDocente(docente);
            
            int id=docente.getIDDocente();
            
            utente.setDocente(id);
            utente.setUsername(username);
            utente.setPassword(password);
            utente.setIDGruppo(2);
            
            ((IgwDataLayer)request.getAttribute("datalayer")).storeUtente(utente);
            
                request.setAttribute("message", "Upload has been done successfully!");
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
                    action_registraD(request, response);
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
