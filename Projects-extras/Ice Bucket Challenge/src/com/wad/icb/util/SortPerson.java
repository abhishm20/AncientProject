package com.wad.icb.util;

import java.util.Comparator;

import com.wad.icb.dao.PersonDTO;

public class SortPerson implements Comparator<PersonDTO>{

	
	@Override
	public int compare(PersonDTO e1, PersonDTO e2) {
		if(e1.getId() > e2.getId()){
			return 1;
		} else {
			return -1;
		}
	}
}
