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
    private static int hoeveelheidPersonen = 0;
    
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
    
    public double getHoeveelheidGeldInKassa(){                        
        return hoeveelheidGeld;
    }
    
    public int getHoeveelheidPersonen() {
        return hoeveelheidPersonen;
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
        hoeveelheidPersonen += 1;
        double totaalPrijs=0.00;
        boolean kkh=false; //kkh=kortingskaarthouder
        double kortingspercentage=0.00;
        boolean kortingMax=false;
        double maxKorting=0.00;
        double korting=0.00;
        if (persoon instanceof KortingskaartHouder){
            kkh=true;
            kortingspercentage=persoon.geefKortingsPercentage();
            maxKorting=0.00;
            if (persoon.heeftMaximum()){
                kortingMax=false;
                maxKorting=persoon.geefMaximum();
            }
            else kortingMax=false;
        }
        Iterator<Artikel> itr=getIteratorDienblad();
        while(itr.hasNext()){
            art=itr.next();
            double prijs=0.00;
            if (kkh){
                prijs = art.getArtikelPrice();
                korting+=(prijs*(1-kortingspercentage));
            }
            else prijs = art.getArtikelPrice();
            totaalPrijs+=prijs;
        }
        if (kkh){
            if (kortingMax && korting>maxKorting){
                    korting=maxKorting;
            }
            totaalPrijs-=korting;
        }
        else hoeveelheidGeld += totaalPrijs;
    }
    
    /**
     * Reset some values
     * 
     * @return void
     */
    
    public void resetKassa(){
        aantalArtikelen = 0;
        hoeveelheidGeld = 0;
        hoeveelheidPersonen = 0;
    }
        
}
