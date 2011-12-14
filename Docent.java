
/**
 * Write a description of class Docent here.
 * 
 * @author Hylke de Vries
 * @version 1.0
 */
public class Docent extends Persoon
{
    public String afkorting;
    public String afdeling;
    
    public Docent (int BSN, int dag, int maand, int jaar, char Geslacht, String Voornaam, String Achternaam, String afkorting, String afdelig)
    {
        super(BSN, dag, maand, jaar, Geslacht, Voornaam, Achternaam);
        this.afkorting=afkorting;
        this.afdeling=afdeling;
    }
    
    public void drukAf() {
        System.out.println("Docent:");
        System.out.println("Afkorting: "+afkorting);
        System.out.println("Afdeling: "+afdeling);
        System.out.println();
    }
}
