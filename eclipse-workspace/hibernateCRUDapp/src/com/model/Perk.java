package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate( value= true)
public class Perk {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eid;
	private String bonus;
	private String glocary;
	private String cloths;

	@Override
	public String toString() {
		return "Perk [eid=" + eid + ", bonus=" + bonus + ", glocary=" + glocary + ", cloths=" + cloths + "]";
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getBonus() {
		return bonus;
	}

	public void setBonus(String bonus) {
		this.bonus = bonus;
	}

	public String getGlocary() {
		return glocary;
	}

	public void setGlocary(String glocary) {
		this.glocary = glocary;
	}

	public String getCloths() {
		return cloths;
	}

	public void setCloths(String cloths) {
		this.cloths = cloths;
	}

}
