package clase;

import java.time.LocalDate;

public class Nota {
    private int id;
    private Student student;
    private Materie materie;
    private double value;
    private LocalDate data;

    public Nota(int id, Student student, Materie materie, double value, LocalDate data) {
        this.id = id;
        this.student = student;
        this.materie = materie;
        this.value = value;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public Materie getMaterie() {
        return materie;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Nota : " +"student:" + student.getFullName() +", materie:" + materie.getDenumire() +", value:" + value +", data:" + data;
    }
}