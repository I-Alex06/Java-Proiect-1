package clase;

public abstract class Persoana {
    protected int id;
    protected String Nume;
    protected String Prenume;
    protected String email;
    protected String telefon;

    public Persoana(int id, String Nume, String Prenume, String email, String telefon) {
        this.id = id;
        this.Nume = Nume;
        this.Prenume = Prenume;
        this.email = email;
        this.telefon = telefon;
    }

    public int getId() {
        return id;
    }

    public String getNume() {
        return Nume;
    }

    public void setNume(String Nume) {
        this.Nume = Nume;
    }

    public String getPrenume() {
        return Prenume;
    }

    public void setPrenume(String Prenume) {
        this.Prenume = Prenume;
    }

    public String getFullName() {
        return Nume + " " + Prenume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nume: " + getFullName() + ", Email: " + email;
    }
}