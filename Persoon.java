
/**
 * Write a description of class Persoon here.
 * 
 * @author Hylke de Vries
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Iterator;

public class Persoon
{
    private boolean isSchrikkelJaar;
    
    private int bsn;
    
    private int dag;
    private int maand;
    private int jaar;
    
    private char geslacht;
    
    private String voornaam;
    private String achternaam;
    
    public Dienblad dienblad;
    private Iterator iterator;
    
    private Betaalwijze betaalwijze;
    private Contant contant;
    private Pinpas pinpas;
    
    //------ Constructor
    
    public Persoon(){
        this.dag = 0;
        this.maand = 0;
        this.jaar = 0;
        
        this.geslacht = 'X';
    }
   
    public Persoon(int bsn, int dag, int maand, int jaar, char geslacht, String voornaam, String achternaam){
        this.bsn = bsn;
        
        setBirthdate(dag, maand, jaar);
        this.geslacht = geslacht;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
    }  
   
    
    //------ Getters
    
    /**
     * Get the BSN;
     * 
     * @return BSN;
     */
    
    public int getBsn(){
        return bsn;
    }
    
    /**
     * Get the Birthday
     * 
     * @return Geboortedatum
     */
    
    public String getGeboorteDatum(){
        String temp;
        
        if(dag == 0 && maand == 0 & jaar == 0){
            temp = "Onbekend";
        }
        else {
            temp = dag+"/"+maand+"/"+jaar;
        }
        
        return temp;
    }
    
    /**
     * Get gender
     * 
     * @return Gender
     */
    
    public String getGender(){
        String gender;
        
        if(geslacht == 'M'){
            gender = "Man";
        }
        else if (geslacht == 'V'){
            gender = "Vrouw"; 
        }
        else {
            gender = "Onbekend";
        }
        
        return gender;

    }
    
    /**
     * Get the first name
     * 
     * @return Voornaam
     */
    
    public String getFirstname(){
        return voornaam;
    }
    
    /**
     * Get the last name
     * 
     * @return Achternaam
     */
    
    public String getLastname(){
        return achternaam;
    }
    
    public String getName(){
        String naam = voornaam+" "+achternaam;
        return naam;
    }
    
    
    //------------------------------------- Setters
    
    
    /**
     * Set the BSN
     * 
     * @return BSN
     * 
     */
    
    public void setBsn(int bsn){
        this.bsn = bsn;
    }
    
    /**
     * Set the birthdate
     * 
     * @return Birthday
     */
    
    public void setBirthdate(int dag, int maand, int jaar){
            
        if(jaar >= 1900 && jaar <= 2100){
            
            if(jaar % 4 == 0){
                if((jaar % 100 == 0) && (jaar % 400 != 0)){
                    isSchrikkelJaar = false;
                }
                else {
                    isSchrikkelJaar = true;
                }
            }
            else {
                isSchrikkelJaar = false;
            }
            
        this.jaar = jaar;
                       
            if(maand >= 1 && maand <= 12 && dag >= 1){
                
                
                if(maand <= 7 && maand % 2 == 1){
                    this.maand =  maand;
                    
                    if(dag <= 31){
                        this.dag = dag;
                    }
                    else { 
                       this.dag = 0;
                    }
                }
                else if (maand == 2) {
                    this.maand = maand;
                    
                    if(isSchrikkelJaar == true){
                        if (dag <= 29){
                            this.dag = dag;
                        }
                        else {
                            this.dag = 0;
                        }
                    }
                    else {
                        if (dag <= 28){
                            this.dag = dag;
                        }
                        else { 
                            this.dag = 0;
                        }
                    }
                }
                else if(maand <= 6 && maand %2 == 0){
                    this.maand = maand;
                    
                    if(dag <= 30){
                        this.dag = dag;
                    }
                    else { 
                        this.dag = 0;
                    }
                }
                else if(maand >= 8 && maand % 2 == 0){
                    this.maand = maand;
                    
                    if(dag <= 31){
                        this.dag = dag;
                    }
                    else { 
                        this.dag = 0;
                    }
                }
                else if (maand >= 8 && maand % 2 == 1){
                    this.maand = maand;
                    
                    if(dag <= 30){
                        this.dag = dag;
                    }
                    else { 
                       this.dag = 0;
                    }
                }
                else {
                    System.out.println("### DEBUG: " + dag + " " + maand + " " + jaar);
                }
            }
            else {
                System.out.println("### FOUT: Dit jaar slaat nergens op!");
            }
        }
        else {
            System.out.println("### FOUT: De jaren moeten liggen tussen 1900 of 2100");
        }
                
    }
    
    
    
    /**
     * Set the first name
     * 
     * @return first name
     */
    
    public void setVoornaam(String voornaam){
        this.voornaam = voornaam;
    }
    
    /**
     * Set the last name
     * 
     * @return last name
     */
    
    public void setAchternaam(String achternaam){
        this.achternaam = achternaam;
    }
    
    /**
     * Set the gender
     * 
     * @return gender
     */
    
    public void setGender(char geslacht){
        if (this.geslacht != 'M' || this.geslacht != 'V'){
            this.geslacht = 'X';    
        }
        else { 
            this.geslacht = geslacht;
        }
    }
    
    
    //------- Druk af
    
    /**
     * Prints a report about the Person
     * 
     * @return void
     */
    
    public void drukAf(){
        System.out.println("###################################################");
        System.out.println("## Informatie over:" + getFirstname() +" " + getLastname() + "##");
        System.out.println("## BSN:" + getBsn() +"##");
        System.out.println("## Geslacht:" + getGender() +"##");
        System.out.println("## Geboortedatum:" + getGeboorteDatum() +"##");
        System.out.println("###################################################");
        System.out.println();
    }
    
    
    //------ Check Schrikkeljaar
    
    /**
     * Checks wether the given year is a leap year or not
     * 
     * @returns boolean true or false
     */
    
    public boolean checkSchrikkeljaar(int jaar){
        this.jaar =  jaar;
            if(jaar % 4 == 0){
                if((jaar % 100 == 0) && (jaar % 400 != 0)){
                    isSchrikkelJaar = false;
                }
                else {
                    isSchrikkelJaar = true;
                }
            }
            else {
                isSchrikkelJaar = false;
        }
        
        return isSchrikkelJaar;
        
    }
    
    //------ Kantine opdrachten
    
    /**
     * Pak een nieuw dienblad
     */
    
    public void pakDienblad(){
        dienblad = new Dienblad();
    }
    
    /**
     * Haal het dienblad met artikelen als een Iterator op
     * 
     * @return iterator
     */
    public Iterator getIteratorDienblad() {
        iterator=dienblad.getIteratorDienblad();
        return iterator;
    }
    
    public String toString() {
        String naam=voornaam+" "+achternaam;
        return naam;
    }
    
    public boolean equals(Object object) {
        if (this==object) return true; //Referentiegelijkheid
        if (!(object instanceof Persoon)) return false; //Niet hetzelfde type
        //Toegang krijgen tot de velden van andere personen
        Persoon other=(Persoon) object;
        /*return voornaam.equals(other.voornaam) &&
                achternaam.equals(other.achternaam) &&
                dienblad.equals(other.dienblad) &&
                iterator.equals(other.iterator) &&
                bsn==other.bsn &&
                dag==other.dag &&
                maand==other.maand &&
                jaar==other.jaar &&
                geslacht==other.geslacht;*/
        return bsn==other.bsn;
    }
    
    public void setBetaalwijze(double saldo){
        betaalwijze.setSaldo(saldo);
    }
    
    public Betaalwijze getBetaalwijze(){
        return betaalwijze;
    }
    
    public void nieuwePinpas(int kredietlemiet){
        pinpas = new Pinpas();
        pinpas.setKredietlemiet(kredietlemiet);
    }
    
    public Pinpas getPinpas(){
        return pinpas;
    }
    
    // methode om kortingspercentage op te vragen
    public double geefKortingsPercentage(){return 0.00;}
    // methode om op te vragen of er maximum per keer aan de korting zit
    public boolean heeftMaximum(){return false;}
    // methode om het maximum kortingsbedrag op te vragen
    public double geefMaximum(){return 0.00;}
}