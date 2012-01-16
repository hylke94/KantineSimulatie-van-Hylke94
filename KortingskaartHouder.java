
/**
 * Write a description of interface KortingskaartHouder here.
 * 
 * @author Hylke de Vries
 * @version 1.0
 */

public interface KortingskaartHouder {
    // methode om kortingspercentage op te vragen
    public abstract double geefKortingsPercentage();
    // methode om op te vragen of er maximum per keer aan de korting zit
    public boolean heeftMaximum();
    // methode om het maximum kortingsbedrag op te vragen
    public double geefMaximum();
}