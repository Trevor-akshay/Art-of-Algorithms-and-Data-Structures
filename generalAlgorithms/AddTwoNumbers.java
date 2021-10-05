package algorithms.generalAlgorithms;

public class AddTwoNumbers {
    public int addNumbers(int a,int b){
        while (b > 0){
            a++;
            b--;
        }
        return a;
    }
}
