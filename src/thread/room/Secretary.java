package thread.room;

import entity.Building;
import entity.room.Room;

public class Secretary {

    private Room myRoom;
    private boolean empty = true;
    private int seats;

    /**
     * Constructor, initialize a new room and set seats to zero
     */
    public Secretary(){
        myRoom = new Room("C4", "ClassRoom", new Building("Didattica", "Ingegneria"));
        myRoom.setSeats(0);
        seats = myRoom.getSeats();
    }

    /**
     * This method is synchronized and check if the room is empty
     * if it is not wait, otherwise add a seat to the room
     */
    public synchronized void add(){
        if(!empty){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        seats++;
        System.out.println(Thread.currentThread().getName() + " added a seat to " + myRoom.getName());
        System.out.println(seats + " seats currently");
        empty = false;
        notify();
    }

    /**
     * This method is synchronized and check if the room is empty
     * if it is empty wait, otherwise remove a seat to the room
     */
    public synchronized void delete(){
        if(empty){
            try{
                wait();
            }catch (InterruptedException e ){
                e.printStackTrace();
            }
        }
        seats--;
        System.out.println(Thread.currentThread().getName() + " removed a seat from " + myRoom.getName());
        System.out.println(seats + " seats currently");
        empty = true;
        notify();
    }

}
