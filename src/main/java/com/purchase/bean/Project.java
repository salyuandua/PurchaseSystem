package com.purchase.bean;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="project")
public class Project implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="project_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	@Column(name="project_name")
	private String name;
	
	@NotBlank
	@Column(name="project_location")
	private String location;
	
	@NotBlank
	@Column(name="project_contact_name")
	private String contactName;
	
	@NotBlank
	@Column(name="project_contact_phone")
	private String contactPhone;
	
	@NotBlank
	@Column(name="project_contact_email")
	private String contactEmail;
	
	@Size(min=1)
	@OneToMany(targetEntity=Equipment.class,cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="equipemnt_project")
	private Set<Equipment> equipments;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="project_state")
	private ProjectState state;
	
	public Project() {
		//set default state
		state=new ProjectState();
		state.setId(1);
	}
	
	
	
	public Project(String name, String location, String contactName, String contactPhone, String contactEmail,
			Set<Equipment> equipments) {
		this();
		this.name = name;
		this.location = location;
		this.contactName = contactName;
		this.contactPhone = contactPhone;
		this.contactEmail = contactEmail;
		this.equipments = equipments;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public Set<Equipment> getEquipments() {
		return equipments;
	}

	public void setEquipments(Set<Equipment> equipments) {
		this.equipments = equipments;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public ProjectState getState() {
		return state;
	}



	public void setState(ProjectState state) {
		this.state = state;
	}



	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", location=" + location + ", contactName=" + contactName
				+ ", contactPhone=" + contactPhone + ", contactEmail=" + contactEmail + ", equipments=" + equipments
				+ ", state=" + state + "]";
	}
	
	
	
	
	
}
