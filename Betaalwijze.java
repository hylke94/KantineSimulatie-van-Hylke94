
/**
 * Abstract class Betaalwijze - write a description of the class here
 * 
 * @author Hylke de Vries
 * @version 1.0
 */
public abstract class Betaalwijze
{
    protected double saldo;
    
    /**
     * Method om krediet te initialiseren
     * 
     * @param krediet
     */
    public void setSaldo(double saldo){
        this.saldo=saldo;
    }
    
    /**
     * Methode om betaling af te handelen
     * 
     * @param teBetalen
     * @return Boolean om te kijken of er volddoende saldo is
     */
    public abstract boolean betaal(double teBetalen);
}
