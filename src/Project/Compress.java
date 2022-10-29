/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project;
import java.io.*;
import java.util.Arrays;

import java.util.zip.GZIPOutputStream;

/**
 *
 * @author msi
 */
public class Compress {
    public static void method(File file) throws IOException {
        // gets the file directory by using getParent()
        String fileDirectory = file.getParent();
        //System.out.println(fileDirectory);    
        
        //fileInputStream readthe input file 
        FileInputStream fis = new FileInputStream(file);
        //After reading fileoutstream used to write on file in compressedfile.gz
       
        FileOutputStream fos = new FileOutputStream(fileDirectory + "/Compressedfile.gz");
        
        //compressed charactere seen by below 
        GZIPOutputStream gzipOS = new GZIPOutputStream(fos);
                
        byte [] buffer = new byte[1024];
        
        int len;
        
        while((len = fis.read(buffer)) != -1){
            gzipOS.write(buffer,0,len);
            
        }
        //System.out.println(Arrays.toString(buffer));
        
        gzipOS.close();
        fos.close();
        fis.close();
        
    }
    
    public static void main(String[] args) throws IOException {
           File path = new File("C:\\Users\\msi\\OneDrive\\Documents\\NetBeansProjects\\CompressDecompress\\src\\compressdecompress\\textfile.txt");
           method(path);
    }
    
    
    
}
