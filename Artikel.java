
/**
 * Write a description of class Artikel here.
 * 
 * @author Hylke de Vries
 * @version 1.0
 */
public class Artikel
{
    private String artikelNaam;
    public Artikel artikel;
    
    private double artikelPrijs = 0;
    
    
    /**
     * Initliase a constructor for the Article name and the Article price.
     */
    
    public Artikel(){
        
    }
    
    public Artikel(String artikelNaam, double artikelPrijs){
        this.artikelNaam =  artikelNaam;
        this.artikelPrijs = artikelPrijs;
        
    }
    
    /**
     * Get the Article name
     */
    
    public String getArtikelName(){
        return artikelNaam;
    }
    
    /**
     * Get the Article price
     */
    
    public double getArtikelPrice(){
        return artikelPrijs;
    }
    
    /**
     * Set the Article name
     */
    
    public void setArticleName(String artikelNaam){
        this.artikelNaam =  artikelNaam;
    }
    
    /**
     * Set a new Article price
     */
    
    public void setArticlePrice(int artikelPrijs){
        this.artikelPrijs =  artikelPrijs;
    }
    
    //--- Druk af
    
    public void drukAf(Artikel art){
        System.out.println("######################");
        System.out.println("## Artikelnaam: " + getArtikelName() + "##");
        System.out.println("## Artikelprijs: " + getArtikelPrice() + "##");
        System.out.println("######################");
        System.out.println();
    }
    
    
    //---------- Opgave 4 -  Primitieve types
    
    public void primitieveTypes(){
        
        int i = 1; // Hier wijs je de waarde 1 toe aan papier I (dit is directe opslag)
        int j = 2; // Hier wijs je 2 toe aan papier J (Ook directe opslag)
        
        i = j; // Dus I word nu 2
        
        j = 3; // Nu geef je het papier J de waarde 3.
        
        System.out.println("i = " + i +", j = " + j); // Dit toont i = 2, want papier I heeft de waarde 2, en papier j heeft waarde 3.
        
        
        // In de case van de objecten verwijs je a naar b, waarna je b de waarde geeft van 3. 
        //Hierdoor krijgt a ook de waarde van B, wat dus resulteert in dezelfde waarde voor beide objecten.
  
    }
}
