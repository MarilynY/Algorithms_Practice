public class TestKeywordStatic {
    public static void main (String[] args) {
        testStatic instance = new testStatic();
        instance.nonStaticMethod();

        testStatic.staticMethod();
    }
}

//static method can only access static field
//non-static method can access both static and non-static field
//eg.

class testStatic {

    static int a = 4;
    int b = 5;

    public void nonStaticMethod() {
        System.out.println(a);//4
        System.out.println(b);//5
    }

    public static void staticMethod() {
        System.out.println(a);//4

        //This is wring. It equals to (this.b), but no this in static method.
        //Error:non-static variable b cannot be referenced from a static context
        //System.out.println(b);


        //right way
        testStatic object = new testStatic();
        System.out.print(object.b);//5
    }
}