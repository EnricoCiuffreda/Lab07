package it.polito.tdp.poweroutages.model;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.poweroutages.DAO.PowerOutageDAO;

public class Ricerca {
	private List <Poweroutage> soluzione;
	private int massimo=0;
	private int oremassimo=0;
	private List<Poweroutage> tutti;
	
	
	public String trova(Nerc nerc,int anni,int ore){
	    String stampa="";
		PowerOutageDAO dao=new PowerOutageDAO();
		tutti=dao.getPoweroutagesNerc(nerc.getId());
		List <Poweroutage> parziale=new ArrayList<>();
		cerca(parziale,0,anni,ore);
		for(Poweroutage p:soluzione) {
			stampa+=p.toString();
		}
		stampa+="\n   "+ massimo+"  "+ oremassimo;
		return stampa;
	}
	
	private void cerca(List<Poweroutage> parziale,int livello,int anni,int ore){
		int massimoparziale=0;
		int oreparziale=0;
		//calcolo delle ore
		for(Poweroutage p:parziale) {
			oreparziale+=p.getData_event_began().until(p.getData_event_finished(), ChronoUnit.HOURS);	
		}
		//System.out.println(oreparziale);
		//condizione uscita 
		if(oreparziale>ore) {
			return;
		}
		//calcolo delle persone
		for(Poweroutage p:parziale) {
			massimoparziale+=p.getCustomers_affected();
		}
		//System.out.println(massimoparziale);
		//System.out.println(parziale);
		//elimino soluzioni con troppi anni
		if(parziale.size()>=2) {
			if(parziale.get(0).getData_event_began().until(parziale.get(parziale.size()-1).getData_event_finished(), ChronoUnit.YEARS)>anni) {
				return;
			}
		}
		//aggiornamento soluzione
		if(massimoparziale>massimo) {
			soluzione=new ArrayList<>(parziale);
			massimo=massimoparziale;
			oremassimo=oreparziale;
		}		
		if(livello==(tutti.size())) {
			return;
		}
		parziale.add(tutti.get(livello));
		cerca(parziale,livello+1,anni,ore);
		parziale.remove(tutti.get(livello));
		//provo a non aggiungerlo
		cerca(parziale,livello+1,anni,ore);
		
	}

}
