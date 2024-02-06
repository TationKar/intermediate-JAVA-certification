package srv;

import model.Toy;
import java.util.List;
import java.util.Scanner;

public class MainServ {

        /*
            добавление игрушки в файл
        */
        public void addToy() {
            Scanner scanner = new Scanner(System.in);

            int id = getPrizesList().size() + 1;

            System.out.println("Введите название игрушки: ");
            String title = scanner.nextLine();

            String amount;
            do {
                System.out.println("Введите количество игрушек: ");
                amount = scanner.nextLine();
            } while (!amount.matches("\\d+"));

            String priority;
            do {
                System.out.println("Введите шанс получения игрушки от 1 до 9: ");
                priority = scanner.nextLine();
            } while (!priority.matches("[1-9]"));

            DataServ.writeData(new Toy(id, title, Integer.parseInt(amount), Integer.parseInt(priority)), true);
        }

        /*
            получение всех игрушек
        */
        public List<Toy> getPrizesList() {
            return DataServ.readData();
        }

    }


