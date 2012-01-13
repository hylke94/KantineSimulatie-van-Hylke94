
/**
 * Write a description of class Artikel here.
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
    
    /**
     * Print all information about the article
     * @param art
     */
    public void drukAf(Artikel art){
        System.out.println("######################");
        System.out.println("## Artikelnaam: " + getArtikelName() + "##");
        System.out.println("## Artikelprijs: " + getArtikelPrice() + "##");
        System.out.println("######################");
        System.out.println();
    }
}
