
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

//Fungerande notepad

public class Notepad extends JFrame {

    /**
     * Holds the name of the file
     */
    private JTextField fileNameTextField;

    private JTextArea textArea;


    private JButton openButton, saveButton, helpButton;

    /**
     * default constructor
     */
    public Notepad() {

        fileNameTextField = new JTextField();
        textArea = new JTextArea();

        /**
         * Create a panel for the buttons to reside.
         * The default layout for containers is FlowLayout
         */
        JPanel buttonPanel = new JPanel();

        openButton = new JButton("Open");
        saveButton = new JButton("Save");
        helpButton = new JButton("Help");

        // Instantiate an action listener to listen for button click events
        NotepadButtonListener buttonListener = new NotepadButtonListener();

        // attach our action listener to the buttons

        openButton.addActionListener(buttonListener);
        saveButton.addActionListener(buttonListener);
        helpButton.addActionListener(buttonListener);


        buttonPanel.add(openButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(helpButton);

        // set the layout of the JFrame
        this.setLayout(new BorderLayout());

        /**
         * Add the elements to the panel.
         * BorderLayouts have 5 positions that you can add Objects:
         * NORTH, SOUTH, EAST, WEST, and CENTER
         */

        add(fileNameTextField, BorderLayout.NORTH);
        add(textArea, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // show the frame
        setPreferredSize(new Dimension(400, 300));
        pack();
        setVisible(true);
    }

    /**
     *
     * @return the name of the file
     */
    private String getFileName() {
        return fileNameTextField.getText();
    }

    /**
     * Read from the specified file
     */
    private void readFile(String fileName) {
        Scanner inFile = null;

        try {
            // file reader
            inFile = new Scanner(new FileReader(fileName));

            // clear the text area
            textArea.setText("");

            // copy file
            while (inFile.hasNextLine()) {
                textArea.append(inFile.nextLine());
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println("File not found");
        } finally {
            if (inFile != null) {
                inFile.close();
            }
        }
    }

    /**
     * Write to the specified file
     * @param fileName the name of the file to write to
     */
    private void writeFile(String fileName) {
        PrintWriter outFile = null;

        try {
            // file writer
            outFile = new PrintWriter(new FileWriter(fileName));

            outFile.print(textArea.getText());

        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println("File not found");
        } finally {
            if (outFile != null) {
                outFile.close();
            }
        }
    }

    /**
     * The action listener for our Notepad application
     * Action listeners must implement the ActionListener interface and define
     * the behavior of the actionPerformed() method.
    **/

    class NotepadButtonListener implements ActionListener {

        /**
         * This needs to be defined since this class implements the ActionListener interface
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton sourceButton = (JButton) e.getSource();

            // Figure out which button was pressed
            if (sourceButton.equals(openButton)) {
                System.out.println("Open...");
                readFile(getFileName());
            } else if (sourceButton.equals(saveButton)) {
                System.out.println("Saving...");
                writeFile(getFileName());
            } else if (sourceButton.equals(helpButton)) {
                System.out.println("You want help? Try google...");

                // clear the text area
                textArea.setText("");
            } else {
                System.out.println("Unknown button pressed");
            }
        }
    }

    /**
     * The application's entry point
     */
    public static void main(String[] args) {
        // Create the notepad instance
        new Notepad();
    }
}

