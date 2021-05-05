
package notepadclone;
import java.awt.Font;
import javax.swing.*;

public class AboutPage {
    JFrame jf;
    AboutPage(){
        jf=new JFrame("About Textpad Application");
        jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setLayout(null);
        jf.setVisible(true);
        ImageIcon ic = new ImageIcon("C:\\Users\\SANDESH\\Downloads\\notes.png");
        jf.setIconImage(ic.getImage());
        JLabel iconLabel = new JLabel(ic);
        iconLabel.setBounds(100,80,500,450);
        jf.add(iconLabel);
        
        JLabel text = new JLabel("<html>Welcome to Textpad.<br>Textpad is a simple text editor for Microsoft Windows and a basic text-editing program which enables users to create documents<br>All rights reserved &copy; @2021</html>");
        text.setBounds(700,50,1000,600);
        text.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,50));
        jf.add(text);
        
        
    }
    
    
    
    public static void main(String args[]){
        SwingUtilities.invokeLater(new Runnable(){
           public void run(){
               new AboutPage();
           } 
        });
    }
}
