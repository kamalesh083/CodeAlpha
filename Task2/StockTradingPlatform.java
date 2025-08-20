import java.util.*;

class Stock {
    String symbol;
    double price;

    Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }
}

class User {
    String name;
    double balance;
    HashMap<String, Integer> portfolio = new HashMap<>();

    User(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    void buyStock(Stock stock, int quantity) {
        double cost = stock.price * quantity;
        if (cost <= balance) {
            balance -= cost;
            portfolio.put(stock.symbol, portfolio.getOrDefault(stock.symbol, 0) + quantity);
            System.out.println("Bought " + quantity + " of " + stock.symbol);
        } else {
            System.out.println("Not enough balance!");
        }
    }

    void sellStock(Stock stock, int quantity) {
        if (portfolio.getOrDefault(stock.symbol, 0) >= quantity) {
            balance += stock.price * quantity;
            portfolio.put(stock.symbol, portfolio.get(stock.symbol) - quantity);
            System.out.println("Sold " + quantity + " of " + stock.symbol);
        } else {
            System.out.println("Not enough shares!");
        }
    }

    void showPortfolio() {
        System.out.println("\n--- Portfolio ---");
        for (String s : portfolio.keySet()) {
            System.out.println(s + " : " + portfolio.get(s));
        }
        System.out.println("Balance: $" + balance);
    }
}

public class StockTradingPlatform {
    public static void main(String[] args) {
        Stock apple = new Stock("AAPL", 150.0);
        Stock google = new Stock("GOOGL", 2800.0);

        User user = new User("Alice", 5000);

        user.buyStock(apple, 10);
        user.buyStock(google, 1);
        user.sellStock(apple, 5);

        user.showPortfolio();
    }
}
