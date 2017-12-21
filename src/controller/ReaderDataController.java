package controller;

import entity.TemplateRoom;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReaderDataController {



    public void readTemplateRoom(String nameTemplate) {

        File file = new File("src/util/templateRoom.txt");
        String s2 = new String();

        try {

            // A simple text scanner
            Scanner myFile = new Scanner(file);


            while(myFile.hasNextLine())
            {
                String s = nameTemplate;

                String nome;

                if((nome = myFile.next()).equals(s))
                {
                    System.out.println(myFile.next());
                    System.out.println(myFile.next());
                    System.out.println(myFile.next());
                    System.out.println(myFile.next());
                    System.out.println(myFile.next());



                    /*
                     * TODO
                     */
                }myFile.nextLine();
            }

            // Close file...
            myFile.close();

        } catch (IOException e) {
            // TODO
            e.printStackTrace();
        }
    }


    public static void main(String[] args){

        //TemplateRoom templateRoom = new TemplateRoom("c", 150,
        //        "Nera", 2, 0, true);
        ReaderDataController rDC = new ReaderDataController();
        rDC.readTemplateRoom("b");
        }
}

