package ui;

import exceptions.NegativeIdException;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Represents a window to the customer to delete items from the cart
public class DeleteFromCart extends JFrame implements ActionListener {

    JTextField id;
    JButton btnSubmit;
    JButton btnBack;

    // MODIFIES: this
    // EFFECTS: creates the GUI window
    public DeleteFromCart() {
        super("Delete From Cart");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 400));
        ((JPanel) getContentPane()).setBorder(new LineBorder(Color.getColor("black")));
        ((JPanel) getContentPane()).setBackground(Color.lightGray);
        setLayout(new FlowLayout());
        id = new JTextField(5);
        id.setText("id");
        btnSubmit = new JButton("Submit");
        btnBack = new JButton("Back");
        btnBack.addActionListener(this);
        btnSubmit.addActionListener(this);
        add(id);
        add(btnSubmit);
        add(btnBack);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }


    // MODIFIES: this
    // EFFECTS: opens a new window according to the selected button
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBack) {
            new EditCart();
            dispose();
        } else if (e.getSource() == btnSubmit) {
            int idNumber = Integer.parseInt(id.getText());
            try {
                InitialMenu.myCart.removeFromCart(idNumber);
                String deleted = "Item deleted from cart successfully! now save cart from main menu";
                JOptionPane.showMessageDialog(null, deleted);
            } catch (NegativeIdException negativeIdException) {
                JOptionPane.showMessageDialog(null, "ERROR!! enter valid id (positive value)");
            }
        }
    }
}
