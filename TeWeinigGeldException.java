
/**
 * Write a description of class TeWeinigGeldException here.
 * 
 * @author Hylke de Vries
 * @version 1.0
 */
public class TeWeinigGeldException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 */
    public TeWeinigGeldException(){
    	
    }
    
    /**
     * Constructor
     * @return 
     */
	public TeWeinigGeldException(Exception e){
    	System.out.println(e.toString());
    }
    
    /**
     * Constructor
     */
    public TeWeinigGeldException(String message){
    	super(message);
    }
    
    @Override
	public String toString(){
    	return "Onvoldoende saldo op pinpas";
    }
}