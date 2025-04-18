package clase;

import java.util.ArrayList;
import java.util.List;

public class Student extends Persoana {
    private String Id_Student;
    private int An;
    private List<Nota> note;

    public Student(int id, String Nume, String Prenume, String email, String telefon, String Id_Student, int An) {
        super(id, Nume, Prenume, email, telefon);
        this.Id_Student = Id_Student;
        this.An = An;
        this.note = new ArrayList<>();
    }

    public String getId_Student() {
        return Id_Student;
    }

    public void setId_Student(String Id_Student) {
        this.Id_Student = Id_Student;
    }

    public int getAn() {
        return An;
    }

    public void setAn(int An) {
        this.An = An;
    }

    public List<Nota> getNote() {
        return note;
    }

    public void addNota(Nota nota) {
        this.note.add(nota);
    }

    public double calculeazaMedia() {
        if (note.isEmpty()) {
            return 0.0;
        }
        
        double sum = 0.0;
        for (Nota nota : note) {
            sum += nota.getValue();
        }
        return sum / note.size();
    }

    @Override
    public String toString() {
        return "Student: " + super.toString() + ", Id Student: " + Id_Student + ", Anul: " + An;
    }
}