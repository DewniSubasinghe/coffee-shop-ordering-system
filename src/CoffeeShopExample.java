public class CoffeeShopExample {
    public static void main(String[] args) {
        // Initializing coffee shop with a queue capacity of 5
        CoffeeShop coffeeShop = new CoffeeShop(5);

        // Creating and starting customer threads
        for (int i = 1; i <= 20; i++) {
//            new Customer(coffeeShop).start();
            Customer customer = new Customer(coffeeShop);
            customer.start();
        }

        // Creating and starting barista threads
        for (int i = 1; i <= 3; i++) {
//            new Barista(coffeeShop).start();
            Barista barista = new Barista(coffeeShop);
            barista.start();
        }
    }
}

