package ui;


import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//Represents a window to the employee to add items to the menu
public class AddToMenu extends JFrame implements ActionListener {

    JTextField id;
    JTextField name;
    JTextField price;
    JButton btnSubmit;
    JButton btnBack;

    // MODIFIES: this
    // EFFECTS: creates the GUI window
    public AddToMenu() {
        super("Add To Menu");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 400));
        ((JPanel) getContentPane()).setBorder(new LineBorder(Color.getColor("black")));
        ((JPanel) getContentPane()).setBackground(Color.lightGray);
        setLayout(new FlowLayout());
        addFields();
        btnSubmit = new JButton("Submit");
        btnBack = new JButton("Back");
        btnBack.addActionListener(this);
        btnSubmit.addActionListener(this);

        add(btnSubmit);
        add(btnBack);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    // MODIFIES: this
    // EFFECTS: adds text fields to frame
    public void addFields() {
        id = new JTextField(5);
        id.setText("id");
        name = new JTextField(5);
        name.setText("name");
        price = new JTextField(5);
        price.setText("price");
        add(id);
        add(name);
        add(price);
    }

    // MODIFIES: this
    // EFFECTS: opens a new window according to the selected button
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBack) {
            new EmployeeMenu();
            dispose();
        } else if (e.getSource() == btnSubmit) {
            String added = "Item added to menu successfully! now save menu from main menu or continue to add more";
            int productId = Integer.parseInt(id.getText());
            String productName = name.getText();
            double productPrice = Double.parseDouble(price.getText());
            InitialMenu.menu.addToMenu(productId, productName, productPrice);
            JOptionPane.showMessageDialog(null, added);
        }
    }
}
