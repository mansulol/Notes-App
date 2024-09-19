import javax.swing.*;

public class App{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
                new gestorNotasGui();
                // new notaGui("18/08/2024", "19:37", "Toyota Land Cruiser Prado 2022", "Un carricoche").addComponents();
            }
        });

    }
}