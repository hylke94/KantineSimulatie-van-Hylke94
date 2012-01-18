/**
 * Een tester om de kantinesimulatie voor een X aantal dagen te laten draaien.
 * 
 * @author Eigenaar
 * @version 1.0
 */

public class Tester {
	
	//Parameters
	static KantineSimulatie ks;
	
	/**
	 * Een tester om de kantinesimulatie voor een X aantal dagen te laten draaien.
	 * 
	 * @param Sting[] args, eerste argument bevat het aantal dagen voor de simulatie
	 */
	public static void main (String[] args){
		Model model = new Model();
    	View view = new View(model);
    	Controller controller = new Controller(model,view);
    	
    	view.setVisible(true);
    	
    	ks = new KantineSimulatie();
	}
	
	public void run(){
	    Model model = new Model();
    	View view = new View(model);
    	Controller controller = new Controller(model,view);
    	
    	view.setVisible(true);
    	
    	ks = new KantineSimulatie();
	}
}