package view;

import model.Toy;
import srv.DataServ;
import java.util.List;

public abstract class BaseView{
    public abstract void action();
    public void showToysList() {
        List<Toy> list = DataServ.readData();
        for (Toy toy : list) {
            System.out.printf("Название игрушки: %s, количество: %d шт., Шанс получения приза: %d\n",
                    toy.getnToy(), toy.getPcsToy(), (toy.getChnsToy()));
        }
    }
}
