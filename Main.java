import java.time.LocalDate;
import java.util.Map;

import clase.*;
import serviciu.Serviciu;

public class Main {
    public static void main(String[] args) {
        Serviciu serviciu = new Serviciu();
        serviciu.addDomeniu(1, "Informatica", "Domeniul Informatica al FMI");
        serviciu.addDomeniu(2, "Matematica", "Domeniul Matematica al FMI");
        serviciu.addProfesor(1, "Ionut", "Marius", "ionus.marius@p.unibuc.ro", "1234567890", "Informatica", "Informatica");
        serviciu.addProfesor(2, "Popescu", "Ioan", "popescu.ioan@p.unibuc.ro", "0987654321", "Matematica", "Mate-Info");
        serviciu.addMaterie(1, "PAOJ", "Programare avansata de obiecte in Java");
        serviciu.addMaterie(2, "Geometrie", "Introducere in geometrie computationala");
        serviciu.addProfesorLaDomeniul(1, 1);
        serviciu.addProfesorLaDomeniul(2, 2);
        serviciu.addMaterieLaDomeniul(1, 1);
        serviciu.addMaterieLaDomeniul(2, 2);
        serviciu.adaugaProfesorLaMaterie(1, 1);
        serviciu.adaugaProfesorLaMaterie(2, 2);
        serviciu.addStudent(1, "Ionescu", "Alexandru", "ionescu.alexandru@s.unibuc.ro", "1234567890", "S001", 2);
        serviciu.addStudent(2, "Popescu", "Radu", "popescu.radu@s.unibuc.ro", "5234624525", "S002", 2);
        serviciu.addStudent(3, "Traian", "Basse", "traian.basse@s.unibuc.ro", "9876543234", "S003", 1);
        serviciu.adaugaStudentLaMaterie(1, 1);
        serviciu.adaugaStudentLaMaterie(1, 2);
        serviciu.adaugaStudentLaMaterie(2, 1);
        serviciu.adaugaStudentLaMaterie(3, 2);
        serviciu.addNota(1, 1, 1, 9.5, LocalDate.now());
        serviciu.addNota(2, 1, 2, 8.0, LocalDate.now());
        serviciu.addNota(3, 2, 1, 7.5, LocalDate.now());
        serviciu.addNota(4, 3, 2, 9.0, LocalDate.now());
        serviciu.addAdmin(1,"Oprea","Matei","oprea.andrei@a.unibuc.ro","99999999999","MAXIM", LocalDate.now());
        serviciu.addAdmin(2,"Pruna","Mihai","pruna.mihai@a.unibuc.ro","0000000000","SCAZUT", LocalDate.now());
        
        System.out.println("Toate Materiile:");
        for (Materie materie : serviciu.getAllMaterii()) {
            System.out.println(materie);
        }

        System.out.println("\nAdmini:");
        for (Admin admin : serviciu.getAllAdmins()) {
            System.out.println(admin);
        }
        
        System.out.println("\nStudentii de la Informatica:");
        for (Student student : serviciu.getStudentsInMaterie(1)) {
            System.out.println(student);
        }
        
        System.out.println("\nStudenti cu media peste 8.5:");
        for (Student student : serviciu.getStudentsCuNotaPeste(8.5)) {
            System.out.println(student + "   Media: " + student.calculeazaMedia());
        }

        System.out.println("\nRaport PAOJ:");
        System.out.println(serviciu.generateRaportMaterie(1));
        
        System.out.println("\nStudentii sortati dupa medie:");
        Map<Student, Double> sortedStudents = serviciu.getStudentiDupaMedie();
        for (Map.Entry<Student, Double> entry : sortedStudents.entrySet()) {
            System.out.println(entry.getKey().getFullName() + "   Media: " + entry.getValue());
        }

        System.out.println("\nPersoane:");
        for (Persoana persoana : serviciu.getAllPersoane()) {
            System.out.println(persoana);
        }
        
        
    }
}