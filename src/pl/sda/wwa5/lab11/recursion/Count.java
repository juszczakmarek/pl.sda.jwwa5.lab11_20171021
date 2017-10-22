package pl.sda.wwa5.lab11.recursion;

public class Count {

    private int countUntil;

    public Count(int countUntil) {
        this.countUntil = countUntil;
    }

    public int countStrong(int countUntil) {
        int result=1;
        for (int i=1; i<=countUntil; i++){
            result = result * i;
        }
        return result;
    }

    public int countStrongWithRecursion(int n) {
        if (n==0) {
            return 1;
        }
        if (n==1) {
            return 1;
        }
        return n*countStrongWithRecursion(n-1);
    }

    public int fib(int n) {

        int result=0;
        int secondPreviousElement=0;
        int previousElement=1;

        if (n==0) {
            return 0;
        }

        if (n==1 || n==2) {
            return 1;
        }

        for (int i=2;i<=n;i++) {
            result=secondPreviousElement+previousElement;
            secondPreviousElement=previousElement;
            previousElement=result;
        }

        return result;
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

    public int getCountUntil() {
        return countUntil;
    }
}
