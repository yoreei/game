package gameInterface;

import gameMechanics.EntityManagerThread;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import pkgResources.ResourceLoader;
/*import org.lwjgl.LWJGLException;
 import org.lwjgl.opengl.Display;
 import org.lwjgl.opengl.DisplayMode;*/

public class Run {

    public static EntityManagerThread manager;
    public static ResourceLoader resources;
    public static final Dimension ScreenSize =
            Toolkit.getDefaultToolkit().getScreenSize();

    public static void main(String[] args) throws Exception /*throws LWJGLException **/ {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ResourceLoader.load();
                } catch (Exception ex) {
                    Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("DONE");
               
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    new gameInterface.Screen(new Dimension(1366, 704)).setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
                }            
            }
        }).start();
    }
}