
/**
 * Write a description of class Controller here.
 * 
 * @author Hylke de Vries
 * @version 1.0
 */

import javax.swing.*;

public class Controller extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private Model model;
	private View view;
	
	public Controller(Model model1, View view1) {
		this.model=model1;
		this.view=view1;
	}
}
