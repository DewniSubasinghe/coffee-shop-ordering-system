public class Barista extends Thread {
    private final CoffeeShop coffeeShop;

    public Barista(CoffeeShop coffeeShop) {
        this.coffeeShop = coffeeShop;
    }

    @Override
    public void run() {
        try {
            // Keep preparing orders
            while (true) {
                String order = coffeeShop.prepareOrder();
                System.out.println("Barista " + Thread.currentThread().getName() + " prepared: " + order);
                // Simulating preparation time
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
