package ui;


import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Represents a window to show the menu for an employee to edit menu
public class EmployeeMenu extends JFrame implements ActionListener {

    JButton btnAddToMenu;
    JButton btnDeleteFromMenu;
    JButton btnSeeMenu;
    JButton btnQuit;
    JButton btnSaveMenu;
    JButton btnLoadMenu;
    JButton btnBack;

    // MODIFIES: this
    // EFFECTS: creates the GUI window
    public EmployeeMenu() {
        super("Employee Menu");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 400));
        ((JPanel) getContentPane()).setBorder(new LineBorder(Color.getColor("blue")));
        ((JPanel) getContentPane()).setBackground(Color.lightGray);
        setLayout(new GridLayout(7, 1));
        makeButtons();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    // MODIFIES: this
    // EFFECTS: initialises buttons and icons and Adds them to frame
    public void makeButtons() {
        btnAddToMenu = new JButton("Add to the menu");
        btnDeleteFromMenu = new JButton("Delete from the menu");
        btnSeeMenu = new JButton("See menu");
        btnQuit = new JButton("Quit");
        btnSaveMenu = new JButton("Save Menu");
        btnLoadMenu = new JButton("Load Menu");
        btnBack = new JButton("Back");
        ImageIcon iconAdd = new ImageIcon("add.png");
        btnAddToMenu.setIcon(iconAdd);
        ImageIcon iconDel = new ImageIcon("delete.png");
        btnDeleteFromMenu.setIcon(iconDel);
        setCommands(btnAddToMenu,btnDeleteFromMenu,btnSeeMenu,btnQuit,btnSaveMenu,btnLoadMenu,btnBack);
        addButtons(btnAddToMenu, btnDeleteFromMenu, btnSeeMenu, btnQuit, btnSaveMenu, btnLoadMenu, btnBack);
    }

    // MODIFIES: this
    // EFFECTS: Sets the ActionListener for buttons
    public void setCommands(JButton a, JButton b, JButton c, JButton d, JButton e, JButton f, JButton g) {

        a.addActionListener(this);
        b.addActionListener(this);
        c.addActionListener(this);
        d.addActionListener(this);
        e.addActionListener(this);
        f.addActionListener(this);
        g.addActionListener(this);
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
        if (e.getSource() == btnBack) {
            new InitialMenu();
            dispose();
        } else if (e.getSource() == btnAddToMenu) {
            new AddToMenu();
            dispose();
        } else if (e.getSource() == btnDeleteFromMenu) {
            new DeleteFromMenu();
            dispose();
        } else if (e.getSource() == btnQuit) {
            System.exit(0);
        } else if (e.getSource() == btnSaveMenu) {
            InitialMenu.saveMenu();
        } else if (e.getSource() == btnLoadMenu) {
            InitialMenu.loadMenu();
            JOptionPane.showMessageDialog(null, "Menu loaded successfully!");
        } else if (e.getSource() == btnSeeMenu) {
            new SeeMenu();
        }
    }

}

