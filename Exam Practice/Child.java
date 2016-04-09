
public class Child extends Parent {
    public Child() {
        System.out.println("Child default");
    }
    public Child(int v) {
        super(v);
        System.out.println("Child int");
    }
    public void speak() {
        System.out.println("Yo dude");
    }
    public static void main(String[] args) {
        Parent p1 = new Parent();
        Parent p2 = new Parent(5);
        Parent p3 = new Child();
        Child c1 = new Child(3);
        p2.speak();
        p3.speak();
        c1.speak();
    }
}
