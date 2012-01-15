
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
    public void setKredietlemiet (double kredlem){
        this.kredietlemiet=kredlem;
    }
    
    /**
     * Methode om betaling af te handelen
     */
    @Override
	public boolean betaal (double teBetalen){
        if (teBetalen<=this.kredietlemiet){
            this.kredietlemiet-=teBetalen;
            this.saldo-=teBetalen;
            return true;
        }
        return false;
    }
}
