package ui;

import model.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

// Represents a window to display items on the menu
public class SeeMenu extends JFrame {
    JTable menuTable;
    DefaultTableModel tableModel;

    // MODIFIES: this
    // EFFECTS: creates the GUI window
    public SeeMenu() {
        super("Show Menu");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(new Dimension(500, 500));
        //setResizable(false);

        initialiseTable();

        menuTable.setPreferredScrollableViewportSize(new Dimension(400, 400));
        menuTable.setFillsViewportHeight(true);

        add(new JScrollPane(menuTable));
    }


    // MODIFIES: this
    // EFFECTS: adds rows to the table displaying data of the menu
    private void initialiseTable() {
        String[] columnNames = {"id", "name", "price"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        menuTable = new JTable(tableModel);

        for (Product p : InitialMenu.menu.menu) {
            ArrayList<String> output = new ArrayList<>();
            output.add("" + p.getId());
            output.add(p.getProductName());
            output.add("" + p.getProductPrice());
            Object[] data = output.toArray();

            tableModel.addRow(data);
        }
    }
}

