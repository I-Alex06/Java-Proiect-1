package clase;

import java.util.HashSet;
import java.util.Set;

public class Materie {
    private int id;
    private String denumire;
    private String descriere;
    private Profesor profesor;
    private Set<Student> studenti_inscrisi;

    public Materie(int id, String denumire, String descriere) {
        this.id = id;
        this.denumire = denumire;
        this.descriere = descriere;
        this.studenti_inscrisi = new HashSet<>();
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

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Set<Student> getStudenti_inscrisi() {
        return studenti_inscrisi;
    }

    public void adauga_student(Student student) {
        studenti_inscrisi.add(student);
    }

    public void removeStudent(Student student) {
        studenti_inscrisi.remove(student);
    }

    @Override
    public String toString() {
        return "Materia: " +"id:" + id +", denumire:'" + denumire + "'" +", profesor:" + (profesor != null ? profesor.getFullName() : "Nu exista inca") +", Numar Studenti:" + studenti_inscrisi.size();
    }
}