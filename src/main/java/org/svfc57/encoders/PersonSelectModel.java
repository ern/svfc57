package org.svfc57.encoders;

import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry5.OptionGroupModel;
import org.apache.tapestry5.OptionModel;
import org.apache.tapestry5.util.AbstractSelectModel;
import org.svfc57.entities.Person;

public class PersonSelectModel extends AbstractSelectModel {

	private List<Person> persons;
	
	public PersonSelectModel(List<Person> persons) {
		this.persons = persons;
	}

	@Override
	public List<OptionGroupModel> getOptionGroups() {
		return null;
	}

	@Override
	public List<OptionModel> getOptions() {
		List<OptionModel> list = new ArrayList<OptionModel>();
		
		for(Person p : persons) {
			list.add(new PersonOptionModel(p));
		}
		
		return list;
	}

}
