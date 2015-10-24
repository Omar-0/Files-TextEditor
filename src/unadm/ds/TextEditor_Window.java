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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
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
public class TextEditor_Window {

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

    //watch dog, cuida cuando el archivo fue editado
    public boolean watchDoge;
    //Referencia al archivo actual
    public File currentFile;   

    public TextEditor_Window() {

        //Iniciar componentes GUI
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

        frame.add(scrollPane, BorderLayout.CENTER);
    }

    //crear el menu del editor de texto
    private void setupMenu() {
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
        //Listener: Abrira el archivo de texto
        menuItemAbrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Clikeado abrir");
                JFileChooser fileChooser = new JFileChooser();
                //fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                int result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                    //una vez abierto el flujo obtener el resultado:
                    textArea.setText(leerArchivoTexto(selectedFile));
                }
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
                if(currentFile != null){
                    escribirArchivoTexto(textArea.getText(), currentFile);
                }else{
                    saveAsDialog();
                }
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
                saveAsDialog();
            }
        });
        archivo.add(menuItemSaveAs);

        barra.add(archivo);

    }
    
    //Metodo Salvar como dialogo
    
    private void saveAsDialog(){
         JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Guardar Archivo");

                int userSelection = fileChooser.showSaveDialog(frame);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();
                    System.out.println("Save as file: " + fileToSave.getAbsolutePath());
                    escribirArchivoTexto(textArea.getText(), fileToSave);
                }
    }

    //Metodo para escribir el archivo
    private void escribirArchivoTexto(String contenido, File destinationFile) {
        try {
            // if file doesnt exists, then create it
            if (!destinationFile.exists()) {
                destinationFile.createNewFile();
            }

            FileWriter fw = new FileWriter(destinationFile.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();

            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Metodo para leer un archivo
    private String leerArchivoTexto(File file) {
        //String fileName = "temp.txt";
        // This will reference one line at a time
        String line = null;
        String full = "";

        try {
            FileReader fileReader = new FileReader(file);
            //Abrir flujo
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                full += line + "\n";
            }
            //cerrar el flujo
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "No se pudo abrir" + file + "'");
        } catch (IOException ex) {
            System.out.println("Erro de lectura '" + file + "'");

        }
        //referencia al archivo actual
        currentFile = file;
        return full;
    }

}
