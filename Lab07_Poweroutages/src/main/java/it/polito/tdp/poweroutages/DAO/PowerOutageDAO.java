package it.polito.tdp.poweroutages.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.time.*;

import it.polito.tdp.poweroutages.model.Nerc;
import it.polito.tdp.poweroutages.model.Poweroutage;

public class PowerOutageDAO {
	
	public List<Nerc> getNercList() {

		String sql = "SELECT id, value FROM nerc";
		List<Nerc> nercList = new ArrayList<>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				Nerc n = new Nerc(res.getInt("id"), res.getString("value"));
				nercList.add(n);
			}

			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return nercList;
	}
	
	
	public List<Poweroutage> getPoweroutagesNerc(Integer id){

		String sql = "SELECT p.id,event_type_id,tag_id,area_id,nerc_id,responsible_id,customers_affected,date_event_began,date_event_finished,demand_loss FROM poweroutages AS p,nerc WHERE nerc.id=? AND p.nerc_id=nerc.id ORDER BY  p.id desc";
		List<Poweroutage> poweroutages = new ArrayList<>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet res = st.executeQuery();
			while (res.next()) {
				Poweroutage n = new Poweroutage(res.getInt("p.id"),res.getInt("event_type_id"),res.getInt("tag_id"),res.getInt("area_id"),
						                        res.getInt("nerc_id"),res.getInt("responsible_id"),res.getInt("customers_affected"),
						                        res.getObject("date_event_began",LocalDateTime.class),res.getObject("date_event_finished",LocalDateTime.class),res.getInt("demand_loss"));
				poweroutages.add(n);
			}

			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return poweroutages;
	}

}
