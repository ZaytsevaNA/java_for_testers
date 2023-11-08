package common;

import java.util.Random;

public class CommonFunctions {
    public static String randomString(int n) {
        var result = "test-";
        var rnd = new Random();
        for (int i = 0; i < n; i++) {
            result = result + (char)('a' + rnd.nextInt(26));
        }
        return result;
    }
}