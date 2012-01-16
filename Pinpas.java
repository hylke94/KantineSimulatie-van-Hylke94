
/**
 * Write a description of class Pinpas here.
 * 
 * @author Hylke de Vries
 * @version 1.0
 */
public class Pinpas extends Betaalwijze
{
    private double kredietlimiet;
    
    /**
     * Methode om kredietlemiet te zetten
     * 
     * @param kredietlemiet
     */
    public void setKredietlemiet (double kredietlimiet1){
        this.kredietlimiet=kredietlimiet1;
    }
    
    /**
     * Methode om betaling af te handelen
     * @throws TeWeinigGeldException 
     */
    @Override
	public void betaal (double teBetalen) throws TeWeinigGeldException{
        if (teBetalen<=this.saldo && this.saldo-teBetalen>=this.kredietlimiet){
            this.saldo-=teBetalen;
        }
        else{
        	throw new TeWeinigGeldException("Onvoldoende saldo op pinpas!");
        }
    }
}
