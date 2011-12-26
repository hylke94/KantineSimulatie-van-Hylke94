
/**
 * Write a description of class Contant here.
 * 
 * @author Hylke de Vries
 * @version 1.0
 */
public class Contant extends Betaalwijze
{
    /**
     * Methode om betaling af te handelen
     */
    public boolean betaal(double teBetalen){
        if (teBetalen<=saldo){
            saldo-=teBetalen;
            return true;
        }
        return false;
    }
}
