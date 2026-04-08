package pekan3_2511532010;

public class stackArrayDriver_2511532010 {

    public static void main(String[] args) {
        stackArray_2511532010 s = new stackArray_2511532010();
        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println(s.pop_2511532010() + " dikeluarkan dari stack");
        System.out.println("Elemen teratas adalah : " + s.peek_2511532010());
        System.out.println("Elemen pada stack :");
        s.print();
    }
}