
import java.awt.event.*;
import javax.swing.*;

public class notaEvents implements MouseListener, KeyListener {
    notaGui nota;

    notaEvents(notaGui nota){
        this.nota = nota;
        
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Raton clickado en nota");
        System.out.println("Fuente: "+e.getSource());
        System.out.println("Componente: "+e.getComponent());

        if(e.getSource() instanceof JPanel){
            if(e.getSource() instanceof JLabel){
                JLabel label = (JLabel) e.getSource();

                if(label == nota.imgAgregar){
                    System.out.println("\nImagen de agregar");
                }
                if(label == nota.imgsettings){
                    System.out.println("\nImagen de opciones");

                }
            }

            // JLabel imgAgregar = (JLabel) panel.getComponent(0);
            // JLabel imgOpciones = (JLabel) panel.getComponent(1);
            /*
            if(imgOpciones == nota.imgsettings){
                System.out.println("Settings");

                JDialog menuColores = new JDialog();
                menuColores.setTitle("Elige color...");
                menuColores.setSize(new Dimension(200, 100));
                menuColores.setLayout(new GridLayout(1, 4));

                JButton botonVerde = new JButton();
                JButton botonRosa = new JButton();
                JButton botonAmarillo = new JButton();
                JButton botonNaranja = new JButton();
                JButton botonAzul = new JButton();

                botonVerde.setBackground(settings.DEFAULT_GREEN);
                botonVerde.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                        nota.contenedorMenu.setBackground(settings.DEFAULT_GREEN);
                        nota.contenedorMenu.repaint();
                    }
                });

                botonRosa.setBackground(settings.DEFAULT_PINK);
                botonRosa.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                        nota.contenedorMenu.setBackground(settings.DEFAULT_PINK);
                        nota.contenedorMenu.repaint();
                    }
                });

                botonAmarillo.setBackground(settings.DEFAULT_YELLOW);
                botonAmarillo.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                        nota.contenedorMenu.setBackground(settings.DEFAULT_YELLOW);
                        nota.contenedorMenu.repaint();
                    }
                });

                botonNaranja.setBackground(settings.DEFAULT_ORANGE);
                botonNaranja.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                        nota.contenedorMenu.setBackground(settings.DEFAULT_ORANGE);
                        nota.contenedorMenu.repaint();
                    }
                });

                botonAzul.setBackground(settings.COLOR_PRIMARIO);
                botonAzul.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                        nota.contenedorMenu.setBackground(settings.COLOR_PRIMARIO);
                        nota.contenedorMenu.repaint();
                    }
                });

                menuColores.add(botonVerde);
                menuColores.add(botonRosa);
                menuColores.add(botonAmarillo);
                menuColores.add(botonNaranja);
                menuColores.add(botonAzul);

                menuColores.setVisible(true);
            }*/

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

        if( e.getSource() instanceof JTextField ){
            JTextField input = (JTextField) e.getSource();
            nota.setTitulo(input.getText());
            nota.actualizarFechas();
        }
        
        if( e.getSource() instanceof JTextArea ){
            JTextArea areaTexto = (JTextArea) e.getSource();
            nota.setDescripcion(areaTexto.getText());
            
            nota.textoInfo.setText( nota.getFechaHoraString()+" | Caracteres: "+nota.getCaracteres() );
            nota.textoInfo.repaint();
        }
        
    }
}