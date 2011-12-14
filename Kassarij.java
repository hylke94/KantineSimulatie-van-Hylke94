import java.util.ArrayList;
/**
* Class Kassarij
*
* @author Hylke de Vries
* @version 1.0
*/
public class Kassarij
{
    //--- Variabelen
    
    private ArrayList<Persoon> persoon;
    
    //--- Constructor
    
    public Kassarij(){
        persoon = new ArrayList<Persoon>();
    }
    
    //--- Getters
    
    /**
    * Checks wether there is a queue
    *
    * @return boolean true or false
    */
    
    public boolean isErEenRij(){
        return (persoon.size() >= 1);
    }
    
    /**
    * Returns the first person that will be served next.
    *
    * @return Person
    */
    
    public Persoon eerstePersoonInRij(Persoon persoon){
        
        if(isErEenRij()){
            return this.persoon.get(0);
        }
        else { // Geen rij
            return null;
        }
    }
    
    //--- Setters
    
    //--- Voids
    
    /**
    * Join the queue
    *
    * @return void
    */
    
    public void sluitAchteraan(Persoon persoon){
        this.persoon.add(persoon);
    }
    
    /**
       * Verwijderd een persoon uit de rij
         */
    
    public void verwijderPersoonUitRij(){
        persoon.remove(0);
    }
    
}