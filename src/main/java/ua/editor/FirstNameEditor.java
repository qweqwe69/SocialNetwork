package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.service.FirstNameService;

public class FirstNameEditor extends PropertyEditorSupport {
	
	private final FirstNameService firstNameService;

	public FirstNameEditor(FirstNameService firstNameService) {
		this.firstNameService = firstNameService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(firstNameService.findOne(Integer.valueOf(text)));
	} 
	
	

}
