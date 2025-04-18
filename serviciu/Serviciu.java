package serviciu;

import clase.*;

import java.time.LocalDate;
import java.util.*;

public class Serviciu {
    private List<Student> studenti;
    private List<Profesor> profesori;
    private List<Materie> materii;
    private List<Nota> note;
    private List<Domeniu> domenii;
    private List<Admin> admini;
    private List<Persoana> persoane;
    private Map<Student, Double> student_medie;

    public Serviciu() {
        this.studenti = new ArrayList<>();
        this.profesori = new ArrayList<>();
        this.materii = new ArrayList<>();
        this.note = new ArrayList<>();
        this.domenii = new ArrayList<>();
        this.admini = new ArrayList<>();
        this.persoane = new ArrayList<>();
        this.student_medie = new TreeMap<>(Comparator.comparing(Student::calculeazaMedia).reversed());
    }

    public Student addStudent(int id, String Nume, String Prenume, String email, String telefon, String Id_Student, int An) {
        Student student = new Student(id, Nume, Prenume, email, telefon, Id_Student, An);
        studenti.add(student);
        persoane.add(student);
        updateMedieStudent(student);
        return student;
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(studenti);
    }

    public Student getStudentById(int id) {
        for (Student student : studenti) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public Profesor addProfesor(int id, String Nume, String Prenume, String email, String telefon, String domeniul, String specializare) {
        Profesor prof = new Profesor(id, Nume, Prenume, email, telefon, domeniul, specializare);
        profesori.add(prof);
        persoane.add(prof);
        return prof;
    }

    public List<Profesor> getAllProfesori() {
        return new ArrayList<>(profesori);
    }

    public Profesor getProfesorById(int id) {
        for (Profesor prof : profesori) {
            if (prof.getId() == id) {
                return prof;
            }
        }
        return null;
    }

    public Materie addMaterie(int id, String denumire, String descriere) {
        Materie course = new Materie(id, denumire, descriere);
        materii.add(course);
        return course;
    }

    public List<Materie> getAllMaterii() {
        return new ArrayList<>(materii);
    }

    public Materie getMaterieById(int id) {
        for (Materie materie : materii) {
            if (materie.getId() == id) {
                return materie;
            }
        }
        return null;
    }

    public void adaugaProfesorLaMaterie(int Id_Profesor, int Id_Materie) {
        Profesor prof = getProfesorById(Id_Profesor);
        Materie materie = getMaterieById(Id_Materie);
        
        if (prof != null && materie != null) {
            materie.setProfesor(prof);
        }
    }

    public void adaugaStudentLaMaterie(int Id_Student, int Id_Materie) {
        Student student = getStudentById(Id_Student);
        Materie materie = getMaterieById(Id_Materie);
        
        if (student != null && materie != null) {
            materie.adauga_student(student);
        }
    }

    public void scoateStudentDinMaterie(int Id_Student, int Id_Materie) {
        Student student = getStudentById(Id_Student);
        Materie materie = getMaterieById(Id_Materie);
        
        if (student != null && materie != null) {
            materie.removeStudent(student);
        }
    }

    public Nota addNota(int id, int Id_Student, int Id_Materie, double value, LocalDate data) {
        Student student = getStudentById(Id_Student);
        Materie materie = getMaterieById(Id_Materie);
        
        if (student != null && materie != null) {
            Nota nota = new Nota(id, student, materie, value, data);
            note.add(nota);
            student.addNota(nota);
            updateMedieStudent(student);
            return nota;
        }
        return null;
    }

    private void updateMedieStudent(Student student) {
        student_medie.put(student, student.calculeazaMedia());
    }

    public double getMedieStudent(int Id_Student) {
        Student student = getStudentById(Id_Student);
        if (student != null) {
            return student.calculeazaMedia();
        }
        return 0.0;
    }

    public List<Student> getStudentsInMaterie(int Id_Materie) {
        Materie materie = getMaterieById(Id_Materie);
        if (materie != null) {
            return new ArrayList<>(materie.getStudenti_inscrisi());
        }
        return new ArrayList<>();
    }

    public List<Student> getStudentsCuNotaPeste(double prag) {
        List<Student> result = new ArrayList<>();
        for (Student student : studenti) {
            if (student.calculeazaMedia() > prag) {
                result.add(student);
            }
        }
        return result;
    }

    public Domeniu addDomeniu(int id, String denumire, String descriere) {
        Domeniu domeniul = new Domeniu(id, denumire, descriere);
        domenii.add(domeniul);
        return domeniul;
    }

    public void addProfesorLaDomeniul(int Id_Profesor, int Id_Domeniul) {
        Profesor prof = getProfesorById(Id_Profesor);
        Domeniu dom = getDomeniulById(Id_Domeniul);
        
        if (prof != null && dom != null) {
            dom.addProfesor(prof);
            prof.setDomeniul(dom.getDenumire());
        }
    }

    public void addMaterieLaDomeniul(int Id_Materie, int Id_Domeniul) {
        Materie materie = getMaterieById(Id_Materie);
        Domeniu domeniu = getDomeniulById(Id_Domeniul);
        
        if (materie != null && domeniu != null) {
            domeniu.addMaterie(materie);
        }
    }

    public Domeniu getDomeniulById(int id) {
        for (Domeniu dom : domenii) {
            if (dom.getId() == id) {
                return dom;
            }
        }
        return null;
    }

    public List<Domeniu> getAllDomeniu() {
        return new ArrayList<>(domenii);
    }

    public String generateRaportMaterie(int Id_Materie) {
        Materie materie = getMaterieById(Id_Materie);
        if (materie == null) {
            return "Materia nu exista!";
        }
        
        StringBuilder raport = new StringBuilder();
        raport.append("Materie: ").append(materie.getDenumire()).append("\n");
        raport.append("Descriere: ").append(materie.getDescriere()).append("\n");
        
        if (materie.getProfesor() != null) {
            raport.append("Profesor: ").append(materie.getProfesor().getFullName()).append("\n");
        } else {
            raport.append("Profesor: Nu exista\n");
        }
        
        raport.append("Studenti inscrisi:\n");
        for (Student student : materie.getStudenti_inscrisi()) {
            raport.append("- ").append(student.getFullName()).append(" (").append(student.getId_Student()).append(")\n");
        }
        
        return raport.toString();
    }

    public Map<Student, Double> getStudentiDupaMedie() {
        return student_medie;
    }
    
    public Admin addAdmin(int id, String Nume, String Prenume, String email, String telefon, String nivelAcces, LocalDate dataAngajare) {
        Admin admin = new Admin(id, Nume, Prenume, email, telefon, nivelAcces, dataAngajare);
        admini.add(admin);
        persoane.add(admin);
        return admin;
    }
    
    public List<Admin> getAllAdmins() {
        return new ArrayList<>(admini);
    }
    
    public Admin getAdminById(int id) {
        for (Admin admin : admini) {
            if (admin.getId() == id) {
                return admin;
            }
        }
        return null;
    }
    public List<Persoana> getAllPersoane() {
        return new ArrayList<>(persoane);
    }
}