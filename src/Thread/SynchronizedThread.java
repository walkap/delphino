package Thread;

import entity.TemplateRoom;

import java.util.List;

class MakeSomething {
    private TemplateRoom tR;

    public synchronized void doOp(String name) {
        System.out.println("Il valore del dato dal thread "
                + Thread.currentThread().getName() + " è di ");
        for (int i = 1; i < 6; i++) {
            try {
                Thread.sleep(1500);
                name = name + Integer.toString(i);
                //System.out.println(name);
                TemplateRoom tR = new TemplateRoom(name, 150,
                        "Nera", 2, 0, true);
                System.out.println(tR.getNameTemplate());
                name = name.substring(0, 1);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class RunThread1 implements Runnable {

    private MakeSomething ms;

    public RunThread1(MakeSomething mop) {

        this.ms = mop;
    }

    public void run() {
        ms.doOp("A");
    }
}

class RunThread2 implements Runnable {
    private MakeSomething ms;

    public RunThread2(MakeSomething ms) {
        this.ms = ms;
    }

    public void run() {
        ms.doOp("B");
    }
}

public class SynchronizedThread {
    public static void main(String args[]) {
        MakeSomething ms = new MakeSomething();

        Thread t_1 = new Thread(new RunThread1(ms), "Aule A");
        Thread t_2 = new Thread(new RunThread2(ms), "Aule B");

        t_1.start();
        t_2.start();
    }
}

