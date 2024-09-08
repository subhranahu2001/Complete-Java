package MultiThreading.LockImplementation;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private final Lock lock = new ReentrantLock();

    private int balance = 100;

    public void withdraw(int amount) {

        System.out.println(Thread.currentThread().getName() + ": attempting to withdrawing " + amount + " from bank");
        try {

            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {

                if (amount < balance) {
                    try{
                        System.out.println(Thread.currentThread().getName() + ": proceed to withdraw " + amount + " from bank");
                        balance -= amount;

                        Thread.sleep(100);
                        System.out.println(Thread.currentThread().getName() + ": successfully withdrawn . Remaining balance " + balance + " from bank");
                    }catch (InterruptedException e){
                        Thread.currentThread().interrupt();
                    } finally {
                        lock.unlock();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + " insufficient balance ");
                }


            } else {
                System.out.println(Thread.currentThread().getName()+" Could not acquire lock , try later");
            }


        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }


    }

}
