/*
 * Hibernate OGM, Domain model persistence for NoSQL datastores
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package com.simavirtual;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

/**
 * A person organizing hikes.
 *
 * @author Gunnar Morling
 */
@Entity
@Indexed
public class Person {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	@Field( analyze = Analyze.NO )
	private String firstName;

	@Field( analyze = Analyze.NO )
	private String lastName;

	@OneToMany(mappedBy = "organizer", cascade = CascadeType.PERSIST)
	private Set<Hike> organizedHikes = new HashSet<>();

	// constructors, getters and setters...

	Person() {
	}

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Hike> getOrganizedHikes() {
		return organizedHikes;
	}

	public void setOrganizedHikes(Set<Hike> organizedHikes) {
		this.organizedHikes = organizedHikes;
	}
}