
/**
 * Write a description of class Docent here.
 * 
 * @author Hylke de Vries
 * @version 1.0
 */
public class Docent extends Persoon implements KortingskaartHouder
{
    public String afkorting;
    public String afdeling;
    
    /**
     * Constructor that makes a teacher
     * 
     * @param BSN
     * @param dag
     * @param maand
     * @param jaar
     * @param geslacht
     * @param voornaam
     * @param achternaam
     * @param afkorting
     * @param afdeling
     */
    public Docent (int bsn, int dag, int maand, int jaar, char geslacht, String voornaam, String achternaam, String afkorting, String afdeling)
    {
        super(bsn, dag, maand, jaar, geslacht, voornaam, achternaam);
        this.afkorting=afkorting;
        this.afdeling=afdeling;
    }
    
    /**
     * Method to print all the teacher-information.
     */
    public void drukAf() {
        System.out.println("Docent:");
        System.out.println("Afkorting: "+afkorting);
        System.out.println("Afdeling: "+afdeling);
        System.out.println();
    }
    
    /**
     * Method to make a String of all the teacher-information.
     * 
     * @return string
     */
    public String toString() {
        String line1="Docent:\n";
        String line2=super.toString()+"\n";
        String line3="Afkorting: "+afkorting+"\n";
        String line4="Afdeling: "+afdeling+"\n";
        String string=line1+line2+line3+line4;
        return string;
    }
    
    /**
     * Gives the discount rate.
     * 
     * @return double discount rate
     */
    public double geefKortingsPercentage(){
        return 0.25;
    }

    /**
     * Returns a boolean. True if the teacher has a maximum of discount rate.
     * 
     * @return boolean
     */
    public boolean heeftMaximum(){
        return true;
    }

    /**
     * Returns the maximum of discount rate
     * 
     * @return double maximum discount rate
     */
    public double geefMaximum(){
        return 1.00;
    }
}
