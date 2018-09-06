public class less1 {
    public static void main (String[] args) {
        float a=1f;
        int b=147483645;

        a = (float) b;
        //System.out.println(a);

        task2 t2 = new task2();
        task3 t3 = new task3();
    }

}

class task2 {
    public task2 () {
        float f = (float)128.50;
        int i;
        int b;

        i = 128;
        b = i - (int)f;
        System.out.println(b);
    }
}

class task3 {
    public task3 () {
        short number = 9;
        short zero=48;
        int nine = (zero + number);
        // ASCII од символа '9' = 57
        System.out.println((char)nine);
    }
}
