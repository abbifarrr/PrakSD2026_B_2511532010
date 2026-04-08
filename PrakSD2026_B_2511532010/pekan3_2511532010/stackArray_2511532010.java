package pekan3_2511532010;

public class stackArray_2511532010 {
    static final int MAX = 1000;
    int top;
    int a[] = new int[MAX];

    // Constructor
    stackArray_2511532010() {
        top = -1;
    }

    boolean isEmpty() {
        return (top == -1);
    }

    boolean push(int x) {
        if (top >= (MAX - 1)) {
            System.out.println("Stack Overflow");
            return false;
        } else {
            a[++top] = x;
            System.out.println(x + " dimasukkan dalam stack");
            return true;
        }
    }

    int pop_2511532010() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        } else {
            int x = a[top--];
            return x;
        }
    }

    int peek_2511532010() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        } else {
            int x = a[top];
            return x;
            
            
        }
    }
    
    void print() {
    	for (int i = top; i>-1; i--)
    	{
    		
    	System.out.println (" " + a[i]);
    	}
    	}
}