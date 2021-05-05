
package notepadclone;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileNameExtensionFilter;



class Textpad implements ActionListener{
    JFrame jf;

    JMenuBar mb = new JMenuBar();
    JMenu file = new JMenu("File");
    JMenu edit = new JMenu("Edit");
    JMenu help = new JMenu("Help");
    JMenu themes = new JMenu("Themes");
    
    JMenuItem newFile = new JMenuItem("New");
    JMenuItem openFile = new JMenuItem("Open");
    JMenuItem saveFile = new JMenuItem("Save");
    JMenuItem print = new JMenuItem("Print");
    JMenuItem exit = new JMenuItem("Exit");
    
    JMenuItem cut = new JMenuItem("Cut");
    JMenuItem copy = new JMenuItem("Copy");
    JMenuItem paste = new JMenuItem("Paste");
    JMenuItem selectall = new JMenuItem("Select All");
    
    JMenuItem about = new JMenuItem("About");
    
    JMenuItem def = new JMenuItem("Default");
    JMenuItem aluminium = new JMenuItem("Aluminium");
    JMenuItem noire = new JMenuItem("Noire");
    JMenuItem bernstein = new JMenuItem("Bernstein");
    JMenuItem smart = new JMenuItem("Smart");
    
    
    JTextArea ta = new JTextArea();
    
    Textpad(){
        
        jf=new JFrame("Textpad");
        jf.setSize(600,600);
        jf.setVisible(true);
        jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon ic = new ImageIcon("C:\\Users\\SANDESH\\Downloads\\notes.png");
        jf.setIconImage(ic.getImage());

     
        mb.add(file);
        mb.add(Box.createHorizontalStrut(20));
        mb.add(edit);
        mb.add(Box.createHorizontalStrut(20));
        mb.add(help);
        mb.add(Box.createHorizontalStrut(20));
        mb.add(themes);
  
        jf.setJMenuBar(mb);
       
        
        file.add(newFile);
        file.add(openFile);
        file.add(saveFile);
        file.add(print);
        file.add(exit);
        
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectall);
        
        help.add(about);
        
        themes.add(def);
        themes.add(aluminium);
        themes.add(noire);
        themes.add(bernstein);
        themes.add(smart);
        
        JScrollPane sp = new JScrollPane(ta);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        sp.setBorder(BorderFactory.createEmptyBorder());
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        jf.add(sp);
        
        ta.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
        
        newFile.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);
        print.addActionListener(this);
        exit.addActionListener(this);
        
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectall.addActionListener(this);
        
        about.addActionListener(this);
        
        
        newFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,KeyEvent.CTRL_DOWN_MASK));
        openFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,KeyEvent.CTRL_DOWN_MASK));
        saveFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_DOWN_MASK));
        print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,KeyEvent.CTRL_DOWN_MASK));
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,KeyEvent.CTRL_DOWN_MASK));
        
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,KeyEvent.CTRL_DOWN_MASK));
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,KeyEvent.CTRL_DOWN_MASK));
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,KeyEvent.CTRL_DOWN_MASK));
        selectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,KeyEvent.CTRL_DOWN_MASK));
        
        about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J,KeyEvent.CTRL_DOWN_MASK));
        
        aluminium.addActionListener(this);
        bernstein.addActionListener(this);
        smart.addActionListener(this);
        def.addActionListener(this);
        noire.addActionListener(this);
        
             
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("New")){
            JOptionPane.showMessageDialog(null, "New Text File opened!");
            ta.setText(null);
            
        }
        else if(e.getActionCommand().equals("Open")){
            
             JFileChooser fc = new JFileChooser();
            FileNameExtensionFilter tf = new FileNameExtensionFilter("Only Text Files(.txt)", "txt");
            fc.setAcceptAllFileFilterUsed(false);
            fc.addChoosableFileFilter(tf);
            
            int action = fc.showOpenDialog(null);
            if(action!=JFileChooser.APPROVE_OPTION){
                return;
            }
            else{
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(fc.getSelectedFile()));
                    ta.read(reader, null);
                } catch (IOException ex) {
                    Logger.getLogger(Textpad.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            
        }
        else if(e.getActionCommand().equals("Save")){
            
            JFileChooser fc = new JFileChooser();
            FileNameExtensionFilter tf = new FileNameExtensionFilter("Only Text Files(.txt)", "txt");
            fc.setAcceptAllFileFilterUsed(false);
            fc.addChoosableFileFilter(tf);
            
            int action=fc.showSaveDialog(null);
            if(action!=JFileChooser.APPROVE_OPTION){
                return;
            }
            else{
                String fileName = fc.getSelectedFile().getAbsolutePath().toString();
                if(!fileName.contains(".txt")){
                    fileName=fileName+".txt";
                }
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                    ta.write(writer);
                } catch (IOException ex) {
                    Logger.getLogger(Textpad.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            
        }
        else if(e.getActionCommand().equals("Print")){
            
            try {
                ta.print();
            } catch (PrinterException ex) {
                Logger.getLogger(Textpad.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else if(e.getActionCommand().equals("Exit")){
            System.exit(0);
        }
        else if(e.getActionCommand().equals("Cut")){
            ta.cut();
        }
        else if(e.getActionCommand().equals("Copy")){
            ta.copy();
        }
        else if(e.getActionCommand().equals("Paste")){
            ta.paste();
        }
        else if(e.getActionCommand().equals("Select All")){
            ta.selectAll();
        }
        else if(e.getActionCommand().equals("About")){
            new AboutPage();
        }
        
        
        else if(e.getActionCommand().equals("Default")){
         
             try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    SwingUtilities.updateComponentTreeUI(jf);
                    ta.setBackground(Color.white);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }
        else if(e.getActionCommand().equals("Noire")){
            
              String str="com.jtattoo.plaf.noire.NoireLookAndFeel";
            try {
                 for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(str);
                    SwingUtilities.updateComponentTreeUI(jf);
                    ta.setBackground(Color.black);
                    ta.setForeground(Color.white);
                    break;
                }
                
                
            }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Textpad.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(Textpad.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Textpad.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(Textpad.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else if(e.getActionCommand().equals("Smart")){
            
              String str="com.jtattoo.plaf.smart.SmartLookAndFeel";
            try {
                 for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(str);
                    SwingUtilities.updateComponentTreeUI(jf);
                    ta.setBackground(Color.darkGray);
                    ta.setForeground(Color.white);
                    break;
                }
                
                
            }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Textpad.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(Textpad.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Textpad.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(Textpad.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else if(e.getActionCommand().equals("Bernstein")){
               String str="com.jtattoo.plaf.bernstein.BernsteinLookAndFeel";
            try {
                 for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(str);
                    SwingUtilities.updateComponentTreeUI(jf);
                    ta.setBackground(Color.yellow);
                    ta.setForeground(Color.black);
                    break;
                }
                
                
            }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Textpad.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(Textpad.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Textpad.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(Textpad.class.getName()).log(Level.SEVERE, null, ex);
            }
             
        }
        else if(e.getActionCommand().equals("Aluminium")){
            
              String str="com.jtattoo.plaf.aluminium.AluminiumLookAndFeel";
            try {
                 for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(str);
                    SwingUtilities.updateComponentTreeUI(jf);
                    ta.setBackground(Color.LIGHT_GRAY);
                    break;
                }
                
                
            }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Textpad.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(Textpad.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Textpad.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(Textpad.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
}

public class Notepad {
    public static void main(String args[]) throws Exception{
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE, null, ex);
                }
                new Textpad();
            }
        });
    }
}
