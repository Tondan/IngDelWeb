/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseweb.controller;

import courseweb.controller.data.DataLayerException;
import courseweb.model.interfacce.CDL;
import courseweb.model.interfacce.IgwDataLayer;
import courseweb.view.FailureResult;
import courseweb.view.TemplateManagerException;
import courseweb.view.TemplateResult;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Toni & Tony
 */
public class Home extends BaseController {

    private void action_error(HttpServletRequest request, HttpServletResponse response) {
        if (request.getAttribute("exception") != null) {
            (new FailureResult(getServletContext())).activate((Exception) request.getAttribute("exception"), request, response);
        } else {
            (new FailureResult(getServletContext())).activate((String) request.getAttribute("message"), request, response);
        }
    }

    private void action_default(HttpServletRequest request, HttpServletResponse response,String lingua) throws IOException, ServletException, TemplateManagerException {
        try {
            
            TemplateResult res = new TemplateResult(getServletContext());
            request.setAttribute("page_title", "Home");
            
            Random rand= new Random();
            List<CDL> cdl=((IgwDataLayer)request.getAttribute("datalayer")).getCDLNoMag();
            List<CDL> cdlm=((IgwDataLayer)request.getAttribute("datalayer")).getCDLMag();
            List<CDL> rcdl=new ArrayList();
            List<CDL> rcdlm=new ArrayList();
            int n=4;
            int cdlsize=cdl.size();
            int cdlmsize=cdlm.size();
            for (int i=0;i<n;i++){
                if(!cdl.isEmpty() &&i<=cdlsize){
                    int randomIndex=rand.nextInt(cdl.size());
                    rcdl.add(cdl.get(randomIndex));
                    cdl.remove(randomIndex);
                }
                if(!cdlm.isEmpty() && i<=cdlmsize){
                    int randomIndex=rand.nextInt(cdlm.size());
                    rcdlm.add(cdlm.get(randomIndex));
                    cdlm.remove(randomIndex);
                }
            }
            
            HttpSession session= request.getSession(false);
            if(session!=null && request.isRequestedSessionIdValid()){
            String a = (String) session.getAttribute("username");
            request.setAttribute("nome",a);}
            request.setAttribute("change","y");
            request.setAttribute("servlet","Home?");
            request.setAttribute("cdl",rcdl);
            request.setAttribute("cdlm",rcdlm);
            if(lingua.equals("it")||lingua.equals("")){
                request.setAttribute("lingua","it");
                res.activate("homepage.ftl.html", request, response); 
            }
            else{
                request.setAttribute("lingua","en");
                res.activate("homepage_en.ftl.html", request, response);
            }
            
            
            
        } catch (DataLayerException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
            String lin;
            //boolean b=false;
        try {
            /*Enumeration list=request.getParameterNames();
            while(list.hasMoreElements())
                if(list.nextElement().toString().equals("lin")){
                    b=true;
                    break;
                }
            if(b)
                lin=request.getParameter("lin");
            lin="it";
            */
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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Main Corso servlet";
    }// </editor-fold>

}
