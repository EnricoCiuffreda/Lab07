package it.polito.tdp.poweroutages.model;

import java.time.LocalDateTime;

public class Poweroutage {
	private Integer id;
	private Integer event_type_id;
	private Integer tag_id;
	private Integer area_id;
	private Integer nerc_id;
	private Integer responsible_id;
	private Integer customers_affected;
	private LocalDateTime data_event_began;
	private LocalDateTime data_event_finished;
	private Integer demand_loss;
	
	
	/**
	 * @param id
	 * @param event_type_id
	 * @param tag_id
	 * @param area_id
	 * @param nerc_id
	 * @param responsible_id
	 * @param customers_affected
	 * @param data_event_began
	 * @param data_event_finished
	 * @param demand_loss
	 */
	public Poweroutage(Integer id, Integer event_type_id, Integer tag_id, Integer area_id, Integer nerc_id,
			Integer responsible_id, Integer customers_affected, LocalDateTime data_event_began,
			LocalDateTime data_event_finished, Integer demand_loss) {
		super();
		this.id = id;
		this.event_type_id = event_type_id;
		this.tag_id = tag_id;
		this.area_id = area_id;
		this.nerc_id = nerc_id;
		this.responsible_id = responsible_id;
		this.customers_affected = customers_affected;
		this.data_event_began = data_event_began;
		this.data_event_finished = data_event_finished;
		this.demand_loss = demand_loss;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getEvent_type_id() {
		return event_type_id;
	}
	public void setEvent_type_id(Integer event_type_id) {
		this.event_type_id = event_type_id;
	}
	public Integer getTag_id() {
		return tag_id;
	}
	public void setTag_id(Integer tag_id) {
		this.tag_id = tag_id;
	}
	public Integer getArea_id() {
		return area_id;
	}
	public void setArea_id(Integer area_id) {
		this.area_id = area_id;
	}
	public Integer getNerc_id() {
		return nerc_id;
	}
	public void setNerc_id(Integer nerc_id) {
		this.nerc_id = nerc_id;
	}
	public Integer getResponsible_id() {
		return responsible_id;
	}
	public void setResponsible_id(Integer responsible_id) {
		this.responsible_id = responsible_id;
	}
	public Integer getCustomers_affected() {
		return customers_affected;
	}
	public void setCustomers_affected(Integer customers_affected) {
		this.customers_affected = customers_affected;
	}
	public LocalDateTime getData_event_began() {
		return data_event_began;
	}
	public void setData_event_began(LocalDateTime data_event_began) {
		this.data_event_began = data_event_began;
	}
	public LocalDateTime getData_event_finished() {
		return data_event_finished;
	}
	public void setData_event_finished(LocalDateTime data_event_finished) {
		this.data_event_finished = data_event_finished;
	}
	public Integer getDemand_loss() {
		return demand_loss;
	}
	public void setDemand_loss(Integer demand_loss) {
		this.demand_loss = demand_loss;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Poweroutage other = (Poweroutage) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return data_event_began +"  "+ data_event_finished + "  [" + customers_affected + "]  \n";
	}
	
	

}
