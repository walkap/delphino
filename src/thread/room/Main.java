package thread.room;

public class Main {

    public static void main(String args[]){
        Secretary secretary = new Secretary();
        new Producer(secretary);
        new Consumer(secretary);
    }

}
