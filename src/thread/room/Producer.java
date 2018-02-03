package thread.room;

public class Producer implements Runnable {

    private Secretary secretary;

    public Producer(Secretary secretary){
        this.secretary = secretary;
        new Thread(this, "Producer Secretary").start();
    }

    @Override
    public void run() {
        for(int i = 1; i <= 10; i++){
            secretary.add();
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }


    }
}
