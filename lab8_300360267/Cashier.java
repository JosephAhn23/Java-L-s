public class Cashier {
    private int totalCustomersServed;
    private int totalItemsServed;
    private int totalCustomerWaitTime;
    private Customer currentCustomer;
    private ArrayQueue<Customer> queue;

    public Cashier() {
        totalCustomersServed = 0;
        totalItemsServed = 0;
        totalCustomerWaitTime = 0;
        currentCustomer = null;
        queue = new ArrayQueue<>();
    }

    public void addCustomer(Customer c) {
        queue.enqueue(c);
    }

    public int getQueueSize() {
        return queue.size();
    }

    public void serveCustomers(int currentTime) {
        if (currentCustomer == null && !queue.isEmpty()) {
            currentCustomer = queue.dequeue();
            totalCustomerWaitTime += currentTime - currentCustomer.getArrivalTime();
        }

        if (currentCustomer != null) {
            currentCustomer.serve();
            totalItemsServed++;

            if (currentCustomer.getNumberOfItems() == 0) {
                totalCustomersServed++;
                currentCustomer = null;
            }
        }
    }

    public int getTotalCustomerWaitTime() {
        return totalCustomerWaitTime;
    }

    public int getTotalItemsServed() {
        return totalItemsServed;
    }

    public int getTotalCustomersServed() {
        return totalCustomersServed;
    }

    @Override
    public String toString() {
        return "Cashier{" +
                "totalCustomersServed=" + totalCustomersServed +
                ", totalItemsServed=" + totalItemsServed +
                ", totalCustomerWaitTime=" + totalCustomerWaitTime +
                ", queueSize=" + queue.size() +
                '}';
    }

}
