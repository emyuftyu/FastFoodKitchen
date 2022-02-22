package fastfoodkitchen;
import fastfoodkitchen.FastFoodKitchen;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author emray
 */


public class Main {
     
        public static void main(String[] args) {
            FastFoodKitchen kitchen;
            kitchen = new FastFoodKitchen();
                Scanner sc = new Scanner(System.in);

                while (kitchen.getNumOrdersPending() != 0) {

                        System.out.println("Please select from the following menu of options, by typing a number:");
                        System.out.println("\t 1. Order food");
                        System.out.println("\t 2. Cancel last order");
                        System.out.println("\t 3. Show number of orders currently pending.");
                        System.out.println("\t 4. Exit");
                        System.out.println("\t 5. Is Order Done?");
                        System.out.println("\t 6. Cancel Order");
                        
                        int num = sc.nextInt();
                        switch (num) {
                        case 1:
                                System.out.println("How many hamburgers do you want?");
                                int ham = sc.nextInt();
                                System.out.println("How many cheeseburgers do you want?");
                                int cheese = sc.nextInt();
                                System.out.println("How many veggieburgers do you want?");
                                int veggie = sc.nextInt();
                                System.out.println("How many sodas do you want?");
                                int sodas = sc.nextInt();
                                System.out.println("Is your order to go? (Y/N)");
                                char letter = sc.next().charAt(0);
                                boolean TOGO = false;
                                if (letter == 'Y' || letter == 'y') {
                                        TOGO = true;
                                }
                                int orderNum = kitchen.addOrder(ham, cheese, veggie, sodas, TOGO);
                                System.out.println("Thank-you. Your order number is " + orderNum);
                                System.out.println();
                                break;
                        case 2:
                                boolean ready = kitchen.cancelLastOrder();
                                if (ready) {
                                        System.out.println("Thank you. The last order has been canceled");
                                } else {
                                        System.out.println("Sorry. There are no orders to cancel.");
                                }
                                System.out.println();
                                break;
                        case 3:
                                System.out.println("There are " + kitchen.getNumOrdersPending() + " pending orders");
                                break;
                        case 4:
                                break;

                        case 5:
                                System.out.println("What is your Order Number?");
                                int order = sc.nextInt();
                                int OrderNum = kitchen.isOrderDone(order);
                                if (OrderNum == 1) {
                                        System.out.println("Your Order has been Completed");
                                } else {
                                        System.out.println("Your Order is being Prepared");
                                }
                                break;
                        case 6:
                                System.out.println("What is your Order Number?");
                                int orderID = sc.nextInt();
                                boolean OrderNumCancel = kitchen.cancelOrder(orderID);
                                if (OrderNumCancel) {
                                        System.out.println("Your order has been successfully cancelled");
                                } else {
                                        System.out.println("Sorry, we can’t find your order number in the system");
                                }
                                break;
                        case 7:
                                System.out.println("What is your Order Number?");
                                int searchOrderID = sc.nextInt();
                                int index = kitchen.findOrderSeq(searchOrderID);
                                if (index != -1) {
                                        System.out.println("Your order found at postion : "+index);
                                } else {
                                        System.out.println("Sorry, we can’t find your order number in the system");
                                }
                                break;
                        case 8:
                                System.out.println("What is your Order Number?");
                                int searchBinOrderID = sc.nextInt();
                                int idx = kitchen.findOrderBin(searchBinOrderID);
                                if (idx != -1) {
                                        System.out.println("Your order found at postion : "+idx);
                                } else {
                                        System.out.println("Sorry, we can’t find your order number in the system");
                                }
                                break;
                        case 9:
                                kitchen.selectionSort();
                                System.out.println("**** Sorted orders with selection sort *****");
                                System.out.println(kitchen.toString());
                                break;
                        case 10:
                                kitchen.insertionSort();
                                System.out.println("**** Sorted orders with insertion sort *****");
                                System.out.println(kitchen.toString());
                                break;

                        default:
                                System.out.println("Sorry, but you need to enter a 1, 2, 3, 4, 5, or a 6");
                        }

                }
        }
}
    

