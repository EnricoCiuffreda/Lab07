package it.polito.tdp.poweroutages.model;

import java.util.List;

import it.polito.tdp.poweroutages.DAO.PowerOutageDAO;

public class Model {
	
	PowerOutageDAO podao=new PowerOutageDAO();
	
	public Model() {
	}
	
	public List<Nerc> getNercList() {
		return podao.getNercList();
	}
	public List<Poweroutage> getPoweroutagesNerc(Integer id){
		return podao.getPoweroutagesNerc(id);
	}
	
	public String getRicerca(Nerc nerc,int anni, int ore){
		Ricerca ricerca=new Ricerca();
		return ricerca.trova(nerc, anni, ore);
	}

}
