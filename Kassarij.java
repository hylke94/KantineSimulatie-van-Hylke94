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
        this.persoon = new ArrayList<Persoon>();
    }
    
    //--- Getters
    
    /**
    * Checks wether there is a queue
    *
    * @return boolean true or false
    */
    
    public boolean isErEenRij(){
        return (this.persoon.size() >= 1);
    }
    
    /**
    * Returns the first person that will be served next.
    *
    * @return Person
    */
    
    public Persoon eerstePersoonInRij(){
        
        if(isErEenRij()){
            return this.persoon.get(0);
        }
        // Geen rij
        return null;
    }
    
    //--- Setters
    
    //--- Voids
    
    /**
    * Join the queue
    *
    * @return void
    */
    
    public void sluitAchteraan(Persoon pers){
        this.persoon.add(pers);
    }
    
    /**
    * Verwijderd een persoon uit de rij
    */
    
    public void verwijderPersoonUitRij(){
        this.persoon.remove(0);
    }
    
}