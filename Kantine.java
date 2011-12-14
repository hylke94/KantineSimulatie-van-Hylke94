import java.util.*;

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
    
    private Persoon persoon;
    private Persoon persoon1;
    private Artikel[] artikel;
    
    //artikelen
    private static final String[] artikelnamen=
        new String[] {"Koffie","Broodje hamburger","Broodje kaas","Melk"};
    
    //prijzen
    private static double[] artikelprijzen=
        new double[] {1.50,2.10,1.65,1.65};
    
    
    public static double hoeveelheidGeld =0;
    
    public static int hoeveelheidPersonen = 0;
    
    private KantineAanbod kantineaanbod;
    
    private KantineSimulatie kantineSimulatie;
    
    //-- Constructor
    
    public Kantine(){
        kassarij = new Kassarij();
        kassa = new Kassa(kassarij);
        kantineaanbod=kantineSimulatie.kantineaanbod;
    }
    
    //-- Getters
    
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
     * @artikelnamen
     * 
     * Hierna sluit het persoon zich aan in de rij voor de kassa.
     */
    
    public void loopPakSluitAan(Persoon persoon, String[] namen){
       if (namen.length>0) {
           for (int i=0;i<namen.length;i++) {
               Artikel art=kantineSimulatie.kantineaanbod.getArtikel(namen[i]);
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
