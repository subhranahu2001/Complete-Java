package MultiThreading.Questions;

class EvenOdd {
    static int count = 0;

    public synchronized void printEven() {

        while (count < 10) {
            if (count % 2 != 0) {
                try{
                    wait();
                }catch (InterruptedException e){}
            }

            System.out.println(Thread.currentThread().getName() + ": " + count++);
            notifyAll();
        }

    }

    public synchronized void printOdd() {

        while(count < 10) {
            if (count % 2 == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {}
            }
            System.out.println(Thread.currentThread().getName() + ": " + count++);
            notifyAll();

        }
    }
}

public class EvenOddProgram {


    public static void main(String[] args){
        EvenOdd evenOdd = new EvenOdd();
        Runnable r1 = evenOdd::printEven;
        Runnable r2 = evenOdd::printOdd;
        new Thread(r1, "Even").start();
        new Thread(r2, "Odd").start();
    }

}
