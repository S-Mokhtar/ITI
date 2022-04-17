package lab10;

public class Lab10 {
    @FunctionalInterface
    public interface SomeTest<T> {
        boolean test(T n, T m);
    }

    public static void main(String[] args) {
        SomeTest<Integer> isFactor = new SomeTest<Integer>() {
            public boolean test(Integer n, Integer m) {
                return n % m == 0;
            }
        };
        if (isFactor.test(10, 2)) {
            System.out.println("2 is a factor of 10");
        }
        System.out.println();
    }

}
