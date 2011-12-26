
/**
 * Write a description of class KantineMedewerker here.
 * 
 * @author Hylke de Vries
 * @version 1.0
 */
public class KantineMedewerker extends Persoon
{
    private int medewerkersnummer;
    private boolean achterKassa;
    
    public KantineMedewerker (int BSN, int dag, int maand, int jaar, char Geslacht, String Voornaam, String Achternaam, int medewerkersnummer, boolean achterKassa)
    {
        super(BSN, dag, maand, jaar, Geslacht, Voornaam, Achternaam);
        this.medewerkersnummer=medewerkersnummer;
        this.achterKassa=achterKassa;
    }
    
    public void drukAf() {
        System.out.println("Kantinemedewerker:");
        System.out.println("Medewerkersnummer: "+medewerkersnummer);
        System.out.println("Achter kassa: "+achterKassa);
        System.out.println();
    }
    
    public String toString() {
        String line1="Kantinemedewerker:\n";
        String line2=super.toString()+"\n";
        String line3="Medewerkersnummer: "+medewerkersnummer+"\n";
        String line4="Mag achter kassa: "+achterKassa+"\n";
        String string=line1+line2+line3+line4;
        return string;
    }
}
