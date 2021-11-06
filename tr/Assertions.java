package beadando.tr;

class Assertions {
    private static final String testString = "Test ";
    private static final String testPassedString = " Passed";
    private static final String testFailedString = " Failed";

    public static void assertTrue(Boolean input, int testsRan) {
        if (input) System.out.println(testString + testsRan + testPassedString);
        else System.out.println(testString + testsRan + testFailedString);
    }

    public static void assertEquals(String actual, String expected, int testsRan) {
        if (actual.equals(expected)) System.out.println(testString + testsRan + testPassedString);
        else System.out.println(testString + testsRan + testFailedString);
    }

    public static void assertEquals(int actual, int expected, int testsRan) {
        if (actual == expected) System.out.println(testString + testsRan + testPassedString);
        else System.out.println(testString + testsRan + testFailedString);
    }

    public static void assertEquals(double actual, double expected, int testsRan) {
        if (actual == expected) System.out.println(testString + testsRan + testPassedString);
        else System.out.println(testString + testsRan + testFailedString);
    }

    public static void assertEquals(long actual, long expected, int testsRan) {
        if (actual == expected) System.out.println(testString + testsRan + testPassedString);
        else System.out.println(testString + testsRan + testFailedString);
    }

    
    public static void assertEquals(Integer actual, Integer expected, int testsRan) {
        if (actual.equals(expected)) System.out.println(testString + testsRan + testPassedString);
        else System.out.println(testString + testsRan + testFailedString);
    }

    public  static void assertEquals(Double actual, Double expected, int testsRan) {
        if (actual.equals(expected)) System.out.println(testString + testsRan + testPassedString);
        else System.out.println(testString + testsRan + testFailedString);
    }

    public  static void assertEquals(Long actual, Long expected, int testsRan) {
        if (actual.equals(expected))  System.out.println(testString + testsRan + testPassedString);
        else System.out.println(testString + testsRan + testFailedString);
    }
}