package srv;

import model.Toy;
import java.util.List;

public class ConsServ {

        public String getPrize(int chance) {
            List<Toy> toyList = DataServ.readData();
            int value = chance;
            Toy tempToy = null;
            for (Toy toy : toyList) {
                if (toy.getChnsToy() == value) {
                    if (toy.getPcsToy() > 0) {
                        toy.setPcsToy(toy.getPcsToy() - 1);
                        DataServ.reWriteData(toyList);
                        return toy.getnToy();
                    }
                }
//                if (toy.getChnsToy() == value && toy.getPcsToy() == 0) {
//                    tempToy = toy;
//                }
            }
//            if (tempToy != null) {
//                toyList.remove(tempToy);
//                DataServ.reWriteData(toyList);
//            }
            return "LOSS";
        }

        /*
            получение всех игрушек
        */
        public List<Toy> getPrizesList() {
            return DataServ.readData();
        }
}
