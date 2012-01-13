
/**
 * Write a description of class KantineMedewerker here.
 * 
 * @author Hylke de Vries
 * @version 1.0
 */
public class KantineMedewerker extends Persoon implements KortingskaartHouder
{
    private int medewerkersnummer;
    private boolean achterKassa;
    
    public KantineMedewerker (int bsn, int dag, int maand, int jaar, char geslacht, String voornaam, String achternaam, int medewerkersnummer, boolean achterKassa)
    {
        super(bsn, dag, maand, jaar, geslacht, voornaam, achternaam);
        this.medewerkersnummer=medewerkersnummer;
        this.achterKassa=achterKassa;
    }
    
    /**
     * Methode om alle gegevens van de kantinewederwerk(st)er af te druken.
     */
    public void drukAf() {
        System.out.println("Kantinemedewerker:");
        System.out.println("Medewerkersnummer: "+medewerkersnummer);
        System.out.println("Achter kassa: "+achterKassa);
        System.out.println();
    }
    
    /**
     * Methode om een String te maken van alle informatie van de kantinemederwerk(st)er
     * 
     * @return String
     */
    public String toString() {
        String line1="Kantinemedewerker:\n";
        String line2=super.toString()+"\n";
        String line3="Medewerkersnummer: "+medewerkersnummer+"\n";
        String line4="Mag achter kassa: "+achterKassa+"\n";
        String string=line1+line2+line3+line4;
        return string;
    }
    
    /**
     * Gives the discount rate.
     * 
     * @return double discount rate
     */
    public double geefKortingsPercentage(){
        return 0.35;
    }
    
    /**
     * Returns a boolean. True if the teacher has a maximum of discount rate.
     * 
     * @return boolean
     */
    public boolean heeftMaximum(){
        return false;
    }
    
    /**
     * Returns the maximum of discount rate
     * 
     * @return double maximum discount rate
     */
    public double geefMaximum(){
        return 0.00;
    }
}
