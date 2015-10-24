/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unadm.ds;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

/**
 *
 * @author 0
 */
public class FileBrowserEditor_Window {
    public JFrame frame = new JFrame("Editor de archivos");
    public JMenuBar barra = new javax.swing.JMenuBar();
    public JPanel mPanelContainer = new JPanel();
    
    JButton mBotonRojo, mBotonAzul;
    
    public FileBrowserEditor_Window(){
        //Iniciar componentes
        //Iniciar frame o la ventana
        frame.setLocation(130, 400);
        frame.setVisible(true);
        frame.setSize(400, 200);
        //Permitir que el frame cierre la aplicacion al hacer click en cerrar
        //ventana
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
        
        mBotonRojo = new JButton("Abrir");
        mBotonAzul = new JButton("Borrar");
        
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        
        mBotonRojo.setSize(80, 100);
        //mBotonRojo.setLocation(100, 500);
        mBotonRojo.setVisible(true);
        mBotonRojo.setBackground(Color.GRAY);
                
        mBotonAzul.setSize(80, 100);
        //mBotonAzul.setLocation(500, 500);
        mBotonAzul.setVisible(true);
        mBotonAzul.setBackground(Color.blue);
        
         panel.add(mBotonAzul);
        panel.add(mBotonRojo);
        
        frame.add(panel);
    }
    
    private void setListeners(){
         mBotonRojo.addMouseListener(new MouseAdapter() { 
            @Override
            public void mouseClicked(MouseEvent e){ 
                
                System.out.println("clic en el boton"); 
            } 
        }); 
        //El boton azul cambia a azul el fondo del panel
        mBotonAzul.addMouseListener(new MouseAdapter() { 
            @Override
            public void mouseClicked(MouseEvent e){ 
               
                System.out.println("clic en el boton"); 
            } 
        }); 
    }
}
