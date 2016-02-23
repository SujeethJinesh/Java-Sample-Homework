public class Person {
    private String name;
    private double balance;

    public Person(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public Person(double balance) {
        this("Pete", balance);
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public boolean purchase(Item item) {
        if ((balance - item.getPrice() >= 0)) {
            balance -= item.getPrice();
        } else {
            return false;
        }
        return true;
    }

    public void deposit(double amount) {
        if (amount >= 0) {
            balance += amount;
        }
    }

    public String toString() {
        return name + " " + balance;
    }
}
