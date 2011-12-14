import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class Kassa
 * 
 * @author Hylke de Vries
 * @version 1.0
 */
public class Kassa
{
    //-- Variabelen
    private Kassarij kassarij;
    private Persoon persoon;
    private Dienblad dienblad;
    private Artikel artikel;
    private Artikel art;
    private Iterator iterator;
    private Kantine kantine;
    
    private static int aantalArtikelen = 0;
    private static double hoeveelheidGeld = 0;
    
    //-- Constructor
    
    public Kassa(Kassarij kassarij){
        
        this.kassarij = kassarij;
    }
    
    //-- Getters 
    
    /**
     * Returns the amount of items
     * 
     * @return int items sold;
     */
    
    public int aantalArtikelen(){               
        return aantalArtikelen;
    }
    
    /**
     * Returns the total amount of money earned
     * 
     * @return int Money earned;
     */
    
    public double hoeveelheidGeldInKassa(){                        
        return hoeveelheidGeld;
    }
    
    public Iterator getIteratorDienblad() {
        persoon=kassarij.eerstePersoonInRij(persoon);
        iterator=persoon.getIteratorDienblad();
        return iterator;
    }
    
    //-- Setters
    
    //-- Void
    /**
     * Makes person pay
     * 
     * @return void
     */
    
    public void rekenAf(Persoon persoon){
        kantine.hoeveelheidPersonen += 1;
        Iterator<Artikel> itr=getIteratorDienblad();
        while(itr.hasNext()){
            art=itr.next();
            double prijs = art.getArtikelPrice();
            hoeveelheidGeld += prijs;
        }
    }
    
    /**
     * Reset some values
     * 
     * @return void
     */
    
    public void resetKassa(){
        aantalArtikelen = 0;
        hoeveelheidGeld = 0;
    }
        
}
