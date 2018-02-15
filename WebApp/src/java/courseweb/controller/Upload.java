/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseweb.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import javax.servlet.http.Part;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author Toni & Tony
 */
public class Upload {
    
    /*Esegue l'upload di un file, conoscendo il contesto, la directory relativa dove salvare il file, il nuovo nome del file*/
    protected static String Up(String context,Part part,String dir,String name) throws IOException{
        File cn=new File(context);
        context=cn.getParentFile().getParent()+File.separator+"web\\";
        //contructs path of the directory to save uploaded file
        String savePath=context+dir;
        //Creates the save directory if not exists
        File saveDir=new File(savePath);
        if(!saveDir.exists())
            saveDir.mkdir();
        
        String ext;
        String fileName;
 /*       String fileName=extractFileName(part);
        fileName=name;*/
       //if(!novo){
            ext=FilenameUtils.getExtension(extractFileName(part));
            fileName=name+"."+ext;
            int i=1;
            File file=new File(context+dir+File.separator+fileName);
            while(file.exists()){
                fileName=name+i+"."+ext;
                file=new File(context+dir+File.separator+fileName);
                i+=1;
            }
       // }
    /*    else{
            ext=FilenameUtils.getExtension(extractFileName(part));
            fileName=name+"."+ext;
        }*/
        try(InputStream input=part.getInputStream()){
            Files.copy(input, file.toPath());
        }
        //part.write(savePath+File.separator+fileName);
        return dir+File.separator+fileName;
        
    }
    
    private static String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }
    
}
