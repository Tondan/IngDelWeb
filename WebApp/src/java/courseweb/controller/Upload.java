/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseweb.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.http.Part;

/**
 *
 * @author Toni & Tony
 */
public class Upload {
    
    protected static String Up(String context,Part part,String dir) throws IOException{
        //contructs path of the directory to save uploaded file
        String savePath=context+dir;
        //Creates the save directory if not exists
        File saveDir=new File(savePath);
        if(!saveDir.exists())
            saveDir.mkdir();
        
        String fileName=extractFileName(part);
        fileName=new File(fileName).getName();
        part.write(savePath+File.separator+fileName);
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