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


public class CategoryView extends AbstractView implements ActionListener {

	private CategoryFacade facade;
	private JTextField newNameField;
	private JTextField newShortdescrField;
	
	public CategoryView() {
		this.facade = new CategoryFacade();
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JScrollPane scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -63, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, -10, SpringLayout.EAST, this);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane);
		
		JLabel lblCategories = new JLabel("Categories");
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 13, SpringLayout.SOUTH, lblCategories);
		springLayout.putConstraint(SpringLayout.NORTH, lblCategories, 20, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblCategories, 177, SpringLayout.WEST, this);
		lblCategories.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblCategories);
		
		JButton btnNewButton = new JButton("Products");
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 20, SpringLayout.WEST, this);
		add(btnNewButton);
		
		JButton btnServices = new JButton("Services");
		springLayout.putConstraint(SpringLayout.EAST, btnServices, -349, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, -6, SpringLayout.NORTH, btnServices);
		add(btnServices);
		
		JButton btnCategories = new JButton("Categories");
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 4, SpringLayout.EAST, btnCategories);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lblNewCategory = new JLabel("New category");
		lblNewCategory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewCategory, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewCategory, 10, SpringLayout.WEST, panel);
		panel.add(lblNewCategory);
		
		JLabel lblName = new JLabel("Name");
		sl_panel.putConstraint(SpringLayout.WEST, lblName, 10, SpringLayout.WEST, lblNewCategory);
		panel.add(lblName);
		
		newNameField = new JTextField();
		sl_panel.putConstraint(SpringLayout.WEST, newNameField, 7, SpringLayout.EAST, lblName);
		sl_panel.putConstraint(SpringLayout.NORTH, lblName, 3, SpringLayout.NORTH, newNameField);
		sl_panel.putConstraint(SpringLayout.NORTH, newNameField, 6, SpringLayout.SOUTH, lblNewCategory);
		panel.add(newNameField);
		newNameField.setColumns(10);
		
		JLabel lblShortDescription = new JLabel("Short description");
		sl_panel.putConstraint(SpringLayout.NORTH, lblShortDescription, 9, SpringLayout.SOUTH, newNameField);
		sl_panel.putConstraint(SpringLayout.EAST, lblShortDescription, -193, SpringLayout.EAST, panel);
		panel.add(lblShortDescription);
		
		newShortdescrField = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, newShortdescrField, -3, SpringLayout.NORTH, lblShortDescription);
		sl_panel.putConstraint(SpringLayout.WEST, newShortdescrField, 6, SpringLayout.EAST, lblShortDescription);
		sl_panel.putConstraint(SpringLayout.EAST, newShortdescrField, -10, SpringLayout.EAST, panel);
		panel.add(newShortdescrField);
		newShortdescrField.setColumns(10);
		
		JLabel lblLongDescription = new JLabel("Long description");
		sl_panel.putConstraint(SpringLayout.NORTH, lblLongDescription, 18, SpringLayout.SOUTH, lblShortDescription);
		sl_panel.putConstraint(SpringLayout.WEST, lblLongDescription, 0, SpringLayout.WEST, lblName);
		panel.add(lblLongDescription);
		
		JTextArea newLongdescrArea = new JTextArea();
		sl_panel.putConstraint(SpringLayout.NORTH, newLongdescrArea, 12, SpringLayout.SOUTH, newShortdescrField);
		sl_panel.putConstraint(SpringLayout.WEST, newLongdescrArea, 6, SpringLayout.EAST, lblLongDescription);
		sl_panel.putConstraint(SpringLayout.SOUTH, newLongdescrArea, 54, SpringLayout.SOUTH, newShortdescrField);
		sl_panel.putConstraint(SpringLayout.EAST, newLongdescrArea, -10, SpringLayout.EAST, panel);
		panel.add(newLongdescrArea);
		
		JSeparator separator = new JSeparator();
		sl_panel.putConstraint(SpringLayout.NORTH, separator, 6, SpringLayout.SOUTH, newLongdescrArea);
		sl_panel.putConstraint(SpringLayout.WEST, separator, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, separator, 8, SpringLayout.SOUTH, newLongdescrArea);
		sl_panel.putConstraint(SpringLayout.EAST, separator, 0, SpringLayout.EAST, newShortdescrField);
		panel.add(separator);
		
		JLabel lblUpdateACategory = new JLabel("Update a category");
		sl_panel.putConstraint(SpringLayout.NORTH, lblUpdateACategory, 7, SpringLayout.SOUTH, separator);
		sl_panel.putConstraint(SpringLayout.WEST, lblUpdateACategory, 0, SpringLayout.WEST, lblNewCategory);
		lblUpdateACategory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblUpdateACategory);
		
		JLabel lblCategoryName = new JLabel("Category name");
		sl_panel.putConstraint(SpringLayout.NORTH, lblCategoryName, 6, SpringLayout.SOUTH, lblUpdateACategory);
		sl_panel.putConstraint(SpringLayout.WEST, lblCategoryName, 0, SpringLayout.WEST, lblName);
		panel.add(lblCategoryName);
		
		JSpinner updateCategorynameSpinner = new JSpinner();
		sl_panel.putConstraint(SpringLayout.NORTH, updateCategorynameSpinner, -3, SpringLayout.NORTH, lblCategoryName);
		sl_panel.putConstraint(SpringLayout.WEST, updateCategorynameSpinner, 6, SpringLayout.EAST, lblCategoryName);
		panel.add(updateCategorynameSpinner);
		
		JSeparator separator_1 = new JSeparator();
		sl_panel.putConstraint(SpringLayout.WEST, separator_1, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, separator_1, 300, SpringLayout.WEST, panel);
		panel.add(separator_1);
		
		JLabel label = new JLabel("New label");
		sl_panel.putConstraint(SpringLayout.SOUTH, separator_1, -6, SpringLayout.NORTH, label);
		sl_panel.putConstraint(SpringLayout.NORTH, label, 213, SpringLayout.NORTH, panel);
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sl_panel.putConstraint(SpringLayout.WEST, label, 0, SpringLayout.WEST, lblNewCategory);
		panel.add(label);
		
		JLabel lblCategoryName_1 = new JLabel("Category name");
		sl_panel.putConstraint(SpringLayout.NORTH, lblCategoryName_1, 3, SpringLayout.SOUTH, label);
		sl_panel.putConstraint(SpringLayout.WEST, lblCategoryName_1, 0, SpringLayout.WEST, lblName);
		panel.add(lblCategoryName_1);
		
		JSpinner deleteCategorynameSpinner = new JSpinner();
		sl_panel.putConstraint(SpringLayout.EAST, updateCategorynameSpinner, 0, SpringLayout.EAST, deleteCategorynameSpinner);
		sl_panel.putConstraint(SpringLayout.NORTH, deleteCategorynameSpinner, -3, SpringLayout.NORTH, lblCategoryName_1);
		sl_panel.putConstraint(SpringLayout.WEST, deleteCategorynameSpinner, 6, SpringLayout.EAST, lblCategoryName_1);
		panel.add(deleteCategorynameSpinner);
		
		JButton btnUpdate = new JButton("Update");
		sl_panel.putConstraint(SpringLayout.NORTH, separator_1, 3, SpringLayout.SOUTH, btnUpdate);
		sl_panel.putConstraint(SpringLayout.NORTH, btnUpdate, -4, SpringLayout.NORTH, lblCategoryName);
		sl_panel.putConstraint(SpringLayout.EAST, btnUpdate, 0, SpringLayout.EAST, newShortdescrField);
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		sl_panel.putConstraint(SpringLayout.EAST, deleteCategorynameSpinner, -22, SpringLayout.WEST, btnDelete);
		sl_panel.putConstraint(SpringLayout.NORTH, btnDelete, -4, SpringLayout.NORTH, lblCategoryName_1);
		sl_panel.putConstraint(SpringLayout.EAST, btnDelete, 0, SpringLayout.EAST, newShortdescrField);
		panel.add(btnDelete);
		springLayout.putConstraint(SpringLayout.EAST, btnCategories, -347, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.NORTH, btnCategories, 120, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, btnServices, -6, SpringLayout.NORTH, btnCategories);
		btnCategories.setEnabled(false);
		add(btnCategories);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
