package de.urszeidler.eclipse.solidity.ui.preferences;

import org.eclipse.jface.preference.*;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.IWorkbench;
import de.urszeidler.eclipse.solidity.ui.Activator;

/**
 * This class represents a preference page that is contributed to the
 * Preferences dialog. By subclassing <samp>FieldEditorPreferencePage</samp>, we
 * can use the field support built into JFace that allows us to create a page
 * that is small and knows how to save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They are stored in the
 * preference store that belongs to the main plug-in class. That way,
 * preferences can be accessed directly via the preference store.
 */

public class SolidityGenerationPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public SolidityGenerationPreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("The solidity generation preferences.");
	}

	/**
	 * Creates the field editors. Field editors are abstractions of the common
	 * GUI blocks needed to manipulate various types of preferences. Each field
	 * editor knows how to save and restore itself.
	 */
	public void createFieldEditors() {
		addField(new StringFieldEditor(PreferenceConstants.GENERATION_TARGET, "generate to directory", -1,
				StringFieldEditor.VALIDATE_ON_KEY_STROKE, getFieldEditorParent()));

		addField(new BooleanFieldEditor(PreferenceConstants.GENERATE_HTML, "generate mix html",
				BooleanFieldEditor.DEFAULT, getFieldEditorParent()));
		addField(new BooleanFieldEditor(PreferenceConstants.GENERATE_MIX, "generate mix config",
				BooleanFieldEditor.DEFAULT, getFieldEditorParent()));
		addField(new BooleanFieldEditor(PreferenceConstants.GENERATE_WEB3, "generate web3 interface",
				BooleanFieldEditor.DEFAULT, getFieldEditorParent()));

		addField(new StringFieldEditor(PreferenceConstants.GENERATION_TARGET_DOC, "generate doc to directory", -1,
				StringFieldEditor.VALIDATE_ON_KEY_STROKE, getFieldEditorParent()));
		addField(new BooleanFieldEditor(PreferenceConstants.GENERATE_MARKDOWN, "generate markdown report",
				BooleanFieldEditor.DEFAULT, getFieldEditorParent()));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}

}