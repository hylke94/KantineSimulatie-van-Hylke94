/**
 * Klasse Dienblad
 * 
 * @author Hylke de Vries
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Iterator;

public class Dienblad
{
    //--- Instantievariabelen
    
    public ArrayList<Artikel> artikelen;
    
    //--- Constructors
    
    public Dienblad(){
        artikelen = new ArrayList<Artikel>();
    }
    
    
    //--- Getters
    public Iterator<Artikel> getIteratorDienblad() {
        Iterator<Artikel> itr=artikelen.iterator();
        return itr;
    }
    
    //--- Setters
    
    
    //--- Voids
    
    /**
     * Adds the item to an ArrayList
     * 
     * @return void
     */
    
    public void voegToe(Artikel artikel){
        artikelen.add(artikel);
    }
    
    
}
