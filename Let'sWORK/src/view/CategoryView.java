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
	
	public CategoryView() {
		this.facade = new CategoryFacade();
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JScrollPane scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 155, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 189, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -78, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, -86, SpringLayout.EAST, this);
		add(scrollPane);
		
		JLabel lblCategories = new JLabel("Categories");
		springLayout.putConstraint(SpringLayout.WEST, lblCategories, 307, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblCategories, -35, SpringLayout.NORTH, scrollPane);
		lblCategories.setFont(new Font("Tahoma", Font.PLAIN, 40));
		add(lblCategories);
		
		JButton btnMenuProducts = new JButton("Products");
		springLayout.putConstraint(SpringLayout.NORTH, btnMenuProducts, 0, SpringLayout.NORTH, scrollPane);
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
		sl_panel.putConstraint(SpringLayout.NORTH, lblCategoryName, 10, SpringLayout.SOUTH, lblUpdateACategory);
		sl_panel.putConstraint(SpringLayout.WEST, lblCategoryName, 0, SpringLayout.WEST, lblNewCategory);
		lblCategoryName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblCategoryName);
		
		JSpinner updateCategorynameSpinner = new JSpinner();
		updateCategorynameSpinner.setModel(new SpinnerListModel(new String[] {"Category 1"}));
		sl_panel.putConstraint(SpringLayout.NORTH, updateCategorynameSpinner, -1, SpringLayout.NORTH, lblCategoryName);
		sl_panel.putConstraint(SpringLayout.WEST, updateCategorynameSpinner, 19, SpringLayout.EAST, lblCategoryName);
		panel.add(updateCategorynameSpinner);
		
		JLabel lblDeleteACategory = new JLabel("Delete a category");
		sl_panel.putConstraint(SpringLayout.WEST, lblDeleteACategory, 0, SpringLayout.WEST, lblNewCategory);
		lblDeleteACategory.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblDeleteACategory);
		
		JLabel lblDelCategoryName = new JLabel("Category name");
		sl_panel.putConstraint(SpringLayout.SOUTH, lblDeleteACategory, -6, SpringLayout.NORTH, lblDelCategoryName);
		sl_panel.putConstraint(SpringLayout.NORTH, lblDelCategoryName, 272, SpringLayout.NORTH, panel);
		lblDelCategoryName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sl_panel.putConstraint(SpringLayout.WEST, lblDelCategoryName, 21, SpringLayout.WEST, panel);
		panel.add(lblDelCategoryName);
		
		JSpinner deleteCategorynameSpinner = new JSpinner();
		deleteCategorynameSpinner.setModel(new SpinnerListModel(new String[] {"Category 1"}));
		sl_panel.putConstraint(SpringLayout.EAST, updateCategorynameSpinner, 0, SpringLayout.EAST, deleteCategorynameSpinner);
		sl_panel.putConstraint(SpringLayout.WEST, deleteCategorynameSpinner, 8, SpringLayout.EAST, lblDelCategoryName);
		panel.add(deleteCategorynameSpinner);
		
		JButton btnUpdate = new JButton("Update");
		sl_panel.putConstraint(SpringLayout.NORTH, btnUpdate, -4, SpringLayout.NORTH, lblCategoryName);
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		sl_panel.putConstraint(SpringLayout.WEST, btnUpdate, 0, SpringLayout.WEST, btnDelete);
		sl_panel.putConstraint(SpringLayout.WEST, btnDelete, 410, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, deleteCategorynameSpinner, -13, SpringLayout.WEST, btnDelete);
		sl_panel.putConstraint(SpringLayout.NORTH, btnDelete, -4, SpringLayout.NORTH, lblDelCategoryName);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnDelete);
		
		JSeparator separator_1 = new JSeparator();
		sl_panel.putConstraint(SpringLayout.NORTH, separator_1, 15, SpringLayout.SOUTH, btnUpdate);
		sl_panel.putConstraint(SpringLayout.WEST, separator_1, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, separator_1, -6, SpringLayout.NORTH, lblDeleteACategory);
		sl_panel.putConstraint(SpringLayout.EAST, separator_1, -10, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, deleteCategorynameSpinner, 36, SpringLayout.SOUTH, separator_1);
		panel.add(separator_1);
		
		JButton btnAdd = new JButton("Add");
		sl_panel.putConstraint(SpringLayout.EAST, newLongdescrArea, -6, SpringLayout.WEST, btnAdd);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnAdd, -6, SpringLayout.NORTH, separator);
		sl_panel.putConstraint(SpringLayout.EAST, btnAdd, 0, SpringLayout.EAST, newShortdescrField);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnAdd);
		btnMenuCategories.setEnabled(false);
		add(btnMenuCategories);
		
		JButton btnLogOut = new JButton("Log out");
		springLayout.putConstraint(SpringLayout.SOUTH, btnLogOut, -6, SpringLayout.NORTH, scrollPane);
		springLayout.putConstraint(SpringLayout.EAST, btnLogOut, 0, SpringLayout.EAST, scrollPane);
		add(btnLogOut);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
