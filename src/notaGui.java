import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;

public class notaGui extends JFrame{
    private String titulo;
    private String descripcion;
    private String fecha;
    private String hora;
    private int caracteres;

    // Objetos que almacenen el menu y las imagenes del menu
    JPanel contenedorMenu;
    JLabel imgAgregar;
    JLabel imgsettings;

    // Objetos principales
    JPanel contenedorContenido;
    JPanel contenedortitulo;
    JTextField textoTitulo;
    JLabel textoInfo;
    JScrollPane contenedorAreaTexto;
    JTextArea areaTexto;

    // Clase encargada de recoger todos los eventos que ocurran en la nota
    notaEvents eventosNota;
    Random random;

    // Para obtener fecha y hora
    GregorianCalendar calendario;
    SimpleDateFormat formatoFecha;
    SimpleDateFormat formatoHora;
    Date horaDate;

    private settings settings;

    notaGui(String fecha, String hora, String titulo, String descripcion){
        int caracteresDescripcion = descripcion.split(" ").length;

        this.fecha = fecha;
        this.hora = hora;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.caracteres = caracteresDescripcion;

        // Cargo los settings necesarios a esta clase
        settings = new settings();
        eventosNota = new notaEvents(this);
        random = new Random();

        
        addMouseListener(eventosNota);
        addKeyListener(eventosNota);

        actualizarFechas();
    }
    
    public void addComponents(){
        // settings del JFrame
        setLocation( random.nextInt(400, 900), random.nextInt(50, 160) );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Le doy los settings predeterminados al contenedor del contenido principal como tamaño y fondo
        contenedorContenido = new JPanel();
        contenedorContenido.setPreferredSize(new Dimension(settings.ANCHO_APP, settings.ANCHO_APP));
        contenedorContenido.setBackground(settings.COLOR_FONDO_SECUNDARIO);
        contenedorContenido.setLayout(null);
        add(contenedorContenido, BorderLayout.CENTER);
        pack();

        // Cargar Menu, personalizarlo y añadirlo al contenido
        contenedorMenu = new JPanel();
        contenedorMenu.setBounds(0, 0, settings.ANCHO_APP, 30);
        contenedorMenu.setBackground(settings.COLOR_PRIMARIO);
        contenedorMenu.setLayout(new BorderLayout());
        
        // Añadir los iconos a la barra de menu
        // Icono de añadir con su margen en la izquierda
        imgAgregar = loadImages(settings.RUTA_IMG_AGREGAR);
        imgAgregar.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        // Escuchador de mouse para añadir notas
        imgAgregar.addMouseListener(eventosNota);
        
        // Icono de settings con su margen en la derecha
        imgsettings = loadImages(settings.RUTA_IMG_PUNTOS);
        imgsettings.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        // Escuchador de mouse para ver settings
        imgsettings.addMouseListener(eventosNota);
        
        // Añado los iconos a la barra de menu
        contenedorMenu.add(imgAgregar, BorderLayout.WEST);
        contenedorMenu.add(imgsettings, BorderLayout.EAST);
        contenedorContenido.add(contenedorMenu, BorderLayout.NORTH);

        // Contenedor del titulo de la nota
        contenedortitulo = new JPanel();
        contenedortitulo.setBounds(13, 50, settings.ANCHO_NOTA, 30);
        contenedortitulo.setLayout(new BoxLayout(contenedortitulo, BoxLayout.Y_AXIS));
        contenedortitulo.setBackground(null);
        contenedorContenido.add(contenedortitulo);

        // Titulo de la nota
        textoTitulo = new JTextField(titulo);
        textoTitulo.setBorder(null);
        textoTitulo.setFont(settings.FUENTE_TITULO);
        textoTitulo.setForeground(settings.COLOR_SECUNDARIO);
        textoTitulo.setBackground(null);
        // Con su respectivo listener
        textoTitulo.addKeyListener(eventosNota);
        contenedortitulo.add(textoTitulo);

        // Para desplegar informacion de la nota
        textoInfo = new JLabel(getFechaHoraString()+" | Caracteres: "+getCaracteres());
        textoInfo.setBounds(13, 73, settings.ANCHO_NOTA, 20);
        textoInfo.setBackground(null);
        textoInfo.setForeground(settings.COLOR_TERCIARIO);
        textoInfo.setFont(settings.FUENTE_FECHA);
        contenedorContenido.add(textoInfo);

        // Primero creo el area de texto
        areaTexto = new JTextArea(descripcion);
        areaTexto.setBackground(settings.COLOR_FONDO_SECUNDARIO);
        areaTexto.setForeground(settings.COLOR_SECUNDARIO);
        areaTexto.setWrapStyleWord(true);
        areaTexto.setLineWrap(true);
        // Con su respectivo escuchador
        areaTexto.addKeyListener(eventosNota);
        
        // El contenedor de la area de texto es un componente de tipo JScrollPane
        contenedorAreaTexto = new JScrollPane(areaTexto);
        contenedorAreaTexto.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        contenedorAreaTexto.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        contenedorAreaTexto.setBounds(13, 100, settings.ANCHO_NOTA, 191);
        contenedorAreaTexto.setFont(settings.FUENTE_DESCRIPCION);
        contenedorAreaTexto.setBackground(settings.COLOR_FONDO_SECUNDARIO);
        contenedorAreaTexto.setBorder(null);
        contenedorContenido.add(contenedorAreaTexto);

        setVisible(true);
    }

    public void actualizarFechas(){
        // Instancio los objetos necesarios para obtener fecha y hora
        calendario = new GregorianCalendar();
        horaDate = calendario.getTime();

        // Creo los formatos de fecha y hora
        formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        formatoHora = new SimpleDateFormat("HH:mm");

        fecha = formatoFecha.format(horaDate);
        hora = formatoHora.format(horaDate);
    }

    public void actualizarCaracteres(){
        caracteres = getDescripcion().split(" ").length;
    }
    
    private JLabel loadImages(String ruta){
        JLabel imgContainer;
        BufferedImage bufferImg;

        try {
            InputStream input = this.getClass().getResourceAsStream(ruta);
            bufferImg = ImageIO.read(input);
            imgContainer = new JLabel(new ImageIcon(bufferImg));

            return imgContainer;
        } 
        catch (Exception e) {
            System.err.println("Error: "+e);
            return new JLabel("Decripted");
        }
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof notaGui) {
            notaGui nota = (notaGui) obj;
            return nota.hashCode() == this.hashCode();
            
        }

        return false;
    }

    @Override
    public int hashCode(){
        return (titulo.hashCode() + hora.hashCode() + fecha.hashCode()) * 15;
    }

    // Getteres
    public String getTitulo(){ return titulo; }

    public String getDescripcion(){ return descripcion; }

    public int getCaracteres(){ 
        actualizarCaracteres();
        return caracteres; 
    }

    private String getFecha(){
        actualizarFechas();
        return fecha;
    }
    
    private String getHora(){
        actualizarFechas();
        return hora;
    }

    // Metodo que me devuelve la fecha y la hora en un string
    public String getFechaHoraString(){
        return getFecha()+ ", "+getHora();
    }

    // Setters
    public void setTitulo(String titulo){
        this.titulo = titulo;
        actualizarFechas();
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
        this.caracteres = getDescripcion().split(" ").length;
        actualizarFechas();
    }

    @Override
    public String toString(){
        return getFecha()+", "+getHora()+", "+getTitulo()+", "+getDescripcion()+", "+getCaracteres();
    }
}
