package Lab4;

import Lab4.Constants.Constants;

import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static Lab4.Constants.Constants.*;


public class VirtualKeyboardGUI extends JFrame {

    private List<List<CommandJButton>> buttonsArray;
    private JTextArea textArea;

    private Vector<String> commands;

    private CommandReader reader;

    public VirtualKeyboardGUI(CommandReader reader) {
        super(TITLE);
        this.reader = reader;

        buttonsArray = new ArrayList<>();
        textArea = new JTextArea();
        commands = new Vector<>();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        //set size of the content pane ie frame
        this.getContentPane().setPreferredSize(SIZE);
        this.setLocation(POSITION);

        //init and paint frame
        initWidgets();
        setVisible(true);
    }

    /**
     * Method to initialize frame component
     */
    private void initWidgets() {
        //set the text area on top
        textArea.setFont(new Font(Font.DIALOG_INPUT, Font.ITALIC, 24));
        textArea.setPreferredSize(new Dimension(800, 200));

        //set the info label on top
        JLabel info = new JLabel("<html>Набирайте как-нить текст и чтот-то будет печататься в поле ниже :з <br> </html>");
        //set the bold font for info
        info.setFont(new Font("Verdana", Font.BOLD, 14));

        /*set the layout and place compomnet in place and pack it */
        setLayout(new BorderLayout());
        /*Various panel for the layout */
        JPanel jpNorth = new JPanel();
        JPanel jpCenter = new JPanel();
        JPanel jpKeyboard = new JPanel();
        JPanel jpNote = new JPanel();
        add(jpNorth, BorderLayout.NORTH);
        add(jpNote);
        add(jpCenter, BorderLayout.CENTER);
        add(jpKeyboard, BorderLayout.SOUTH);

        ListModel<String> model = new DefaultListModel<>();
        JList list = new JList(model);
        DefaultListModel<String> listModel = (DefaultListModel) list.getModel();
        list.addListSelectionListener((e) -> {
            textArea.setText(null);
            textArea.append((String) list.getSelectedValue());
        });
        JScrollPane scroller = new JScrollPane(list);
        scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        jpNorth.setLayout(new BorderLayout());
        jpNorth.add(info, BorderLayout.WEST);

        jpCenter.setLayout(new BorderLayout());
        jpCenter.add(textArea, BorderLayout.WEST);
        jpCenter.add(scroller, BorderLayout.CENTER);

        //layout for keyboard
        jpKeyboard.setLayout(new GridLayout(6, 1));
        //pack the components
        pack();
        for (int i = 0; i < Constants.ROWS; i++) {
            buttonsArray.add(new ArrayList<>());
        }
        for (int i = 0; i < ALL_ROWS.length; i++) {
            for (int j = 0; j < ALL_ROWS[i].length; j++) {
                String text = ALL_ROWS[i][j];
                switch (text) {
                    case "Enter":
                        buttonsArray.get(i).add(new CommandJButton(ALL_ROWS[i][j]) {
                            @Override
                            public void execute() {
                                textArea.append("\n");
                            }
                        });
                        break;
                    case "Del":
                        buttonsArray.get(i).add(new CommandJButton(ALL_ROWS[i][j]) {
                            @Override
                            public void execute() {
                                textArea.setText(null);
                            }
                        });
                        break;
                    case "               Space                ":
                        buttonsArray.get(i).add(new CommandJButton(ALL_ROWS[i][j]) {
                            @Override
                            public void execute() {
                                textArea.append("  ");
                            }
                        });
                        break;
                    case "Run command":
                        buttonsArray.get(i).add(new CommandJButton(ALL_ROWS[i][j]) {
                            @Override
                            public void execute() {
                                if (!textArea.getText().isEmpty()) {
                                    reader.runCommand(textArea.getText());
                                    textArea.setText(null);
                                }
                            }
                        });
                        break;
                    case "UNDO":
                        buttonsArray.get(i).add(new CommandJButton(ALL_ROWS[i][j]) {
                            @Override
                            public void execute() {
                                reader.undoCommand();

                            }
                        });
                        break;
                    case "Create command":
                        buttonsArray.get(i).add(new CommandJButton(ALL_ROWS[i][j]) {
                            @Override
                            public void execute() {
                                String textFromTextArea = textArea.getText();
                                reader.createCommand(textFromTextArea);
                                textArea.setText(null);
                                if (!textFromTextArea.isEmpty())
                                    listModel.addElement(textFromTextArea);
                            }
                        });
                        break;
                    default:
                        buttonsArray.get(i).add(new CommandJButton(ALL_ROWS[i][j]) {
                            @Override
                            public void execute() {
                                textArea.append(text);
                            }
                        });
                        break;
                }

            }
        }

        for (List<CommandJButton> array : buttonsArray) {
            JPanel rowPanel = new JPanel(new GridLayout(1, array.size()));
            for (CommandJButton button : array) {
                button.setPreferredSize(new Dimension(80, 40));
                rowPanel.add(button);
            }
            jpKeyboard.add(rowPanel);
        }

        /*paint first keyboard row  and add it to the keyboard*/

        //paint the fifth row
        //get the panel for the  row

        /*draw the buttons */
        /*add listeners */

        /*add listeners to all the button */
        for (List<CommandJButton> array : buttonsArray)
            for (CommandJButton button : array)
                button.addActionListener(e -> button.execute());


    }
}
