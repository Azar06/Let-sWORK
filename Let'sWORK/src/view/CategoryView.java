package view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import business.facade.CategoryFacade;
import business.facade.UserFacade;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.SpinnerListModel;


public class CategoryView extends AbstractView implements ActionListener {

	private CategoryFacade facade;
	private JTextField newNameField;
	private JTextField newShortdescrField;
	private JTextField updateNameField;
	private JTextField updateShortdescrField;
	
	public CategoryView() {
		this.facade = new CategoryFacade();
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JScrollPane scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 65, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -29, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, -86, SpringLayout.EAST, this);
		add(scrollPane);
		
		JLabel lblCategories = new JLabel("Categories");
		springLayout.putConstraint(SpringLayout.SOUTH, lblCategories, -6, SpringLayout.NORTH, scrollPane);
		lblCategories.setFont(new Font("Tahoma", Font.PLAIN, 40));
		add(lblCategories);
		
		JButton btnMenuProducts = new JButton("Products");
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 16, SpringLayout.EAST, btnMenuProducts);
		springLayout.putConstraint(SpringLayout.NORTH, btnMenuProducts, 155, SpringLayout.NORTH, this);
		btnMenuProducts.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(btnMenuProducts);
		
		JButton btnMenuServices = new JButton("Services");
		springLayout.putConstraint(SpringLayout.NORTH, btnMenuServices, 8, SpringLayout.SOUTH, btnMenuProducts);
		springLayout.putConstraint(SpringLayout.EAST, btnMenuServices, -627, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.EAST, btnMenuProducts, 0, SpringLayout.EAST, btnMenuServices);
		btnMenuServices.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(btnMenuServices);
		
		JButton btnMenuCategories = new JButton("Categories");
		springLayout.putConstraint(SpringLayout.NORTH, btnMenuCategories, 6, SpringLayout.SOUTH, btnMenuServices);
		springLayout.putConstraint(SpringLayout.EAST, btnMenuCategories, 0, SpringLayout.EAST, btnMenuProducts);
		btnMenuCategories.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lblNewCategory = new JLabel("New category");
		lblNewCategory.setFont(new Font("Tahoma", Font.PLAIN, 20));
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewCategory, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewCategory, 10, SpringLayout.WEST, panel);
		panel.add(lblNewCategory);
		
		JLabel lblName = new JLabel("Name");
		sl_panel.putConstraint(SpringLayout.NORTH, lblName, 9, SpringLayout.SOUTH, lblNewCategory);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sl_panel.putConstraint(SpringLayout.WEST, lblName, 10, SpringLayout.WEST, lblNewCategory);
		panel.add(lblName);
		
		newNameField = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, newNameField, -1, SpringLayout.NORTH, lblName);
		sl_panel.putConstraint(SpringLayout.WEST, newNameField, 6, SpringLayout.EAST, lblName);
		sl_panel.putConstraint(SpringLayout.EAST, newNameField, 228, SpringLayout.EAST, lblName);
		panel.add(newNameField);
		newNameField.setColumns(10);
		
		JLabel lblShortDescription = new JLabel("Short description");
		sl_panel.putConstraint(SpringLayout.NORTH, lblShortDescription, 7, SpringLayout.SOUTH, newNameField);
		sl_panel.putConstraint(SpringLayout.EAST, lblShortDescription, 0, SpringLayout.EAST, lblNewCategory);
		lblShortDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblShortDescription);
		
		newShortdescrField = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, newShortdescrField, -1, SpringLayout.NORTH, lblShortDescription);
		sl_panel.putConstraint(SpringLayout.WEST, newShortdescrField, 6, SpringLayout.EAST, lblShortDescription);
		sl_panel.putConstraint(SpringLayout.EAST, newShortdescrField, -33, SpringLayout.EAST, panel);
		panel.add(newShortdescrField);
		newShortdescrField.setColumns(10);
		
		JLabel lblLongDescription = new JLabel("Long description");
		sl_panel.putConstraint(SpringLayout.NORTH, lblLongDescription, 13, SpringLayout.SOUTH, lblShortDescription);
		sl_panel.putConstraint(SpringLayout.WEST, lblLongDescription, 0, SpringLayout.WEST, lblName);
		lblLongDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblLongDescription);
		
		JTextArea newLongdescrArea = new JTextArea();
		sl_panel.putConstraint(SpringLayout.NORTH, newLongdescrArea, 10, SpringLayout.SOUTH, newShortdescrField);
		sl_panel.putConstraint(SpringLayout.WEST, newLongdescrArea, 6, SpringLayout.EAST, lblLongDescription);
		panel.add(newLongdescrArea);
		
		JSeparator separator = new JSeparator();
		sl_panel.putConstraint(SpringLayout.SOUTH, newLongdescrArea, -6, SpringLayout.NORTH, separator);
		sl_panel.putConstraint(SpringLayout.NORTH, separator, 151, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, separator, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, separator, -10, SpringLayout.EAST, panel);
		panel.add(separator);
		
		JLabel lblUpdateACategory = new JLabel("Update a category");
		sl_panel.putConstraint(SpringLayout.SOUTH, separator, -7, SpringLayout.NORTH, lblUpdateACategory);
		sl_panel.putConstraint(SpringLayout.NORTH, lblUpdateACategory, 160, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblUpdateACategory, 0, SpringLayout.WEST, lblNewCategory);
		lblUpdateACategory.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblUpdateACategory);
		
		JLabel lblCategoryName = new JLabel("Category name");
		sl_panel.putConstraint(SpringLayout.EAST, lblCategoryName, 0, SpringLayout.EAST, lblLongDescription);
		lblCategoryName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblCategoryName);
		
		JSpinner updateCategorynameSpinner = new JSpinner();
		sl_panel.putConstraint(SpringLayout.NORTH, updateCategorynameSpinner, 9, SpringLayout.SOUTH, lblUpdateACategory);
		sl_panel.putConstraint(SpringLayout.WEST, updateCategorynameSpinner, 6, SpringLayout.EAST, lblCategoryName);
		sl_panel.putConstraint(SpringLayout.EAST, updateCategorynameSpinner, -126, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblCategoryName, 1, SpringLayout.NORTH, updateCategorynameSpinner);
		updateCategorynameSpinner.setModel(new SpinnerListModel(new String[] {"Category 1"}));
		panel.add(updateCategorynameSpinner);
		
		JLabel lblDeleteACategory = new JLabel("Delete a category");
		sl_panel.putConstraint(SpringLayout.WEST, lblDeleteACategory, 0, SpringLayout.WEST, lblNewCategory);
		lblDeleteACategory.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblDeleteACategory);
		
		JLabel lblDelCategoryName = new JLabel("Category name");
		sl_panel.putConstraint(SpringLayout.NORTH, lblDelCategoryName, 424, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblDeleteACategory, -6, SpringLayout.NORTH, lblDelCategoryName);
		sl_panel.putConstraint(SpringLayout.EAST, lblDelCategoryName, 0, SpringLayout.EAST, lblLongDescription);
		lblDelCategoryName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblDelCategoryName);
		
		JSpinner deleteCategorynameSpinner = new JSpinner();
		sl_panel.putConstraint(SpringLayout.NORTH, deleteCategorynameSpinner, -1, SpringLayout.NORTH, lblDelCategoryName);
		sl_panel.putConstraint(SpringLayout.WEST, deleteCategorynameSpinner, 0, SpringLayout.WEST, newLongdescrArea);
		sl_panel.putConstraint(SpringLayout.EAST, deleteCategorynameSpinner, 0, SpringLayout.EAST, updateCategorynameSpinner);
		deleteCategorynameSpinner.setModel(new SpinnerListModel(new String[] {"Category 1"}));
		panel.add(deleteCategorynameSpinner);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setEnabled(false);
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		sl_panel.putConstraint(SpringLayout.WEST, btnUpdate, 0, SpringLayout.WEST, btnDelete);
		sl_panel.putConstraint(SpringLayout.NORTH, btnDelete, -4, SpringLayout.NORTH, lblDelCategoryName);
		sl_panel.putConstraint(SpringLayout.EAST, btnDelete, 0, SpringLayout.EAST, newShortdescrField);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnDelete);
		
		JSeparator separator_1 = new JSeparator();
		sl_panel.putConstraint(SpringLayout.NORTH, separator_1, 385, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, separator_1, -6, SpringLayout.NORTH, lblDeleteACategory);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnUpdate, -6, SpringLayout.NORTH, separator_1);
		sl_panel.putConstraint(SpringLayout.WEST, separator_1, 0, SpringLayout.WEST, lblNewCategory);
		sl_panel.putConstraint(SpringLayout.EAST, separator_1, 0, SpringLayout.EAST, separator);
		panel.add(separator_1);
		
		JButton btnAdd = new JButton("Add");
		sl_panel.putConstraint(SpringLayout.EAST, newLongdescrArea, -6, SpringLayout.WEST, btnAdd);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnAdd, -6, SpringLayout.NORTH, separator);
		sl_panel.putConstraint(SpringLayout.EAST, btnAdd, 0, SpringLayout.EAST, newShortdescrField);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnAdd);
		
		JLabel lblUpdateName = new JLabel("Name");
		lblUpdateName.setEnabled(false);
		sl_panel.putConstraint(SpringLayout.NORTH, lblUpdateName, 19, SpringLayout.SOUTH, lblCategoryName);
		sl_panel.putConstraint(SpringLayout.WEST, lblUpdateName, 54, SpringLayout.WEST, panel);
		panel.add(lblUpdateName);
		
		updateNameField = new JTextField();
		updateNameField.setEnabled(false);
		sl_panel.putConstraint(SpringLayout.WEST, updateNameField, 6, SpringLayout.EAST, lblUpdateName);
		sl_panel.putConstraint(SpringLayout.EAST, updateNameField, -208, SpringLayout.EAST, panel);
		panel.add(updateNameField);
		updateNameField.setColumns(10);
		
		JLabel lblUpdateShortDescription = new JLabel("Short description");
		lblUpdateShortDescription.setEnabled(false);
		sl_panel.putConstraint(SpringLayout.NORTH, lblUpdateShortDescription, 9, SpringLayout.SOUTH, updateNameField);
		panel.add(lblUpdateShortDescription);
		
		updateShortdescrField = new JTextField();
		updateShortdescrField.setEnabled(false);
		sl_panel.putConstraint(SpringLayout.EAST, lblUpdateShortDescription, -6, SpringLayout.WEST, updateShortdescrField);
		sl_panel.putConstraint(SpringLayout.SOUTH, updateNameField, -6, SpringLayout.NORTH, updateShortdescrField);
		sl_panel.putConstraint(SpringLayout.EAST, updateShortdescrField, 0, SpringLayout.EAST, newShortdescrField);
		sl_panel.putConstraint(SpringLayout.NORTH, updateShortdescrField, 261, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, updateShortdescrField, 157, SpringLayout.WEST, panel);
		panel.add(updateShortdescrField);
		updateShortdescrField.setColumns(10);
		
		JLabel lblUpdateLongDescription = new JLabel("Long description");
		lblUpdateLongDescription.setEnabled(false);
		sl_panel.putConstraint(SpringLayout.NORTH, lblUpdateLongDescription, 17, SpringLayout.SOUTH, lblUpdateShortDescription);
		sl_panel.putConstraint(SpringLayout.WEST, lblUpdateLongDescription, 0, SpringLayout.WEST, lblUpdateName);
		panel.add(lblUpdateLongDescription);
		
		JTextArea updateLongdescrArea = new JTextArea();
		updateLongdescrArea.setEnabled(false);
		sl_panel.putConstraint(SpringLayout.NORTH, updateLongdescrArea, -3, SpringLayout.NORTH, lblUpdateLongDescription);
		sl_panel.putConstraint(SpringLayout.WEST, updateLongdescrArea, 0, SpringLayout.WEST, updateShortdescrField);
		sl_panel.putConstraint(SpringLayout.SOUTH, updateLongdescrArea, -20, SpringLayout.NORTH, separator_1);
		sl_panel.putConstraint(SpringLayout.EAST, updateLongdescrArea, -6, SpringLayout.WEST, btnUpdate);
		panel.add(updateLongdescrArea);
		btnMenuCategories.setEnabled(false);
		add(btnMenuCategories);
		
		JButton btnLogOut = new JButton("Log out");
		springLayout.putConstraint(SpringLayout.EAST, lblCategories, -147, SpringLayout.WEST, btnLogOut);
		springLayout.putConstraint(SpringLayout.SOUTH, btnLogOut, -6, SpringLayout.NORTH, scrollPane);
		springLayout.putConstraint(SpringLayout.EAST, btnLogOut, 0, SpringLayout.EAST, scrollPane);
		add(btnLogOut);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
