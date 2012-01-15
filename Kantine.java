
/**
 * Class Kantine
 * 
 * @author Hylke de Vries
 * @version 1.0
 */
public class Kantine
{
    //-- Variabelen
    
    public static Kassa kassa;
    public Kassarij kassarij;
    
    private Persoon persoon1;
    
    public static double hoeveelheidGeld =0;
    
    public static int hoeveelheidPersonen = 0;
    
    private KantineAanbod kantineaanbod;
    
    //-- Constructor
    
    /**
     * Constructor die een kassa met een kassarij maakt.
     */
    public Kantine(){
        this.kassarij = new Kassarij();
        kassa = new Kassa(this.kassarij);
        this.kantineaanbod=KantineSimulatie.kantineaanbod;
    }
    
    //-- Getters
    
    /**
     * Return the KantineAanbod
     * 
     * @return kantineaanbod
     */
    public KantineAanbod getKantineAanbod(){
        return this.kantineaanbod;
    }
    
    //-- Setters
    
    //-- Voids
    
    /**
     * In deze methode kiest een Persoon met een dienblad
     * de artikelen in artikelnamen
     * 
     * @param persoon
     * @param artikelnamen
     * 
     * Hierna sluit het persoon zich aan in de rij voor de kassa.
     */
    public void loopPakSluitAan(Persoon persoon, String[] namen){
    	//als er geen artikelnamen zijn doorgegeven, meteen aansluiten in de rij
       if (namen.length>0) {
    	   //ga elk artikel bijlangs
           for (int i=0;i<namen.length;i++) {
        	   //het artikel zelf selecteren op basis van de naam
               Artikel art=KantineSimulatie.kantineaanbod.getArtikel(namen[i]);
               //artikel op dienblad "leggen"
               persoon.dienblad.voegToe(art);
            }
        }
       //achter aansluiten
        this.kassarij.sluitAchteraan(persoon);
    }
    
    /**
     * Verwerkt de rij voor de kassa en verwijderd de persoon daarna.
     * Er wordt een while lus gemaakt omdat dit makkelijker is.
     */
    public void verwerkRij(){
    	//zolang er een rij is, doorgaan met betalen
        while(this.kassarij.isErEenRij()==true){
        	//pak de eerste persoon uit de rij
            this.persoon1 = this.kassarij.eerstePersoonInRij();
            //laat de persoon afrekenen
            Kantine.kassa.rekenAf(this.persoon1);
            //verwijder de persoon uit de rij
            this.kassarij.verwijderPersoonUitRij();
        }
    }
    
    /**
     * Reset de kassa
     */
    public static void resetKassa(){
        hoeveelheidPersonen = 0;
        hoeveelheidGeld = 0;
    }
    
}
