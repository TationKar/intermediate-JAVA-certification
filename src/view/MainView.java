package view;

import srv.MainServ;

import java.util.Scanner;

public class MainView extends BaseView {

        private final MainServ serv;

        public MainView() {
            serv = new MainServ();
        }

        @Override
        public void action() {
            Scanner scanner = new Scanner(System.in);

            while (true) {

                System.out.println("""
                    Выберите действие (введите нужное число):
                    1. Добавить игрушки в список.
                    2. Показать список всех игрушек.
                    0. Выход из программы.""");
                String input = scanner.nextLine();

                while (true) {
                    if (input.equals("1")) {
                        serv.addToy();
                        input = retryAsk();
                        continue;
                    }

                    if (input.equals("2")) {
                        showToysList();
                        input = retryAsk();
                        continue;
                    }

                    if (input.equals("0")) {
                        return;
                    } else {
                        System.out.println("Некорректно, повторите ввод!");
                    }
                }
            }
        }

        private String retryAsk() {
            System.out.println("============================================");
            System.out.println("""
                \tДобавить еще игрушку, введите: "1"
                \tПросмотр списка игрушек, введите: "2"
                \tДля выхода введите: "0\"""");
            return new Scanner(System.in).nextLine();
        }
    }


