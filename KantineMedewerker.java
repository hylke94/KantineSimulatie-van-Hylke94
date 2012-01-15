
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
    
    public KantineMedewerker (int bsn, int dag, int maand, int jaar, char geslacht, String voornaam, String achternaam, int mdwnr, boolean achtKas)
    {
        super(bsn, dag, maand, jaar, geslacht, voornaam, achternaam);
        this.medewerkersnummer=mdwnr;
        this.achterKassa=achtKas;
    }
    
    /**
     * Methode om alle gegevens van de kantinewederwerk(st)er af te druken.
     */
    @Override
	public void drukAf() {
        System.out.println("Kantinemedewerker:");
        System.out.println("Medewerkersnummer: "+this.medewerkersnummer);
        System.out.println("Achter kassa: "+this.achterKassa);
        System.out.println();
    }
    
    /**
     * Methode om een String te maken van alle informatie van de kantinemederwerk(st)er
     * 
     * @return String
     */
    @Override
	public String toString() {
        String line1="Kantinemedewerker:\n";
        String line2=super.toString()+"\n";
        String line3="Medewerkersnummer: "+this.medewerkersnummer+"\n";
        String line4="Mag achter kassa: "+this.achterKassa+"\n";
        String string=line1+line2+line3+line4;
        return string;
    }
    
    /**
     * Gives the discount rate.
     * 
     * @return double discount rate
     */
    @Override
	public double geefKortingsPercentage(){
        return 0.35;
    }
    
    /**
     * Returns a boolean. True if the teacher has a maximum of discount rate.
     * 
     * @return boolean
     */
    @Override
	public boolean heeftMaximum(){
        return false;
    }
    
    /**
     * Returns the maximum of discount rate
     * 
     * @return double maximum discount rate
     */
    @Override
	public double geefMaximum(){
        return 0.00;
    }
}
