
/**
 * De klasse Dienblad houdt een ArrayList bij, met de gekozen artikelen.
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
    
    /**
     * Constructor that maken an empty ArrayList for the tray
     */
    public Dienblad(){
        this.artikelen = new ArrayList<Artikel>();
    }
    
    
    //--- Getters
    
    /**
     * Make an iterator from the tray
     * 
     * @return Iterator<Artikel>
     */
    public Iterator<Artikel> getIteratorDienblad() {
        Iterator<Artikel> itr=this.artikelen.iterator();
        return itr;
    }
    
    //--- Setters
    
    
    //--- Voids
    
    /**
     * Adds the item to an ArrayList
     * 
     * @param artikel
     */
    
    public void voegToe(Artikel artikel){
        this.artikelen.add(artikel);
    }
    
    
}
