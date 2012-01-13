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
    private Artikel art;
    private Iterator<Artikel> iterator;
    
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
    
    /**
     * Geeft het aantal gepasseerde personen.
     * 
     * @return int hoeveelheidpersonen
     */
    public int getHoeveelheidPersonen() {
        return hoeveelheidPersonen;
    }
    
    /**
     * Geeft een iterator van het dienblad
     * 
     * @return Itrator<Artikel> dienblad
     */
    public Iterator<Artikel> getIteratorDienblad() {
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
                kortingMax=true;
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
        Pinpas pinpas=persoon.getPinpas();
        if (pinpas.betaal(totaalPrijs)) hoeveelheidGeld += totaalPrijs;
        else System.out.println("Er staat niet genoeg geld op de pinpas.\nDe betaling is geanuleerd.\n");
        
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
