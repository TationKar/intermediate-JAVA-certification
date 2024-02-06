package view;

import srv.ConsServ;

import java.util.Scanner;

    public class ConsView extends BaseView {
        private final ConsServ services;
        public ConsView() {
            services = new ConsServ();
        }

        @Override
        public void action() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("""
                    Выберите действие (введите нужное число):
                    1. Участвовать в игре и получить шанс на приз!
                    2. Показать список игрушек.
                    0. Выход.""");
            String input = scanner.nextLine();

            while (true) {

                if (input.equals("1")) {
                    System.out.print("Испытайте удачу введите число от 1 до 9\n");
                    input = scanner.nextLine();
                    int chance = Integer.parseInt(input);
                    while (true) {
                        if (chance != 0) {
                            String toy = services.getPrize(chance);
                            if (!toy.equals("LOSS")) {
                                System.out.printf("ПОЗДРАВЛЯЕМ!!! ВАШ ПРИЗ: >>> %s <<<\n", toy);
                                break;
                            } else {
                                System.out.println("Вы не выиграли, попробуйте еще раз.");
                                input = scanner.nextLine();
                                chance = Integer.parseInt(input);
                            }
                        } else {
                            break;
                        }
                    }
                    System.out.println("\tУчаствовать еще, введите: \"1\".\n\tПросмотр списка, введите \"2\".\n\tВыхода введите: \"0\"\n");
                    input = scanner.nextLine();
                }

                if (input.equals("2")) {
                    showToysList();

                    System.out.println("Участвовать - введите: \"1\", выход - введите: \"0\"");
                    input = scanner.nextLine();
                }

                if (input.equals("0")) {
                    break;
                } else {
                    System.out.println("Повторите ввод.");
                }
            }
        }

}
