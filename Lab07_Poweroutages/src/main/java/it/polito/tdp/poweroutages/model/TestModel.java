package it.polito.tdp.poweroutages.model;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		//System.out.println(model.getNercList());
		System.out.println(model.getPoweroutagesNerc(2));
		Nerc nerc=new Nerc(2,"HECO");
		System.out.println(model.getRicerca(nerc, 10, 5));

	}

}
