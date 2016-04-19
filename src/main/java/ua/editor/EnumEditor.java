package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.Sex;

public class EnumEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(Sex.valueOf(text));
	}
	
	
}
