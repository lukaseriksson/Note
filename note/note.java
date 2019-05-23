import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class note {
    private JPanel panelen;
    private JTextArea text1;
    private JButton open;
    private JButton save;
    private JButton help;
    private JLabel label;

 //test av GUI

    public note() {
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(this, "Funkar inte än... Prova google? ");
            }
        });
        help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 40; i++) }
                text1.append("SAVE");
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("note");
        frame.setContentPane(new note().panelen);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
