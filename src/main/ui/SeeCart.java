package ui;

import model.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;


//Represents a window to the customer to see items in the cart
public class SeeCart extends JFrame {
    JTable cartTable;
    DefaultTableModel tableModel;
    private JTextField field = new JTextField("Total Cost of cart is - " + InitialMenu.myCart.showTotalCost());

    // MODIFIES: this
    // EFFECTS: creates the GUI window
    public SeeCart() {
        super("Show Cart and Total Bill");
        field.setEnabled(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2,1));
        setVisible(true);
        setSize(new Dimension(500, 500));
        //setResizable(false);

        initialiseTable();

        cartTable.setPreferredScrollableViewportSize(new Dimension(400, 400));
        cartTable.setFillsViewportHeight(true);

        add(new JScrollPane(cartTable));
        JPanel totalPanel = new JPanel();
        totalPanel.add(field);
        field.setHorizontalAlignment(SwingConstants.CENTER);
        add(totalPanel);
    }

    // MODIFIES: this
    // EFFECTS: adds rows to the table displaying data of the cart
    private void initialiseTable() {
        String[] columnNames = {"id", "name", "price"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        cartTable = new JTable(tableModel);

        for (Product p : InitialMenu.myCart.showCart()) {
            ArrayList<String> output = new ArrayList<>();
            output.add("" + p.getId());
            output.add(p.getProductName());
            output.add("" + p.getProductPrice());
            Object[] data = output.toArray();

            tableModel.addRow(data);
        }
    }
}
