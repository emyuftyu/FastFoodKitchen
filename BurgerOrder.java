package fastfoodkitchen;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author emray
 */
public class BurgerOrder {
    
    private int numHamburgers = 0;
    private int numCheeseburgers = 0;
    private int numVeggieburgers = 0;
    private int numSodas = 0;
    private boolean orderToGo = false;
    private int orderNum = 4;
    
    
    /**
     * Step 12   
     * Add a constructor to this class
     * it should take 6 parameters
     * @return 
     */
    
      public BurgerOrder(int numHamburgers, int numCheeseburgers, int numVeggieburgers, int numSodas, boolean orderToGo, int orderNum) {
          
          this.numCheeseburgers = numCheeseburgers;
          this.numHamburgers = numHamburgers;
          this.numVeggieburgers = numVeggieburgers;
          this.numSodas = numSodas;
          this.orderNum = orderNum;
          this.orderToGo = orderToGo;
                  
          
          
          
      }
                       
    
    
    
    
    //NUMHAMBURGERS
    //getter method
    public int getNumHamburgers(){
        return numHamburgers;
    }
    //setter method
    public void setNumHamburgers(int numHamburgers){
        this.numHamburgers = numHamburgers;
    }
    
    //NUM CHEESEBURGERS
    //getter method
    public int getCheeseburgers(){
        return numCheeseburgers;
    }
    //setter
    public void setNumCheeseburgers(int Cheeseburgers){
        this.numCheeseburgers = numCheeseburgers;
    }
    
    //NUMVEGGIEBURGERS
    //getter
     public int getVeggieburgers(){
        return numVeggieburgers;
    }
    //setter
    public void setNumVeggieburgers(int Veggieburgers){
        this.numVeggieburgers = numVeggieburgers;
    }
    
    //NUMSODAS
        //getter
     public int getSodas(){
        return numSodas;
    }
    //setter
    public void setSodas(int Sodas){
        this.numSodas = numSodas;
    }
    
    //isOrderToGo
    //getter
    //getter is a little differetn when the data type is boolean
    public boolean isOrderToGo(){
        return orderToGo;
    }
    //setter
    public void setorderToGo(boolean orderToGo){
        this.orderToGo = orderToGo;
    }
    
    //ORDERNUM
    //getter
    public int getOrderNum(){
        return orderNum;
    }
    //setter
    public void setOrderNum(int orderNum){
        this.orderNum = orderNum;
    }

    
    //Step 13
    //String value
    @Override
    public String toString() {
        return "BurgerOrder{" + "numHamburgers=" + numHamburgers + ", numCheeseburgers=" + numCheeseburgers + ", numVeggieburgers=" + numVeggieburgers + ", numSodas=" + numSodas + ", orderToGo=" + orderToGo + ", orderNum=" + orderNum + '}';
    }
    
    
    
    
        public int getTotalBurgerOrders() {
                return (this.numCheeseburgers + this.numHamburgers + this.numVeggieburgers);
        }

        public int compareTo(BurgerOrder element) {
                int res = 0;
                if (this.getTotalBurgerOrders() < element.getTotalBurgerOrders()) {
                        res = -1;
                }
                if (this.getTotalBurgerOrders() > element.getTotalBurgerOrders()) {
                        res = 1;
                }
                return res;
        }

}
    
    
    

