package Lab4.GUI;

import Lab4.CommandJButton;
import Lab4.Commands.CommandReader;
import Lab4.Constants.Constants;

import javax.swing.*;
import java.awt.*;

import java.util.ArrayList;
import java.util.List;

import static Lab4.Constants.Constants.*;


public class VirtualKeyboardGUI extends JFrame {

    private final List<List<CommandJButton>> buttonsArray;
    private final JTextArea textArea;

    private final CommandReader reader;

    public VirtualKeyboardGUI(CommandReader reader) {
        super(TITLE);
        this.reader = reader;

        buttonsArray = new ArrayList<>();
        textArea = new JTextArea();
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
        JLabel info = new JLabel("<html> Run command - запуск комманды <br>" +
                "Create command - создает комманду <br>" +
                "UNDO - отменят последнюю комманду <html>");
        //set the bold font for info
        info.setFont(new Font("Verdana", Font.BOLD, 12));

        /*set the layout and place compomnet in place and pack it */
        setLayout(new BorderLayout());
        /*Various panel for the layout */
        JPanel jpNorth = new JPanel();
        JPanel jpCenter = new JPanel();
        JPanel jpKeyboard = new JPanel();
        JPanel jpNote = new JPanel();
        add(jpNote, BorderLayout.WEST);
        add(jpNorth, BorderLayout.NORTH);
        add(jpCenter, BorderLayout.CENTER);
        add(jpKeyboard, BorderLayout.SOUTH);

        jpNorth.setLayout(new BorderLayout());
        jpNorth.add(info, BorderLayout.WEST);

        jpCenter.setLayout(new BorderLayout());
        jpCenter.add(textArea, BorderLayout.CENTER);

        //creating scrollPane with binding commands
        ListModel<String> modelListCommands = new DefaultListModel<>();
        JList listCommands = new JList(modelListCommands);
        listCommands.setFixedCellWidth(200);
        DefaultListModel<String> listModel = (DefaultListModel) listCommands.getModel();
        listCommands.addListSelectionListener((e) -> {
            textArea.setText(null);
            textArea.append((String) listCommands.getSelectedValue());
        });
        JScrollPane scroller1 = new JScrollPane(listCommands);
        scroller1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jpCenter.add(scroller1, BorderLayout.EAST);


        //creating scrollPane with log
        ListModel<String> modelListExecuted = new DefaultListModel<>();
        JList listCommandsExecuted = new JList(modelListExecuted);
        listCommandsExecuted.setFixedCellWidth(200);
        listCommandsExecuted.clearSelection();
        JScrollPane scroller2 = new JScrollPane(listCommandsExecuted);
        scroller2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        DefaultListModel<String> listModelExecuted = (DefaultListModel) listCommandsExecuted.getModel();
        jpCenter.add(scroller2, BorderLayout.WEST);


        //jpNote.add(scroller2, BorderLayout.CENTER);
        //layout for keyboard
        jpKeyboard.setLayout(new GridLayout(ROWS, 1));
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
                                    if (listModel.contains(textArea.getText()))
                                        listModelExecuted.addElement(textArea.getText());
                                    textArea.setText(null);
                                    listCommands.clearSelection();
                                }
                            }
                        });
                        break;
                    case "UNDO":
                        buttonsArray.get(i).add(new CommandJButton(ALL_ROWS[i][j]) {
                            @Override
                            public void execute() {
                                reader.undoCommand();
                                if (!listModelExecuted.isEmpty())
                                    listModelExecuted.remove(listModelExecuted.size() - 1);
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
                                if (!textFromTextArea.isEmpty() && !listModel.contains(textFromTextArea))
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


        /*add listeners to all the button */
        for (List<CommandJButton> array : buttonsArray)
            for (CommandJButton button : array)
                button.addActionListener(e -> button.execute());
    }


}
