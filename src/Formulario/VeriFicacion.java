

package Formulario;

/**
 *@Autor
 *          JAVIER ANDRES HERRERA MANJARREZ
 */


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.*;
import javax.swing.JDialog;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
public class VeriFicacion {
    
    private final ArrayList<String> ArrNombre = new ArrayList<>(); //1
    private final ArrayList<String> ArrApellidos = new ArrayList<>(); //2
    private final ArrayList<String> ArrSexo = new ArrayList<>();  // 3
    private final ArrayList<String> ArrFeNacimiento = new ArrayList<>();  //4
    private final ArrayList<String> ArrEstudios = new ArrayList<>();  // 5
    private final ArrayList<String> ArrAltura = new ArrayList<>();  // 6
    private final ArrayList<String> ArrEdad = new ArrayList<>();  // 7
    private final ArrayList<String> ArrEstMilitar = new ArrayList<>();  // 8
    private final ArrayList<String> ArrIDN = new ArrayList<>();  // 9
    private final ArrayList<String> ArrFechCenso = new ArrayList<>();  // 10
    private final ArrayList<String> ArrDepaYPoblacion = new ArrayList<>();  // 11
    private final ArrayList<String> ArrCalleYNcasa = new ArrayList<>();  // 12
    
    private     File archivo;
    private     FileReader leer;
    private     BufferedReader almacenamiento;
    private  ArrayList<String> todasLasLineas = new ArrayList<>();
    
    public VeriFicacion() {
    
    }
    
    //*****************************************************************
    //*****************************************************************
    //*****************************************************************
    public boolean verificarSiEsta(String nom, String apellidos, String sexo, String fechaNaCi){
        odtenerDatosDeTxt();
        boolean resultado = false;
        
        for (int y = 0; y < ArrNombre.size() - 1; y++) {
            if (ArrNombre.get(y).equalsIgnoreCase(nom) && ArrApellidos.get(y).equalsIgnoreCase(apellidos) && ArrSexo.get(y).equalsIgnoreCase(sexo) && ArrFeNacimiento.get(y).equals(fechaNaCi)) {
                resultado=true;
                break;
            }
        }
        vaciarArrais();
        return resultado;
        
    }/// fin del metodo verificacion
    
    //*****************************************************************
    //*****************************************************************
    //*****************************************************************
    private void odtenerDatosDeTxt(){
         /////     llenando los ArrayList
        int lon=0;
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
                    todasLasLineas.add(lon,cadena);
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
        
        String[] datos= new String[12];
        for (int i = 0; i < todasLasLineas.size() - 1; i++) {
            String cadena2 = todasLasLineas.get(i);
            datos = cadena2.split("¡");
            ArrNombre.add(i,datos[0]);//1
            ArrApellidos.add(i,datos[1]);//2
            ArrSexo.add(i,datos[2]);//3
            ArrFeNacimiento.add(i,datos[3]);//4
            ArrEstudios.add(i,datos[4]);//5
            ArrAltura.add(i,datos[5]);//6
            ArrEdad.add(i,datos[6]);//7
            ArrEstMilitar.add(i,datos[7]);//8
            ArrIDN.add(i,datos[8]);//9
            ArrFechCenso.add(i,datos[9]);//10
            ArrDepaYPoblacion.add(i,datos[10]);//11
            ArrCalleYNcasa.add(i,datos[11]);//12
            
        }
        
        
        
    }

    //*****************************************************************
    //*****************************************************************
    //*****************************************************************
    public void elimiNarFila(int nun) {
        odtenerDatosDeTxt();
        if(ArrNombre.get(nun) != null){ 
            ArrNombre.remove(nun);//1
            ArrApellidos.remove(nun);//2
            ArrSexo.remove(nun);//3
            ArrFeNacimiento.remove(nun);//4
            ArrEstudios.remove(nun);//5
            ArrAltura.remove(nun);//6
            ArrEdad.remove(nun);//7
            ArrEstMilitar.remove(nun);//8
            ArrIDN.remove(nun);//9
            ArrFechCenso.remove(nun);//10
            ArrDepaYPoblacion.remove(nun);//11
            ArrCalleYNcasa.remove(nun);//12
            rescribirArchivoTxt();
            vaciarArrais();
            todasLasLineas.clear();
        }else{
            todasLasLineas.clear();
            vaciarArrais();
        }
    }
    
    //*****************************************************************
    //*****************************************************************
    //*****************************************************************
    //   imprincipal
    public JTable  nuevaTabla(){
        
        JTable tabla = new JTable();
        DefaultTableModel modelo = new DefaultTableModel(){
            //  para que no se pueda editar la tabla
        @Override
            public boolean isCellEditable(int row, int column){

            return false;
            }
        };

        ///****************************
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
        int lon=0;
        try{
            leer = new FileReader(archivo);
            // abrir el archivo que se le estraeran los datos
            almacenamiento = new BufferedReader(leer);
            //     Para obtener las lineas de testo de archivo
            while(cadena!=null){
                try{
                    
                     cadena = almacenamiento.readLine();
                     todasLasLineas.add(lon,cadena); lon++;
                    
                }catch(IOException ee){
                
                }
                //modelo.addRow(datos);
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
        
        
        for (int i = 0; i < todasLasLineas.size() - 1; i++) {
            String cadena2 = todasLasLineas.get(i);
            if(cadena2 != null){
                datos = cadena2.split("¡");

                modelo.addRow(datos);
            }
        }
         
        
        int val[] = {200, 200, 100, 150, 150, 75, 75, 100, 100, 100, 200, 200};
        
        
        
        //       color de las lines
        tabla.setGridColor(new Color(95,130,255));
        tabla.setForeground(new Color(0,0,0));
        tabla.setFont(new Font("calibri",2,16));
        
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
        
        todasLasLineas.clear();
        return tabla;
    }/// fin metodo nueva tabla

    //*****************************************************************
    //*****************************************************************
    //*****************************************************************
    private void rescribirArchivoTxt() {
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

        for (int o = 0; o < ArrNombre.size(); o++) {
            File archiv = new File("Usuarios.txt");// Para manipular al archivo
            FileWriter escribir;// para esccribir en el aechivo
            PrintWriter linea;// para escibir en el archivo
            try {
                escribir = new FileWriter(archiv, true); // de esta forma no remplaza el contenido del archivo si no que le agrega lineas 

                linea = new PrintWriter(escribir);// par aescribir en varias lineas de texto

                if (ArrNombre.get(o) != null) {
                    linea.println(ArrNombre.get(o)+"¡"+ArrApellidos.get(o)+"¡"+ArrSexo.get(o)+"¡"+ArrFeNacimiento.get(o)+"¡"
                            +ArrEstudios.get(o)+"¡"+ArrAltura.get(o)+"¡"+ArrEdad.get(o)+"¡"+ArrEstMilitar.get(o)+"¡"
                            +ArrIDN.get(o)+"¡"+ArrFechCenso.get(o)+"¡"+ArrDepaYPoblacion.get(o)+"¡"+ArrCalleYNcasa.get(o));//1


                }

                linea.close();
                escribir.close();
            } catch (IOException rr) {

            }

        }
        
    }//// fin metodo rescribir archivo
    
    //*****************************************************************
    //*****************************************************************
    //*****************************************************************
    public void rescribirDatosDePersona(int num){
        odtenerDatosDeTxt();
        if(ArrApellidos.get(num)!=null){
        
            JDialog ventanaEdit = new JDialog();
            ventanaEdit.setLayout(null);

            JLabel titulo = new JLabel("Edición de datos", SwingConstants.CENTER);
            titulo.setForeground(Color.BLACK);
            titulo.setBackground(new Color(255, 130, 249));
            titulo.setFont(new Font("arial", 1, 26));
            titulo.setBounds(242, 12, 516, 42);
            titulo.setOpaque(true);
            ventanaEdit.add(titulo);
            //**************************************************************
            //**************************************************************
            JTextField camNombre = new JTextField(ArrNombre.get(num));
            camNombre.setHorizontalAlignment(SwingConstants.CENTER);
            camNombre.setFont(new Font("Arial", 1, 26));
            camNombre.setBackground(new Color(246, 252, 243));
            camNombre.setBounds(10, 69, 516, 55);
            camNombre.setForeground(Color.BLACK);
            camNombre.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(246, 252, 243)), "Nombre(s)", TitledBorder.CENTER, TitledBorder.CENTER, new Font("calibri", 1, 16), Color.BLACK));
            camNombre.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char caracter = e.getKeyChar();//Comber a char
                    // Verificar si la tecla pulsada no es un digito
                    if (Character.isDigit(caracter)) {//si el caracter es un nuemero
                        e.consume();  // ignorar el evento de teclado 
                    }
                    if(camNombre.getText().endsWith(" ")){// el ultimo caracter es un espacio
                        if(caracter == ' '){
                            e.consume();
                        }
                    }
                }
            });
            ventanaEdit.add(camNombre);
            //**************************************************************
            //**************************************************************
            JTextField camApellido = new JTextField(ArrApellidos.get(num));
            camApellido.setHorizontalAlignment(SwingConstants.CENTER);
            camApellido.setFont(new Font("Arial", 1, 26));
            camApellido.setBackground(new Color(246, 252, 243));
            camApellido.setBounds(10, 139, 516, 55);
            camApellido.setForeground(Color.BLACK);
            camApellido.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(246, 252, 243)), "Apellido(s)", TitledBorder.CENTER, TitledBorder.CENTER, new Font("calibri", 1, 16), Color.BLACK));
            camApellido.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char caracter = e.getKeyChar();//Comber a char
                    // Verificar si la tecla pulsada no es un digito
                    if (Character.isDigit(caracter)) {//si el caracter es un nuemero
                        e.consume();  // ignorar el evento de teclado 
                    }
                    if(camApellido.getText().endsWith(" ")){// el ultimo caracter es un espacio
                        if(caracter == ' '){
                            e.consume();
                        }
                    }
                }
            });
            ventanaEdit.add(camApellido);
            //**************************************************************
            //**************************************************************
            JTextField numerIdentid = new JTextField(ArrIDN.get(num));
            numerIdentid.setHorizontalAlignment(SwingConstants.CENTER);
            numerIdentid.setFont(new Font("Arila", 1, 26));
            numerIdentid.setBackground(new Color(246, 252, 243));
            numerIdentid.setBounds(10, 217, 516, 55);
            numerIdentid.setForeground(Color.BLACK);
            numerIdentid.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(246, 252, 243)), "Número de identidad", TitledBorder.CENTER, TitledBorder.CENTER, new Font("calibri", 1, 16), Color.BLACK));
            numerIdentid.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char caracter = e.getKeyChar();
                    if (Character.isLetter(caracter) || Character.isWhitespace(caracter)) {
                        e.consume();
                    }
                    if (numerIdentid.getText().length() == 12) {
                        e.consume();
                    }
                }
            });
            ventanaEdit.add(numerIdentid);
            //**************************************************************
            //**************************************************************
            JTextField numMilitar = new JTextField(ArrEstMilitar.get(num));
            numMilitar.setHorizontalAlignment(SwingConstants.CENTER);
            numMilitar.setFont(new Font("Arial", 1, 26));
            numMilitar.setBackground(new Color(246, 252, 243));
            numMilitar.setBounds(10, 295, 516, 55);
            numMilitar.setForeground(Color.BLACK);
            numMilitar.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(246, 252, 243)), "Número de libreta militar", TitledBorder.CENTER, TitledBorder.CENTER, new Font("calibri", 1, 16), Color.BLACK));
            numMilitar.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    char caracter = e.getKeyChar();
                    if (Character.isLetter(caracter) || Character.isWhitespace(caracter)) {
                        e.consume();
                    }
                    if (numMilitar.getText().length() == 12) {
                        e.consume();
                    }
                }
            });
            ventanaEdit.add(numMilitar);

            //**************************************************************
            //**************************************************************
            JPanel panelEducation = new JPanel();
            JRadioButton radEdubasica = new JRadioButton("Básica");
            radEdubasica.setBackground(new Color(246, 252, 243));
            radEdubasica.setForeground(Color.BLACK);
            radEdubasica.setFont(new Font("Arial", 1, 18));
            JRadioButton radEduMedia = new JRadioButton("Media");
            radEduMedia.setBackground(new Color(246, 252, 243));
            radEduMedia.setForeground(Color.BLACK);
            radEduMedia.setFont(new Font("Arial", 1, 18));
            JRadioButton raEduSuperior = new JRadioButton("Superior");
            raEduSuperior.setBackground(new Color(246, 252, 243));
            raEduSuperior.setForeground(Color.BLACK);
            raEduSuperior.setFont(new Font("Arial", 1, 18));

            ButtonGroup selec = new ButtonGroup();
            selec.add(radEdubasica);
            selec.add(radEduMedia);
            selec.add(raEduSuperior);
            if (ArrEstudios.get(num).equals("Básica")) {
                radEdubasica.setSelected(true);
            } else if (ArrEstudios.get(num).equals("Media")) {
                radEduMedia.setSelected(true);
            } else {
                raEduSuperior.setSelected(true);
            }

            panelEducation.add(radEdubasica);
            panelEducation.add(radEduMedia);
            panelEducation.add(raEduSuperior);
            panelEducation.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(246, 252, 243)), "Estudios", TitledBorder.CENTER, TitledBorder.CENTER, new Font("colibri", 1, 20), Color.BLACK));
            panelEducation.setBackground(new Color(246, 252, 243));
            panelEducation.setLayout(new GridLayout(3, 1));
            panelEducation.setBounds(30, 365, 166, 120);
            ventanaEdit.add(panelEducation);

            //**************************************************************
            //**************************************************************
            JPanel panelSexo = new JPanel();
            JRadioButton masculino = new JRadioButton("Masculino");
            JRadioButton femenino = new JRadioButton("Femenino");
            JRadioButton otre = new JRadioButton("Otro");
            if (ArrSexo.get(num).equals("Masculino")) {
                masculino.setSelected(true);
            } else if (ArrSexo.get(num).equals("Femenino")) {
                femenino.setSelected(true);
            } else {
                otre.setSelected(true);
            }

            masculino.setBackground(new Color(246, 252, 243));
            masculino.setForeground(Color.BLACK);
            masculino.setFont(new Font("Arial", 1, 18));

            femenino.setBackground(new Color(246, 252, 243));
            femenino.setForeground(Color.BLACK);
            femenino.setFont(new Font("Arial", 1, 18));

            otre.setBackground(new Color(246, 252, 243));
            otre.setForeground(Color.BLACK);
            otre.setFont(new Font("Arial", 1, 18));

            ButtonGroup selectunica = new ButtonGroup();
            selectunica.add(masculino);
            selectunica.add(femenino);
            selectunica.add(otre);

            panelSexo.add(masculino);
            panelSexo.add(femenino);
            panelSexo.add(otre);
            panelSexo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(246, 252, 243)), "Sexo", TitledBorder.CENTER, TitledBorder.CENTER, new Font("colibri", 1, 20), Color.BLACK));
            panelSexo.setBackground(new Color(246, 252, 243));
            panelSexo.setLayout(new GridLayout(3, 1));
            panelSexo.setBounds(250, 365, 166, 120);
            ventanaEdit.add(panelSexo);
            //**************************************************************
            //**************************************************************
            //                   Fecha Nacimiento
            JPanel paFechaDeNa = new JPanel();

            int num1 = 0, num2 = 0, num3 = 0;
            String secmenta[] = ArrFeNacimiento.get(num).split("-");

            num1 = Integer.parseInt(secmenta[0]);
            num2 = Integer.parseInt(secmenta[1]);
            num3 = Integer.parseInt(secmenta[2]);
            //    ingresan la fecha                       |
            JLabel etiquetaDia = new JLabel("Dia:", SwingConstants.CENTER);
            etiquetaDia.setForeground(Color.black);
            etiquetaDia.setFont(new Font("Arial", 1, 18));
            paFechaDeNa.add(etiquetaDia);

            JSpinner spidia = new JSpinner();

            SpinnerNumberModel msDia = new SpinnerNumberModel();
            msDia.setMaximum(31);
            msDia.setMinimum(1);
            msDia.setValue(num1);
            spidia.setModel(msDia);
            spidia.setFont(new Font("Arial", 1, 18));
            spidia.setBorder(BorderFactory.createLineBorder(new Color(246,252,243)));
            spidia.setEditor(new JSpinner.DefaultEditor(spidia));
            spidia.getEditor().getComponent(0).setForeground(Color.BLACK);
            spidia.getEditor().getComponent(0).setBackground(new Color(246, 252, 243));
            paFechaDeNa.add(spidia);

            ///          etiqueta MES
            JLabel etiquetaMes = new JLabel("Mes:", SwingConstants.CENTER);
            etiquetaMes.setForeground(Color.black);
            etiquetaMes.setFont(new Font("Arial", 1, 18));
            paFechaDeNa.add(etiquetaMes);

            ///                        JSpinner mes
            JSpinner spiMes = new JSpinner();
            SpinnerNumberModel msMes = new SpinnerNumberModel();
            msMes.setMaximum(12);
            msMes.setMinimum(1);
            msMes.setValue(num2);
            spiMes.setModel(msMes);
            spiMes.setFont(new Font("Arial", 1, 18));
            spiMes.setEditor(new JSpinner.DefaultEditor(spiMes));
            spiMes.setBorder(BorderFactory.createLineBorder(new Color(246, 252, 243)));
            spiMes.getEditor().getComponent(0).setForeground(Color.black);
            spiMes.getEditor().getComponent(0).setBackground(new Color(246, 252, 243));
            paFechaDeNa.add(spiMes);

            ///          etiqueta AÑO
            JLabel etiquetayear = new JLabel("Año:", SwingConstants.CENTER);
            etiquetayear.setForeground(Color.black);
            etiquetayear.setFont(new Font("Arial", 1, 18));
            paFechaDeNa.add(etiquetayear);

            //              JSpinner  año
            JSpinner spiAAAa = new JSpinner();
            SpinnerNumberModel modeloAno = new SpinnerNumberModel();
            modeloAno.setMaximum(5000);
            modeloAno.setMinimum(1900);
            modeloAno.setValue(num3);
            spiAAAa.setModel(modeloAno);
            spiAAAa.setFont(new Font("Arial", 1, 18));
            spiAAAa.setEditor(new JSpinner.DefaultEditor(spiAAAa));
            spiAAAa.setBorder(BorderFactory.createLineBorder(new Color(246, 252, 243)));
            spiAAAa.getEditor().getComponent(0).setForeground(Color.black);
            spiAAAa.getEditor().getComponent(0).setBackground(new Color(246, 252, 243));
            paFechaDeNa.add(spiAAAa);

            paFechaDeNa.setLayout(new GridLayout(1, 6));
            paFechaDeNa.setBackground(new Color(246, 252, 243));
            paFechaDeNa.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(246, 252, 243)), "Fecha de Nasimiento", TitledBorder.CENTER, TitledBorder.CENTER, new Font("calibri", 1, 16), Color.black));
            paFechaDeNa.setBounds(557, 63, 424, 55);
            ventanaEdit.add(paFechaDeNa);

            //**************************************************************
            //**************************************************************
            //                   Fecha censo
            JPanel paFechaCenso = new JPanel();

            String secmenta2[] = ArrFechCenso.get(num).split("/");

            num1 = Integer.parseInt(secmenta2[0]);
            num2 = Integer.parseInt(secmenta2[1]);
            num3 = Integer.parseInt(secmenta2[2]);
            //    ingresan la fecha                       |
            JLabel etiquetaDi = new JLabel("Dia:", SwingConstants.CENTER);
            etiquetaDi.setForeground(Color.black);
            etiquetaDi.setFont(new Font("Arial", 1, 18));
            paFechaCenso.add(etiquetaDi);

            JSpinner spidi = new JSpinner();
            SpinnerNumberModel msDi = new SpinnerNumberModel();
            msDi.setMaximum(31);
            msDi.setMinimum(1);
            msDi.setValue(num1);
            spidi.setModel(msDi);
            spidi.setFont(new Font("Arial", 1, 18));
            spidi.setBorder(BorderFactory.createLineBorder(new Color(246,252,243)));
            spidi.setEditor(new JSpinner.DefaultEditor(spidi));
            spidi.getEditor().getComponent(0).setForeground(Color.BLACK);
            spidi.getEditor().getComponent(0).setBackground(new Color(246, 252, 243));
            paFechaCenso.add(spidi);

            ///          etiqueta MES
            JLabel etiquetaM = new JLabel("Mes:", SwingConstants.CENTER);
            etiquetaM.setForeground(Color.black);
            etiquetaM.setFont(new Font("Arial", 1, 18));
            paFechaCenso.add(etiquetaM);

            ///                        JSpinner mes
            JSpinner spiMe = new JSpinner();
            SpinnerNumberModel msMe = new SpinnerNumberModel();
            msMe.setMaximum(12);
            msMe.setMinimum(1);
            msMe.setValue(num2);
            spiMe.setModel(msMe);
            spiMe.setFont(new Font("Arial", 1, 18));
            spiMe.setEditor(new JSpinner.DefaultEditor(spiMe));
            spiMe.setBorder(BorderFactory.createLineBorder(new Color(246, 252, 243)));
            spiMe.getEditor().getComponent(0).setForeground(Color.black);
            spiMe.getEditor().getComponent(0).setBackground(new Color(246, 252, 243));
            paFechaCenso.add(spiMe);

            ///          etiqueta AÑO
            JLabel etiquetaye = new JLabel("Año:", SwingConstants.CENTER);
            etiquetaye.setForeground(Color.black);
            etiquetaye.setFont(new Font("Arial", 1, 18));
            paFechaCenso.add(etiquetaye);

            //              JSpinner  año
            JSpinner spiAAA = new JSpinner();
            SpinnerNumberModel modeloAn = new SpinnerNumberModel();
            modeloAn.setMaximum(5000);
            modeloAn.setMinimum(1900);
            modeloAn.setValue(num3);
            spiAAA.setModel(modeloAn);
            spiAAA.setFont(new Font("Arial", 1, 18));
            spiAAA.setEditor(new JSpinner.DefaultEditor(spiAAA));
            spiAAA.setBorder(BorderFactory.createLineBorder(new Color(246, 252, 243)));
            spiAAA.getEditor().getComponent(0).setForeground(Color.black);
            spiAAA.getEditor().getComponent(0).setBackground(new Color(246, 252, 243));
            paFechaCenso.add(spiAAA);

            paFechaCenso.setLayout(new GridLayout(1, 6));
            paFechaCenso.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(246, 252, 243)), "Fecha del cénso", TitledBorder.CENTER, TitledBorder.CENTER, new Font("calibri", 1, 16), Color.black));
            paFechaCenso.setBounds(559,124,424, 55);
            paFechaCenso.setBackground(new Color(246, 252, 243));
            ventanaEdit.add(paFechaCenso);       
            //**************************************************************
            //**************************************************************
            
            JLabel etAltura = new JLabel("Altura:",SwingConstants.CENTER);
            etAltura.setFont(new Font("Arial",1,18));
            etAltura.setForeground(Color.black);
            etAltura.setBounds(667,189,80,55);
            ventanaEdit.add(etAltura);
            
            JTextField caAltura = new JTextField(ArrAltura.get(num));
            caAltura.setHorizontalAlignment(SwingConstants.CENTER);
            caAltura.setBackground(new Color(246, 252, 243));
            caAltura.setForeground(Color.BLACK);
            caAltura.setFont(new Font("Arial",1,18));
            caAltura.setBounds(750,189,80,55);
            caAltura.setBorder(BorderFactory.createLineBorder(new Color(246, 252, 243)));
            caAltura.addKeyListener(new KeyAdapter(){
                @Override
                public void keyTyped(KeyEvent e){
                    char caracter = e.getKeyChar();
                    if (!Character.isDigit(caracter) && caracter != '.') {
                        e.consume();
                    }
                    if (caAltura.getText().contains(".") || caAltura.getText().length() ==0) {
                        if (caracter == '.') {
                            e.consume();
                        }
                    }

                    if (caAltura.getText().length() == 4) {
                        e.consume();
                    }
                    
                    
                }  
            });
            ventanaEdit.add(caAltura);
            //**************************************************************
            //**************************************************************
            
            JLabel etEdad = new JLabel("Edad:",SwingConstants.CENTER);
            etEdad.setFont(new Font("Arial",1,18));
            etEdad.setForeground(Color.black);
            etEdad.setBounds(667,254,80,55);
            ventanaEdit.add(etEdad);
            
            JTextField caEdad = new JTextField(ArrEdad.get(num));
            caEdad.setHorizontalAlignment(SwingConstants.CENTER);
            caEdad.setBackground(new Color(246, 252, 243));
            caEdad.setForeground(Color.BLACK);
            caEdad.setFont(new Font("Arial",1,18));
            caEdad.setBounds(750,254,80,55);
            caEdad.setBorder(BorderFactory.createLineBorder(new Color(246, 252, 243)));
            caEdad.addKeyListener(new KeyAdapter(){
                @Override
                public void keyTyped(KeyEvent e){
                    char caracter = e.getKeyChar();
                    if (((caracter < '0') || (caracter > '9')) || Character.isWhitespace(caracter)) {
                        e.consume();
                    }
                    if (caEdad.getText().length() == 2) {
                        e.consume();
                    }
                    
                }  
            });
            ventanaEdit.add(caEdad);
            
            //**************************************************************
            //**************************************************************
            JTextField caDepaYpoblcion = new JTextField(ArrDepaYPoblacion.get(num));
            caDepaYpoblcion.setHorizontalAlignment(SwingConstants.CENTER);
            caDepaYpoblcion.setBackground(new Color(246, 252, 243));
            caDepaYpoblcion.setForeground(Color.BLACK);
            caDepaYpoblcion.setFont(new Font("Arial",1,18));
            caDepaYpoblcion.setBounds(558,317,380,55);
            caDepaYpoblcion.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(246, 252, 243)),
                    "Departamento y pobalción", TitledBorder.CENTER, TitledBorder.CENTER, new Font("calibri",1, 16),
                    Color.black));
            caDepaYpoblcion.addKeyListener(new KeyAdapter(){
                @Override
                public void keyTyped(KeyEvent e){
                    char caracter = e.getKeyChar();
                    if (Character.isDigit(caracter)) {
                        e.consume();
                    }
                    
                    if(caDepaYpoblcion.getText().endsWith(" ")){
                        if(caracter == ' '){
                            e.consume();
                        }
                    }
                }  
            });
            ventanaEdit.add(caDepaYpoblcion);
            //**************************************************************
            //**************************************************************
            
            JTextField caCalleYnuCasa = new JTextField(ArrCalleYNcasa.get(num));
            caCalleYnuCasa.setHorizontalAlignment(SwingConstants.CENTER);
            caCalleYnuCasa.setBackground(new Color(246, 252, 243));
            caCalleYnuCasa.setForeground(Color.BLACK);
            caCalleYnuCasa.setFont(new Font("Arial",1,18));
            caCalleYnuCasa.setBounds(558,380,380,55);
            caCalleYnuCasa.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(246, 252, 243)),
                    "Calle y numero de casa", TitledBorder.CENTER, TitledBorder.CENTER, new Font("calibri", 1, 16),
                    Color.black));
            caCalleYnuCasa.addKeyListener(new KeyAdapter(){
                @Override
                public void keyTyped(KeyEvent e){
                    char caracter = e.getKeyChar();
                    
                    if(caDepaYpoblcion.getText().endsWith(" ")){// si el ultimo caracter es un espacio
                        if(caracter == ' '){
                            e.consume();
                        }
                    }
                }  
            });
            ventanaEdit.add(caCalleYnuCasa);
            //**************************************************************
            //**************************************************************
            
            JButton btncancelar = new JButton("Cancelar");
            btncancelar.setBackground(new Color(208,41,35));
            btncancelar.setFont(new Font("Arial",1,18));
            btncancelar.setForeground(Color.BLACK);
            btncancelar.setBounds(772,482,166,55);
            btncancelar.setBorder(BorderFactory.createLineBorder(Color.black));
            btncancelar.addActionListener((ActionEvent e) -> {
                Icon icono = new ImageIcon(getClass().getResource("/img/escoger.png"));
                int confir = JOptionPane.showConfirmDialog(null,"Los cambios realizados no seran guardados", "Confirme", JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION,icono);
                if(confir == JOptionPane.YES_OPTION){
                    ventanaEdit.dispose();
                    vaciarArrais();
                    todasLasLineas.clear();
                }
            });
            ventanaEdit.add(btncancelar);
            
            JButton btnAceptar = new JButton("Aceptar");
            btnAceptar.setBackground(new Color(27,238,12));
            btnAceptar.setFont(new Font("Arial",1,18));
            btnAceptar.setForeground(Color.BLACK);
            btnAceptar.setBounds(558,482,166,55);
            btnAceptar.setBorder(BorderFactory.createLineBorder(Color.black));
            btnAceptar.addActionListener((ActionEvent e) -> {
                
                Icon ico = new ImageIcon(getClass().getResource("/img/escoger.png"));
                int confir = JOptionPane.showConfirmDialog(null,"Confirme para realizar los cambios", "Confirme", JOptionPane.YES_NO_OPTION,JOptionPane.DEFAULT_OPTION,ico);
                if(confir == JOptionPane.YES_OPTION){
                    
                    String nombre = camNombre.getText();
                    String apellido = camApellido.getText();
                    String numeroIDN = numerIdentid.getText();
                    String nuMilitar = numMilitar.getText();
                    String altura = caAltura.getText();
                    String edad = caEdad.getText();
                    String depaYPobla = caDepaYpoblcion.getText();
                    String callNuCasa = caCalleYnuCasa.getText();
                    
                    if(nombre.equals("") || nombre.equals(" ") || nombre.endsWith(" ")  || apellido.equals("") || apellido.equals(" ") || apellido.endsWith(" ") ||
                            numeroIDN.equals("") || numeroIDN.equals(" ") || numeroIDN.endsWith(" ") || nuMilitar.equals("") || nuMilitar.equals(" ") || nuMilitar.endsWith(" ") ||
                                altura.equals("") || altura.equals(" ")|| altura.endsWith(" ") || edad.equals("") || edad.equals(" ") || edad.endsWith(" ") ||
                                    depaYPobla.equals("") || depaYPobla.equals(" ") || depaYPobla.endsWith(" ") || callNuCasa.equals("") || callNuCasa.equals(" ")|| callNuCasa.endsWith(" ")){
                        String nn = "/img/discrepar.png";
                        Icon icons = new ImageIcon(getClass().getResource(nn));
                        JOptionPane.showMessageDialog(null, "Ninguno de los capos puede quedar vacios\no con un espacio en blanco","Aviso",JOptionPane.DEFAULT_OPTION,icons);
                    }else{
                        
                        ArrNombre.remove(num); //1
                        ArrApellidos.remove(num); //2
                        ArrSexo.remove(num);// 3
                        ArrFeNacimiento.remove(num);  //4
                        ArrEstudios.remove(num); // 5
                        ArrAltura.remove(num);// 6
                        ArrEdad.remove(num);// 7
                        ArrEstMilitar.remove(num);  // 8
                        ArrIDN.remove(num);// 9
                        ArrFechCenso.remove(num);  // 10
                        ArrDepaYPoblacion.remove(num);  // 11
                        ArrCalleYNcasa.remove(num);  // 12
                        
                        String sexo="", educacion="", fechaCEnco="", fechaNAcimeiento="";
                        if (masculino.isSelected()) {
                            sexo = "Masculino";
                        }
                        if (femenino.isSelected()) {
                            sexo = "Femenino";
                        }
                        if (otre.isSelected()) {
                            sexo = "Indefinido";
                        }

                        ////
                        if (radEdubasica.isSelected()) {
                            educacion = "Baja";
                        }
                        if (radEduMedia.isSelected()) {
                            educacion = "Media";
                        }
                        if (raEduSuperior.isSelected()) {
                            educacion = "Superior";
                        }
                        
                        fechaNAcimeiento = String.valueOf(spidia.getValue())+"-"+String.valueOf(spiMes.getValue())+"-"+String.valueOf(spiAAAa.getValue());
                        fechaCEnco = String.valueOf(spidi.getValue())+"/"+String.valueOf(spiMe.getValue())+"/"+String.valueOf(spiAAA.getValue());;
                        ArrNombre.add(num,nombre); //1
                        ArrApellidos.add(num,apellido); //2
                        ArrSexo.add(num,sexo);// 3
                        ArrFeNacimiento.add(num,fechaNAcimeiento);  //4
                        ArrEstudios.add(num,educacion); // 5
                        ArrAltura.add(num,altura);// 6
                        ArrEdad.add(num,edad);// 7
                        ArrEstMilitar.add(num,nuMilitar);  // 8
                        ArrIDN.add(num,numeroIDN);;// 9
                        ArrFechCenso.add(num,fechaCEnco);  // 10
                        ArrDepaYPoblacion.add(num,depaYPobla);  // 11
                        ArrCalleYNcasa.add(num,callNuCasa);  // 12
                        
                        rescribirArchivoTxt();
                        vaciarArrais();
                        todasLasLineas.clear();
                        ventanaEdit.dispose();
                    }

                    
                }
            });
            ventanaEdit.add(btnAceptar);
            
            
            // propiedades del JDialog
            // evita que el boton cerrar de la cometa alguna acción
            ventanaEdit.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            ventanaEdit.setSize(997, 600);
            ventanaEdit.setResizable(false);
            ventanaEdit.setTitle("Edición");
            ventanaEdit.setLocationRelativeTo(null);
            ventanaEdit.getContentPane().setBackground(new Color(34, 255, 248));
            ventanaEdit.setModal(true);
            ventanaEdit.setVisible(true);

        }else{
            vaciarArrais();
        }
    }// fin metodo editar datos

    //*****************************************************************
    //*****************************************************************
    //*****************************************************************
    public void ordenarDatos(int num){
        
        odtenerDatosDeTxt();
        ArrayList<String> ArrNombr = (ArrayList) ArrNombre.clone(); //1
        ArrayList<String> ArrApellido = (ArrayList) ArrApellidos.clone(); //2
        ArrayList<String> ArrSex=(ArrayList) ArrSexo.clone();// 3
        ArrayList<String> ArrFeNacimient = (ArrayList) ArrFeNacimiento.clone();  //4
        ArrayList<String> ArrEstudio = (ArrayList) ArrEstudios.clone(); // 5
        ArrayList<String> ArrAltur = (ArrayList) ArrAltura.clone();// 6
        ArrayList<String> ArrEda = (ArrayList) ArrEdad.clone();// 7
        ArrayList<String> ArrEstMilita = (ArrayList) ArrEstMilitar.clone();  // 8
        ArrayList<String> ArrID = (ArrayList) ArrIDN.clone();// 9
        ArrayList<String> ArrFechCens = (ArrayList) ArrFechCenso.clone();  // 10
        ArrayList<String> ArrDepaYPoblacio = (ArrayList) ArrDepaYPoblacion.clone();  // 11
        ArrayList<String> ArrCalleYNcas = (ArrayList) ArrCalleYNcasa.clone();  // 12
        
        // vaciar los otros arraris
        vaciarArrais();
        todasLasLineas.clear();
        
        char letras[] = new char[27];
        
        if(num ==1){
            char colesuno[] = {'a', 'b', 'c', 'd', 'e','f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
            for(int tt=0; tt<colesuno.length; tt++){
                letras[tt]=colesuno[tt];
            }
        }else if(num == 2){
            char colesuno[] = {'z', 'y', 'x', 'w', 'v','u', 't', 's', 'r', 'q', 'p', 'o', 'ñ', 'n', 'm', 'l',
                'k', 'j', 'i', 'h', 'g', 'f', 'e', 'd', 'c', 'b', 'a'};
            for(int tt=0; tt<colesuno.length; tt++){
                letras[tt]=colesuno[tt];
            }
        
        }else if(num == 3){
            char colesuno[] = {'g', 'f', 'e', 'd','z', 'y', 'x', 'a', 'p', 'o', 'ñ', 'n', 'm', 'l','w', 'v',
                'u', 't', 's', 'r', 'q','k', 'j', 'i', 'h','b', 'c'};
            for(int tt=0; tt<colesuno.length; tt++){
                letras[tt]=colesuno[tt];
            }
        }
        for(int i=0; i<=letras.length-1; i++){
            //System.out.println(i+")"+letras[i]);
            for (int p = 0; p < ArrNombr.size(); p++) {  
                
                char letr[] = ArrNombr.get(p).toCharArray();
                String compa = String.valueOf(letr[0]);
 
                if(compa.equalsIgnoreCase(String.valueOf(letras[i]))){
                    ArrNombre.add(ArrNombr.get(p)); //1
                    ArrApellidos.add(ArrApellido.get(p)); //2
                    ArrSexo.add(ArrSex.get(p));// 3
                    ArrFeNacimiento.add(ArrFeNacimient.get(p));  //4
                    ArrEstudios.add(ArrEstudio.get(p)); // 5
                    ArrAltura.add(ArrAltur.get(p));// 6
                    ArrEdad.add(ArrEda.get(p));// 7
                    ArrEstMilitar.add(ArrEstMilita.get(p));  // 8
                    ArrIDN.add(ArrID.get(p));// 9
                    ArrFechCenso.add(ArrFechCens.get(p));  // 10
                    ArrDepaYPoblacion.add(ArrDepaYPoblacio.get(p));  // 11
                    ArrCalleYNcasa.add(ArrCalleYNcas.get(p));  // 12
                }
 
            }
            
            
        }
        
        rescribirArchivoTxt();
        vaciarArrais();
    }// fin metodo ordenar
    
    //*****************************************************************
    //*****************************************************************
    //*****************************************************************
    private void vaciarArrais(){
        ArrNombre.clear(); //1
        ArrApellidos.clear(); //2
        ArrSexo.clear();// 3
        ArrFeNacimiento.clear();  //4
        ArrEstudios.clear(); // 5
        ArrAltura.clear();// 6
        ArrEdad.clear();// 7
        ArrEstMilitar.clear();  // 8
        ArrIDN.clear();// 9
        ArrFechCenso.clear();  // 10
        ArrDepaYPoblacion.clear();  // 11
        ArrCalleYNcasa.clear();  // 12  
    }

}///   fin de la clase