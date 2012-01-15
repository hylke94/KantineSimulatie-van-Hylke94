
/**
 * Abstract class Betaalwijze - De klasse betaalwijze zorgt voor de betaalwijze.
 * De methode van deze klasse zijn allemaal abstract en worden overerft door de
 * subklassen Contant en Pinpas.
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
    public void setSaldo(double saldo1){
        this.saldo=saldo1;
    }
    
    /**
     * Methode om betaling af te handelen
     * 
     * @param teBetalen
     * @return Boolean om te kijken of er volddoende saldo is
     */
    public abstract boolean betaal(double teBetalen);
}
