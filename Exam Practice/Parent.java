public class Parent {
    public Parent() {
        this(12);
        System.out.println("Parent default");
    }
    public Parent(int v) {
        System.out.println("Parent int");
    }
    public void speak() {
        System.out.println("Listen to me");
    }
}