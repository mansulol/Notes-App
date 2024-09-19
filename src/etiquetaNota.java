
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class etiquetaNota extends JPanel implements MouseListener {
    
    String titulo;
    String detalles;

    JLabel tituloLabel;
    JLabel fechaLabel;

    notaGui nota;

    private settings ajustes = new settings();

    etiquetaNota(notaGui nota){
        this.nota = nota;
        this.titulo = nota.getTitulo();
        this.detalles = nota.getFechaHoraString();

        // Le doy un tamaño al panel
        setPreferredSize(new Dimension(ajustes.ANCHO_NOTA, 44));
        
        // Lo personalizo con un color definido, y borde superior azul
        setBackground(settings.COLOR_FONDO_PRIMARIO);
        setBorder(BorderFactory.createMatteBorder(10, 0, 0, 0, ajustes.COLOR_PRIMARIO));
        setLayout(null);

        addMouseListener(this);
        addComponents();
    }
    
    private void addComponents() {
        tituloLabel = new JLabel(titulo);
        tituloLabel.setBounds(10, 10, ajustes.ANCHO_NOTA, 20);
        tituloLabel.setFont(ajustes.FUENTE_TITULO);
        tituloLabel.setForeground(ajustes.DEFAULT_WHITE);
        
        fechaLabel = new JLabel(detalles);
        fechaLabel.setFont(ajustes.FUENTE_FECHA);
        fechaLabel.setBounds( 0, 32, ajustes.ANCHO_NOTA, 11 );
        fechaLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        fechaLabel.setHorizontalAlignment(JLabel.RIGHT);
        fechaLabel.setForeground(ajustes.COLOR_PRIMARIO);

        add(tituloLabel);
        add(fechaLabel);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            nota.addComponents();
        } 
        catch (Exception i) {
            System.out.println("Solo se puede instanciar una vez");
        }
       nota.addComponents();
    }

    @Override
    public void mousePressed(MouseEvent e) {
       
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       
    }

    @Override
    public void mouseExited(MouseEvent e) {
       
    }
}
