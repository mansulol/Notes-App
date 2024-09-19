import java.awt.*;

public class settings {
    settings(){

    }

    public static final Font FUENTE_TITULO_APP = new Font("Arial", Font.BOLD, 20);
    public static final Font FUENTE_TITULO = new Font("Inter", Font.PLAIN, 14);
    public static final Font FUENTE_DESCRIPCION = new Font("Arial", Font.PLAIN , 12);
    public static final Font FUENTE_FECHA = new Font("Arial", Font.PLAIN , 10);

    public static final Color COLOR_FONDO_PRIMARIO = Color.decode("#363434");
    public static final Color COLOR_FONDO_SECUNDARIO = Color.decode("#454242");
    
    public static final Color COLOR_PRIMARIO = Color.decode("#86C7EC");
    public static final Color COLOR_SECUNDARIO = Color.decode("#1E1E1E");
    public static final Color COLOR_TERCIARIO = Color.decode("#363434");

    public static final Color DEFAULT_WHITE = Color.white;
    public static final Color DEFAULT_BLACK = Color.black;

    public static final Color DEFAULT_YELLOW = Color.decode("#e6b905");
    public static final Color DEFAULT_GREEN = Color.decode("#6fd262");
    public static final Color DEFAULT_PINK = Color.decode("#ea86c2");
    public static final Color DEFAULT_ORANGE = Color.decode("#FF6625");

    public static final int ANCHO_APP = 300;  
    public static final int ALTO_APP = 550;
    
    public static final int ANCHO_NOTA = 274;
    public static final int ALTO_NOTA = 44;

    public static final String RUTA_IMG_PUNTOS = "/assets/dots.png";
    public static final String RUTA_IMG_AGREGAR = "/assets/plus.png";
    public static final String RUTA_IMG_BUSCAR = "/assets/glass.png";
    public static final String RUTA_IMG_AJUSTES = "/assets/settings.png";
}
