import java.awt.event.*;

public class gestorNotasEvents implements MouseListener{

    gestorNotasEvents(){
        
    }

    @Override
    public void mouseClicked(MouseEvent e) { 
        Object fuente = e.getSource();

        System.out.println("JLabel pulsado");
        System.out.println("Fuente: "+fuente.toString());
    }

    @Override
    public void mousePressed(MouseEvent e) {  }

    @Override
    public void mouseReleased(MouseEvent e) {  }

    @Override
    public void mouseEntered(MouseEvent e) {  }

    @Override
    public void mouseExited(MouseEvent e) {  }
}