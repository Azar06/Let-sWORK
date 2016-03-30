package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import business.facade.CategoryFacade;
import business.facade.UserFacade;
import business.utils.CategoryReturnState;
import persistence.Category;
import persistence.CategorySet;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.SpinnerListModel;


public class CategoryView extends AbstractContentView implements ActionListener {

	private CategoryFacade facade;
	private JTextField newNameField;
	private JTextArea newDescrArea;
	private JTextField updateNameField;
	private JTextArea updateDescrArea;
	private JSpinner updateCategorynameSpinner;
	private JSpinner deleteCategorynameSpinner;
	private CategorySet categories;
	private Category selectedCategory;
	private Category selectedCategoryToDelete = null;

	public CategoryView() {
		this.facade = new CategoryFacade();
		setLayout(null);
		this.categories = this.facade.getCategorySet();
		this.selectedCategory = null;

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 25, 525, 506);
		add(scrollPane);

		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);

		JLabel lblNewCategory = new JLabel("New category");
		lblNewCategory.setBounds(10, 10, 122, 25);
		lblNewCategory.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblNewCategory);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(20, 44, 39, 19);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblName);

		newNameField = new JTextField();
		newNameField.setBounds(65, 43, 222, 22);
		panel.add(newNameField);
		newNameField.setColumns(10);

		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(20, 89, 78, 19);
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblDescription);

		newDescrArea = new JTextArea();
		newDescrArea.setBounds(100, 89, 327, 56);
		panel.add(newDescrArea);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 151, 503, 2);
		panel.add(separator);

		JLabel lblUpdateACategory = new JLabel("Update a category");
		lblUpdateACategory.setBounds(10, 160, 164, 25);
		lblUpdateACategory.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblUpdateACategory);

		JLabel lblCategoryName = new JLabel("Category name");
		lblCategoryName.setBounds(23, 195, 101, 19);
		lblCategoryName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblCategoryName);

		JLabel lblDeleteACategory = new JLabel("Delete a category");
		lblDeleteACategory.setBounds(10, 393, 159, 25);
		lblDeleteACategory.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblDeleteACategory);

		JLabel lblDelCategoryName = new JLabel("Category name");
		lblDelCategoryName.setBounds(23, 424, 101, 19);
		lblDelCategoryName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblDelCategoryName);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(417, 352, 96, 27);
		btnUpdate.setEnabled(false);
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnUpdate);
		btnUpdate.addActionListener(this);
		btnUpdate.setActionCommand("update");

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(417, 420, 96, 27);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDelete.setEnabled(false);
		btnDelete.setActionCommand("delete");
		btnDelete.addActionListener(this);
		panel.add(btnDelete);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 385, 503, 2);
		panel.add(separator_1);

		JLabel lblUpdateName = new JLabel("Name");
		lblUpdateName.setBounds(54, 233, 33, 16);
		lblUpdateName.setEnabled(false);
		panel.add(lblUpdateName);

		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(433, 118, 80, 27);
		panel.add(btnAdd);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdd.addActionListener(this);
		btnAdd.setActionCommand("add");

		updateNameField = new JTextField();
		updateNameField.setBounds(93, 233, 222, 22);
		updateNameField.setEnabled(false);
		panel.add(updateNameField);
		updateNameField.setColumns(10);

		JLabel lblUpdateDescription = new JLabel("Description");
		lblUpdateDescription.setBounds(54, 271, 69, 16);
		lblUpdateDescription.setEnabled(false);
		panel.add(lblUpdateDescription);

		updateDescrArea = new JTextArea();
		updateDescrArea.setBounds(130, 268, 283, 71);
		updateDescrArea.setEnabled(false);
		panel.add(updateDescrArea);

		updateCategorynameSpinner = new JSpinner();
		updateCategorynameSpinner.setBounds(130, 194, 267, 22);
		deleteCategorynameSpinner = new JSpinner();
		deleteCategorynameSpinner.setBounds(130, 423, 267, 22);

		ArrayList<String> catList = new ArrayList<String>();
		catList.add("");
		catList.addAll(this.categories.getNames());
		updateCategorynameSpinner.setModel(new SpinnerListModel(catList));
		deleteCategorynameSpinner.setModel(new SpinnerListModel(catList));
		updateCategorynameSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				String nameWrite = (String) updateCategorynameSpinner.getValue();
				selectedCategory = categories.getCategoryWithName(nameWrite);
				if(selectedCategory == null) {
					updateNameField.setText("");
					updateDescrArea.setText("");
					lblUpdateName.setEnabled(false);
					updateNameField.setEnabled(false);
					lblUpdateDescription.setEnabled(false);
					updateDescrArea.setEnabled(false);
					btnUpdate.setEnabled(false);
				}
				else {
					lblUpdateName.setEnabled(true);
					updateNameField.setEnabled(true);
					lblUpdateDescription.setEnabled(true);
					updateDescrArea.setEnabled(true);
					btnUpdate.setEnabled(true);
					updateNameField.setText(selectedCategory.getName());
					updateDescrArea.setText(selectedCategory.getDescription());
				}
			}
		});
		deleteCategorynameSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				String nameWrite = (String) deleteCategorynameSpinner.getValue();
				selectedCategoryToDelete = categories.getCategoryWithName(nameWrite);
				if(selectedCategoryToDelete == null) {
					btnDelete.setEnabled(false);
				}
				else {
					btnDelete.setEnabled(true);
				}
			}
		});
		panel.add(updateCategorynameSpinner);
		panel.add(deleteCategorynameSpinner);
	}

	/**
	 * Get the name of the category to create, write in the text field from the panel INSERT
	 * @return the text write in the text field from the panel INSERT
	 */
	public String getNewNameText()
	{
		return this.newNameField.getText();
	}

	/**
	 * Get the description of the category to create, write in the text field from the panel INSERT
	 * @return the text write in the text field from the panel INSERT
	 */
	public String getNewDescrText()
	{
		return this.newDescrArea.getText();
	}

	/**
	 * Get the name of the category to update, write in the text field from the panel UPDATE
	 * @return the text write in the text field from the panel UPDATE
	 */
	public String getUpdateNameText()
	{
		return this.updateNameField.getText();
	}

	/**
	 * Get the description of the category to update, write in the text field from the panel UPDATE
	 * @return the text write in the text field from the panel UPDATE
	 */
	public String getUpdateDescrText()
	{
		return this.updateDescrArea.getText();
	}

	/**
	 * After the click on the button, the function start the insertion, the modification or the suppression of a category
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String cmd = arg0.getActionCommand();
		if(cmd.equals("add"))
		{
			String newName = getNewNameText();
			String newDescr = getNewDescrText();
			if(newName.equals("") || newDescr.equals("")) { // si tous les champs ne sont pas renseignes
				String message = "All fields must be filled in.";
				JOptionPane.showMessageDialog(null, message, "Missing fields", JOptionPane.ERROR_MESSAGE);
			}
			else {
				CategoryReturnState returnState = this.facade.create(newName, newDescr);
				if(returnState.isRight()) {
					String message = "Category " + newName + " created.";
					JOptionPane.showMessageDialog(null, message, "Creation completed", JOptionPane.INFORMATION_MESSAGE);
					this.getMainView().setContentView(new CategoryView());
				}
				else {
					String message = "Error at the creation of the new category. Maybe a category with the same name is already existent.";
					JOptionPane.showMessageDialog(null, message, "Creation failed", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		else if(cmd.equals("update")) {
			String updName = getUpdateNameText();
			String updDescr = getUpdateDescrText();
			if(updName.equals("") || updDescr.equals("")) { // si tous les champs ne sont pas renseignes
				String message = "All fields must be filled in.";
				JOptionPane.showMessageDialog(null, message, "Missing fields", JOptionPane.ERROR_MESSAGE);
			}
			else {
				if(this.selectedCategory != null) {
					String oldName = this.selectedCategory.getName();
					this.selectedCategory.setName(updName);
					this.selectedCategory.setDescription(updDescr);
					CategoryReturnState returnState = this.facade.save(this.selectedCategory);
					if(returnState.isRight()) {
						String message = "Category " + oldName + " updated to " + updName + ".";
						JOptionPane.showMessageDialog(null, message, "Update completed", JOptionPane.INFORMATION_MESSAGE);
						this.getMainView().setContentView(new CategoryView());
					}
					else {
						String message = "Error at the update of the category. Maybe a category with the same name is already existent.";
						JOptionPane.showMessageDialog(null, message, "Update failed", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
		else if(cmd.equals("delete")) {
			if(this.selectedCategoryToDelete != null) {
				String oldName = this.selectedCategoryToDelete.getName();
				boolean delete = this.facade.delete(this.selectedCategoryToDelete);
				if(delete) {
					String message = "Category " + oldName + " is deleted.";
					JOptionPane.showMessageDialog(null, message, "Update completed", JOptionPane.INFORMATION_MESSAGE);
					this.getMainView().setContentView(new CategoryView());
				}
				else {
					String message = "Error at the delete of the category.";
					JOptionPane.showMessageDialog(null, message, "Update failed", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	/**
	 * Display "Categories" for the title of the view
	 */
	@Override
	public String getTitle() {
		return "Categories";
	}
}
