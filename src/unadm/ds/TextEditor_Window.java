/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unadm.ds;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 *
 * @author 0
 */
public class TextEditor_Window{
    
    public JFrame frame = new JFrame("Editor de Texto");
    public JMenuBar barra = new javax.swing.JMenuBar();
    public JPanel mPanelContainer = new JPanel();

    //menu
    public JMenuItem menuItemNuevo;
    public JMenuItem menuItemAbrir;
    public JMenuItem menuItemGuardar;
    public JMenuItem menuItemSaveAs;
    public JMenuItem menuItemSalir;
    
    //text Area
    
    public JTextArea textArea;
    //El text Area debe ser scrolleable
    private JScrollPane scrollPane;

    public TextEditor_Window() {
        
        //Iniciar componentes
        //Iniciar frame o la ventana
        frame.setLocation(520, 200);
        frame.setVisible(true);
        frame.setSize(600, 600);
        //Permitir que el frame cierre la aplicacion al hacer click en cerrar
        //ventana
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
        //Iniciar menu
        this.setupMenu();
        frame.add(barra, BorderLayout.PAGE_START);
        
        //TODO: agregar area de texto
        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea);
        
        frame.add(scrollPane,BorderLayout.CENTER);
    }
    
    //crear el menu del editor de texto
    private void setupMenu(){
        //Menu Archivo
        JMenu archivo = new javax.swing.JMenu();
        archivo.setText("Archivo");

        menuItemNuevo = new JMenuItem();
        menuItemNuevo.setText("Nuevo");
        menuItemNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Clikeado nuevo");
                new TextEditor_Window();
            }
        });
        archivo.add(menuItemNuevo);
        archivo.add(new JSeparator(SwingConstants.HORIZONTAL));
        
        // menu Abrir
        menuItemAbrir = new JMenuItem();
        menuItemAbrir.setText("Abrir");
        menuItemAbrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Clikeado abrir");
            }
        });
        archivo.add(menuItemAbrir);
        archivo.add(new JSeparator(SwingConstants.HORIZONTAL));
        
        //Menu Guardar
        
        menuItemGuardar = new JMenuItem();
        menuItemGuardar.setText("Guardar");
        menuItemGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Clikeado guardar");
            }
        });
        archivo.add(menuItemGuardar);
        archivo.add(new JSeparator(SwingConstants.HORIZONTAL));
        
        //Menu Guardar como o renombrar
        
        menuItemSaveAs = new JMenuItem();
        menuItemSaveAs.setText("Guardar como ...");
        menuItemSaveAs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Clikeado guardar como");
            }
        });
        archivo.add(menuItemSaveAs);
                
        barra.add(archivo);
               
    }
    
    

}

