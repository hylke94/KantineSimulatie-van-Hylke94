import java.util.*;

/**
 * Class KantimeSimulatie
 * 
 * @author Hylke de Vries
 * @version 1.0
 */
public class KantineSimulatie
{
    //-- Variabelen
    
    //kantine
    private Kantine kantine;
    
    //kantineaanbod
    public static KantineAanbod kantineaanbod;
    
    //random generator
    private Random random;
    
    //aantal artikelen
    private static final int AANTAL_ARTIKELEN=4;
    
    //artikelen
    public static final String[] artikelnamen=
        new String[] {"Koffie","Broodje hamburger","Broodje kaas","Melk"};
    
    //prijzen
    public static double[] artikelprijzen=
        new double[] {1.50,2.10,1.65,1.65};
    
    //minimum en maximum aantal artikelen per soort
    private static final int MIN_ARTIKELEN_PER_SOORT=10000;
    private static final int MAX_ARTIKELEN_PER_SOORT=20000;
    
    //minimum en maximum aantal personen per dag
    private static final int MIN_PERSONEN_PER_DAG=50;
    private static final int MAX_PERSONEN_PER_DAG=100;
    
    //minimum en maximum artikelen per persoon
    private static final int MIN_ARTIKELEN_PER_PERSOON=1;
    private static final int MAX_ARTIKELEN_PER_PERSOON=4;
    
    //-- Constructor
    
    public KantineSimulatie(int dagen){
        kantine=new Kantine();
        random=new Random();
        int[] hoeveelheden=getRandomArray(AANTAL_ARTIKELEN, MIN_ARTIKELEN_PER_SOORT, MAX_ARTIKELEN_PER_SOORT);
        kantineaanbod=new KantineAanbod(artikelnamen, artikelprijzen, hoeveelheden);
        kantine.setKantineAanbod(kantineaanbod);
        
        simuleer(dagen);
    }
    
    //-- Getters
    
    /**
     * Methode om een random getal ussen min(incl) en max(incl) te genereren.
     * 
     * @param lengte
     * @param min
     * @param max
     * 
     * @return De array met random getallen
     */
    private int[] getRandomArray (int lengte, int min, int max) {
        int[] temp=new int[lengte];
        for (int i=0;i<lengte;i++) {
            temp[i]=getRandomValue(min,max);
        }
        return temp;
    }
    
    /**
     * Methode om een random getal tussen min(incl) en max(incl) te genereren.
     * 
     * @param min
     * @param max
     * 
     * @retrun Een random getal
     */
    private int getRandomValue(int min, int max) {
        return random.nextInt(max-min+1)+min;
    }
    
    /**
     * Methode om op basis van een array van indexen voor de array
     * artikelnamen de bijhorende array van artikelnamen te maken
     * 
     * @param indexen
     * 
     * @return De array met artikelnamen
     */
    private String[] geefArtikelNamen(int[] indexen) {
        String[] artikelen=new String[indexen.length];
        for (int i=0;i<indexen.length;i++) {
            artikelen[i]=artikelnamen[indexen[i]];
        }
        return artikelen;
    }
    
    //-- Setters
    
    //-- Voids
    
    /**
     * Deze methode simuleert en aatal dagen in het verloop van de kantine
     * 
     * @param dagen
     */
    public void simuleer(int dagen){
        //for lus voor dagen
        for(int i=1;i<=dagen;i++){
            //bedenk hoeveel personen vandaag binnen lopen
            int aantalpersonen=75;
            
            //laat de personen maar komen...
            for (int j=0;j<aantalpersonen;j++) {
                ///maak persoon en dienblad aan, koppel ze
                Persoon persoon=new Persoon();
                persoon.pakDienblad();
                
                //bedenk hoeveel artikelen worden gepakt
                int aantalartikelen=4;
                
                //genereer de "artikelnummers", dit zijn indexen
                //van de artikelnamen array
                int[] tepakken=getRandomArray(aantalartikelen,0,aantalartikelen-1);
                
                //vind de artikelnamen op basis van de indexen hierboven
                String[] artikelen=geefArtikelNamen(tepakken);
                
                //loop de kantine binnen, pak de gewenste artikelen, sluit aan
                kantine.loopPakSluitAan(persoon,artikelen);
            } 
            //verwerk rij voor kassa
            kantine.verwerkRij();
            
            //druk de dagtotalen af en hoeveel personen binnen zijn gekomen
            System.out.println("########################################################################");
            System.out.println("#De dagtotalen voor dag "+i+" zijn: "+kantine.kassa.hoeveelheidGeldInKassa());
            System.out.println("#Het aantal personen van dag "+i+" is: "+kantine.hoeveelheidPersonen);
            System.out.println("########################################################################");
            System.out.println("");
            
            //reset de kassa voor de volgende dag
            kantine.kassa.resetKassa();
        }
    }
}
