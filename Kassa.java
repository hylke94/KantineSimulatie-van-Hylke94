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
    
    public Kassa(Kassarij kasrij){
        this.kassarij = kasrij;
    }
    
    //-- Getters 
    
    /**
     * Returns the amount of items
     * 
     * @return int items sold;
     */
    
    public static int aantalArtikelen(){               
        return aantalArtikelen;
    }
    
    /**
     * Returns the total amount of money earned
     * 
     * @return int Money earned;
     */
    
    public static double getHoeveelheidGeldInKassa(){                        
        return hoeveelheidGeld;
    }
    
    /**
     * Geeft het aantal gepasseerde personen.
     * 
     * @return int hoeveelheidpersonen
     */
    public static int getHoeveelheidPersonen() {
        return hoeveelheidPersonen;
    }
    
    /**
     * Geeft een iterator van het dienblad
     * 
     * @return Itrator<Artikel> dienblad
     */
    public Iterator<Artikel> getIteratorDienblad() {
    	//pak de eerste persoon uit de rij
        this.persoon=this.kassarij.eerstePersoonInRij();
        //maak een Iterator van zijn/haar dienblad
        this.iterator=this.persoon.getIteratorDienblad();
        return this.iterator;
    }
    
    //-- Setters
    
    //-- Void
    /**
     * Makes person pay
     * 
     * @return void
     */
    
    public void rekenAf(Persoon pers){
        hoeveelheidPersonen += 1;
        double totaalPrijs=0.00;
        boolean kkh=false; //kkh=kortingskaarthouder
        double kortingspercentage=0.00;
        boolean kortingMax=false;
        double maxKorting=0.00;
        double korting=0.00;
        //als de persoon een kortingskaarthouder is, controleer zijn 'kortingsstatus'
        if (pers instanceof KortingskaartHouder){
            kkh=true;
            //haal percentage op
            kortingspercentage=pers.geefKortingsPercentage();
            maxKorting=0.00;
            //als hij/zij een maximumkortingspercentage heeft, haal deze dan op
            if (pers.heeftMaximum()){
                kortingMax=true;
                maxKorting=pers.geefMaximum();
            }
            else kortingMax=false;
        }
        //haal de Iterator van het dienblad op
        Iterator<Artikel> itr=getIteratorDienblad();
        //zolang er nog artikelen aanwezig zijn, ga door met afrekenen
        while(itr.hasNext()){
        	//pak eerstvolgende artikel
            this.art=itr.next();
            double prijs = this.art.getArtikelPrice();
            //als de persoon een kortingskaarthouder is, bereken de korting en sla op in een aparte variabele
            if (kkh){
                korting+=(prijs*(1-kortingspercentage));
            }
            //tel de prijs bij de totaalprijs op
            totaalPrijs+=prijs;
        }
        //haal de korting van de totaalprijs af
        if (kkh){
        	//controle op maximumkorting(overschrijding)
            if (kortingMax && korting>maxKorting){
            	//als de korting hoger is dan het maximum, veranderd de korting in het maximumbedrag
                korting=maxKorting;
            }
            totaalPrijs-=korting;
        }
        //haal de pinpas van de persoon op
        Pinpas pinpas=pers.getPinpas();
        //als de betaling geslaagd is, tel de totaalprijs bij het 'kassageld' op.
        //geef anders een error.
        if (pinpas.betaal(totaalPrijs)) hoeveelheidGeld += totaalPrijs;
        else System.out.println("Er staat niet genoeg geld op de pinpas.\nDe betaling is geanuleerd.\n");
        
    }
    
    /**
     * Reset some values
     * 
     * @return void
     */
    
    public static void resetKassa(){
        aantalArtikelen = 0;
        hoeveelheidGeld = 0;
        hoeveelheidPersonen = 0;
    }
        
}
