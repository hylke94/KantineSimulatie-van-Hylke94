
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
    
    public Student (int BSN, int dag, int maand, int jaar, char Geslacht, String Voornaam, String Achternaam, int studnr, String studricht)
    {
        super(BSN, dag, maand, jaar, Geslacht, Voornaam, Achternaam);
        this.studentnummer=studnr;
        this.studierichting=studricht;
    }
    
    /**
     * Methode om alle gegevens van de student af te drukken
     */
    @Override
	public void drukAf() {
        System.out.println("Student:");
        System.out.println("Studentnummer: "+this.studentnummer);
        System.out.println("Studierichting: "+this.studierichting);
        System.out.println();
    }
    
    /**
     * Geeft een string met alle gegevens van de student
     * 
     * @return String
     */
    @Override
	public String toString() {
        String line1="Student:\n";
        String line2=super.toString()+"\n";
        String line3="Studentnummer: "+this.studentnummer+"\n";
        String line4="Studierichting: "+this.studierichting+"\n";
        String string=line1+line2+line3+line4;
        return string;
    }
}
