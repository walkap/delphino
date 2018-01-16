package dao.templateRoom;

import dao.ReaderData;
import entity.TemplateRoom;

import java.io.*;

public class WriterData {

    private String nameT;
    private int seats;
    private String board;
    private int projectors;
    private int computers;
    private Boolean desk;
    private static File file = new File("src/util/templateRoom.txt");
    private ReaderData rDT = new ReaderData();

    public Boolean writeTemplateRoom(TemplateRoom tR) {

        Boolean bool = false;
        String nameTemplate = tR.getNameTemplate();
        int seats = tR.getSeats();
        String board = tR.getBoard();
        int projectors = tR.getProjectors();
        int computers = tR.getComputers();
        String desk = tR.getDesk().toString();
        if (!rDT.isPresentTemplateRoom(tR.getNameTemplate())) {
            try {

                String content = nameTemplate + " " + seats + " " + board + " "
                        + projectors + " " + computers + " " + desk + "\n";

                if (!file.exists()) {
                    file.createNewFile();
                }

                BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
                bw.append(content);
                bw.close();
                bool = true;

                System.out.println("Ok");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }return bool;
    }

    public void updateTemplateRoom(String nameTemplate) {

        if (rDT.isPresentTemplateRoom(nameTemplate)) {

        }
    }

    /*
        public void deleteTemplateRoom(String nameTemplate) throws FileNotFoundException {
            String currentLine;
            BufferedReader reader = null;
            FileWriter writer = null;
            String oldContent = "";
            Scanner scan = new Scanner (file);
            String buffer = "";

            if (rDT.isPresentTemplateRoom(nameTemplate)) {
                System.out.println("Is present");
                try {Scanner myFile = new Scanner(file);

                    while(myFile.hasNextLine())
                    {

                        if(myFile.next().equals(nameTemplate))
                        {
                            String s = String.valueOf(seats);
                            String b = board;
                            String p = String.valueOf(projectors);
                            String c = String.valueOf(computers);
    //                        String d = Boolean.toString(desk);
                            myFile.next().replace(s, "");
                            myFile.next().replace(b, "");
                            myFile.next().replace(p, "");
                            myFile.next().replace(c, "");
      //                      myFile.next().replace(d, "");

                        }
                        myFile.nextLine();
                    }

                    myFile.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    */
    public static void main(String[] args){

        TemplateRoom templateRoom = new TemplateRoom("b", 150,
                "Nera", 2, 0, true);
        WriterData wDC = new WriterData();
        //wDC.writeTemplateRoom(templateRoom);
        //wDC.deleteTemplateRoom("c");

    }
}


