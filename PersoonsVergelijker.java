/**
 * Write a description of class PersoonsVergelijker here.
 * 
 * @author Hylke de Vries
 * @version 1.0
 */
public class PersoonsVergelijker
{
    /**
     * Constructor
     */
    public PersoonsVergelijker(){
        
    }
    
    public static void main(/*String[] args*/){
        Persoon persoon1 = new Persoon(12345, 18, 03, 1994, 'M', "Hylke", "Vries");
        Persoon persoon2 = new Persoon(12345, 18, 03, 1994, 'M', "Hylke", "Vries");
        
        if(persoon1==persoon2) System.out.println("== is true"); else System.out.println("== is false");
        if(persoon1.equals(persoon2)) System.out.println("equals is true"); else System.out.println("equals is false");
    }
}