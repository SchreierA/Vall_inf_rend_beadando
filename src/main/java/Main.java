package beadando;
import beadando.tr.TestRunner;

class Main {

    @TestRunner.TestCase
    public static class Test{
        TestRunner tr = new TestRunner(this);
        @TestRunner.BeforeClass
        public void t0() { System.out.println("5-ös?");}
        @TestRunner.Test
        public void t1() {
            TestRunner.assertTrue(true);
        }
        @TestRunner.Test
        public void t2() {
            TestRunner.assertEquals("asd", "asd");
        }
        @TestRunner.AfterClass
        public void t4() { System.out.println("5-ös!");}
    }


    public static void main(String[] args) {
        Test t = new Test();
        t.tr.run();
    }
}