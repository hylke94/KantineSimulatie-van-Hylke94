
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
    
    public String toString() {
        String line1="Student:\n";
        String line2=super.toString()+"\n";
        String line3="Studentnummer: "+studentnummer+"\n";
        String line4="Studierichting: "+studierichting+"\n";
        String string=line1+line2+line3+line4;
        return string;
    }
}
