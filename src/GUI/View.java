/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Project.Compress;
import Project.Decompress;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author msi
 */
public class View extends JFrame implements ActionListener{
    
    JButton compressButton;
    JButton decompressButton;
    
    View(){
        this. setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //absolute Layout free to add button everywhere
        this.setLayout(null);
        
        compressButton = new JButton("Select a file to Compress");
        compressButton.addActionListener(this);
        compressButton.setBounds(20,100,200,30);
        
        decompressButton = new JButton("Select a file to Dompress");
        decompressButton.addActionListener(this);
        decompressButton.setBounds(250,100,200,30);
        
        this.add(compressButton);
        this.add(decompressButton);
        
        
        this.setSize(500,200);
        this.getContentPane().setBackground(Color.yellow);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == compressButton)
        {
           JFileChooser fileChooser = new JFileChooser();
           int response = fileChooser.showSaveDialog(null);
           
           if(response == JFileChooser.APPROVE_OPTION){
           
               File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
               System.out.println(file);
               
               try{
                   Compress.method(file);
                   JOptionPane.showMessageDialog(null,"Compression Successful !!!");
               }
               
               catch(HeadlessException | IOException excp){
                   JOptionPane.showMessageDialog(null, excp.toString());
               }
               
           }
        }
        
        
        
         if(e.getSource() == compressButton)
        {
           JFileChooser fileChooser = new JFileChooser();
           int response = fileChooser.showSaveDialog(null);
           
           if(response == JFileChooser.APPROVE_OPTION){
           
               File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
               System.out.println(file);
               
               try{
                   Decompress.method(file);
                   JOptionPane.showMessageDialog(null,"Decompress Successful !!!");
               }
               
               catch(HeadlessException | IOException excp){
                   JOptionPane.showMessageDialog(null, excp.toString());
               }
               
           }
        }
    }
    
    
    public static void main(String[] args){
        View frame = new View();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    
    
    
}
