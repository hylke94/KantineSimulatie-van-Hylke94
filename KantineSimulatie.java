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
    
    //Variabelen voor de administratie
    private int[] aantal;
    private double[] omzet;
    private double[] dagomzet;
    
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
     * Deze methode simuleert en aantal dagen in het verloop van de kantine
     * 
     * @param dagen
     */
    public void simuleer(int dagen){
        aantal=new int[dagen];
        omzet=new double[dagen];
        dagomzet=new double[dagen];
        
        //for lus voor dagen
        for(int i=0;i<dagen;i++){
            //bedenk hoeveel personen vandaag binnen lopen
            int aantalKlanten=100;
            int aantalStudenten=89;
            int aantalDocenten=10;
            int aantalMedewerkers=1;
            
            //laat de personen maar komen...
            for (int j=0;j<aantalKlanten;j++) {
                ///maak persoon en dienblad aan, koppel ze
                Persoon persoon=new Persoon();
                if (j<aantalStudenten) {
                	persoon=new Student(12345,18,03,1994,'M',"Hylke","Vries",296687,"TI");
                }
                else if (j<(aantalStudenten+aantalDocenten)) {
                	persoon=new Docent(12345,18,03,1994,'M',"Jakob","Vries","JJDV","TID2");
                }
                else if (j<(aantalStudenten+aantalDocenten+aantalMedewerkers)) {
                	persoon=new KantineMedewerker(12345,18,03,1994,'M',"Albert","Vries",296687,false);
                }
                persoon.nieuwePinpas(7.50);
                System.out.println(persoon.toString());
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
            
            int dag=i+1;
            //druk de dagtotalen af en hoeveel personen binnen zijn gekomen
            System.out.println("############################################################");
            System.out.println("#De dagtotalen voor dag "+dag+" zijn: "+Kantine.kassa.getHoeveelheidGeldInKassa());
            System.out.println("#Het aantal personen van dag "+dag+" is: "+Kantine.kassa.getHoeveelheidPersonen());
            System.out.println("############################################################");
            System.out.println("");
            
            //variabelen voor de administratie opslaan
            aantal[i]=Kantine.kassa.getHoeveelheidPersonen();
            omzet[i]=Kantine.kassa.getHoeveelheidGeldInKassa();
            dagomzet[i]=Kantine.kassa.getHoeveelheidGeldInKassa();
            
            //reset de kassa voor de volgende dag
            Kantine.kassa.resetKassa();
        }
        
        //Administratiegegevens afdrukken
        
        double gemAantal=Administratie.berekenGemiddeldeAantal(aantal);
        System.out.println("Gemiddelde aantal personen per dag: "+gemAantal);
        System.out.println();
        
        double gemOmzet=Administratie.berekenGemiddeldeOmzet(omzet);
        System.out.println("Gemiddelde omzet per dag: "+gemOmzet);
        System.out.println();
        
        double[] gemDagOmzet=Administratie.berekenDagOmzet(dagomzet);
        System.out.println("Totale omzet van alle zondagen = "+gemDagOmzet[0]);
        System.out.println("Totale omzet van alle maandagen = "+gemDagOmzet[1]);
        System.out.println("Totale omzet van alle dinsdagen = "+gemDagOmzet[2]);
        System.out.println("Totale omzet van alle woensdage = "+gemDagOmzet[3]);
        System.out.println("Totale omzet van alle donderdagen = "+gemDagOmzet[4]);
        System.out.println("Totale omzet van alle vrijdagen = "+gemDagOmzet[5]);
        System.out.println("Totale omzet van alle zaterdagen = "+gemDagOmzet[6]);
        System.out.println();
    }
}
