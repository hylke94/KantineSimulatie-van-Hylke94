
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
}
