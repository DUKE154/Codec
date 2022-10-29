/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project;
import java.io.*;
import java.util.zip.GZIPInputStream;

/**
 *
 * @author msi
 */
public class Decompress {
    
    public static void method(File file) throws IOException{
        String fileDirectory = file.getParent();
        System.out.println(fileDirectory);
        
         //fileInputStream readthe input file 
        FileInputStream fis = new FileInputStream(file);
        //After reading fileoutstream used to write on file in compressedfile.gz
       
        FileOutputStream fos = new FileOutputStream(fileDirectory + "/Decompressfile.txt");
        
        //compressed charactere seen by below 
        GZIPInputStream gis = new GZIPInputStream(fis);
        
                
        byte [] buffer = new byte[1024];
        
        int len = 0;
       
       while((len = gis.read(buffer)) != -1){
           fos.write(buffer,0,len);
       }
        //System.out.println(Arrays.toString(buffer));
        
        gis.close();
        fos.close();
        fis.close();
    }
    
    public static void main(String[] args) throws IOException{
    File file = new File("C:\\Users\\msi\\OneDrive\\Documents\\NetBeansProjects\\CompressDecompress\\src\\compressdecompress\\Compressedfile.gz");
    method(file);
    }
}
