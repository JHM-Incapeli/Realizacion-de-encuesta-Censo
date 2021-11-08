
package Formulario;

/**
 *@Autores CARLOS ANDRES CONEO DIAZ
 *          ANDRES FABIAN BURGOS DE LAS SALAS 
 *          JAVIER ANDRES HERRERA MANJARREZ
 */
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class DatosPersona extends JPanel{
    
  

    DefaultTableModel modelo;
    JTable tabla;
    
    File archivo;
    FileReader leer;
    BufferedReader almacenamiento;

    public DatosPersona() {
        setLayout(null);
        setBounds(0,0,900,500);
        setBackground(new Color(213,233,253));
    }
    
    //**********************************************************************************
    //                   panel de la tabla
    public JPanel componentes() {

        tabla = new JTable();
        setBackground(new Color(0, 92, 255));

        JPanel panelDeArriva = new JPanel();
        panelDeArriva.setBounds(0, 0, 900, 100);
        panelDeArriva.setBackground(new Color(0, 92, 255));
        panelDeArriva.setBorder(BorderFactory.createLineBorder(new Color(0, 92, 255)));
        panelDeArriva.setLayout(null);
        add(panelDeArriva);

        JButton btnBack = new JButton("Menú");
        btnBack.setBounds(74, 29, 90, 41);
        btnBack.setFont(new Font("calibri", 2, 20));
        btnBack.setBackground(new Color(255, 211, 180));
        btnBack.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent even) {
                removeAll();
                updateUI();

                Principal prin = new Principal();

                add(prin.Componente());
            }
        });// fin de un boton
        panelDeArriva.add(btnBack);
        
        
        JButton btnEliminar = new JButton("Eliminar una persona");
        btnEliminar.setBounds(600, 29, 180, 41);
        btnEliminar.setFont(new Font("calibri", 2, 20));
        btnEliminar.setBackground(new Color(255,15,84));
        btnEliminar.setBorder(BorderFactory.createLineBorder(new Color(255,15,84)));
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent even) {
                Icon icon = new ImageIcon(getClass().getResource("/imagenes/eliminadoArchivo.png"));
                JOptionPane.showMessageDialog(null,"Los datos borrados"
                                           +"\n no seran recuperables ","Alerta",JOptionPane.DEFAULT_OPTION,icon);
                removeAll();
                updateUI();
                
                EliminarPersona prin = new EliminarPersona();

                add(prin.conponente());
            }
        });// fin de un boton
        panelDeArriva.add(btnEliminar);
        
        JButton btnBuscar = new JButton("Buscar persona");
        btnBuscar.setBounds(300,29,180,40);
        btnBuscar.setFont(new Font("calibri",2,20));
        btnBuscar.setBackground(new Color(6,166,94));
        btnBuscar.setBorder(BorderFactory.createLineBorder(new Color(6,166,40)));
        btnBuscar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ee){
                
                removeAll();
                updateUI();
                
                BuscarPersona eee =new BuscarPersona();
                add(eee.conponentes());
            }
        });
        panelDeArriva.add(btnBuscar);
        
        

        modelo = new DefaultTableModel(){
            //  para que no se pueda editar la tabla
        @Override
            public boolean isCellEditable(int row, int column){

            return false;
            }
        };
        modelo.addColumn("Nombre(s)");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Sexo");
        modelo.addColumn("Fecha de nacimiento");
        modelo.addColumn("Nivel de estudios");
        modelo.addColumn("Altura");
        modelo.addColumn("Edad");
        modelo.addColumn("Estado militar ");
        modelo.addColumn("IDN");
        modelo.addColumn("Fecha del censo");
        modelo.addColumn("Departamento y población");
        modelo.addColumn("Calle y N°Casa");
        
        String cadena="";
        archivo = new File("Usuarios.txt");
        String[] datos= new String[12];
        try{
            leer = new FileReader(archivo);
            // abrir el archivo que se le estraeran los datos
            almacenamiento = new BufferedReader(leer);
            //     Para obtener las lineas de testo de archivo
            while(cadena!=null){
                try{
                    cadena = almacenamiento.readLine();
                    datos[0]= cadena;
                    datos[1]= almacenamiento.readLine();
                    datos[2]= almacenamiento.readLine();
                    datos[3]= almacenamiento.readLine();
                    datos[4]= almacenamiento.readLine();
                    datos[5]= almacenamiento.readLine();
                    datos[6]= almacenamiento.readLine();
                    datos[7]= almacenamiento.readLine();
                    datos[8]= almacenamiento.readLine();
                    datos[9]= almacenamiento.readLine();
                    datos[10]= almacenamiento.readLine();
                    datos[11]= almacenamiento.readLine();
                    
                }catch(IOException ee){
                
                }
                modelo.addRow(datos);
            }
            try{
                //   cerrando bufer
                almacenamiento.close();
            }catch(IOException er){
            
            }
            try{
                //   serrando archivo
                leer.close();
            }catch(IOException er){
            
            }
            
        }catch(FileNotFoundException rr){
        
        }
        
        
        int val[] = {200, 200, 100, 150, 100, 75, 75, 100, 100, 100, 200, 200};

        //       color de las lines
        tabla.setGridColor(new Color(95,130,255));
        tabla.setForeground(new Color(0,0,0));
        tabla.setFont(new Font("calibri",2,14));
        
        tabla.setModel(modelo);
        //tabla.getTableHeader() obtener encabesado de la tabla
        //       establece la altura de las filas
        tabla.setRowHeight(25);
        tabla.getTableHeader().setOpaque(false);
        tabla.getTableHeader().setBackground(new Color(95,130,255));
        tabla.getTableHeader().setFont(new Font("Calibri",2,14));
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabla.setAutoscrolls(true);
        //   establese el ancho de las columnas
        for (int p = 0; p < 12; p++) {
            tabla.getColumnModel().getColumn(p).setPreferredWidth(val[p]);
        }

        JScrollPane scrull = new JScrollPane(tabla/*,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS*/);
        scrull.setBounds(0, 101, 885, 360);   
        add(scrull);

        return this;
    }// fin de lpanel tabla

}
