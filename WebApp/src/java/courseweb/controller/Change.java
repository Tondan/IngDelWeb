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
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Toni & Tony
 */
public class Change extends BaseController {
   
@Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try{
        request.setCharacterEncoding("utf8");
    } catch (UnsupportedEncodingException ex) {
        Logger.getLogger(Change.class.getName()).log(Level.SEVERE, null, ex);
    }
        response.setContentType("html");
        String[] c=request.getParameterValues("result[]");
        int a=0;
        List<Corso> corsi=new ArrayList();
        int i;
        try{
        for(i=0; i<c.length;i++){
            if(!c[i].trim().isEmpty())
                a=Integer.parseInt(c[i]);
            CDL cd=((IgwDataLayer)request.getAttribute("datalayer")).getCDL(a);
            corsi.addAll(((IgwDataLayer)request.getAttribute("datalayer")).getCorsiInCdl(cd));
        }
        } catch (DataLayerException ex) {
                Logger.getLogger(Change.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    try {
        PrintWriter out = response.getWriter();
        out.write("<select class='chzn-select' name='modulo' id='special-cazzafà' multiple>");
        for(Corso corso:corsi){
            out.write("<option value='"+corso.getID()+"'>"+corso.getNome_it()+"</option>");
        }
        out.write("</select>");
    } catch (IOException ex) {
        Logger.getLogger(Change.class.getName()).log(Level.SEVERE, null, ex);
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
