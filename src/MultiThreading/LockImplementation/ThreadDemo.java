package MultiThreading.LockImplementation;

public class ThreadDemo{

    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount();

        Runnable task = () -> bankAccount.withdraw(70);
        Thread t1 = new Thread(task,"Thread-1");
        Thread t2 = new Thread(task,"Thread-2");
        t1.start();
        t2.start();

        System.out.println();

    }

}
