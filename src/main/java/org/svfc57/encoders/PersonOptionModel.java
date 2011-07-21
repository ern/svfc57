package org.svfc57.encoders;

import java.util.Map;

import org.apache.tapestry5.OptionModel;
import org.svfc57.entities.Person;

public class PersonOptionModel implements OptionModel {

	private Person person;

	public PersonOptionModel(Person person) {
		this.person = person;
	}
	
	@Override
	public Map<String, String> getAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLabel() {
		return person.firstName + " " + person.lastName;
	}

	@Override
	public Object getValue() {
		return person;
	}

	@Override
	public boolean isDisabled() {
		// TODO Auto-generated method stub
		return false;
	}

}
