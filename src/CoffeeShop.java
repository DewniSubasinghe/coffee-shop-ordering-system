import java.util.LinkedList;
import java.util.Queue;

public class CoffeeShop {
    private final Queue<String> orderQueue = new LinkedList<>();
    private final int capacity;

    public CoffeeShop(int capacity) {
        this.capacity = capacity;
    }

    // Placing orders
    public synchronized void placeOrder(String order) throws InterruptedException {
        while (orderQueue.size() == capacity) {
            System.out.println("---------Queue is full. Customer is waiting to place order---------");
            // Wait for space
            wait();
        }
        orderQueue.add(order);
        System.out.println("Order placed: " + order);
        // Notify waiting threads
        notifyAll();
    }

    // Preparing orders
    public synchronized String prepareOrder() throws InterruptedException {
        while (orderQueue.isEmpty()) {
            System.out.println("---------Queue is empty. Barista is waiting for orders---------");
            // Wait for orders
            wait();
        }
        String order = orderQueue.poll();
        System.out.println("Order prepared: " + order);
        // Notify waiting threads
        notifyAll();
        return order;
    }
}
