import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class gestorNotasGui extends JFrame{
    // La clase que se encarga de recoger eventos
    gestorNotasEvents gestorEventos = new gestorNotasEvents();

    // La clase con los ajuste necesarios
    private settings settings = new settings();
    
    // Contenedores principales, el menu y el contenido
    private JPanel contenedorContenido;
    private JPanel contenedorMenu;
    private JPanel contenedorLista;
    private JPanel contenedorListaNotas;
    
    // Componentes relacionados con el buscar notas
    private JPanel contenedorTitulo;
    private JLabel titulo;
    private JPanel contenedorBuscador;
    private JTextField inputBuscador;
    private JLabel buscadorImg;
    
    // Una lista para almacenar las notas
    private ArrayList<notaGui> notas;
    
    // imagenes
    JLabel imgAgregar;
    JLabel imgBuscar;
    JLabel imgsettings;
    JLabel imgPuntos;
    
    gestorNotasGui(){
        // Instanciar nuestro frame
        super.setTitle("Aplicacion de notas");
        setSize(new Dimension(settings.ANCHO_APP, settings.ALTO_APP));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        addMouseListener(gestorEventos);
        
        addComponents();
    }

    private void addComponents(){
        // El contenedor principal para alojar todos los demas componentes
        contenedorContenido = new JPanel();
        contenedorContenido.setPreferredSize(new Dimension(settings.ANCHO_APP, settings.ALTO_APP));
        contenedorContenido.setLayout(null);

        // Personalizar el contenedor principal
        contenedorContenido.setBackground(settings.COLOR_FONDO_PRIMARIO);
        add(contenedorContenido, BorderLayout.CENTER);
        pack();

        // Cargar Menu, personalizarlo y añadirlo al contenido
        contenedorMenu = new JPanel();
        contenedorMenu.setBounds(0, 0, settings.ANCHO_APP, 30);
        contenedorMenu.setBackground(settings.COLOR_PRIMARIO);
        contenedorMenu.setLayout(new BorderLayout());
        contenedorContenido.add(contenedorMenu, BorderLayout.NORTH);

        // Añadir los iconos a la barra de menu
        // Icono de añadir con su margen en la izquierda
        imgAgregar = loadImages(settings.RUTA_IMG_AGREGAR);
        imgAgregar.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        // Escuchador de mouse para añadir notas
        imgAgregar.addMouseListener(gestorEventos);
        
        // Icono de settings con su margen en la derecha
        imgsettings = loadImages(settings.RUTA_IMG_AJUSTES);
        imgsettings.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        // Escuchador de mouse para ver settings
        imgsettings.addMouseListener(gestorEventos);
        
        // Añado los iconos a la barra de menu
        contenedorMenu.add(imgAgregar, BorderLayout.WEST);
        contenedorMenu.add(imgsettings, BorderLayout.EAST);

        // Instanciar contenedor del titulo de la app
        contenedorTitulo = new JPanel();
        contenedorTitulo.setBounds(16, 49, settings.ANCHO_NOTA, 24);
        contenedorTitulo.setLayout(new BoxLayout(contenedorTitulo, BoxLayout.LINE_AXIS));
        contenedorTitulo.setBackground(null);
        
        // Instanciar el titulo personalizado
        titulo = new JLabel("Notas");
        titulo.setFont(settings.FUENTE_TITULO_APP);
        titulo.setForeground(settings.DEFAULT_WHITE);
        contenedorTitulo.add(titulo);
        contenedorContenido.add(contenedorTitulo);

        // Instanciar el contenedor el buscador
        contenedorBuscador = new JPanel();
        contenedorBuscador.setBounds(16, 83, settings.ANCHO_NOTA, 33);
        contenedorBuscador.setBackground(settings.COLOR_FONDO_SECUNDARIO);
        contenedorBuscador.setLayout(new BorderLayout());

        // Instanciar el input
        inputBuscador = new JTextField(" Buscar...");
        inputBuscador.setFont(settings.FUENTE_TITULO);
        inputBuscador.setBackground(null);
        inputBuscador.setForeground(settings.DEFAULT_BLACK);
        inputBuscador.setPreferredSize(new Dimension( 210, 19));
        contenedorBuscador.add(inputBuscador, BorderLayout.WEST);

        // Instanciar la lupa y añadirlo al buscador
        imgBuscar = loadImages(settings.RUTA_IMG_BUSCAR);
        imgBuscar.setSize(new Dimension(17, 17));
        imgBuscar.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 8));
        imgBuscar.setForeground(settings.DEFAULT_BLACK);
        contenedorBuscador.add(imgBuscar, BorderLayout.EAST);

        contenedorContenido.add(contenedorBuscador);

        // Instanciar el contenedor del contenedor de las notas
        contenedorLista = new JPanel();
        contenedorLista.setBackground(Color.blue);

        // Instanciar el contenedor de la lista de las notas
        contenedorListaNotas = new JPanel();
        contenedorListaNotas.setLayout(new BoxLayout(contenedorListaNotas, BoxLayout.Y_AXIS));
        contenedorListaNotas.setBackground(Color.red);
        contenedorLista.add(contenedorListaNotas);

        // Instanciar panel de scroll para las notas para el contenedor de las notas
        JScrollPane scrollPane = new JScrollPane(contenedorLista);
        scrollPane.setBounds(0, 132, settings.ANCHO_APP, 403);
        // Para que aparezca la barra vertical cuando sea necesario y nunca la horizontal
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);

        contenedorContenido.add(scrollPane);

        agregarNotas();
        
        setVisible(true);
    }

    private void agregarNotas(){
        dataHandler datos = new dataHandler();
        notas = datos.leerNotas();

        for(notaGui i: notas){
            etiquetaNota nota = new etiquetaNota(i);
            contenedorListaNotas.add(nota);
        }
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
}  