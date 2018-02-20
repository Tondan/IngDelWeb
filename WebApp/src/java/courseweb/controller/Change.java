package courseweb.controller;

import courseweb.controller.data.DataLayerException;
import courseweb.model.interfacce.CDL;
import courseweb.model.interfacce.Corso;
import courseweb.model.interfacce.IgwDataLayer;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        Map<Integer,String> corsi=new HashMap();
        int i;
        try{
        for(i=0; i<c.length;i++){
            if(!c[i].trim().isEmpty())
                a=Integer.parseInt(c[i]);
            CDL cd=((IgwDataLayer)request.getAttribute("datalayer")).getCDL(a);
            for(Corso corso:((IgwDataLayer)request.getAttribute("datalayer")).getCorsiInCdl(cd))
                corsi.put(corso.getID(), corso.getNome_it());
        }
        } catch (DataLayerException ex) {
                Logger.getLogger(Change.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    try {
        PrintWriter out = response.getWriter();
        out.write("<select class='chzn-select' name='propedeudici' id='special-cazzafà' multiple>");
        for(int key:corsi.keySet()){
            out.write("<option value='"+key+"'>"+corsi.get(key)+"</option>");
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
