
package fastfoodkitchen;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author emray
 */
public class FastFoodKitchen {
        private ArrayList<BurgerOrder> orderList = new ArrayList<BurgerOrder>();
        // private ArrayList orderList = new ArrayList<>();
        private static int nextOrderNum;

        public FastFoodKitchen() {

                BurgerOrder order1 = new BurgerOrder(3, 5, 4, 10, false, 1);
                BurgerOrder order2 = new BurgerOrder(0, 0, 3, 2, true, 2);
                BurgerOrder order3 = new BurgerOrder(1, 1, 0, 2, false, 3);

                orderList.add(order1);
                increamentNextOrderNum();

                orderList.add(order2);
                increamentNextOrderNum();

                orderList.add(order3);
                increamentNextOrderNum();

        }

        public List getOrderList() {
                return orderList;
        }

        public void setOrderList(ArrayList<BurgerOrder> orderList) {
                this.orderList = orderList;
        }

        /**
         * Getting The Order Number
         */

        public static int getNextOrderNum() {
                return nextOrderNum;
        }

        /**
         ham
         * cheese
         * veggi
         * sode
         * toGo
         */
        public int addOrder(int ham, int cheese, int veggie, int soda, boolean toGo) {
                BurgerOrder newOrder = new BurgerOrder(ham, cheese, veggie, soda, toGo, getNextOrderNum());
                orderList.add(newOrder);
                int orderID = getNextOrderNum();
                increamentNextOrderNum();
                return orderID;
        }

        /**
         * Checking if your Order Is Complete with a For loop if the Order is within the
         * List it repeats False otherwise returns True
         * 
         * @param orderID The Order ID that was provided before to check if it's done.
         * @return Returns either a 1 or 0 that entails the phase
         */
        public int isOrderDone(int orderID) {

                for (BurgerOrder order : orderList) {
                        if (order.getOrderNum() == orderID)
                                return 1;
                }
                return 0;
        }

        /**
         * Increaments the Next Order Number by One
         */
        public static void increamentNextOrderNum() {
                nextOrderNum++;
        }

        /**
         * Cancels The Last Ofer but Using an If Statement
         */
        public boolean cancelLastOrder() {
                if (orderList.size() >= 1) {
                        orderList.remove(orderList.size() - 1);
                        nextOrderNum--;
                        return true;
                } else {
                        return false;
                }
        }

        /**
         * A Methoad that uses the Order List Size Command to gather all current orders
         */
        public int getNumOrdersPending() {

                return orderList.size();
        }

        /**
         * Method that Cancels the Specified Order Number by using the Order ID. Using
         * an if statement turning a true or false
         * 
         * @param orderID Uses the Order ID to push through the Method. Order ID was
         *                provided at the beginning after ordering the food.
         * @return Returns a true or false if the order was able to be canceled.
         */
        public boolean cancelOrder(int orderID) {
                for (BurgerOrder order : orderList) {
                        if (order.getOrderNum() == orderID) {
                                orderList.remove(orderID);
                                return true;
                        }
                }
                return false;
        }

        @Override
        public String toString() {
                return "FastFoodKitchen [orderList=" + orderList + "]";

        }

        /**
         * This method search the order using orderid and returns the position of order
         * in the list
         * 
         * @param orderid
         * @return returns position of order in the order list
         * 
         */
        public int findOrderSeq(int orderID) {
                int pos = -1;
                int i = -1;
                // Loop through order list and search for Order
                for (BurgerOrder order : orderList) {
                        i++;
                        if (order.getOrderNum() == orderID) {
                                pos = i;

                        }

                }
                return pos;
        }

  
        /**
         * Comparator class for sorting based on order id for Binary search
         */
        class Sortbyorder implements Comparator<BurgerOrder> {
                // Used for sorting in ascending order of
                // name
                @Override
                public int compare(BurgerOrder a, BurgerOrder b) {

                        return Integer.compare(a.getOrderNum(), b.getOrderNum());
                }
        }

        /**
         * This method search the order with orderid using binary search and returns the
         * position of order in the list
         * 
         * @param orderid
         * @return returns position of order in the order list
         * 
         */
        public int findOrderBin(int orderID) {

                int left = 0, right = orderList.size() - 1;

                while (left <= right) {
                        int mid = left + (right - left) / 2;
                        int cur_order_id = orderList.get(mid).getOrderNum();
                        // Check if x is present at mid
                        if (cur_order_id == orderID) {

                                return mid;
                        }

                        // If cur_order_id greater, ignore left half
                        if (cur_order_id < orderID)
                                left = mid + 1;

                        // If orderID is smaller, ignore right half
                        else
                                right = mid - 1;
                }

                // if we reach here, then element was
                // not present
                return -1;

        }

        /**
         * this method used for selection sort
         * 
         */
        public void selectionSort() {
                for (int i = 0; i < orderList.size(); i++) {
                        // find position of smallest num between (i + 1)th element and last element
                        int pos = i;
                        for (int j = i; j < orderList.size(); j++) {
                                if (orderList.get(j).getTotalBurgerOrders() < orderList.get(pos).getTotalBurgerOrders())
                                        pos = j;
                        }
                        // Swap min (smallest num) to current position on array
                        BurgerOrder min = orderList.get(pos);
                        orderList.set(pos, orderList.get(i));
                        orderList.set(i, min);

                }
        }

       
        public void insertionSort() {
                for (int j = 1; j < orderList.size(); j++) {
                        BurgerOrder current = orderList.get(j);
                        int i = j - 1;

                        while ((i > -1) && ((orderList.get(i).compareTo(current)) == 1)) {
                                orderList.set(i + 1, orderList.get(i));
                                i--;
                        }
                        orderList.set(i + 1, current);
                }
        }

}
