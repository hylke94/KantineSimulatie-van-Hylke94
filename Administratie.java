
/**
 * Write a description of class Administratie here.
 * 
 * @author Hylke de Vries
 * @version 1.0
 */
public class Administratie
{
    static final int DAYS_IN_WEEK=7;
    
    
    /**
     * Deze methode berekent van de int array aantal de gemiddelde waarde
     * 
     * @param aantal
     * @retrun het gemiddelde
     */
    public static double berekenGemiddeldeAantal(int[] aantal)
    {
        if (aantal.length==0) return 0.0;
        int som=0;
        double gem=0;
        for (int i=0;i<aantal.length;i++) som+=aantal[i];
        double som2= (double) som;
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
        if (omzet.length==0) return 0.0;
        double som=0;
        double gem=0;
        for (int i=0;i<omzet.length;i++) som+=omzet[i];
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
        double[] temp=new double[DAYS_IN_WEEK];
        for (int i=0;i<DAYS_IN_WEEK;i++) {
            int j=0;
            while (i+DAYS_IN_WEEK*j<omzet.length) {
                temp[i]+=omzet[i+DAYS_IN_WEEK*j];
                j++;
            }
        }
        return temp;
    }
}
