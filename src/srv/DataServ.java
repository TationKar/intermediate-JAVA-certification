package srv;

import model.Toy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataServ {

    private final static String path_lottery_list = "lottery_list.txt";

    public static void writeData(Toy toy, boolean newLine) {

        try (FileWriter writer = new FileWriter(path_lottery_list, newLine)) {
            writer.write(toy.getIdToy() + ",");
            writer.write(toy.getnToy() + ",");
            writer.write(toy.getPcsToy() + ",");
            writer.write(toy.getChnsToy() + "\n");
            writer.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void reWriteData(List<Toy> toysList) {
        int id = 1;
        for (Toy toy : toysList) {
            if (toy.getIdToy() == 1) {
                toy.setIdToy(id++);
                writeData(toy, false);
                continue;
            }
            toy.setIdToy(id++);
            if (toy.getPcsToy() > 0) {
                writeData(toy, true);
            }
        }
    }

    public static List<Toy> readData() {

        try {
            new File(path_lottery_list).createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Toy> list = new ArrayList<>();

        try (BufferedReader bf = new BufferedReader(new FileReader(path_lottery_list))) {
            String str;
            while ((str = bf.readLine()) != null) {

                String[] array = str.split(",");

                Toy toy = new Toy(Integer.parseInt(array[0]), array[1], Integer.parseInt(array[2]), Integer.parseInt(array[3]));
                list.add(toy);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}

