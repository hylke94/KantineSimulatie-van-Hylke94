
/**
 * Write a description of class Model here.
 * 
 * @author Hylke de Vries
 * @version 1.0
 */

import java.util.*;

public class Model {
	private List<View> views;
	
	public Model() {
		this.views=new ArrayList<View>();
	}
	
	public void addView(View view) {
		this.views.add(view);
	}
	
	public void notifyViews() {
		for(View v: this.views) v.updateView();
	}
}
