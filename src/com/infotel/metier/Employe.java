package com.infotel.metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//Methode 1
@DiscriminatorValue("EMP")
public class Employe extends Personne{
	
	private double salaire;

	public double getSalaire() {
		return salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

	@Override
	public String toString() {
		return "Employe [salaire=" + salaire + "]";
	}
	
	

}
