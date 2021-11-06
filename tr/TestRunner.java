package beadando.tr;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestRunner {
    private static int testsRan = 0;
    private List<Method> testMethods = new ArrayList<>();
    private List<Method> beforeMethods = new ArrayList<>();
    private List<Method> afterMethods = new ArrayList<>();
    private List<Method> beforeClassMethods = new ArrayList<>();
    private List<Method> afterClassMethods = new ArrayList<>();
    private Object testClass;

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.TYPE})
    public @interface TestCase {
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.METHOD})
    public @interface Test {
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.METHOD})
    public @interface Skip {
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.METHOD})
    public @interface Before {
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.METHOD})
    public @interface After {
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.METHOD})
    public @interface BeforeClass {
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.METHOD})
    public @interface AfterClass {
    }

    public TestRunner(Object testClass){
        this.testClass = testClass;
        if (testClass.getClass().getAnnotation(TestCase.class) == null) {
            System.out.println("Received class is not a test case");
            return;
        }
        Method[] allMethods = testClass.getClass().getMethods();
        testMethods = Arrays.stream(allMethods)
                .filter(method ->
                    method.getAnnotation(Test.class) != null
                    && method.getAnnotation(Skip.class) == null
                )
                .collect(Collectors.toList());
        beforeMethods = Arrays.stream(allMethods)
                .filter(method -> method.getAnnotation(Before.class) != null)
                .collect(Collectors.toList());
        afterMethods = Arrays.stream(allMethods)
                .filter(method -> method.getAnnotation(After.class) != null )
                .collect(Collectors.toList());
        beforeClassMethods = Arrays.stream(allMethods)
                .filter(method -> method.getAnnotation(BeforeClass.class) != null)
                .collect(Collectors.toList());
        afterClassMethods = Arrays.stream(allMethods)
                .filter(method -> method.getAnnotation(AfterClass.class) != null )
                .collect(Collectors.toList());
    }

    public void run() {
        testsRan = 0;
        try {
            for (Method before : beforeClassMethods) { before.invoke(testClass); }
            for (Method test : testMethods) {
                for (Method before : beforeMethods) { before.invoke(testClass); }
                test.invoke(testClass);
                testsRan++;
                for (Method after : afterMethods) { after.invoke(testClass); }
            }
            for (Method before : afterClassMethods) { before.invoke(testClass); }
        }
        catch (IllegalAccessException | InvocationTargetException e) {
            System.out.println("Test execution failed with exception: " + e);
            System.out.println("Make sure both your test class and test methods are public");
        }
    }

    public static void assertTrue(Boolean input) {
        Assertions.assertTrue(input, testsRan);
    }

    public static void assertEquals(String actual, String expected) {
        Assertions.assertEquals(actual, expected, testsRan);
    }

    public static void assertEquals(int actual, int expected) {
        Assertions.assertEquals(actual, expected, testsRan);
    }

    public static void assertEquals(double actual, double expected) {
        Assertions.assertEquals(actual, expected, testsRan);
    }

    public static void assertEquals(long actual, long expected) {
        Assertions.assertEquals(actual, expected, testsRan);
    }

    public static void assertEquals(Integer actual, Integer expected) {
        Assertions.assertEquals(actual, expected, testsRan);
    }

    public static void assertEquals(Double actual, Double expected) {
        Assertions.assertEquals(actual, expected, testsRan);
    }

    public static void assertEquals(Long actual, Long expected) {
        Assertions.assertEquals(actual, expected, testsRan);
    }
}