package clase;

import java.util.ArrayList;
import java.util.List;

public class Domeniu {
    private int id;
    private String denumire;
    private String descriere;
    private List<Profesor> profesori;
    private List<Materie> materii;

    public Domeniu(int id, String denumire, String descriere) {
        this.id = id;
        this.denumire = denumire;
        this.descriere = descriere;
        this.profesori = new ArrayList<>();
        this.materii = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public List<Profesor> getProfesori() {
        return profesori;
    }

    public void addProfesor(Profesor profesor) {
        this.profesori.add(profesor);
    }

    public List<Materie> getMaterii() {
        return materii;
    }

    public void addMaterie(Materie materie) {
        this.materii.add(materie);
    }

    @Override
    public String toString() {
        return "Domeniul : " +"id=" + id +", denumire:'" + denumire + "'" +", numar profesori:" + profesori.size() +", numar materii" + materii.size();
    }
}