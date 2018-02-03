package thread.room;

public class Consumer implements Runnable {

    private Secretary secretary;

    public Consumer(Secretary secretary){
        this.secretary = secretary;
        new Thread(this, "Consumer Secretary").start();
    }

    @Override
    public void run() {

        for(int i = 0; i < 10 ;i++){
            secretary.delete();
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }
}
