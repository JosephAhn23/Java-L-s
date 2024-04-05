import java.util.Random;
public class Customer {
    private static final int MAX_NUM_ITEMS = 10;

    private int arrivalTime, numItems, servedItems;

    public Customer(int arrivalTime) {
        this.arrivalTime = arrivalTime;
        Random generator = new Random();
        this.numItems = generator.nextInt(MAX_NUM_ITEMS - 1) + 1;
        this.servedItems = 0;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getNumberOfItems() {
        return numItems - servedItems;
    }

    public int getNumberOfServedItems() {
        return servedItems;
    }

    public void serve() {
        if (getNumberOfItems()>0) {
            servedItems++;
        }
    }

}
