
package Formulario;

/**
 *@Autores CARLOS ANDRES CONEO DIAZ
 *          ANDRES FABIAN BURGOS DE LAS SALAS 
 *          JAVIER ANDRES HERRERA MANJARREZ
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.*;


public class Registro extends JPanel{
    
    private JLabel bajoInicio, inicio;
   // public ArrayList <DatosPersona> inDatos= new ArrayList<>();;
    
    File archivo;// Para manipular al archivo
    FileWriter escribir;// para esccribir en el aechivo
    PrintWriter linea;// para escibir en el archivo
    
    public Registro() {
        
        setLayout(null);
        setBounds(0,0,900,500);
        setBackground(new Color(242,234,191));
                     
    }
    public JPanel Componente() {
        
        archivo = new File("Usuarios.txt");
        
        inicio = new JLabel("Registro");
        inicio.setForeground(Color.black);
        inicio.setBorder(BorderFactory.createLineBorder(new Color(213,233,253)));
        inicio.setFont(new Font("calibri", 3, 60));
        inicio.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        inicio.setBounds(20, 20, 860, 60);
        inicio.setHorizontalAlignment(SwingConstants.CENTER);
        add(inicio); 
        
        
        bajoInicio = new JLabel("Por favor ingrese los siguientes datos");
        bajoInicio.setForeground(Color.black);
        bajoInicio.setBorder(BorderFactory.createLineBorder(Color.black));
        bajoInicio.setFont(new Font("calibri", 3, 20));
        bajoInicio.setBorder(BorderFactory.createEmptyBorder(10, 30, 0, 0));
        bajoInicio.setBounds(20, 82, 860, 30);
        bajoInicio.setHorizontalAlignment(SwingConstants.CENTER);
        add(bajoInicio); 
        
        JRadioButton masculino = new JRadioButton("Masculino");
        masculino.setBackground(new Color(242,234,191));
        masculino.setFont(new Font("calibri", 1, 15));
        masculino.setBounds(600,231,90,25);
        add(masculino);

        JRadioButton femenino = new JRadioButton("Femenino");
        femenino.setBackground(new Color(242,234,191));
        femenino.setFont(new Font("calibri", 1, 15));
        femenino.setBounds(600,256,90,25);
        add(femenino);
        
        JRadioButton otre = new JRadioButton("Otro");
        otre.setBackground(new Color(242,234,191));
        otre.setFont(new Font("calibri", 1, 15));
        otre.setBounds(600,281,90,25);
        add(otre);

        ButtonGroup selectunica = new ButtonGroup();
        selectunica.add(masculino);
        selectunica.add(femenino);
        selectunica.add(otre);

        // etiquea de seleccion de sexo
        JLabel etiSexo = new JLabel("Indique su sexo");
        etiSexo.setFont(new Font("calibri",3,16) );
        etiSexo.setForeground(Color.black);
        etiSexo.setBounds(600, 200, 110, 30);
        add(etiSexo);
        
        //             etiqueta
        JLabel etiNombre = new JLabel("Nombre(s):");
        etiNombre.setBounds(40, 130, 90, 20);
        etiNombre.setFont(new Font("calibri", 2, 16));
        etiNombre.setForeground(Color.black);
        add(etiNombre);
    
        //           campo de texto
        JTextField camNombre = new JTextField();
        camNombre.setHorizontalAlignment(SwingConstants.CENTER);
        camNombre.setBounds(115, 125, 200, 25);
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
        etiApellido.setBounds(320, 130, 90, 20);
        etiApellido.setFont(new Font("calibri", 2, 16));
        etiApellido.setForeground(Color.black);
        add(etiApellido);

        JTextField camApellidos = new JTextField();
        camApellidos.setHorizontalAlignment(SwingConstants.CENTER);
        camApellidos.setBounds(390, 125, 200, 25);
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
        etiFecha.setBounds(600, 125, 140, 30);
        add(etiFecha);
        
        //    ingresan la fecha                       |
        JLabel etiquetaDia = new JLabel();
        etiquetaDia.setText("Dia");
        etiquetaDia.setBounds(600, 155, 30, 30);
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
        spidia.setBounds(620,155,40,30);
        add(spidia);
        
        ///          etiqueta MES
        ///
        JLabel etiquetaMes = new JLabel();
        etiquetaMes.setText("Mes");
        //etiquetaMes.setBorder(BorderFactory.createLineBorder(Color.black));
        etiquetaMes.setBounds(665, 155, 30, 30);
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
        spiMes.setBounds(690,155,40,30);
        spiMes.setEditor(new JSpinner.DefaultEditor(spiMes));
        add(spiMes);
        
        ///          etiqueta AÑO
        ///
        JLabel etiquetayear = new JLabel();
        etiquetayear.setText("Año");
        //etiquetayear.setBorder(BorderFactory.createLineBorder(Color.black));
        etiquetayear.setBounds(735, 155, 30, 30);
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
        spiAAAa.setBounds(760,155,60,30);
        spiAAAa.setEditor(new JSpinner.DefaultEditor(spiAAAa));
        add(spiAAAa);
        //******************************************************************|


        //              etiqueta edad
       JLabel etiEdad = new JLabel("Su edad:");
       etiEdad.setBorder(BorderFactory.createEmptyBorder(5,0,0,0));
       etiEdad.setBounds(40,170,70,20);
       etiEdad.setForeground(Color.black);
       etiEdad.setFont(new Font("calibri",2,16));
       add(etiEdad);
       
       //             campo edad
       JTextField camEdad = new JTextField();
       camEdad.setBounds(100,170,30,20);
       camEdad.setBorder(BorderFactory.createLineBorder(new Color(216, 216, 245)));
       camEdad.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();//Comber a char
                // Verificar si la tecla pulsada no es un digito
                if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
                    e.consume();  // ignorar el evento de teclado
                }
            }
        });
       add(camEdad);
       
       
       //     etiqueta Edad
       JLabel etiAltura = new JLabel("Su altura:");
       etiAltura.setBounds(160,170,70,20);
       etiAltura.setFont(new Font("calibri",2,16));
       etiAltura.setForeground(Color.black);
       etiAltura.setBorder(BorderFactory.createEmptyBorder(5,0,0,0));
       add(etiAltura);
       
       
       JTextField camAltura = new JTextField();
       camAltura.setBounds(230,170,30,20);
       camAltura.setBorder(BorderFactory.createLineBorder(new Color(216, 216, 245)));
       //   acciones del teclado
       camAltura.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();//Comber a char
                // Verificar si la tecla pulsada no es un digito
                if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')&&(caracter != '.')) {
                    e.consume();  // ignorar el evento de teclado
                }
            }
        });
       add(camAltura);
       
      
       JPanel panelEducation =new JPanel();
       JRadioButton radEdubasica = new JRadioButton("Básica");
       radEdubasica.setBackground(new Color(242,234,191));
       JRadioButton radEduMedia = new JRadioButton("Media");
       radEduMedia.setBackground(new Color(242,234,191));
       JRadioButton raEduSuperior = new JRadioButton("Superior");
       raEduSuperior.setBackground(new Color(242,234,191));
       
       //       para que solo se marque uno
       ButtonGroup selec = new ButtonGroup();
       selec.add(radEdubasica);
       selec.add(radEduMedia);
       selec.add(raEduSuperior);
       
       // adñadiendo a panel
       panelEducation.add(radEdubasica);
       panelEducation.add(radEduMedia);
       panelEducation.add(raEduSuperior);
       panelEducation.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(242,234,191)),
                "Estudios", TitledBorder.CENTER,
                TitledBorder.CENTER,//  si colocasa RIGHT el titulo aparecera dentro de panel 
                new Font("colibri", 2, 16),
                new Color(0,0,0)));
       //panelEducation.setBorder(BorderFactory.createTitledBorder("Estudios"));
       panelEducation.setBackground(new Color(242,234,191));
       panelEducation.setLayout(new GridLayout(3,1));
       panelEducation.setBounds(300, 170, 100, 100);
       add(panelEducation);
       
       
       JButton btnAtras = new JButton("Atras");
       btnAtras.setBounds(200,400,90,30);
       btnAtras.setFont(new Font("calibri",2,16));
       add(btnAtras);
       btnAtras.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {     
              Principal princ = new Principal();    
              
              removeAll();
              updateUI();
              add(princ.Componente());           
            }
       });
       
       ///        imagen 
       JLabel imagen = new JLabel();
       imagen.setIcon(new ImageIcon(getClass().getResource("/imagenes/registro.png")));
       imagen.setBounds(20,300,128,128);
       add(imagen);
       
       
       JLabel noti=new JLabel("Departamento y población");
       
       JTextField camDireccion= new JTextField();
       camDireccion.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();//Comber a char
                // Verificar si la tecla pulsada no es un digito
                if ((Character.isDigit(caracter))) {//si el caracter es un nuemero
                    e.consume();  // ignorar el evento de teclado
                }
            }
        });
       camDireccion.setHorizontalAlignment(SwingConstants.CENTER);
       camDireccion.setBorder(BorderFactory.createLineBorder(new Color(216, 216, 245)));
       
       JLabel noti2= new JLabel("Calle y numero de la casa");
       
       JTextField camCalle= new JTextField();
       camCalle.setHorizontalAlignment(SwingConstants.CENTER);
       camCalle.setBorder(BorderFactory.createLineBorder(new Color(216, 216, 245)));
       
       JPanel PnelDIreccion= new JPanel();
       PnelDIreccion.add(noti);
       PnelDIreccion.add(camDireccion);
       PnelDIreccion.add(noti2);
       PnelDIreccion.add(camCalle);
       PnelDIreccion.setLayout(new GridLayout(4,1));
       PnelDIreccion.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(242,234,191)),
                                "Dirección",TitledBorder.CENTER, TitledBorder.CENTER, new Font("calibri",2,16), Color.black));
       PnelDIreccion.setBounds(410,170,160,120);
       PnelDIreccion.setBackground(new Color(242,234,191));
       add(PnelDIreccion);
       
       
       JButton btnFIanlizar = new JButton("Finalizar formulario");
       btnFIanlizar.setBounds(590,400,180,30);
       btnFIanlizar.setFont(new Font("calibri",2,14));
       add(btnFIanlizar);
       btnFIanlizar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {    
                //      JRadioButton
                //   femenino  otre masculino
                //   radEdubasica  radEduMedia   raEduSuperior
                
                //      JTextField
                //    camNombre  camApellidos  camEdad   camAltura
                
                ///        JSpinner
                //   spiMes   spiAAAa  spidia              
               
               if(masculino.isSelected() || femenino.isSelected() || otre.isSelected()){
                    //               segundos radio Button
                   if( radEdubasica.isSelected() || radEduMedia.isSelected() || raEduSuperior.isSelected()){
                       //               JTextField
                       if(camNombre.getText().equals("") || camApellidos.getText().equals("")
                               || camEdad.getText().equals("") || camAltura.getText().equals("")|| camDireccion.getText().equals("")
                               || camCalle.getText().equals("")) {
                           Icon icon = new ImageIcon(getClass().getResource("/imagenes/caja-vacia.png"));
                           JOptionPane.showMessageDialog(null,"Algunos campos de textos están vacíos","Error",JOptionPane.ERROR_MESSAGE,icon);
                       }else{
                           
                           try{
                               
                               String nombre= camNombre.getText();
                               String apellidos= camApellidos.getText();
                               String dia= String.valueOf(spidia.getValue());
                               String mess= String.valueOf(spiMes.getValue());
                               String ano= String.valueOf(spiAAAa.getValue());
                               String edad= camEdad.getText();
                               String altura= camAltura.getText();
                               String sexo="", educacion="", suitaMilitar="",DNI="";
                               String direccion=String.valueOf(camDireccion.getText());
                               String calle= String.valueOf(camCalle.getText());
                               boolean verifi=true;
                               ////
                               if(masculino.isSelected()){
                                   sexo="Masculino";
                                   
                               }
                               if(femenino.isSelected()){
                                   sexo="Femenino";
                               }
                               if(otre.isSelected()){
                                   sexo="Indefinido";
                               }
                               
                               ////
                               if(radEdubasica.isSelected()){
                                   educacion="Baja";
                               }
                               if(radEduMedia.isSelected()){
                                   educacion="Media";
                               }
                               if(raEduSuperior.isSelected()){
                                   educacion="Superior";
                               }
                               
                               String fechana=dia+"-"+mess+"-"+ano;
                               verifi=true;
                               if(Integer.parseInt(edad)> 16){
                                   do{
                                       try{
                                            verifi=true;
                                            DNI = JOptionPane.showInputDialog(null, "Ingrese su número de identidad","212...");
                                            char archar[] = DNI.toCharArray();
                                            int i=1;
                                            for(char c: archar){  
                                                if(Character.isLetter(c)&& i==1){
                                                   verifi=false;
                                                   i+=1;
                                                   JOptionPane.showMessageDialog(null,"Por favor digite solo numeros","Error",JOptionPane.ERROR_MESSAGE);
                                                }
                                            }
                                       }
                                       catch(NullPointerException errr){
                                           verifi=false;
                                       }
                                   }while(verifi==false);
                               }
                               
                               
                               ////                      suitacion militar
                               if(Integer.parseInt(edad)>= 18 && sexo.equals("Masculino")){
                                   do{
                                       try{
                                           verifi=true;
                                            suitaMilitar  = JOptionPane.showInputDialog(null, "Ingrese su número\nde su taregeta libreta militar\nsi no la tiene digite cinco ceros 00000","212...");
                                            char archar[] = suitaMilitar.toCharArray();
                                            int i=1;
                                            for(char c: archar){  
                                                if(Character.isLetter(c)&& i==1){
                                                   verifi=false;
                                                   i+=1;
                                                   JOptionPane.showMessageDialog(null,"Por favor digite solo numeros","Error",JOptionPane.ERROR_MESSAGE);
                                                }
                                            }
                                       }
                                       catch(NullPointerException errr){
                                           verifi=false;
                                       }
                                   }while(verifi==false);
                               }
 
                               Date fechaCenso= new Date();
                               SimpleDateFormat forfechCenso= new SimpleDateFormat("dd/MM/yyyy");
                               
                               String feCEnso = forfechCenso.format(fechaCenso);
                               
                               VeriFicacion vvv = new VeriFicacion();
                               
                               boolean resul = vvv.verificarSiEsta(nombre, apellidos, sexo, fechana);
                               
                               if (resul !=false) {
                                   Icon icon = new ImageIcon(getClass().getResource("/imagenes/comprobacion.png"));
                                   JOptionPane.showMessageDialog(null,"Usted ya esta en la base de datos\nno es necesario que realice el censo","Notificacion",JOptionPane.DEFAULT_OPTION,icon);
                                   
                               } else {
                                   try {
                                       //per.Datos(nombre,apellidos,sexo,fechana,educacion,altura,edad,suitaMilitar,DNI,feCEnso,direccion,calle);
                                       escribir = new FileWriter(archivo, true);
                                       linea = new PrintWriter(escribir);
                                       linea.println(nombre);
                                       linea.println(apellidos);
                                       linea.println(sexo);
                                       linea.println(fechana);
                                       linea.println(educacion);
                                       linea.println(altura);
                                       linea.println(edad);
                                       linea.println(suitaMilitar);
                                       linea.println(DNI);
                                       linea.println(feCEnso);
                                       linea.println(direccion);
                                       linea.println(calle);

                                       linea.close();
                                       escribir.close();
                                   } catch (IOException ex) {

                                   }
                                   removeAll();
                                   updateUI();
                                   FinFormulario fin = new FinFormulario();
                                   add(fin.Intefsss());
                               }

                               
                           }
                           catch(NumberFormatException er){
                               JOptionPane.showMessageDialog(null,"Error","Error",JOptionPane.ERROR_MESSAGE);
                           }
                       }
                   }else{
                       Icon icon = new ImageIcon(getClass().getResource("/imagenes/estudiantes.png"));
                       JOptionPane.showMessageDialog(null,"No ha seleccionado su nivel de estudio","Error",JOptionPane.DEFAULT_OPTION,icon); 
                   } 
                }else{
                    Icon icon = new ImageIcon(getClass().getResource("/imagenes/Sexo.png"));
                    JOptionPane.showMessageDialog(null,"No ha seleccionado su sexo ","Error",JOptionPane.DEFAULT_OPTION,icon); 
                }
            }
       });//  fin boton Finalizar registro
        return this;
    }
    /*
    public ArrayList<DatosPersona> getDatos(){
    
        return inDatos;
    }
    */
    /*
    
     ///////********************************************************************************************
     class PersonaDatos {

        String nombdre;
        String apellidos;
        String sexo;
        String fechaNaCi;
        String estudios;
        String altura;
        String eddaadd;
        String suMilitar;
        String IDNidentidad;
        String fechaDelcenso;
        String Direccion;
        String calle;

        public void PersonaDatos(String nom, String apellidos, String sexo, String fechaNaCi, String estudios, String altura, String eddaadd,
                String suMilitar, String IDNidentidad, String fechaDelcenso, String Direccion, String calle) {
            this.nombdre = nom;
            this.apellidos = apellidos;
            this.sexo = sexo;
            this.fechaNaCi = fechaNaCi;
            this.estudios = estudios;
            this.altura = altura;
            this.eddaadd = eddaadd;
            this.suMilitar = suMilitar;
            this.IDNidentidad = IDNidentidad;
            this.fechaDelcenso = fechaDelcenso;
            this.Direccion = Direccion;
            this.calle = calle;

            //lon++;
        }

    }///// fin f¿de la clase personaDatos
    */
}
