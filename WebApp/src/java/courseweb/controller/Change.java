package courseweb.controller;

import com.google.gson.Gson;
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
import org.json.JSONObject;

/**
 *
 * @author Toni & Tony
 */
public class Change extends BaseController {
   
@Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {
    try {
        request.setCharacterEncoding("utf8");
    } catch (UnsupportedEncodingException ex) {
        Logger.getLogger(Change.class.getName()).log(Level.SEVERE, null, ex);
    }
        response.setContentType("application/json");
        String[] c=request.getParameterValues("result[]");
        int a=0;
        JSONObject cdl=new JSONObject();
        int i;
        for(i=0; i<c.length;i++){
            if(!c[i].trim().isEmpty())
                a=Integer.parseInt(c[i]);
            try {
                CDL cd=((IgwDataLayer)request.getAttribute("datalayer")).getCDL(a);
                String id=new JSONObject().put("id", cd.getIDCDL()).toString();
                String nome=new JSONObject().put("nome", cd.getNome_it()).toString();
                cdl.put("cdl"+i,new JSONObject().put("id", id).put("nome", nome));
            } catch (DataLayerException ex) {
                Logger.getLogger(Change.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        cdl.put("len", 5);
        
        /*try {
        request.setCharacterEncoding("utf8");
    } catch (UnsupportedEncodingException ex) {
        Logger.getLogger(Change.class.getName()).log(Level.SEVERE, null, ex);
    }
        response.setContentType("application/json");
        String[] c=request.getParameterValues("result[]");
        int a=0;
        JSONObject cdl=new JSONObject();
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
        cdl=new JSONObject(corsi);
            
        Iterator itr=corsi.iterator();
        int len=0;
        while(itr.hasNext()){
            itr.next();
            len++;
        }
        cdl.put("len",len);*/
        
        /*List<Corso> corso=new ArrayList();
        int a=0;
        for(int i=0; i<c.length;i++){
            if(!c[i].trim().isEmpty())
                a=Integer.parseInt(c[i]);
            try {
            CDL cd=((IgwDataLayer)request.getAttribute("datalayer")).getCDL(a);
                corso.addAll(((IgwDataLayer)request.getAttribute("datalayer")).getCorsiInCdl(cd));
            } catch (DataLayerException ex) {
                Logger.getLogger(Change.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
        
    try {
        PrintWriter out = response.getWriter();
        out.write(cdl.toString());
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
