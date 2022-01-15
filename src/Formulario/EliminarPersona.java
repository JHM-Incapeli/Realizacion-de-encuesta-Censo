
package Formulario;

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
/**
 *@Autor
 *         JAVIER ANDRES HERRERA MANJARREZ
 */
public class EliminarPersona extends JPanel{
    
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
    
    public EliminarPersona() {
        setLayout(null);
        setBounds(0,0,900,500);
        setBackground(new Color(213,233,253));
    }
    
    public JPanel conponente(){
        setBackground(new Color(255,251,184));
        
        String cadena="";
        archivo = new File("Usuarios.txt");
        
        try{
            leer = new FileReader(archivo);
            // abrir el archivo que se le estraeran los datos
            almacenamiento = new BufferedReader(leer);
            //     Para obtener las lineas de testo de archivo
            while(cadena!=null){
                try{
                    cadena = almacenamiento.readLine();
                    //System.out.println(cadena);//1
                    ArrNombre.add(lon, cadena);
                    
                    cadena = almacenamiento.readLine();
                    //System.out.println(cadena);//2
                    ArrApellidos.add(lon,cadena);
                    
                    cadena = almacenamiento.readLine();
                    //System.out.println(cadena);//3
                    ArrSexo.add(lon, cadena);
                    
                    cadena = almacenamiento.readLine();
                    //System.out.println(cadena);//4
                    ArrFeNacimiento.add(lon, cadena);
                    
                    cadena = almacenamiento.readLine();
                    //System.out.println(cadena);// 5
                   ArrEstudios.add(lon, cadena);
                    
                    cadena = almacenamiento.readLine();
                    //System.out.println(cadena);//6
                    ArrAltura.add(lon, cadena);
                    
                    cadena = almacenamiento.readLine();
                    //System.out.println(cadena);//7
                    ArrEdad.add(lon, cadena);
                    
                    cadena = almacenamiento.readLine();
                    //System.out.println(cadena);//8
                    ArrEstMilitar.add(lon, cadena);
                    
                    cadena = almacenamiento.readLine();
                    //System.out.println(cadena);//9
                    ArrIDN.add(lon, cadena);
                    
                    cadena = almacenamiento.readLine();
                    //System.out.println(cadena);
                    ArrFechCenso.add(lon, cadena);
                   
                    cadena = almacenamiento.readLine();
                    //System.out.println(cadena);
                    ArrDepaYPoblacion.add(lon, cadena);
                    
                    cadena = almacenamiento.readLine();
                     //System.out.println(cadena);
                    ArrCalleYNcasa.add(lon, cadena);
                    
                    lon++;
                }catch(IOException ee){
                
                }
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

        JLabel titu= new JLabel("Eliminar a una persona",SwingConstants.CENTER);
        titu.setFont(new Font("calibri",2,40));
        titu.setOpaque(true);///   para que le color de fondo de la etiqueta no sea transparente
        titu.setBackground(new Color(255,15,84));
        titu.setBorder(BorderFactory.createLineBorder(new Color(255,15,84)));
        titu.setForeground(Color.BLACK);
        titu.setBounds(40,13,800,76);
        
        JPanel panelDearriva= new JPanel();
        panelDearriva.setLayout(null);
        panelDearriva.add(titu);
        panelDearriva.setBackground(new Color(255,213,93));
        panelDearriva.setBorder(BorderFactory.createLineBorder(new Color(255,213,93)));
        panelDearriva.setBounds(0,0, 900,100);
        add(panelDearriva);
        
        JLabel etmostrar = new JLabel("Ingrese los datos correctos de la persona",SwingConstants.CENTER);
        etmostrar.setBounds(0,101,900,40);
        etmostrar.setFont(new Font("calibri",2,24));
        etmostrar.setForeground(Color.BLACK);
        add(etmostrar);
        
        JButton btnAtra = new JButton("Atras");
        btnAtra.setFont(new Font("calibri",2,18));
        btnAtra.setBounds(740, 400,128,36);
        btnAtra.setBorder(BorderFactory.createLineBorder(new Color(255,213,93)));
        btnAtra.setBackground(new Color(255,213,93));
        btnAtra.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               removeAll();
               updateUI();
                 /*
                    System.out.println(ArrNombre.size());//1
                    System.out.println(ArrApellidos.size());//2
                    System.out.println(ArrSexo.size());
                    System.out.println(ArrFeNacimiento.size());
                    System.out.println(ArrEstudios.size());
                    System.out.println(ArrAltura.size());
                    System.out.println(ArrEdad.size());
                    System.out.println(ArrEstMilitar.size());
                    System.out.println(ArrIDN.size());
                    System.out.println(ArrFeNacimiento.size());
                    System.out.println(ArrDepaYPoblacion.size());
                    System.out.println(ArrCalleYNcasa.size());
                    
                    for(int i=0; i<ArrNombre.size() ; i++){
                    System.out.println(ArrNombre.get(i));//1
                    System.out.println(ArrApellidos.get(i));//2
                    System.out.println(ArrSexo.get(i));
                    System.out.println(ArrFeNacimiento.get(i));
                    System.out.println(ArrEstudios.get(i));
                    System.out.println(ArrAltura.get(i));
                    System.out.println(ArrEdad.get(i));
                    System.out.println(ArrEstMilitar.get(i));
                    System.out.println(ArrIDN.get(i));
                    System.out.println(ArrFechCenso.get(i));
                    System.out.println(ArrDepaYPoblacion.get(i));
                    System.out.println(ArrCalleYNcasa.get(i));
                    }
                  */
               DatosPersona datos =new DatosPersona();
               
               add(datos.componentes());
            }
        
        });
        add(btnAtra);
        
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
        //******************************************************************|
        
        JLabel imagen = new JLabel();
        imagen.setIcon(new ImageIcon(getClass().getResource("/imagenes/eliminar.png")));
        imagen.setBounds(322,200,256,256);
        add(imagen);
        
        Date mat = new Date();
        SimpleDateFormat forDia1 = new SimpleDateFormat("dd");
        SimpleDateFormat forMes2 = new SimpleDateFormat("MM");
        
        JButton btneliminar = new JButton("Eliminar");
        btneliminar.setBounds(40, 240,128,43);
        btneliminar.setFont(new Font("calibri",2,18));
        btneliminar.setBorder(BorderFactory.createLineBorder(new Color(249,76,84)));
        btneliminar.setBackground(new Color(249,76,84));
        btneliminar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                // camNombre   camApellidos   spidia  spiMes   spiAAAa
                if(camNombre.getText().equals("") ||camApellidos.getText().equals("") ){
                    Icon iconn = new ImageIcon(getClass().getResource("/imagenes/caja-vacia.png"));
                    JOptionPane.showMessageDialog(null, "Difgite los campos correctamente\nY cambie los numeros de las fechas\nque la persona no nacio hoy","Error",JOptionPane.DEFAULT_OPTION,iconn);
                }else{
                    String nombre= camNombre.getText();
                    String apellidos= camApellidos.getText();
                    String dia= String.valueOf(spidia.getValue());
                    String mess= String.valueOf(spiMes.getValue());
                    String ano= String.valueOf(spiAAAa.getValue());
                    String fecha = dia+"-"+mess+"-"+ano;
                    
                    boolean verifi =ArrNombre.contains(nombre);
                    boolean veri2=ArrApellidos.contains(apellidos);
                    boolean veri3=ArrFeNacimiento.contains(fecha);
                    int p1=-1;
                    boolean portsi=false;
                    if(verifi==true && veri2== true && veri3==true){
                        for(int y=0; y<ArrNombre.size()-1; y++){   
                            if(ArrNombre.get(y).equals(nombre) && ArrApellidos.get(y).equals(apellidos)&&ArrFeNacimiento.get(y).equals(fecha)){
                                p1=y;
                                portsi=true;
                                break;
                            }
 
                        }
                    }
                    
                    if(verifi==true && veri2== true && veri3==true && portsi==true){
                        Icon iconn = new ImageIcon(getClass().getResource("/imagenes/confirmar.png"));
                        ArrNombre.remove(p1);//1
                        ArrApellidos.remove(p1);//2
                        ArrSexo.remove(p1);//3
                        ArrFeNacimiento.remove(p1);//4
                        ArrEstudios.remove(p1);//5
                        ArrAltura.remove(p1);//6
                        ArrEdad.remove(p1);//7
                        ArrEstMilitar.remove(p1);//8
                        ArrIDN.remove(p1);//9
                        ArrFechCenso.remove(p1);//10
                        ArrDepaYPoblacion.remove(p1);//11
                        ArrCalleYNcasa.remove(p1);//12
                        
                        File archi = new File("Usuarios.txt");
                        FileWriter escri;
                        PrintWriter line;
                        
                        try {
                            escri = new FileWriter(archi);
                            line = new PrintWriter(escri);
                            
                            line.close();
                            escri.close();
                        } catch (IOException rr) {

                        }
                        
                        for(int o=0; o<ArrNombre.size();o++){
                            File archivo = new File("Usuarios.txt");// Para manipular al archivo
                            FileWriter escribir;// para esccribir en el aechivo
                            PrintWriter linea;// para escibir en el archivo
                            try {
                                escribir = new FileWriter(archivo,true); // de esta forma no remplaza el contenido del archivo si no que le agrega lineas 
                                              
                                linea = new PrintWriter(escribir);// par aescribir en varias lineas de texto
                                
                                if(ArrNombre.get(o)!=null){
                                    linea.println(ArrNombre.get(o));//1
                                    linea.println(ArrApellidos.get(o));//2
                                    linea.println(ArrSexo.get(o));//3
                                    linea.println(ArrFeNacimiento.get(o));//4
                                    linea.println(ArrEstudios.get(o));//5
                                    linea.println(ArrAltura.get(o));//6
                                    linea.println(ArrEdad.get(o));//7
                                    linea.println(ArrEstMilitar.get(o));//8
                                    linea.println(ArrIDN.get(o));//9
                                    linea.println(ArrFechCenso.get(o));//10
                                    linea.println(ArrDepaYPoblacion.get(o));//11
                                    linea.println(ArrCalleYNcasa.get(o));//12

                                }
                                
                                linea.close();
                                escribir.close();
                            } catch (IOException rr) {

                            }
                        }/// fin de for llenar archivo
                        camNombre.setText("");
                        camApellidos.setText("");
                        JOptionPane.showMessageDialog(null, "Eliminacion Exitoza","Confirmación", JOptionPane.DEFAULT_OPTION,iconn );
                    }else{
                        Icon icons = new ImageIcon(getClass().getResource("/imagenes/encontrar.png"));
                        JOptionPane.showMessageDialog(null, "no se encontro a nadiencon estas caracteristicas","Aviso",JOptionPane.DEFAULT_OPTION,icons);
                    }
 
                } 
            }
        });// fin boton finalizar
        add(btneliminar);
        
        JPopupMenu meEmergente = new JPopupMenu();
        JSeparator nu1 = new JSeparator();
        JSeparator nu2 = new JSeparator();
                                
        JMenuItem btnMenus = new JMenuItem("Menú");
        btnMenus.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                removeAll();
                updateUI();

                Principal prin = new Principal();

                add(prin.Componente());
                meEmergente.removeAll();
            }
            
        });
        JMenuItem btnTAbla = new JMenuItem("Tabla de registrados");
        btnTAbla.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                removeAll();
                updateUI();
                DatosPersona dar = new DatosPersona();
                add(dar.componentes());
                meEmergente.removeAll();
            }
            
        });
        JMenuItem btnbuscar = new JMenuItem("Buscar persona");
        btnbuscar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                removeAll();
                updateUI();
                
                BuscarPersona eee =new BuscarPersona();
                add(eee.conponentes());
                meEmergente.removeAll();
            }
            
        });
           
        meEmergente.add(btnMenus);
        meEmergente.add(nu1);
        meEmergente.add(btnTAbla);
        meEmergente.add(nu2);
        meEmergente.add(btnbuscar);

        setComponentPopupMenu(meEmergente);
        
        return this;    
    }// fin del panle Conponente
}//   fin de la clase
