import java.io.File;

public class Hello {
    public static void main(String[] args) {
        try {
            var z = calculate();
            System.out.println(z);
            System.out.println("Hello, word!");
        }catch (ArithmeticException exception) {
            exception.printStackTrace();
        }
    }

    private static int calculate() {
        var x = 1;
        var y = 1;
        var z = divide(x, y);
        return z;
    }

    private static int divide(int x, int y) {
        var z = x / y;
        return z;
    }
}
