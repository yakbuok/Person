import java.util.concurrent.atomic.AtomicInteger;

class Person {
    private String name;
    private int age;
    private String username;
    private String password;

    public Person(String name, int age, String username, String password) {
        this.name = name;
        this.age = age;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Age: %d", name, age);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Person person = (Person) obj;
        return username.equals(person.username) && password.equals(person.password);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class Customer extends Person {
    private static final AtomicInteger idCounter = new AtomicInteger(0);
    private final int customerID;
    private double balance;

    public Customer(String name, int age, String username, String password) {
        super(name, age, username, password);
        this.customerID = idCounter.incrementAndGet();
        this.balance = 0.0;
    }

    public int getCustomerID() {
        return customerID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return String.format("%s, CustomerID: %d, Balance: %.2f", super.toString(), customerID, balance);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;

        Customer customer = (Customer) obj;
        return customerID == customer.customerID ||
                (getUsername().equals(customer.getUsername()) && getPassword().equals(customer.getPassword()));
    }
}

class Manager extends Person {
    private static final AtomicInteger idCounter = new AtomicInteger(0);
    private final int managerID;
    private int actionNumber;

    public Manager(String name, int age, String username, String password) {
        super(name, age, username, password);
        this.managerID = idCounter.incrementAndGet();
        this.actionNumber = 0;
    }

    public int getManagerID() {
        return managerID;
    }

    public int getActionNumber() {
        return actionNumber;
    }

    public void setActionNumber(int actionNumber) {
        this.actionNumber = actionNumber;
    }

    @Override
    public String toString() {
        return String.format("%s, ManagerID: %d, Action Number: %d", super.toString(), managerID, actionNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;

        Manager manager = (Manager) obj;
        return managerID == manager.managerID ||
                (getUsername().equals(manager.getUsername()) && getPassword().equals(manager.getPassword()));
    }
}
// main has got some problem
public class Main{
    public static void main(String[] args) {
        Customer customer1 = new Customer("Chuol", 30, "chuol123", "password123");
        Manager manager1 = new Manager("Prince", 40, "princeb456", "mypassword");

        customer1.setBalance(100.50);
        manager1.setActionNumber(5);

        System.out.println(customer1);
        System.out.println(manager1);

        System.out.println("customer1 equals manager1: " + customer1.equals(manager1));
    }
}