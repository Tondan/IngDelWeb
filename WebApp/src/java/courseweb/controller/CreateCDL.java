package courseweb.controller;

import courseweb.controller.data.DataLayerException;
import courseweb.view.FailureResult;
import courseweb.view.TemplateManagerException;
import courseweb.view.TemplateResult;
import java.io.IOException;
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
public class CreateCDL extends BaseController {


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
                res.activate("Createcdl.ftl.html", request, response); 
            }
  
    }
    
    
    private void action_creaCDL(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, TemplateManagerException{
                try{
                
                    
                String username1;
                
                String nome= request.getParameter("nome");
                String nomeen= request.getParameter("nomeen");
                
                
                String imgPath=null;
                String fileName;
                String context=request.getServletContext().getRealPath("");
                Part immagine=request.getPart("immagine");
                if(immagine.getSize()!=0){
                    fileName=nome;
                    imgPath=Upload.Up(context,immagine,"imgDocenti",fileName);
                }
                
                
                
                
                
                
                   //fai abbbreviazione italiano ed inglese nello stesso modo circa ahah
                   
                  if(nome.length()>=3){ 
                  username1=nome.toLowerCase().substring(0, 2);}
                  else{
                      username1=nome.toLowerCase();
                    }
                  
                  
                  
                
            
            
            
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
             if (request.getParameter("crea") != null) {
                try {
                    action_creaCDL(request, response);
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
