package ui;

import model.Cart;
import model.Menu;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;

// Represents a window to show the initial menu for a user
public class InitialMenu extends JFrame implements ActionListener {

    private JLabel label;
    public static Cart myCart = new Cart("nothing loaded");
    public static Menu menu = new Menu("nothing loaded");
    public static JsonReader jsonReaderM = new JsonReader("./data/menu.json");
    public static JsonReader jsonReaderC = new JsonReader("./data/cart.json");
    public static JsonWriter jsonWriterC = new JsonWriter("./data/cart.json");
    public static JsonWriter jsonWriterM = new JsonWriter("./data/menu.json");
    JButton btnCustomer;
    JButton btnEmployee;

    // MODIFIES: this
    // EFFECTS: creates the GUI window
    public InitialMenu() {
        super("Supermarché checkout");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setBackground(Color.cyan);
        loadMenu();
        this.setLayout(new FlowLayout());
        addLabel();
        addPanel();
        this.setVisible(true);
        setLocationRelativeTo(null);
        this.setVisible(true);
        setResizable(false);

    }

    // MODIFIES: this
    // EFFECTS: Adds labels to the Frame
    public void addLabel() {
        ImageIcon image = new ImageIcon("main_logo.png");
        Border border = BorderFactory.createLineBorder(Color.cyan, 3);
        label = new JLabel("Press to proceed!");
        label.setForeground(Color.RED);
        label.setFont(new Font("MV Boli", Font.PLAIN, 20));
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.TOP);
        label.setBackground(Color.cyan);
        label.setOpaque(true);
        label.setBorder(border);
        label.setBounds(250,0,500,500);
        add(label);
    }

    // MODIFIES: this
    // EFFECTS: Adds buttons to panel and panel to the Frame
    public void addPanel() {
        JPanel panel = new JPanel();
        btnCustomer = new JButton("Customer");
        btnCustomer.setForeground(Color.red);
        btnEmployee = new JButton("Employee");
        btnEmployee.setForeground(Color.red);
        panel.setPreferredSize(new Dimension(700, 100));
        panel.setBackground(Color.white);
        panel.setLayout(new FlowLayout());
        panel.add(btnCustomer);
        panel.add(btnEmployee);
        btnCustomer.addActionListener(this);
        btnEmployee.addActionListener(this);
        add(panel);
    }

    // MODIFIES: this
    // EFFECTS: opens a new window according to the selected button
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCustomer) {
            new CustomerMenu();
            dispose();
        } else if (e.getSource() == btnEmployee) {
            new EmployeeMenu();
            dispose();
        }
    }

    // MODIFIES: this
    // EFFECTS: loads cart from file
    public static void loadCart() {
        try {
            myCart = jsonReaderC.readCart();
            JOptionPane.showMessageDialog(null, "Cart loaded successfully!");
            System.out.println("loaded cart");
        } catch (IOException e) {
            System.out.println("error");
        }
    }

    // MODIFIES: this
    // EFFECTS: loads cart from file
    public static void loadMenu() {
        try {
            menu = jsonReaderM.readMenu();
            System.out.println("loaded menu");
        } catch (IOException e) {
            System.out.println("error");
        }
    }

    // EFFECTS: saves the cart to file
    public static void saveCart() {
        try {
            jsonWriterC.open();
            jsonWriterC.writeCart(myCart);
            jsonWriterC.close();
            JOptionPane.showMessageDialog(null, "Saved the cart successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }
    }

    // EFFECTS: saves the menu to file
    public static void saveMenu() {
        try {
            jsonWriterM.open();
            jsonWriterM.writeMenu(menu);
            jsonWriterM.close();
            JOptionPane.showMessageDialog(null, "Saved the menu successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }
    }
}