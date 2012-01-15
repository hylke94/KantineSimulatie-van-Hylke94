
/**
 * Dit is een artikel-class, waar een artikel zijn naam en ijs in opslaat.
 * 
 * @author Hylke de Vries
 * @version 1.0
 */
public class Artikel
{
    private String artikelNaam;
    
    private double artikelPrijs = 0;
    
    
    /**
     * Constructor
     */
    
    public Artikel(){
        
    }
    
    public Artikel(String artikelNaam1, double artikelPrijs1){
        this.artikelNaam =  artikelNaam1;
        this.artikelPrijs = artikelPrijs1;
        
    }
    
    /**
     * Get the Article name
     */
    
    public String getArtikelName(){
        return this.artikelNaam;
    }
    
    /**
     * Get the Article price
     */
    
    public double getArtikelPrice(){
        return this.artikelPrijs;
    }
    
    /**
     * Set the Article name
     */
    
    public void setArticleName(String artikelNaam1){
        this.artikelNaam =  artikelNaam1;
    }
    
    /**
     * Set a new Article price
     */
    
    public void setArticlePrice(int artikelPrijs1){
        this.artikelPrijs =  artikelPrijs1;
    }
    
    //--- Druk af
    
    /**
     * Print all information about the article
     */
    public void drukAf(){
        System.out.println("######################");
        System.out.println("## Artikelnaam: " + getArtikelName() + "##");
        System.out.println("## Artikelprijs: " + getArtikelPrice() + "##");
        System.out.println("######################");
        System.out.println();
    }
}
