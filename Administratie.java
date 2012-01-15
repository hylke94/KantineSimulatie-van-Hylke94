
/**
 * Administratie berkent verschillende overzichten voor de simulatie.
 * 
 * @author Hylke de Vries
 * @version 1.0
 */
public class Administratie
{
    /**
     * Deze methode berekent van de int array aantal de gemiddelde waarde
     * 
     * @param aantal
     * @retrun het gemiddelde
     */
    public static double berekenGemiddeldeAantal(int[] aantal)
    {
    	//als de array leeg is, return 0.0
        if (aantal.length==0) return 0.0;
        //variabelen declareren
        int som=0;
        double gem=0;
        //alle getallen van de aray bij elkaar optellen
        for (int i=0;i<aantal.length;i++) som+=aantal[i];
        //een double van de integer maken
        double som2= som;
        //gemiddelde berekenen en returnen
        gem=som2/aantal.length;
        return gem;
    }

    /**
     * Deze methode berekent van de double array omzet de gemiddelde waarde
     * 
     * @param omzet
     * @return het gemiddelde
     */
    public static double berekenGemiddeldeOmzet(double[] omzet)
    {
    	//als de array leeg is, return 0.0
        if (omzet.length==0) return 0.0;
        //variabelen declareren
        double som=0;
        double gem=0;
        //alle getallen in de array bij elkaar optellen
        for (int i=0;i<omzet.length;i++) som+=omzet[i];
        //gemiddelde berekenen en returnen
        gem=som/omzet.length;
        return gem;
    }
    
    /**
     * Methode om dagomzet uit te rekenen
     * 
     * @param omzet
     * @return array (7 elementen) met dagomzetten
     */
    public static double[] berekenDagOmzet(double[] omzet)
    {
    	//als de array leeg is, return 0.0
    	if (omzet.length==0) return null;
    	//variabelen declareren
        int DAYS_IN_WEEK=7;
        //nieuwe arraylist maken met de omvang van de variabele DAYS_IN_WEEK
        double[] temp=new double[DAYS_IN_WEEK];
        //alle getallen in de array bijlangs gaan
        for (int i=0;i<DAYS_IN_WEEK;i++) {
            int j=0;
            //telkens dezelfde dag bij elkaar optellen
            while (i+DAYS_IN_WEEK*j<omzet.length) {
            	//opslaan in de nieuwe variabele
                temp[i]+=omzet[i+DAYS_IN_WEEK*j];
                j++;
            }
        }
        return temp;
    }
}
