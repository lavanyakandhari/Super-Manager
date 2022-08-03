package ui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Represents a window to show the options to a customer to edit their cart
public class EditCart extends JFrame implements ActionListener {

    JButton btnAddToCart;
    JButton btnDeleteFromCart;
    JButton btnBack;

    // MODIFIES: this
    // EFFECTS: creates the GUI window
    public EditCart() {
        super("Edit and view cart");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 400));
        ((JPanel) getContentPane()).setBorder(new LineBorder(Color.getColor("blue")));
        ((JPanel) getContentPane()).setBackground(Color.lightGray);
        setLayout(new GridLayout(3, 1));
        makeButtons();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    // MODIFIES: this
    // EFFECTS: initialises buttons and icons and Adds them to frame
    public void makeButtons() {

        btnAddToCart = new JButton("Add to the cart");
        btnDeleteFromCart = new JButton("Delete from the cart");
        btnBack = new JButton("Back");
        ImageIcon iconAdd = new ImageIcon("add.png");
        ImageIcon iconDel = new ImageIcon("delete.png");
        btnAddToCart.setIcon(iconAdd);
        btnDeleteFromCart.setIcon(iconDel);
        btnAddToCart.addActionListener(this);
        btnDeleteFromCart.addActionListener(this);
        btnBack.addActionListener(this);
        addButtons(btnAddToCart, btnDeleteFromCart, btnBack);
    }

    // MODIFIES: this
    // EFFECTS: Adds buttons to Frame
    public void addButtons(JButton a, JButton b, JButton c) {
        add(a);
        add(b);
        add(c);
    }

    // MODIFIES: this
    // EFFECTS: opens a new window according to the selected button
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBack) {
            new CustomerMenu();
            dispose();
        } else if (e.getSource() == btnDeleteFromCart) {
            new DeleteFromCart();
            dispose();
        } else if (e.getSource() == btnAddToCart) {
            new AddToCart();
            dispose();
        }
    }
}
