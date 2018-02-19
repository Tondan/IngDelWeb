package courseweb.controller;

import courseweb.controller.data.DataLayerException;
import courseweb.controller.security.SecurityLayer;
import courseweb.model.interfacce.CDL;
import courseweb.model.interfacce.Corso;
import courseweb.model.interfacce.Descrizione_en;
import courseweb.model.interfacce.Descrizione_it;
import courseweb.model.interfacce.Docente;
import courseweb.model.interfacce.Dublino_en;
import courseweb.model.interfacce.Dublino_it;
import courseweb.model.interfacce.IgwDataLayer;
import courseweb.model.interfacce.Libro;
import courseweb.model.interfacce.Materiale;
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
public class ModificaCorso extends BaseController {
    

    private void action_error(HttpServletRequest request, HttpServletResponse response) {
        if (request.getAttribute("exception") != null) {
            (new FailureResult(getServletContext())).activate((Exception) request.getAttribute("exception"), request, response);
        } else {
            (new FailureResult(getServletContext())).activate((String) request.getAttribute("message"), request, response);
        }
    }

    private void action_default(HttpServletRequest request, HttpServletResponse response, int id, String lingua) throws IOException, ServletException, TemplateManagerException {
        TemplateResult res = new TemplateResult(getServletContext());
        request.setAttribute("servlet","ModificaCorso?");
            if(lingua.equals("it")||lingua.equals("")){
            try {
                request.setAttribute("lingua","it");
                request.setAttribute("page_title", "Backoffice");
                
                request.setAttribute("cdl",((IgwDataLayer)request.getAttribute("datalayer")).getCDLNoMag());
                request.setAttribute("cdlm",((IgwDataLayer)request.getAttribute("datalayer")).getCDLMag());
                
                
                Corso corso = ((IgwDataLayer)request.getAttribute("datalayer")).getCorso(id);
                request.setAttribute("corso", corso);
                
                request.setAttribute("docente", corso.getDocenti());
                request.setAttribute("docenti", ((IgwDataLayer)request.getAttribute("datalayer")).getDocente());
                
                 
                request.setAttribute("cdl", corso.getCDL());
                request.setAttribute("cdl1", ((IgwDataLayer)request.getAttribute("datalayer")).getCDL());
                
                Descrizione_it descrizioneit= ((IgwDataLayer)request.getAttribute("datalayer")).getDescrizione_it(corso);
                Descrizione_en descrizioneen= ((IgwDataLayer)request.getAttribute("datalayer")).getDescrizione_en(corso);
                Dublino_it dublinoit= ((IgwDataLayer)request.getAttribute("datalayer")).getDublino_it(corso);
                Dublino_en dublinoen= ((IgwDataLayer)request.getAttribute("datalayer")).getDublino_en(corso);
                
 
                request.setAttribute("descrizioneit", descrizioneit);
                request.setAttribute("descrizioneen", descrizioneen);
                request.setAttribute("dublinoit",dublinoit);
                request.setAttribute("dublinoen",dublinoen);
               
                List<Libro> libri=((IgwDataLayer)request.getAttribute("datalayer")).getLibriCorso(corso);
                List<Materiale> materiali=((IgwDataLayer)request.getAttribute("datalayer")).getMaterialeCorso(id);
                
                request.setAttribute("materiali",materiali);
                request.setAttribute("libri",libri);
                
                
                
                HttpSession s = request.getSession(false);
                String a = (String) s.getAttribute("username");
                request.setAttribute("nome",a);
                
                
                res.activate("modificacorso.ftl.html", request, response);
            } catch (DataLayerException ex) {
                Logger.getLogger(Backoffice.class.getName()).log(Level.SEVERE, "CIAOOOO", ex);
            }
       

    }
    }
    
@Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {
            String lin;
            try{
            HttpSession s = SecurityLayer.checkSession(request);
            String username=(String)s.getAttribute("username");
            try {
                if (((IgwDataLayer)request.getAttribute("datalayer")).getAccessUtente(username,"ModificaCorso")) {
                    int n;
                    if (request.getParameter("modifica") != null) {
                         action_modifica(request, response);
                    } else {
                try {
                    if(request.getParameter("lin")==null)
                        lin="it";
                    else{
                        lin=request.getParameter("lin");
                    n = SecurityLayer.checkNumeric(request.getParameter("n"));
                    action_default(request, response, n, lin);
                    }

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
                Logger.getLogger(ModificaCorso.class.getName()).log(Level.SEVERE, null, ex);
            }
            } catch (IOException ex) {
            request.setAttribute("exception", ex);
            action_error(request, response);
            }
}


    private void action_modifica(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try{
                    
                int key=Integer.parseInt(request.getParameter("key"));
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
                

                Corso corso=((IgwDataLayer)request.getAttribute("datalayer")).getCorso(key);
                

                if(!corso.getNome_it().equals(nome))
                    corso.setNome_it(nome);
                if(!corso.getNome_en().equals(nomeEN))
                    corso.setNome_en(nomeEN);
                if(!corso.getSSD().equals(ssd))
                    corso.setSSD(ssd);
                if(!corso.getLingua().equals(linguac))
                    corso.setLingua(linguac);
                if(corso.getSemestre()!=semestre)
                    corso.setSemestre(semestre);
                if(corso.getCfu()!=cfu)
                    corso.setCfu(cfu);
                if(corso.getTipologia()!=tipologia.charAt(0))
                    corso.setTipologia(tipologia.charAt(0));
                corso.setDocenti(docenti);
                corso.setCDLInCorso(cdl);
                
                
                //DESCRIZIONE
                Descrizione_it descrizioneit=((IgwDataLayer)request.getAttribute("datalayer")).getDescrizione_it(corso);
                
                String prerequisiti= request.getParameter("prerequisiti");
                String obiettivi= request.getParameter("obiettivi");
                String mod_esame= request.getParameter("modesa");
                String mod_insegnamento= request.getParameter("modins");
                String sillabo= request.getParameter("sillabo");
                String note= request.getParameter("note");
                String homepage= request.getParameter("homepage");
                String forum= request.getParameter("forum");
                String risorse_ext= request.getParameter("risorse");
                
            
            ((IgwDataLayer)request.getAttribute("datalayer")).storeCorso(corso);
                response.sendRedirect("Backoffice");
            
            } catch (DataLayerException ex) {
            request.setAttribute("message", "Data access exception: " + ex.getMessage());
            action_error(request, response);
        }
    }

   
    }

 
