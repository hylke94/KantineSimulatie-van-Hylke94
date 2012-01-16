
/**
 * Contant is een subklasse van Betaalwijze
 * en heeft een body van de methodeden in Betaalwijze.
 * 
 * @author Hylke de Vries
 * @version 1.0
 */
public class Contant extends Betaalwijze
{
    /**
     * Methode om betaling af te handelen
     * 
     * @throws TeWeinigGeldException als er niet genoeg krediet is
     */
    @Override
	public void betaal(double teBetalen) throws TeWeinigGeldException{
        if (teBetalen<=this.saldo){
            this.saldo-=teBetalen;
        }
        else{
        	throw new TeWeinigGeldException("Onvoldoende saldo!");
        }
    }
}