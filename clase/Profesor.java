package clase;

public class Profesor extends Persoana {
    private String domeniul;
    private String specializare;

    public Profesor(int id, String Nume, String Prenume, String email, String telefon, String domeniul, String specializare) {
        super(id, Nume, Prenume, email, telefon);
        this.domeniul = domeniul;
        this.specializare = specializare;
    }

    public String getDomeniul() {
        return domeniul;
    }

    public void setDomeniul(String domeniul) {
        this.domeniul = domeniul;
    }

    public String getSpecializare() {
        return specializare;
    }

    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }

    @Override
    public String toString() {
        return "Profesor: " + super.toString() + ", Domeniul: " + domeniul + ", Specializare: " + specializare;
    }
}