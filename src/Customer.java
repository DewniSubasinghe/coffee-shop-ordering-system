public class Customer extends Thread {
    private final CoffeeShop coffeeShop;

    public Customer(CoffeeShop coffeeShop) {
        this.coffeeShop = coffeeShop;
    }

    @Override
    public void run() {
        try {
            String order = "Coffee Order by " + Thread.currentThread().getName();
            coffeeShop.placeOrder(order);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
