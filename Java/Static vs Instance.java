public class Counter {

    // Static variable (shared by all objects)
    static int count = 0;

    // Instance method (requires object)
    public void increment() {
        count++;
    }

    // Static method
    public static int getCount() {
        return count;
    }

    public static void main(String[] args) {

        Counter c1 = new Counter();
        Counter c2 = new Counter();

        c1.increment();  // count = 1
        c2.increment();  // count = 2
        c1.increment();  // count = 3

        System.out.println("Final Count: " + Counter.getCount());
    }
}
