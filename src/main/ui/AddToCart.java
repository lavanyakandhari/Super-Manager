package ui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Product;


//Represents a window to the customer to add items to the cart
public class AddToCart extends JFrame implements ActionListener {

    JTextField id;
    JButton btnSubmit;
    JButton btnBack;

    // MODIFIES: this
    // EFFECTS: creates the GUI window
    public AddToCart() {
        super("Add To Cart");
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
    // EFFECTS: adds the product with the given id from menu to myCart
    void addItemToMyCart(int i) {
        for (Product p : InitialMenu.menu.menu) {
            if (i == p.getId()) {
                InitialMenu.myCart.addToCart(p);
                String added = "Item added to cart successfully! now save cart from main menu or continue to add more";
                JOptionPane.showMessageDialog(null, added);
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: opens a new window according to the selected button
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBack) {
            new EditCart();
            dispose();
        }
        if (e.getSource() == btnSubmit) {
            int idNumber = Integer.parseInt(id.getText());
            addItemToMyCart(idNumber);
            System.out.println("item added to cart successfully");
        }
    }
}

