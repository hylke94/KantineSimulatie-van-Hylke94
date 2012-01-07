
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
    
    public Docent (int BSN, int dag, int maand, int jaar, char Geslacht, String Voornaam, String Achternaam, String afkorting, String afdeling)
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
    
    public String toString() {
        String line1="Docent:\n";
        String line2=super.toString()+"\n";
        String line3="Afkorting: "+afkorting+"\n";
        String line4="Afdeling: "+afdeling+"\n";
        String string=line1+line2+line3+line4;
        return string;
    }
    
    // methode om kortingspercentage op te vragen
    public double geefKortingsPercentage(){
        return 0.25;
    }
    // methode om op te vragen of er maximum per keer aan de korting zit
    public boolean heeftMaximum(){
        return true;
    }
    // methode om het maximum kortingsbedrag op te vragen
    public double geefMaximum(){
        return 1.00;
    }
}
