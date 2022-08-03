//package ui;
//
//
//import model.Menu;
//import model.Product;
//import model.Cart;
//import persistence.JsonReader;
//import persistence.JsonWriter;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.Scanner;
//
////Supermarket Shopping Management System
//public class ShoppingApp {
//    private static final String JSON_STORE_M = "./data/menu.json";
//    private static final String JSON_STORE_C = "./data/cart.json";
//    private Menu menu;
//    private Cart myCart;
//    private Scanner input;
//    private JsonReader jsonReaderM;
//    private JsonWriter jsonWriterM;
//    private JsonReader jsonReaderC;
//    private JsonWriter jsonWriterC;
//
//    // EFFECTS: runs the ShoppingApp application
//    public ShoppingApp() throws FileNotFoundException {
//        menu = new Menu("menu 1");
//        myCart = new Cart("cart 1");
//        jsonWriterM = new JsonWriter(JSON_STORE_M);
//        jsonReaderM = new JsonReader(JSON_STORE_M);
//        jsonWriterC = new JsonWriter(JSON_STORE_C);
//        jsonReaderC = new JsonReader(JSON_STORE_C);
//        //runShoppingApp();
//    }
//
//    //REQUIRES: keepGoing = true to continue the loop
//    // MODIFIES: this
//    // EFFECTS: processes user input
//    private void runShoppingApp() {
//        boolean keepGoing = true;
//        input = new Scanner(System.in);
//        boolean ans = isCustomer();
//        loadEverything();
//        while (keepGoing) {
//            if (ans) {
//                displayOption(ans);
//                int option = input.nextInt();
//                if (option == 4) {
//                    keepGoing = false;
//                } else {
//                    customerMenu(option);
//                }
//            } else {
//                displayOption(ans);
//                int empAns = input.nextInt();
//                if (empAns == 4) {
//                    keepGoing = false;
//                } else {
//                    empAnsInput(empAns);
//                }
//            }
//        }
//    }
//
//    //EFFECTS: displays the options to employee or customer displays the
//    // options to employee to view menu,edit menu , save menu
//    //and gives an option to save cart
//    private void displayOption(boolean ans) {
//        if (ans) {
//            System.out.println("choose\n\t1.see menu\n\t2.view & edit cart\n\t3.see total cost in cart\n\t4.quit"
//                    + "\n\t5.save cart\n");
//        } else {
//            System.out.println("choose\n\t1.add to the menu\n\t2.delete from the menu\n\t3.See menu\n\t4.quit "
//                    + "\n\t5.save menu\n");
//        }
//    }
//
//    //MODIFY:  menu
//    //EFFECTS:displays the options to employee to view menu,edit menu , save menu
//    private void empAnsInput(int empAns) {
//        switch (empAns) {
//            case 5: {
//                saveMenu();
//                break;
//            }
//            default: {
//                editMenu(empAns);
//            }
//        }
//    }
//
//    //REQUIRES: keepGoing = true to continue the loop
//    //MODIFY: myCart
//    //EFFECT : processes user command after displaying menu
//    private void afterMenu() {
//        boolean keepGoing = true;
//        while (keepGoing) {
//            System.out.println("1.do you want to add items in cart?\n2.go to main menu");
//            int ifYes = input.nextInt();
//            if (ifYes == 2) {
//                keepGoing = false;
//            } else if (ifYes == 1) {
//                System.out.println("enter the id of the item");
//                int newItem = input.nextInt();
//                addItemToMyCart(newItem);
//            }
//
//        }
//    }
//
//
//    //MODIFY: menu
//    //EFFECTS: displays the options to employee to add or delete items from menu
//    private void editMenu(int ans) {
//
//        switch (ans) {
//            case 1: {
//                System.out.println("enter product id");
//                int id = input.nextInt();
//                System.out.println("Enter product name(without white space");
//                String name = input.next();
//                System.out.println("enter product price");
//                double cost = input.nextInt();
//                menu.addToMenu(id, name, cost);
//                System.out.println("item added successfully!");
//                break;
//            }
//            case 2: {
//                System.out.println("enter product id");
//                int id = input.nextInt();
//                menu.deleteFromMenu(id);
//                break;
//            }
//            case 3: {
//                showMenu();
//                break;
//            }
//        }
//    }
//
//    //EFFECTS: returns true if ans is "y" and false otherwise
//    private boolean isCustomer() {
//        input = new Scanner(System.in);
//        System.out.println("Are you a customer? (y/n)");
//        String ans = input.next();
//        return ans.equals("y");
//    }
//
//
//    //MODIFY: myCart
//    //EFFECTS:displays the options to customer to view menu,edit car or show the total bill amount
//    // and gives an option to save cart or load a saved cart
//    private void customerMenu(int ans) {
//        switch (ans) {
//            case 1:
//                showMenu();
//                afterMenu();
//                break;
//            case 2:
//                showCart();
//                editCart();
//                break;
//            case 3:
//                System.out.println("$" + myCart.showTotalCost());
//                break;
//            case 5:
//                saveCart();
//                break;
//        }
//    }
//
//    //REQUIRES: keepGoing = true to continue the loop
//    //MODIFIES: myCart
//    //EFFECTS: displays option to customer to edit cart by adding or deleting items from cart
//    private void editCart() {
//        boolean keepGoing = true;
//        input = new Scanner(System.in);
//        while (keepGoing) {
//            System.out.println("choose one\n\t1.add items to cart\n\t2.delete items from cart\n\t3.go to main menu");
//            int ans = input.nextInt();
//            if (ans == 1) {
//                System.out.println("enter item id to add");
//                int id = input.nextInt();
//                addItemToMyCart(id);
//
//            } else if (ans == 2) {
//                System.out.println("enter product id");
//                int id = input.nextInt();
//                myCart.removeFromCart(id);
//            } else if (ans == 3) {
//                keepGoing = false;
//            }
//        }
//    }
//
//    // MODIFIES: this
//    // EFFECTS: adds the product with the given id from menu to myCart
//    void addItemToMyCart(int i) {
//        for (Product p : menu.menu) {
//            if (i == p.getId()) {
//                myCart.addToCart(p);
//            }
//        }
//
//    }
//
//
//    // EFFECTS: Returns a list of all products at he supermarket
//    // displays the menu to the user
//    public void showMenu() {
//        for (Product p : menu.menu) {
//            displayProduct(p);
//        }
//    }
//
//    //EFFECTS: displays the Product with details like product id , name and cost of product
//    public void displayProduct(Product product) {
//        System.out.println(product.getId() + "->" + product.getProductName() + "->$" + product.getProductPrice());
//    }
//
//    //EFFECTS: displays the cart with products , their ids and their prices.
//    public void showCart() {
//        for (Product product : myCart.cart) {
//            displayProduct(product);
//        }
//    }
//
//    // EFFECTS: saves the menu to file
//    private void saveMenu() {
//        try {
//            jsonWriterM.open();
//            jsonWriterM.writeMenu(menu);
//            jsonWriterM.close();
//            System.out.println("Saved " + menu.getNameMenu() + " to " + JSON_STORE_M);
//        } catch (FileNotFoundException e) {
//            System.out.println("Unable to write to file: " + JSON_STORE_M);
//        }
//    }
//
//    // MODIFIES: this
//    // EFFECTS: loads menu and cart from files
//    private void loadEverything() {
//        try {
//            menu = jsonReaderM.readMenu();
//            System.out.println("Loaded " + menu.getNameMenu() + " from " + JSON_STORE_M);
//        } catch (IOException e) {
//            System.out.println("Unable to read from file: " + JSON_STORE_M);
//        }
//        loadCart();
//    }
//
//    // EFFECTS: saves the cart to file
//    private void saveCart() {
//        try {
//            jsonWriterC.open();
//            jsonWriterC.writeCart(myCart);
//            jsonWriterC.close();
//            System.out.println("Saved " + myCart.getNameCart() + " to " + JSON_STORE_C);
//        } catch (FileNotFoundException e) {
//            System.out.println("Unable to write to file: " + JSON_STORE_C);
//        }
//    }
//
//    // MODIFIES: this
//    // EFFECTS: loads cart from file
//    private void loadCart() {
//        try {
//            myCart = jsonReaderC.readCart();
//            System.out.println("Loaded " + myCart.getNameCart() + " from " + JSON_STORE_C);
//        } catch (IOException e) {
//            System.out.println("Unable to read from file: " + JSON_STORE_C);
//        }
//    }
//}
//
//
