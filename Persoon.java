
/**
 * Write a description of class Persoon here.
 * 
 * @author Hylke de Vries
 * @version 1.0
 */

import java.util.Iterator;

public class Persoon
{
    private int bsn;
    
    private int dag;
    private int maand;
    private int jaar;
    private boolean isSchrikkelJaar;
    
    private char geslacht;
    
    private String voornaam;
    private String achternaam;
    
    public Dienblad dienblad;
    private Iterator<Artikel> iterator;
    
    private Betaalwijze betaalwijze;
    private Pinpas pinpas;
    
    //------ Constructor
    
    public Persoon(){
        this.dag = 0;
        this.maand = 0;
        this.jaar = 0;
        
        this.geslacht = 'X';
    }
   
    public Persoon(int bsn1, int dag1, int maand1, int jaar1, char geslacht1, String voornaam1, String achternaam1){
        setBsn(bsn1);
        setBirthdate(dag1, maand1, jaar1);
        setGender(geslacht1);
        setVoornaam(voornaam1);
        setAchternaam(achternaam1);
    }  
   
    
    //------ Getters
    
    /**
     * Get the BSN;
     * 
     * @return BSN;
     */
    
    public int getBsn(){
        return this.bsn;
    }
    
    /**
     * Get the Birthday
     * 
     * @return Geboortedatum
     */
    
    public String getGeboorteDatum(){
        String temp;
        //als er geen datum bekend is, return "onbekend"
        if(this.dag == 0 && this.maand == 0 & this.jaar == 0){
            temp = "Onbekend";
        }
        else {
            temp = this.dag+"/"+this.maand+"/"+this.jaar;
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
        
        if(this.geslacht == 'M'){
            gender = "Man";
        }
        else if (this.geslacht == 'V'){
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
        return this.voornaam;
    }
    
    /**
     * Get the last name
     * 
     * @return Achternaam
     */
    
    public String getLastname(){
        return this.achternaam;
    }
    
    /**
     * Get the full name
     * 
     * @return voornaam + achternaam
     */
    public String getName(){
        String naam = this.voornaam+" "+this.achternaam;
        return naam;
    }
    
    
    //------------------------------------- Setters
    
    
    /**
     * Set the BSN
     * 
     * @return BSN
     * 
     */
    
    public void setBsn(int bsn1){
        this.bsn = bsn1;
    }
    
    /**
     * Set the birthdate
     * 
     * @return Birthday
     */
    
    public void setBirthdate(int dag1, int maand1, int jaar1){
    	if (jaar1>=1900 && jaar1<=2100){
    		if (maand1>=0 && maand1<=12){
    			this.maand=maand1;
    			if (dag1>=1 && dag1<=31){
    				if (maand1==2){
    					if (checkSchrikkeljaar(jaar1)==true && dag1<=29) this.dag=dag1;
    					else if (dag1<=28) this.dag=dag1;
    				}
    				else if	(	(maand1<=6 && maand1%2==0 && dag1<=30)		||
    							(maand1<=7 && maand1%2==1 && dag1<=31)		||
    							(maand1>=8 && maand1%2==0 && dag1<=31)		||
    							(maand1>=9 && maand1%2==1 && dag1<=30))	this.dag=dag1;
    				else{
    					this.dag=0;
    					System.out.println("Deze dag bestaat niet!");
    				}
    			}
    			else{
    				this.dag=0;
    				System.out.println("Deze dag bestaat niet!");
    			}
    		}
    		else System.out.println("Deze maand bestaat niet!");
    	}
    	else System.out.println("De jaren moeten tussen de 1900 en 2100 liggen!");
    }
    
    /**
     * Set the first name
     * 
     * @return first name
     */
    
    public void setVoornaam(String voornaam1){
        this.voornaam = voornaam1;
    }
    
    /**
     * Set the last name
     * 
     * @return last name
     */
    
    public void setAchternaam(String achternaam1){
        this.achternaam = achternaam1;
    }
    
    /**
     * Set the gender
     * 
     * @return gender
     */
    
    public void setGender(char geslacht1){
        if (this.geslacht != 'M' || this.geslacht != 'V'){
            this.geslacht = 'X';    
        }
        else { 
            this.geslacht = geslacht1;
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
    
    public boolean checkSchrikkeljaar(int jaar1){
        this.jaar =  jaar1;
            if(jaar1 % 4 == 0){
                if((jaar1 % 100 == 0) && (jaar1 % 400 != 0)){
                    this.isSchrikkelJaar = false;
                }
                else {
                    this.isSchrikkelJaar = true;
                }
            }
            else {
                this.isSchrikkelJaar = false;
        }
        
        return this.isSchrikkelJaar;
        
    }
    
    //------ Kantine opdrachten
    
    /**
     * Pak een nieuw dienblad
     */
    
    public void pakDienblad(){
        this.dienblad = new Dienblad();
    }
    
    /**
     * Haal het dienblad met artikelen als een Iterator op
     * 
     * @return Iterator<Artikel> dienblad
     */
    public Iterator<Artikel> getIteratorDienblad() {
        this.iterator=this.dienblad.getIteratorDienblad();
        return this.iterator;
    }
    
    /**
     * Geeft een string van de gegevens (in dit geval alleen de naam)
     * 
     * @return String
     */
    @Override
	public String toString() {
        String naam=this.voornaam+" "+this.achternaam;
        return naam;
    }
    
    /**
     * Controleert of twee personen dezelfde personen zijn
     * 
     * @param Object
     * 
     * @return boolean
     */
    @Override
	public boolean equals(Object object) {
        if (this==object) return true; //Referentiegelijkheid
        if (!(object instanceof Persoon)) return false; //Niet hetzelfde type
        //Toegang krijgen tot de velden van andere personen
        Persoon other=(Persoon) object;
        return this.bsn==other.bsn;
    }
    
    /**
     * Setter voor de betaalwijze
     * 
     * @param saldo
     */
    public void setBetaalwijze(double saldo){
        this.betaalwijze.setSaldo(saldo);
    }
    
    /**
     * Getter voor de betaalwijze
     * 
     * @return betaalwijze
     */
    public Betaalwijze getBetaalwijze(){
        return this.betaalwijze;
    }
    
    /**
     * Maakt een nieuwe pinpas voor de persoon
     * 
     * @param kredietlemiet
     */
    public void nieuwePinpas(double kredietlemiet){
        this.pinpas = new Pinpas();
        this.pinpas.setKredietlemiet(kredietlemiet);
    }
    
    /**
     * Geeft de pinpas
     * 
     * @return Pinpas
     */
    public Pinpas getPinpas(){
        return this.pinpas;
    }
    
    // methode om kortingspercentage op te vragen
    @SuppressWarnings("static-method")
	public double geefKortingsPercentage(){return 0.00;}
    // methode om op te vragen of er maximum per keer aan de korting zit
    @SuppressWarnings("static-method")
	public boolean heeftMaximum(){return false;}
    // methode om het maximum kortingsbedrag op te vragen
    @SuppressWarnings("static-method")
	public double geefMaximum(){return 0.00;}
}