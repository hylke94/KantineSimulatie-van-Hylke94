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
    
    /**
     * Constructor that maken an empty ArrayList for the tray
     */
    public Dienblad(){
        artikelen = new ArrayList<Artikel>();
    }
    
    
    //--- Getters
    
    /**
     * Make an iterator from the tray
     * 
     * @return Iterator<Artikel>
     */
    public Iterator<Artikel> getIteratorDienblad() {
        Iterator<Artikel> itr=artikelen.iterator();
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
        artikelen.add(artikel);
    }
    
    
}
