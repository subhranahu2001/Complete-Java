package MultiThreading;

class Pen {

    public  void writeWithPenAndPaper(Paper paper) {
        System.out.println(Thread.currentThread().getName()+" is using pen "+this+" and trying to use paper");
        paper.finishWriting();
    }

    public  void finishWriting() {
        System.out.println(Thread.currentThread().getName()+" finish using pen "+this);
    }
}

class Paper {
    public  void writeWithPenAndPaper(Pen pen) {
        System.out.println(Thread.currentThread().getName()+" is using paper "+this+" and trying to use pen");
        pen.finishWriting();
    }

    public void finishWriting() {
        System.out.println(Thread.currentThread().getName()+" finish using paper "+this);

    }
}

class Task1 extends Thread {
    Pen pen;
    Paper paper;
    Task1(Pen pen, Paper paper,String name) {
        super(name);
        this.pen = pen;
        this.paper = paper;
    }

    @Override
    public void run() {
        pen.writeWithPenAndPaper(paper);
    }
}

class Task2 extends Thread {
    Pen pen;
    Paper paper;
    Task2(Pen pen, Paper paper,String name) {
        super(name);
        this.pen = pen;
        this.paper = paper;
    }

    @Override
    public void run() {
        synchronized (pen) {
            paper.writeWithPenAndPaper(pen);
        }
    }
}

public class DeadLockDemo {

    public static void main(String[] args) {
        Pen pen = new Pen();
        Paper paper = new Paper();

        Thread t1 = new Task1(pen, paper,"first");
        Thread t2 = new Task2(pen, paper,"second");
        t1.start();
        t2.start();
    }

}
