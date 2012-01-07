
/**
 * Write a description of class Pinpas here.
 * 
 * @author Hylke de Vries
 * @version 1.0
 */
public class Pinpas extends Betaalwijze
{
    private double kredietlemiet;
    
    /**
     * Methode om kredietlemiet te zetten
     * 
     * @param kredietlemiet
     */
    public void setKredietlmiet (double kredietlemiet){
        this.kredietlemiet=kredietlemiet;
    }
    
    /**
     * Methode om betaling af te handelen
     */
    public boolean betaal (double teBetalen){
        if (teBetalen<=saldo){
            saldo-=teBetalen;
            return true;
        }
        return false;
    }
}