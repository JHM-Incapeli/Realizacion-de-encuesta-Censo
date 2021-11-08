
package Formulario;

/**
 *@Autores CARLOS ANDRES CONEO DIAZ
 *         ANDRES FABIAN BURGOS DE LAS SALAS 
 *         JAVIER ANDRES HERRERA MANJARREZ
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import javax.swing.border.*;
public class BuscarPersona extends JPanel{
    
    ArrayList<String> ArrNombre = new ArrayList<>(); //1
    ArrayList<String> ArrApellidos = new ArrayList<>(); //2
    ArrayList<String> ArrSexo = new ArrayList<>();  // 3
    ArrayList<String> ArrFeNacimiento = new ArrayList<>();  //4
    ArrayList<String> ArrEstudios = new ArrayList<>();  // 5
    ArrayList<String> ArrAltura = new ArrayList<>();  // 6
    ArrayList<String> ArrEdad = new ArrayList<>();  // 7
    ArrayList<String> ArrEstMilitar = new ArrayList<>();  // 8
    ArrayList<String> ArrIDN = new ArrayList<>();  // 9
    ArrayList<String> ArrFechCenso = new ArrayList<>();  // 10
    ArrayList<String> ArrDepaYPoblacion = new ArrayList<>();  // 11
    ArrayList<String> ArrCalleYNcasa = new ArrayList<>();  // 12
    int lon=0;
    File archivo;
    FileReader leer;
    BufferedReader almacenamiento;

    public BuscarPersona() {
        setLayout(null);
        setBounds(0,0,900,500);
    }
    
    public JPanel conponentes(){
        setBackground(new Color(199,249,182));
        String cadena = "";
        archivo = new File("Usuarios.txt");
        try {
            leer = new FileReader(archivo);
            // abrir el archivo que se le estraeran los datos
            almacenamiento = new BufferedReader(leer);
            //     Para obtener las lineas de testo de archivo
            while (cadena != null) {
                try {
                    cadena = almacenamiento.readLine();
                    ArrNombre.add(lon, cadena);

                    cadena = almacenamiento.readLine();
                    ArrApellidos.add(lon, cadena);

                    cadena = almacenamiento.readLine();
                    ArrSexo.add(lon, cadena);

                    cadena = almacenamiento.readLine();
                    ArrFeNacimiento.add(lon, cadena);

                    cadena = almacenamiento.readLine();
                    ArrEstudios.add(lon, cadena);

                    cadena = almacenamiento.readLine();
                    ArrAltura.add(lon, cadena);

                    cadena = almacenamiento.readLine();
                    ArrEdad.add(lon, cadena);

                    cadena = almacenamiento.readLine();
                    ArrEstMilitar.add(lon, cadena);

                    cadena = almacenamiento.readLine();
                    ArrIDN.add(lon, cadena);

                    cadena = almacenamiento.readLine();
                    ArrFechCenso.add(lon, cadena);

                    cadena = almacenamiento.readLine();
                    ArrDepaYPoblacion.add(lon, cadena);

                    cadena = almacenamiento.readLine();
                    ArrCalleYNcasa.add(lon, cadena);

                    lon++;
                } catch (IOException ee) {

                }
            }
            try {
                //   cerrando bufer
                almacenamiento.close();
            } catch (IOException er) {

            }
            try {
                //   serrando archivo
                leer.close();
            } catch (IOException er) {

            }

        } catch (FileNotFoundException rr) {

        }
        
        JLabel titu= new JLabel("Buscar una persona",SwingConstants.CENTER);
        titu.setFont(new Font("calibri",2,40));
        titu.setOpaque(true);///   para que le color de fondo de la etiqueta no sea transparente
        titu.setBackground(new Color(6,166,94));
        titu.setBorder(BorderFactory.createLineBorder(new Color(6,166,94)));
        titu.setForeground(Color.BLACK);
        titu.setBounds(40,13,800,76);
        
        JPanel panelDearriva= new JPanel();
        panelDearriva.setLayout(null);
        panelDearriva.add(titu);
        panelDearriva.setBackground(new Color(108,232,104));
        panelDearriva.setBorder(BorderFactory.createLineBorder(new Color(108,232,104)));
        panelDearriva.setBounds(0,0, 900,100);
        add(panelDearriva);
        
        JLabel etmostrar = new JLabel("Ingrese los datos correctos de la persona a buscar",SwingConstants.CENTER);
        etmostrar.setBounds(0,101,900,40);
        etmostrar.setFont(new Font("calibri",2,24));
        etmostrar.setForeground(Color.BLACK);
        add(etmostrar);
        
        
        //             etiqueta
        JLabel etiNombre = new JLabel("Nombre(s):");
        etiNombre.setBounds(40, 130+30, 90, 20);
        etiNombre.setFont(new Font("calibri", 2, 16));
        etiNombre.setForeground(Color.black);
        add(etiNombre);
    
        //           campo de texto
        JTextField camNombre = new JTextField();
        camNombre.setHorizontalAlignment(SwingConstants.CENTER);
        camNombre.setBounds(115, 125+30, 200, 25);
        camNombre.setForeground(Color.black);
        camNombre.setBorder(BorderFactory.createLineBorder(new Color(216, 216, 245)));
        camNombre.setFont(new Font("calibri", 1, 16));
        camNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();//Comber a char
                // Verificar si la tecla pulsada no es un digito
                if ((Character.isDigit(caracter))) {//si el caracter es un nuemero
                    e.consume();  // ignorar el evento de teclado
                }
            }
        });
        add(camNombre);
        
        JLabel etiApellido = new JLabel("Apellidos:");
        etiApellido.setBounds(320, 130+30, 90, 20);
        etiApellido.setFont(new Font("calibri", 2, 16));
        etiApellido.setForeground(Color.black);
        add(etiApellido);
        
        JTextField camApellidos = new JTextField();
        camApellidos.setHorizontalAlignment(SwingConstants.CENTER);
        camApellidos.setBounds(390, 125+30, 200, 25);
        camApellidos.setForeground(Color.black);
        camApellidos.setBorder(BorderFactory.createLineBorder(new Color(216, 216, 245)));
        camApellidos.setFont(new Font("calibri", 1, 16));
        camApellidos.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();//Comber a char
                // Verificar si la tecla pulsada no es un digito
                if ((Character.isDigit(caracter))) {//si el caracter es un nuemero
                    e.consume();  // ignorar el evento de teclado 
                }
            }
        });
        add(camApellidos);
        
         //         etiqueta de la fecha
        JLabel etiFecha = new JLabel("Fecha de nacimiento");
        etiFecha.setFont(new Font("calibri",3,16));
        etiFecha.setForeground(Color.black);
        //etiFecha.setBorder(BorderFactory.createLineBorder(Color.black));
        etiFecha.setBounds(600, 125+30, 140, 30);
        add(etiFecha);
        
        //    ingresan la fecha                       |
        JLabel etiquetaDia = new JLabel();
        etiquetaDia.setText("Dia");
        etiquetaDia.setBounds(600, 155+30, 30, 30);
        add(etiquetaDia);
        
        JSpinner spidia = new JSpinner();
        Date dia = new Date();
        SimpleDateFormat forDia = new SimpleDateFormat("dd");
        int numeDia = Integer.parseInt(forDia.format(dia));
        SpinnerNumberModel msDia = new SpinnerNumberModel();
        msDia.setMaximum(31);
        msDia.setMinimum(1);
        msDia.setValue(numeDia);
        spidia.setModel(msDia);
        spidia.setEditor(new JSpinner.DefaultEditor(spidia));
        spidia.setBounds(620,155+30,40,30);
        add(spidia);
        
        ///          etiqueta MES
        ///
        JLabel etiquetaMes = new JLabel();
        etiquetaMes.setText("Mes");
        etiquetaMes.setBounds(665, 155+30, 30, 30);
        add(etiquetaMes);
        
        ///                        JSpinner mes
        JSpinner spiMes = new JSpinner();
        Date mes = new Date();
        SimpleDateFormat forMes = new SimpleDateFormat("MM");
        int numeMes = Integer.parseInt(forMes.format(mes));
        SpinnerNumberModel msMes = new SpinnerNumberModel();
        msMes.setMaximum(12);
        msMes.setMinimum(1);
        msMes.setValue(numeMes);
        spiMes.setModel(msMes);
        spiMes.setBounds(690,155+30,40,30);
        spiMes.setEditor(new JSpinner.DefaultEditor(spiMes));
        add(spiMes);
        
        ///          etiqueta AÑO
        ///
        JLabel etiquetayear = new JLabel();
        etiquetayear.setText("Año");
        //etiquetayear.setBorder(BorderFactory.createLineBorder(Color.black));
        etiquetayear.setBounds(735, 155+30, 30, 30);
        add(etiquetayear);
            
        //              JSpinner  año
        JSpinner spiAAAa = new JSpinner();
        Date daano = new Date();
        SimpleDateFormat forano = new SimpleDateFormat("YYYY");
        int numeAno = Integer.parseInt(forano.format(daano));
        SpinnerNumberModel modeloAno = new SpinnerNumberModel();
        modeloAno.setMaximum(5000);
        modeloAno.setMinimum(1900);
        modeloAno.setValue(numeAno);
        spiAAAa.setModel(modeloAno);
        spiAAAa.setBounds(760,155+30,60,30);
        spiAAAa.setEditor(new JSpinner.DefaultEditor(spiAAAa));
        add(spiAAAa);
        
        JButton btnAtra = new JButton("Atras");
        btnAtra.setFont(new Font("calibri",2,20));
        btnAtra.setBounds(740, 400,128,36);
        btnAtra.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(51, 255, 51),
                new Color(255, 153, 102), new Color(153, 0, 0), new Color(255, 102, 102)));
        btnAtra.setBackground(new Color(25,217,86));
        btnAtra.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               removeAll();
               updateUI();
               
               DatosPersona datos =new DatosPersona();
               add(datos.componentes());
            }
        });
        add(btnAtra);
        
        JButton buscar = new JButton("Buscar");
        buscar.setBounds(40, 240,128,43);
        buscar.setBackground(new Color(249,76,84));
        buscar.setForeground(new Color(0,0,0));
        buscar.setFont(new Font("calibri",2,20));
        buscar.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(51, 255, 51),
                new Color(255, 153, 102), new Color(153, 0, 0), new Color(255, 102, 102)));
        add(buscar);
        
        Date mat = new Date();
        SimpleDateFormat forDia1 = new SimpleDateFormat("dd");
        SimpleDateFormat forMes2 = new SimpleDateFormat("MM");
        
        JLabel imagen = new JLabel();
        imagen.setIcon(new ImageIcon(getClass().getResource("/img/buscar.png")));
        imagen.setBounds(322,200,256,256);
        add(imagen);
        
        buscar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent r){
                // camApellidos camNombre
                //  spidia spiMes  spiAAAa
                if(camApellidos.getText().equals("") || camNombre.getText().equals("") || String.valueOf(spidia.getValue()).equals(String.valueOf(forDia1.format(mat))) ){
                    Icon iconn = new ImageIcon(getClass().getResource("/imagenes/caja-vacia.png"));
                    JOptionPane.showMessageDialog(null, "Difgite los campos correctamente\nY cambie los numeros de las fechas\nque la persona no nacio hoy","Error",JOptionPane.DEFAULT_OPTION,iconn);
                
                }else{
                    
                    String nombre= camNombre.getText();
                    String apellidos= camApellidos.getText();
                    String dia= String.valueOf(spidia.getValue());
                    String mess= String.valueOf(spiMes.getValue());
                    String ano= String.valueOf(spiAAAa.getValue());
                    String fecha = dia+"-"+mess+"-"+ano;
                    String Auxiliar="";
                    boolean verifi =ArrNombre.contains(nombre);
                    boolean veri2=ArrApellidos.contains(apellidos);
                    boolean veri3=ArrFeNacimiento.contains(fecha);
                    int p1=0;
                    boolean portsi=false;
                    if(verifi==true && veri2== true && veri3==true){
                        for(int y=0; y<ArrNombre.size()-1; y++){   
                            if(ArrNombre.get(y).equals(nombre) && ArrApellidos.get(y).equals(apellidos)&&ArrFeNacimiento.get(y).equals(fecha)){
                                p1=y;
                                portsi=true;
                                Auxiliar+= "Nombre(s):    "+ArrNombre.get(p1);//1
                                Auxiliar += "\nApellido(s):    " + ArrApellidos.get(p1);//2
                                Auxiliar += "\nsexo:    " + ArrSexo.get(p1);//3
                                Auxiliar += "\nFecha de nacimiento:    " + ArrFeNacimiento.get(p1);//4
                                Auxiliar += "\nNivel de estudiios:    " + ArrEstudios.get(p1);//5
                                Auxiliar += "\nAltura:    " + ArrAltura.get(p1);//6
                                Auxiliar += "\nEdad:    " + ArrEdad.get(p1);//7
                                Auxiliar += "\nEstado militar:    " + ArrEstMilitar.get(p1);//8
                                Auxiliar += "\nIDN:    " + ArrIDN.get(p1);//9
                                Auxiliar += "\nFecha del censo:    " + ArrFechCenso.get(p1);//10
                                Auxiliar += "\nDepartamento y población:    " + ArrDepaYPoblacion.get(p1);//11
                                Auxiliar += "\nCalle y N° de Casa:    " + ArrCalleYNcasa.get(p1)+"\n\n";//12
                            }
 
                        }
                    }
                    
                    if(verifi==true && veri2== true && veri3==true && portsi==true){
                        String datos = Auxiliar;
                        
                        Image imagen = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/censo.png"));
                        
                        JDialog Dilo= new JDialog();
                        Dilo.setTitle("Datos");
                        Dilo.getContentPane().setBackground(new Color(199,249,182));
                        Dilo.setIconImage(imagen);
                        
                        TextArea texto = new TextArea(datos);
                        texto.setBackground(Color.white);
                        texto.setForeground(Color.black);
                        texto.setFont(new Font("calibri",2,16));
                        texto.setBounds(5,1,300,300);
                        texto.setEditable(false);
                        Dilo.add(texto);
                        
                        JLabel icono = new JLabel();
                        icono.setIcon(new ImageIcon(getClass().getResource("/img/resultado.png")));
                        icono.setBounds(330,60,64,64);
                        Dilo.add(icono);
                        
                        JButton btnCancelar = new JButton("Cerrar");
                        btnCancelar.setBounds(330,200,90,30);
                        btnCancelar.setBackground(new Color(0,221,0));
                        btnCancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent even){
                            Dilo.dispose();
			}
                        });// fin de un boton
                        Dilo.add(btnCancelar);
                        
                        Dilo.setResizable(false);
                        Dilo.setLayout(null);
                        Dilo.setLocationRelativeTo(null);
                        Dilo.setModal(true);// para que solo le permita utilizar la ventana principal cuando cierr esta
                        Dilo.setSize(450,345);
                        Dilo.setVisible(true);
                        
                    }else{
                        Icon icons = new ImageIcon(getClass().getResource("/imagenes/encontrar.png"));
                        JOptionPane.showMessageDialog(null, "no se encontro a nadiencon estas caracteristicas","Aviso",JOptionPane.DEFAULT_OPTION,icons);
                    } 
                }
            }
        });
        
        return this;
    }// fin Jpanel de componentes

    
}// fin clase
