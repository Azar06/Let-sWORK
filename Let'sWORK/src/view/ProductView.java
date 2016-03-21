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


public class ProductView extends AbstractView implements ActionListener {

	private CategoryFacade facade;
	private JTextField newCodeField;
	private JTextField newLabelField;
	
	public ProductView() {
		this.facade = new CategoryFacade();
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JScrollPane scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 155, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 189, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -78, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, -86, SpringLayout.EAST, this);
		add(scrollPane);
		
		JLabel lblCategories = new JLabel("Products");
		springLayout.putConstraint(SpringLayout.WEST, lblCategories, 324, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblCategories, -35, SpringLayout.NORTH, scrollPane);
		lblCategories.setFont(new Font("Tahoma", Font.PLAIN, 40));
		add(lblCategories);
		
		JButton btnNewButton = new JButton("Products");
		btnNewButton.setEnabled(false);
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 0, SpringLayout.NORTH, scrollPane);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(btnNewButton);
		
		JButton btnServices = new JButton("Services");
		springLayout.putConstraint(SpringLayout.NORTH, btnServices, 8, SpringLayout.SOUTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.EAST, btnServices, -627, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, 0, SpringLayout.EAST, btnServices);
		btnServices.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(btnServices);
		
		JButton btnCategories = new JButton("Categories");
		springLayout.putConstraint(SpringLayout.NORTH, btnCategories, 6, SpringLayout.SOUTH, btnServices);
		springLayout.putConstraint(SpringLayout.EAST, btnCategories, 0, SpringLayout.EAST, btnNewButton);
		btnCategories.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lblNewProduct = new JLabel("New product");
		lblNewProduct.setFont(new Font("Tahoma", Font.PLAIN, 20));
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewProduct, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewProduct, 10, SpringLayout.WEST, panel);
		panel.add(lblNewProduct);
		
		JLabel lblCategory = new JLabel("Category");
		sl_panel.putConstraint(SpringLayout.NORTH, lblCategory, 9, SpringLayout.SOUTH, lblNewProduct);
		lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sl_panel.putConstraint(SpringLayout.WEST, lblCategory, 10, SpringLayout.WEST, lblNewProduct);
		panel.add(lblCategory);
		
		JLabel lblCode = new JLabel("Code");
		sl_panel.putConstraint(SpringLayout.NORTH, lblCode, 9, SpringLayout.SOUTH, lblCategory);
		sl_panel.putConstraint(SpringLayout.EAST, lblCode, -10, SpringLayout.EAST, lblCategory);
		lblCode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblCode);
		
		newCodeField = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, newCodeField, -1, SpringLayout.NORTH, lblCode);
		sl_panel.putConstraint(SpringLayout.WEST, newCodeField, 6, SpringLayout.EAST, lblCode);
		sl_panel.putConstraint(SpringLayout.EAST, newCodeField, -284, SpringLayout.EAST, panel);
		panel.add(newCodeField);
		newCodeField.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description");
		sl_panel.putConstraint(SpringLayout.NORTH, lblDescription, 13, SpringLayout.SOUTH, lblCode);
		sl_panel.putConstraint(SpringLayout.WEST, lblDescription, 0, SpringLayout.WEST, lblCategory);
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblDescription);
		
		JTextArea newDescrArea = new JTextArea();
		sl_panel.putConstraint(SpringLayout.NORTH, newDescrArea, 10, SpringLayout.SOUTH, newCodeField);
		sl_panel.putConstraint(SpringLayout.WEST, newDescrArea, 6, SpringLayout.EAST, lblDescription);
		panel.add(newDescrArea);
		
		JSeparator separator = new JSeparator();
		sl_panel.putConstraint(SpringLayout.SOUTH, newDescrArea, -6, SpringLayout.NORTH, separator);
		sl_panel.putConstraint(SpringLayout.NORTH, separator, 151, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, separator, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, separator, -10, SpringLayout.EAST, panel);
		panel.add(separator);
		
		JLabel lblUpdateAProduct = new JLabel("Update a product");
		sl_panel.putConstraint(SpringLayout.SOUTH, separator, -7, SpringLayout.NORTH, lblUpdateAProduct);
		sl_panel.putConstraint(SpringLayout.NORTH, lblUpdateAProduct, 160, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblUpdateAProduct, 0, SpringLayout.WEST, lblNewProduct);
		lblUpdateAProduct.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblUpdateAProduct);
		
		JLabel lblProductCode = new JLabel("Product code");
		sl_panel.putConstraint(SpringLayout.EAST, lblProductCode, 0, SpringLayout.EAST, lblNewProduct);
		lblProductCode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblProductCode);
		
		JSpinner updateProductcodeSpinner = new JSpinner();
		sl_panel.putConstraint(SpringLayout.NORTH, updateProductcodeSpinner, 9, SpringLayout.SOUTH, lblUpdateAProduct);
		sl_panel.putConstraint(SpringLayout.WEST, updateProductcodeSpinner, 8, SpringLayout.EAST, lblProductCode);
		sl_panel.putConstraint(SpringLayout.NORTH, lblProductCode, 1, SpringLayout.NORTH, updateProductcodeSpinner);
		updateProductcodeSpinner.setModel(new SpinnerListModel(new String[] {"Product 1"}));
		panel.add(updateProductcodeSpinner);
		
		JLabel lblDeleteAProduct = new JLabel("Delete a product");
		sl_panel.putConstraint(SpringLayout.WEST, lblDeleteAProduct, 0, SpringLayout.WEST, lblNewProduct);
		lblDeleteAProduct.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblDeleteAProduct);
		
		JLabel lblDelProductCode = new JLabel("Product code");
		sl_panel.putConstraint(SpringLayout.SOUTH, lblDeleteAProduct, -6, SpringLayout.NORTH, lblDelProductCode);
		sl_panel.putConstraint(SpringLayout.NORTH, lblDelProductCode, 272, SpringLayout.NORTH, panel);
		lblDelProductCode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sl_panel.putConstraint(SpringLayout.WEST, lblDelProductCode, 21, SpringLayout.WEST, panel);
		panel.add(lblDelProductCode);
		
		JSpinner deleteProductCodeSpinner = new JSpinner();
		deleteProductCodeSpinner.setModel(new SpinnerListModel(new String[] {"Product 1"}));
		sl_panel.putConstraint(SpringLayout.WEST, deleteProductCodeSpinner, 8, SpringLayout.EAST, lblDelProductCode);
		panel.add(deleteProductCodeSpinner);
		
		JButton btnUpdate = new JButton("Update");
		sl_panel.putConstraint(SpringLayout.NORTH, btnUpdate, 38, SpringLayout.SOUTH, separator);
		sl_panel.putConstraint(SpringLayout.EAST, updateProductcodeSpinner, -13, SpringLayout.WEST, btnUpdate);
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		sl_panel.putConstraint(SpringLayout.WEST, btnUpdate, 0, SpringLayout.WEST, btnDelete);
		sl_panel.putConstraint(SpringLayout.WEST, btnDelete, 410, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, deleteProductCodeSpinner, -13, SpringLayout.WEST, btnDelete);
		sl_panel.putConstraint(SpringLayout.NORTH, btnDelete, -4, SpringLayout.NORTH, lblDelProductCode);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnDelete);
		
		JSeparator separator_1 = new JSeparator();
		sl_panel.putConstraint(SpringLayout.NORTH, separator_1, 15, SpringLayout.SOUTH, btnUpdate);
		sl_panel.putConstraint(SpringLayout.WEST, separator_1, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, separator_1, -6, SpringLayout.NORTH, lblDeleteAProduct);
		sl_panel.putConstraint(SpringLayout.EAST, separator_1, -10, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, deleteProductCodeSpinner, 36, SpringLayout.SOUTH, separator_1);
		panel.add(separator_1);
		
		JLabel lblBrand = new JLabel("Brand");
		sl_panel.putConstraint(SpringLayout.EAST, lblBrand, -178, SpringLayout.EAST, panel);
		lblBrand.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sl_panel.putConstraint(SpringLayout.NORTH, lblBrand, 0, SpringLayout.NORTH, lblCategory);
		panel.add(lblBrand);
		
		JSpinner categorySpinner = new JSpinner();
		sl_panel.putConstraint(SpringLayout.NORTH, categorySpinner, 1, SpringLayout.NORTH, lblCategory);
		sl_panel.putConstraint(SpringLayout.WEST, categorySpinner, 6, SpringLayout.EAST, lblCategory);
		sl_panel.putConstraint(SpringLayout.EAST, categorySpinner, 202, SpringLayout.EAST, lblCategory);
		categorySpinner.setModel(new SpinnerListModel(new String[] {"Category 1"}));
		panel.add(categorySpinner);
		
		JSpinner brandSpinner = new JSpinner();
		brandSpinner.setModel(new SpinnerListModel(new String[] {"Brand 1"}));
		sl_panel.putConstraint(SpringLayout.NORTH, brandSpinner, -1, SpringLayout.NORTH, lblCategory);
		sl_panel.putConstraint(SpringLayout.WEST, brandSpinner, 6, SpringLayout.EAST, lblBrand);
		sl_panel.putConstraint(SpringLayout.EAST, brandSpinner, -9, SpringLayout.EAST, btnUpdate);
		panel.add(brandSpinner);
		
		JLabel lblLabel = new JLabel("Label");
		sl_panel.putConstraint(SpringLayout.EAST, lblLabel, -220, SpringLayout.EAST, panel);
		lblLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sl_panel.putConstraint(SpringLayout.NORTH, lblLabel, 0, SpringLayout.NORTH, lblCode);
		panel.add(lblLabel);
		
		newLabelField = new JTextField();
		sl_panel.putConstraint(SpringLayout.WEST, newLabelField, 317, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, newLabelField, -22, SpringLayout.SOUTH, lblCode);
		sl_panel.putConstraint(SpringLayout.SOUTH, newLabelField, 0, SpringLayout.SOUTH, lblCode);
		sl_panel.putConstraint(SpringLayout.EAST, newLabelField, 178, SpringLayout.EAST, lblLabel);
		panel.add(newLabelField);
		newLabelField.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		sl_panel.putConstraint(SpringLayout.SOUTH, btnAdd, -6, SpringLayout.NORTH, separator);
		sl_panel.putConstraint(SpringLayout.EAST, newDescrArea, -6, SpringLayout.WEST, btnAdd);
		sl_panel.putConstraint(SpringLayout.EAST, btnAdd, 0, SpringLayout.EAST, btnUpdate);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnAdd);
		add(btnCategories);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
