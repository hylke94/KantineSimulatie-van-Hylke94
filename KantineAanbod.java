/**
 * Klasse KantineAanbod
 * 
 * @author Hylke de Vries
 * @version 1.0
 */

import java.util.*;

public class KantineAanbod {

    // interne opslag voorraad
    public HashMap<String, ArrayList<Artikel>> aanbod;
    
    /**
     * Constructor. Het eerste argument is een lijst met artikelnamen,
     * het tweede argument is een lijst met prijzen en het derde argument
     * is een lijst met hoeveelheden. Let op: de dimensies van de drie arrays
     * moeten wel gelijk zijn!
     */
    public KantineAanbod(String[] artikelnaam, double[] prijs, int[] hoeveelheid) 
    {
        aanbod=new HashMap<String, ArrayList<Artikel>>();
        for(int i=0;i<artikelnaam.length;i++) 
        {
            ArrayList<Artikel> artikelen=new ArrayList<Artikel>();
            for(int j=0;j<hoeveelheid[i];j++) 
            {
                artikelen.add(new Artikel(artikelnaam[i], prijs[i]));
            }
            aanbod.put(artikelnaam[i], artikelen);
        }
    }
    
    /**
     * Private methode om de lijst van artikelen te krijgen op basis van de    
     * naam van het artikel. Retourneert null als artikel niet bestaat.
     */
    public ArrayList<Artikel> getArrayList(String productnaam) {
         return aanbod.get(productnaam); 
    }

    /**
     * Private methode om een Artikel van de stapel artikelen af te pakken. 
     * Retourneert null als de stapel leeg is.
     */
    private Artikel getArtikel(ArrayList<Artikel> stapel) 
    {
        if (stapel==null) { 
            System.out.println("Stapel bestaat niet!");
            return null;
        }
        if (stapel.size()==0){
            System.out.println("Stapel is leeg!");
            return null;
        }
        else {
            Artikel a=stapel.get(0);
            stapel.remove(0);
            return a;
        }
    }

    /**
     * Publieke methode om een artikel via de naam van de stapel te pakken.
     * Retouneert null als artikel niet bestaat of niet op voorraad is.
     * @param naam (van artikel)
     * @return artikel (of null)
     */
    public Artikel getArtikel(String naam) {
        return getArtikel(getArrayList(naam));
    }
}