import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class main {
    public static void main(String[] args) {
        // 1. Create the main window
        JFrame frame = new JFrame("To-Do List");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // 2. Create components
        JTextField taskField = new JTextField(); // Text box for new task
        JButton addButton = new JButton("Add Task");
        JButton deleteButton = new JButton("Delete Task");

        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> taskList = new JList<>(listModel);

        // 3. Panel for top area (text field + add button)
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(taskField, BorderLayout.CENTER);
        topPanel.add(addButton, BorderLayout.EAST);

        // 4. Add components to frame
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(taskList), BorderLayout.CENTER);
        frame.add(deleteButton, BorderLayout.SOUTH);

        // 5. Add Button Click Actions
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String task = taskField.getText().trim();
                if (!task.isEmpty()) {
                    listModel.addElement(task);
                    taskField.setText(""); // Clear the text field
                } else {
                    JOptionPane.showMessageDialog(frame, "Please enter a task!");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    listModel.remove(selectedIndex);
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a task to delete!");
                }
            }
        });

        // 6. Show the window
        frame.setVisible(true);
    }
}
