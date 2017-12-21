package controller;

import entity.TemplateRoom;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterDataController {

    public void writeTemplateRoom(TemplateRoom tR) {

        String nameTemplate = tR.getNameTemplate();
        int seats = tR.getSeats();
        String board = tR.getBoard();
        int projectors = tR.getProjectors();
        int computers = tR.getComputers();
        String desk = tR.getDesk().toString();
        try {

            String content = nameTemplate + " " + seats + " " + board + " "
                    + projectors + " " + computers + " " + desk +  "\n";

            File file = new File("src/util/templateRoom.txt");
            if (!file.exists()){
                file.createNewFile();
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            bw.append(content);
            bw.close();

            System.out.println("Ok");

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        TemplateRoom templateRoom = new TemplateRoom("b", 150,
                "Nera", 2, 0, true);
        WriterDataController wDC = new WriterDataController();
            wDC.writeTemplateRoom(templateRoom);

    }
}


