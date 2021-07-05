package concepts.learning;

abstract class AbsClass {
    AbsClass() {
        System.out.println("AbsClass");
    }

    AbsClass(int b) {
        System.out.println("AbsClass " + b);
    }

    void work() {
        System.out.println("Works Fine");
    }

    static void workIt() {
        System.out.println("Works IT Fine");
    }

    abstract public void doOverride();
}

interface AbsInterface1 {
    public default void defaultFunCheck() {

    }

    ;
}

interface AbsInterface2 {
    public default void defaultFunCheck() {

    }

    ;
}

final class FinalClassCheck {
    private int val = 9;

    public int getVal() {
        return val;
    }
}

public class Inheritance extends AbsClass implements AbsInterface1, AbsInterface2 {
    Inheritance() {
        super();
        System.out.println("Inheritance");
    }

    Inheritance(int b) {
//        this();
//        super(b);
        System.out.println("Inheritance " + b);
    }

    static {
        System.out.println("Static Block");
    }

    static void workIt() {
        System.out.println("Works Fine");
    }

    @Override
    public void doOverride() {
        System.out.println("doOverride");
    }

    public void defaultFunCheck() {
        AbsInterface1.super.defaultFunCheck();
    }

    void testOverLoad(int a) {
        System.out.println("a = " + a);
    }

    void testOverLoad(int a, int b) {
        System.out.println("a = " + a + " b = " + b);
    }

    public static void main(String[] args) {
        Inheritance inheritance = new Inheritance(5);
        inheritance.doOverride();
        inheritance.work();
        workIt();
        AbsClass.workIt();
        FinalClassCheck finalClassCheck = new FinalClassCheck();
        System.out.println(finalClassCheck.getVal());

//        AbsClass absClass = new AbsClass();

    }
}
