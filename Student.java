
/**
 * Write a description of class Student here.
 * 
 * @author Hylke de Vries
 * @version 1.0
 */
public class Student extends Persoon
{
    private int studentnummer;
    private String studierichting;
    
    public Student (int BSN, int dag, int maand, int jaar, char Geslacht, String Voornaam, String Achternaam, int studentnummer, String studierichting)
    {
        super(BSN, dag, maand, jaar, Geslacht, Voornaam, Achternaam);
        this.studentnummer=studentnummer;
        this.studierichting=studierichting;
    }
    
    public void drukAf() {
        System.out.println("Student:");
        System.out.println("Studentnummer: "+studentnummer);
        System.out.println("Studierichting: "+studierichting);
        System.out.println();
    }
}
