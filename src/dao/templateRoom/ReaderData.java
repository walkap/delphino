package dao.templateRoom;

import entity.TemplateRoom;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class ReaderData {


    private String nameT;
    private int seats;
    private String board;
    private int projectors;
    private int computers;
    private Boolean desk;
    File file = new File("src/util/templateRoom.txt");

    public Boolean isPresentTemplateRoom(String nameTemplate) {

        Boolean bol = false;

        try {

            // A simple text scanner
            Scanner myFile = new Scanner(file);

            while (myFile.hasNextLine()) {

                if (myFile.next().equals(nameTemplate)) {
                    bol = true;
                    System.out.println("is present");
                }
                myFile.nextLine();
            }

            myFile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return bol;
    }

    public TemplateRoom getTemplateRoom(String nameTemplate) {


        try {

            // A simple text scanner
            Scanner myFile = new Scanner(file);

            while (myFile.hasNextLine()) {

                if (myFile.next().equals(nameTemplate)) {
                    seats = myFile.nextInt();
                    board = myFile.next();
                    projectors = myFile.nextInt();
                    computers = myFile.nextInt();
                    desk = myFile.nextBoolean();

                    System.out.println(seats);
                    System.out.println(board);
                    System.out.println(projectors);
                    System.out.println(computers);
                    System.out.println(desk);

                }
                myFile.nextLine();
            }

            myFile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        TemplateRoom tR = new TemplateRoom(nameTemplate, seats, board, projectors, computers, desk);
        System.out.println(tR);
        return tR;
    }

    public Vector<TemplateRoom> getAllTemplateRoom() {

        Vector<TemplateRoom> vec = new Vector<>();

        try {
            Scanner myFile = new Scanner(file);
            while (myFile.hasNextLine()) {

                nameT = myFile.next();
                seats = myFile.nextInt();
                board = myFile.next();
                projectors = myFile.nextInt();
                computers = myFile.nextInt();
                desk = myFile.nextBoolean();
                TemplateRoom tR = new TemplateRoom(nameT,
                        seats, board, projectors, computers, desk);
                vec.add(tR);
                System.out.println(tR.getNameTemplate());
                System.out.println(tR);


                myFile.nextLine();
            }
            myFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(vec);
        return vec;
    }


    public static void main(String[] args) {

        //TemplateRoom templateRoom = new TemplateRoom("c", 150,
        //        "Nera", 2, 0, true);
        ReaderData rDC = new ReaderData();
        //rDC.getTemplateRoom("a");
        //rDC.getAllTemplateRoom();
        rDC.isPresentTemplateRoom("b");
    }
}



