package model;

import java.util.Objects;

//        id игрушки,
//        текстовое название,
//        количество
//        частота выпадения игрушки (вес в % от 100)
public class Toy implements Comparable<Toy>{
    int idToy;
    String nToy;
    int pcsToy;
    int chnsToy;

    public Toy(int idToy, String nToy, int pcsToy, int chnsToy) {
        this.idToy = idToy;
        this.nToy = nToy;
        this.pcsToy = pcsToy;

        if (chnsToy > 9 || chnsToy < 1) {
            this.chnsToy = 5;
        } else {
            this.chnsToy = chnsToy;
        }
    }

    public void setIdToy(int idToy) {
        this.idToy = idToy;
    }

    public void setnToy(String nToy) {
        this.nToy = nToy;
    }

    public void setPcsToy(int pcsToy) {
        this.pcsToy = pcsToy;
    }

    public void setChnsToy(int chnsToy) {
        this.chnsToy = chnsToy;
    }

    public int getIdToy() {
        return idToy;
    }

    public String getnToy() {
        return nToy;
    }

    public int getPcsToy() {
        return pcsToy;
    }

    public int getChnsToy() {
        return chnsToy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Toy toy = (Toy) o;

        if (idToy != toy.idToy) return false;
        if (pcsToy != toy.pcsToy) return false;
        if (chnsToy != toy.chnsToy) return false;
        return Objects.equals(nToy, toy.nToy);
    }

    @Override
    public int hashCode() {
        int result = idToy;
        result = 31 * result + (nToy != null ? nToy.hashCode() : 0);
        result = 31 * result + pcsToy;
        result = 31 * result + chnsToy;
        return result;
    }

    @Override
    public String toString() {
        return "mdl.Toy{" +
                "id=" + idToy +
                ", название ='" + nToy + '\'' +
                ", количество =" + pcsToy +
                ", частота =" + chnsToy +
                '}';
    }

    @Override
    public int compareTo(Toy toy) {
        return this.chnsToy - toy.getChnsToy();
    }
}
