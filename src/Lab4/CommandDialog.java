package Lab4;

import javax.swing.*;
import java.awt.*;

public class CommandDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JLabel operationName;

    public CommandDialog(String typeOfOperation, String operation) {
       this(operation);
        setTitle(typeOfOperation);

    }

    public CommandDialog(String operation) {
        setContentPane(contentPane);
        setLocation(800, 400);
        setSize(400,200);

        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(e -> onOK());
        operationName.setText(operation);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        pack();
        setVisible(true);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

}
