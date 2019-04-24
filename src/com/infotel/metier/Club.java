package com.infotel.metier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Club {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idClub;
	private String nomClub;
	
	@ManyToMany (mappedBy = "clubs")
	private List<Personne> personnes = new ArrayList<Personne>();

	public int getIdClub() {
		return idClub;
	}

	public void setIdClub(int idClub) {
		this.idClub = idClub;
	}

	public String getNomClub() {
		return nomClub;
	}

	public void setNomClub(String nomClub) {
		this.nomClub = nomClub;
	}

	@Override
	public String toString() {
		return "Club [idClub=" + idClub + ", nomClub=" + nomClub + "]";
	}




	
	
}
