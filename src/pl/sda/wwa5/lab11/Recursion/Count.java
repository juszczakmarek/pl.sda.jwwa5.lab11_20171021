package pl.sda.wwa5.lab11.Recursion;

public class Count {

    private int silnia =1;
    private int countUntil;
    private int fibonacci;

    public Count(int countUntil) {
        this.countUntil = countUntil;
        this.silnia = countStrong(countUntil);
        //this.silnia = countStrongWithRecursion(countUntil);
        this.fibonacci = fibWithRecursion(countUntil);
    }

    public int countStrongWithRecursion(int n) {
        if (n==0) {
            return 1;
        }
        if (n==1) {
            return 1;
        }
        return countStrongWithRecursion(n-2)*countStrongWithRecursion(n-1);
    }

    public int fibWithRecursion(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibWithRecursion(n - 1) + fibWithRecursion(n - 2);
    }

    public int countStrong(int silnia) {

        int result=1;

        for (int i=1; i<=silnia; i++){
            result = result * i;
        }

        return result;
    }

    public int getSilnia() {
        return silnia;
    }

    public int getCountUntil() {
        return countUntil;
    }

    public int getFibonacci() {
        return fibonacci;
    }

    public void setFibonacci(int fibonacci) {
        this.fibonacci = fibonacci;
    }
}
