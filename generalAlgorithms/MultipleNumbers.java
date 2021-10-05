package algorithms.generalAlgorithms;

public class MultipleNumbers {
    public int multiple(int a,int b) {
        if (a == 0 || b == 0)
            return 0;
        if (b > 0)
            return a + multiple(a, b - 1);
        else
            return -multiple(a, -b);
    }
}
