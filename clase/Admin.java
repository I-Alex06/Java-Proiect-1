package clase;

import java.time.LocalDate;

public class Admin extends Persoana {
    private String nivelAcces;
    private LocalDate dataAngajare;

    public Admin(int id, String Nume, String Prenume, String email, String telefon, String nivelAcces, LocalDate dataAngajare) {
        super(id, Nume, Prenume, email, telefon);
        this.nivelAcces = nivelAcces;
        this.dataAngajare = dataAngajare;
    }

    public String getNivelAcces() {
        return nivelAcces;
    }

    public void setNivelAcces(String nivelAcces) {
        this.nivelAcces = nivelAcces;
    }

    public LocalDate getDataAngajare() {
        return dataAngajare;
    }

    public void setDataAngajare(LocalDate dataAngajare) {
        this.dataAngajare = dataAngajare;
    }

    @Override
    public String toString() {
        return "Admin: " + super.toString() + ", Nivel Acces: " + nivelAcces + ", Data Angajare: " + dataAngajare;
    }
}