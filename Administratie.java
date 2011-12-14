
/**
 * Write a description of class Administratie here.
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
    public double berekenGemiddeldeAantal(int[] aantal)
    {
        if (aantal.length==0) return 0.0;
        int som=0;
        double gem=0;
        for (int i=0;i<aantal.length;i++) som+=aantal[i];
        //if (som&2==0) som= (double) som;
        gem=som/aantal.length;
        return gem;
    }

    /**
     * Deze methode berekent van de double array omzet de gemiddelde waarde
     * 
     * @param omzet
     * @return het gemiddelde
     */
    public double berekenGemiddeldeOmzet(double[] omzet)
    {
        if (omzet.length==0) return 0.0;
        double som=0;
        double gem=0;
        for (int i=0;i<omzet.length;i++) som+=omzet[i];
        gem=som/omzet.length;
        return gem;
    }
}
