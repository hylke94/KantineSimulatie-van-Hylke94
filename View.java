
/**
 * Write a description of class View here.
 * 
 * @author Hylke de Vries
 * @version 1.0
 */

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class View extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	//model
	protected Model model;
	
	//tekstvelden
	private JTextField inputfield1 = new JTextField(5);
	private JTextField inputfield2 = new JTextField(5);
	private JTextField inputfield3 = new JTextField(5);
	private JTextField inputfield4 = new JTextField(5);
	private JTextField aantalDagen = new JTextField(3);
	private JTextField minArtikelenPerSoort = new JTextField(5);
	private JTextField maxArtikelenPerSoort = new JTextField(5);
	private JTextField minArtikelenPerPersoon = new JTextField(5);
	private JTextField maxArtikelenPerPersoon = new JTextField(5);
	
	//buttons
	private JButton button1 = new JButton("Toevoegen");
	private JButton button2 = new JButton("Start");
	
	public View(Model model1) {
	    //set up model
		this.model=model1;
		model1.addView(this);
		
		//layout
		JPanel content = new JPanel();
		content.add(new JLabel("Artikelnaam:"));
		content.add(new JLabel("Prijs:"));
		content.add(new JLabel("Hoeveelheid:"));
		content.add(new JLabel("Koffie:"));
		content.add(new JLabel("1,50"));
		content.add(this.inputfield1);
		content.add(new JLabel("Broodje hamburger:"));
		content.add(new JLabel("2,10"));
		content.add(this.inputfield2);
		content.add(new JLabel("Broodje kaas:"));
		content.add(new JLabel("1,65"));
		content.add(this.inputfield3);
		content.add(new JLabel("Melk:"));
		content.add(new JLabel("1,65"));
		content.add(this.inputfield4);
		content.add(new JLabel(""));
		content.add(this.button1);
		content.add(new JLabel(""));
		content.add(new JLabel(""));
		content.add(new JLabel(""));
		content.add(new JLabel(""));
		content.add(new JLabel("Min/Max artikelen per soort:"));
		content.add(this.minArtikelenPerSoort);
		content.add(this.maxArtikelenPerSoort);
		content.add(new JLabel("Min/Max artikelen per persoon:"));
		content.add(this.minArtikelenPerPersoon);
		content.add(this.maxArtikelenPerPersoon);
		content.add(new JLabel("Aantal dagen:"));
		content.add(this.aantalDagen);
		content.add(new JLabel(""));
		content.add(new JLabel(""));
		content.add(this.button2);
		content.add(new JLabel(""));
		
		this.button1.addActionListener(this);
		this.button2.addActionListener(this);
		
		content.setLayout(new GridLayout(0, 3));
		
		this.setContentPane(content);
		this.pack();
	}
	
	public Model getModel() {
		return this.model;
	}
	
	public void updateView() {
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		String artikelnaam;
		if(command.equals("Toevoegen")) {
			if (this.inputfield1.getSelectionEnd()!=0 || this.inputfield2.getSelectionEnd()!=0 || 
					this.inputfield3.getSelectionEnd()!=0 || this.inputfield4.getSelectionEnd()!=0){
				if (this.inputfield1.getSelectionEnd()!=0){
					artikelnaam="Koffie";
					ArrayList<Artikel> artikel = KantineSimulatie.kantineaanbod.getArrayList(artikelnaam);
					String input = this.inputfield1.getText();
					int aantal=Integer.parseInt(input);
					for (int i=0;i<aantal;i++){
						artikel.add(new Artikel("Koffie", 1.50));
					}
					System.out.println("Artikelen (koffie) toegevoegd.");
				}
				if (this.inputfield2.getSelectionEnd()!=0){
					artikelnaam="Broodje hamburger";
					ArrayList<Artikel> artikel = KantineSimulatie.kantineaanbod.getArrayList(artikelnaam);
					String input = this.inputfield1.getText();
					int aantal=Integer.parseInt(input);
					for (int i=0;i<aantal;i++){
						artikel.add(new Artikel("Broodje hamburger", 2.10));
					}
					System.out.println("Artikelen (broodje hamburger) toegevoegd.");
				}
				if (this.inputfield3.getSelectionEnd()!=0){
					artikelnaam="Broodje kaas";
					ArrayList<Artikel> artikel = KantineSimulatie.kantineaanbod.getArrayList(artikelnaam);
					String input = this.inputfield1.getText();
					int aantal=Integer.parseInt(input);
					for (int i=0;i<aantal;i++){
						artikel.add(new Artikel("Broodje kaas", 1.65));
					}
					System.out.println("Artikelen (broodje kaas) toegevoegd.");
				}
				if (this.inputfield4.getSelectionEnd()!=0){
					artikelnaam="Melk";
					ArrayList<Artikel> artikel = KantineSimulatie.kantineaanbod.getArrayList(artikelnaam);
					String input = this.inputfield1.getText();
					int aantal=Integer.parseInt(input);
					for (int i=0;i<aantal;i++){
						artikel.add(new Artikel("Melk", 1.65));
					}
					System.out.println("Artikelen (melk) toegevoegd.");
				}
			}
			else{
				System.out.println("U heeft nergens een hoeveelheid ingevuld!");
			}
		}
		else if (command.equals("Start")) {
			if (this.aantalDagen.getSelectionEnd()!=0 && 
					this.minArtikelenPerSoort.getSelectionEnd()!=0 && 
					this.maxArtikelenPerSoort.getSelectionEnd()!=0){
				String inputDagen = this.aantalDagen.getText();
				int dagen = Integer.parseInt(inputDagen);
				String inputMins = this.minArtikelenPerSoort.getText();
				int mins = Integer.parseInt(inputMins);
				String inputMaxs = this.maxArtikelenPerSoort.getText();
				int maxs = Integer.parseInt(inputMaxs);
				String inputMinp = this.minArtikelenPerPersoon.getText();
				int minp = Integer.parseInt(inputMinp);
				String inputMaxp = this.maxArtikelenPerPersoon.getText();
				int maxp = Integer.parseInt(inputMaxp);
				Tester.ks.simuleer(dagen,mins,maxs,minp,maxp);
			}
			else{
				System.out.println("U heeft geen dagen ingevoerd!");
			}
		}
	}
}
