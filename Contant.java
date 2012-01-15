
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
     */
    @Override
	public boolean betaal(double teBetalen){
        if (teBetalen<=this.saldo){
            this.saldo-=teBetalen;
            return true;
        }
        return false;
    }
}
