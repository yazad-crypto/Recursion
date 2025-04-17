public class Main {
    public static void main(String[] args){
        countDown(5);
    }
}


public static void countDown(int n) {
    if(n == 0){
        return;
    }
    System.out.println("The current time is " + n);
    n--;
    
}