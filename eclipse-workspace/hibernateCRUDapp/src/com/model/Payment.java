package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate( value= true)
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int salary;
	private int salary_Cut;

	@Override
	public String toString() {
		return "Payment [salary=" + salary + ", salary_Cut=" + salary_Cut + "]";
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getSalary_Cut() {
		return salary_Cut;
	}

	public void setSalary_Cut(int salary_Cut) {
		this.salary_Cut = salary_Cut;
	}
}
