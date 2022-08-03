package ui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerMenu extends JFrame implements ActionListener {

    JButton btnSeeCart;
    JButton btnSaveCart;
    JButton btnSeeMenu;
    JButton btnEditCart;
    JButton btnQuit;
    JButton btnLoadCart;
    JButton btnBack;

    // MODIFIES: this
    // EFFECTS: creates the GUI window
    public CustomerMenu() {
        super("Customer Menu");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 400));
        ((JPanel) getContentPane()).setBorder(new LineBorder(Color.getColor("black")));
        ((JPanel) getContentPane()).setBackground(Color.lightGray);
        setLayout(new GridLayout(7,1));
        makeButtons();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    // MODIFIES: this
    // EFFECTS: initialises buttons and icons and Adds them to frame
    public void makeButtons() {
        btnSeeMenu = new JButton("See Menu");
        btnEditCart = new JButton("Edit Cart");
        btnSeeCart = new JButton("See Cart and Total bill");
        btnQuit = new JButton("Quit");
        btnSaveCart = new JButton("Save Cart");
        btnLoadCart = new JButton("Load Cart");
        btnBack = new JButton("Back");
        btnSeeMenu.addActionListener(this);
        btnEditCart.addActionListener(this);
        btnSeeCart.addActionListener(this);
        btnQuit.addActionListener(this);
        btnSaveCart.addActionListener(this);
        btnLoadCart.addActionListener(this);
        btnBack.addActionListener(this);
        addButtons(btnSeeMenu, btnEditCart, btnSeeCart, btnQuit, btnSaveCart, btnLoadCart, btnBack);
    }

    // MODIFIES: this
    // EFFECTS: Adds buttons to Frame
    public void addButtons(JButton a, JButton b, JButton c, JButton d, JButton e, JButton f, JButton g) {
        add(a);
        add(b);
        add(c);
        add(d);
        add(e);
        add(f);
        add(g);
    }

    // MODIFIES: this
    // EFFECTS: opens a new window according to the selected button
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSeeCart) {
            new SeeCart();
        }
        if (e.getSource() == btnBack) {
            new InitialMenu();
            dispose();
        }
        if (e.getSource() == btnEditCart) {
            //new SeeCart();
            new EditCart();
            dispose();
        } else if (e.getSource() == btnSeeMenu) {
            new SeeMenu();
        } else if (e.getSource() == btnQuit) {
            System.exit(0);
        }
        if (e.getSource() == btnSaveCart) {
            InitialMenu.saveCart();
        }
        if (e.getSource() == btnLoadCart) {
            InitialMenu.loadCart();
        }
    }

}
