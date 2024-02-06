package controller;

import view.BaseView;

public class Controller {
        public void appStart(BaseView[] view, String args) {

            if (args.equals("1")) {
                System.out.println("Режим работы: Завмаг");
                view[0].action();
                return;
            } else {
                System.out.println("Режим работы: Гость");
                view[1].action();
                return;
            }

        }
}
