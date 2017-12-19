package courseweb.controller;


import courseweb.controller.data.DataLayerException;
import courseweb.controller.security.SecurityLayer;
import courseweb.model.interfacce.Docente;
import courseweb.model.interfacce.IgwDataLayer;
import courseweb.view.FailureResult;
import courseweb.view.TemplateManagerException;
import courseweb.view.TemplateResult;
import courseweb.view.StreamResult;
import java.io.File;
import java.net.URL;
import java.net.URLConnection;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Toni & Tony
 */
public class DetailsDocente extends BaseController {

    private void action_error(HttpServletRequest request, HttpServletResponse response) {
        if (request.getAttribute("exception") != null) {
            (new FailureResult(getServletContext())).activate((Exception) request.getAttribute("exception"), request, response);
        } else {
            (new FailureResult(getServletContext())).activate((String) request.getAttribute("message"), request, response);
        }
    }

    private void action_default(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException, TemplateManagerException {
        try {
            TemplateResult res = new TemplateResult(getServletContext());
            Docente doc=((IgwDataLayer)request.getAttribute("datalayer")).getDocente(id);
            request.setAttribute("page_title", doc.getNome() + " " + doc.getCognome() );
            request.setAttribute("docente", doc);
            res.activate("teacher_profile.ftl.html", request, response);
        } catch (DataLayerException ex) {
            request.setAttribute("message", "Data access exception: " + ex.getMessage());
            action_error(request, response);
        }
    }
    
    private void action_download(HttpServletRequest request, HttpServletResponse response, int res) throws IOException, ServletException, TemplateManagerException {
        StreamResult result = new StreamResult(getServletContext());
        //in base a res, dovremmo determinare la risorsa da scaricare, quindi aprire uno stream di input
        //per leggerla in binario
        //...
        //con la classe StreamResult possiamo usare un file o direttamente uno stream, anche aperto da una base di dati
        //qui, per esempio, prendiamo sempre un file di test all'interno della nostra applicazione
        //we should determine the file to download using the res parameter, but in this toy example we always download the same file
        //the StreamResult utility class provides methods to start a binary download from a file or any data stream
        //
        //usate questa versione per leggere una risorsa incorporata nel WAR e se siete certi che sia stato espanso sul disco, o per una risorsa prelevata da una cartella esterna al contesto
        //use this version only if you want to read a resource embedded in the WAR file AND you know that it has been expanded to disk, or to read a resource from a folder outside the context
        File in = new File(getServletContext().getRealPath("") + File.separatorChar + "curriculum.txt");
        result.activate(in, request, response);
        //
        //usate questa versione per leggere una risorsa incorporata nel WAR
        //use this version to read a resource is inside the WAR
//        URL resource = getServletContext().getResource("/" + "file_di_esempio.txt");
//        if (resource != null) {
//            URLConnection connection = resource.openConnection();
//            String url = resource.toString();
//            //settiamo il tipo del file da trasmettere
//            //set the media type of the file to send
//            request.setAttribute("contentType", connection.getContentType());
//            result.activate(connection.getInputStream(), connection.getContentLength(), url.substring(url.lastIndexOf('/') + 1), request, response);
//        } else {
//            request.setAttribute("exception", new FileNotFoundException("Resource not found: "+res));
//            action_error(request, response);
//        }
    }
    

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {

        int k;
        try {
            k = SecurityLayer.checkNumeric(request.getParameter("k"));
            action_default(request, response, k);
            int res = SecurityLayer.checkNumeric(request.getParameter("res"));
            action_download(request, response, res);
    
        } catch (NumberFormatException ex) {
            request.setAttribute("message", "Teacher key not specified");
            action_error(request, response);
        } catch (IOException ex) {
            request.setAttribute("exception", ex);
            action_error(request, response);
               
        } catch (TemplateManagerException ex) {
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
