package com.mmm.dsjsm.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="group", schema="endeca_db")
public class Group implements Serializable {
	private static final long serialVersionUID = -2042323568022489725L;

	@Id
	@GeneratedValue
	private Long id;
	private String groupName;
	@OneToMany(mappedBy="group")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Student> students;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "curator_fk")
	private Teacher curator;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Teacher getCurator() {
		return curator;
	}

	public void setCurator(Teacher curator) {
		this.curator = curator;
	}
}
