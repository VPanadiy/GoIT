package Java_Core.JUnit;

/**
 * Created by Vitaliy on 23.12.2016.
 */
public class JUnit_test {
    public static void main(String[] args) {
        int a = 10;
        int b = 5;
        SimpleMath simpleMath = new SimpleMath();
        simpleMath.add(a,b);
        simpleMath.sub(a,b);
        simpleMath.mult(a,b);
        simpleMath.mod(a,b);
    }
}

class SimpleMath{
    public int add (int a, int b){
        return a+b;
    }
    public int sub (int a, int b){
        return a-b;
    }
    public int mult(int a, int b){
        return a*b;
    }
    public int mod (int a, int b){
        return a%b;
    }
    public int div(int a, int b){throw new UnsupportedOperationException("This operation is not supported yet");}
}
