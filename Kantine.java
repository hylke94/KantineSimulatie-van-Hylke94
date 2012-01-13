
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
     * Constructor that makes a checkout with a cash row.
     */
    public Kantine(){
        kassarij = new Kassarij();
        kassa = new Kassa(kassarij);
        kantineaanbod=KantineSimulatie.kantineaanbod;
    }
    
    //-- Getters
    
    /**
     * Return the KantineAanbod
     * 
     * @return kantineaanbod
     */
    public KantineAanbod getKantineAanbod(){
        return kantineaanbod;
    }
    
    //-- Setters
    
    /**
     * Set KantineAanbod
     */
    public void setKantineAanbod(KantineAanbod kantineaanbod) {
        
    }
    
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
       if (namen.length>0) {
           for (int i=0;i<namen.length;i++) {
               Artikel art=KantineSimulatie.kantineaanbod.getArtikel(namen[i]);
               persoon.dienblad.voegToe(art);
            }
        }
        kassarij.sluitAchteraan(persoon);
    }
    
    /**
     * Verwerkt de rij voor de kassa en verwijderd de persoon daarna.
     * Er wordt een while lus gemaakt omdat dit makkelijker is.
     */
    public void verwerkRij(){
        while(kassarij.isErEenRij()==true){
            persoon1 = kassarij.eerstePersoonInRij(persoon1);
            kassa.rekenAf(persoon1);
            kassarij.verwijderPersoonUitRij();
        }
    }
    
    /**
     * Reset de kassa
     */
    public void resetKassa(){
        hoeveelheidPersonen = 0;
        hoeveelheidGeld = 0;
    }
    
}
