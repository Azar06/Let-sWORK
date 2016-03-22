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


public class ServiceView extends AbstractView implements ActionListener {

	private CategoryFacade facade;
	private JTextField newCodeField;
	private JTextField newLabelField;
	
	public ServiceView() {
		this.facade = new CategoryFacade();
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JScrollPane scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 155, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 189, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -78, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, -86, SpringLayout.EAST, this);
		add(scrollPane);
		
		JLabel lblServices = new JLabel("Services");
		springLayout.putConstraint(SpringLayout.WEST, lblServices, 328, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblServices, -35, SpringLayout.NORTH, scrollPane);
		lblServices.setFont(new Font("Tahoma", Font.PLAIN, 40));
		add(lblServices);
		
		JButton btnMenuProducts = new JButton("Products");
		springLayout.putConstraint(SpringLayout.NORTH, btnMenuProducts, 0, SpringLayout.NORTH, scrollPane);
		btnMenuProducts.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(btnMenuProducts);
		
		JButton btnMenuServices = new JButton("Services");
		btnMenuServices.setEnabled(false);
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
		
		JLabel lblNewService = new JLabel("New service");
		lblNewService.setFont(new Font("Tahoma", Font.PLAIN, 20));
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewService, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewService, 10, SpringLayout.WEST, panel);
		panel.add(lblNewService);
		
		JLabel lblCategory = new JLabel("Category");
		sl_panel.putConstraint(SpringLayout.NORTH, lblCategory, 9, SpringLayout.SOUTH, lblNewService);
		lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sl_panel.putConstraint(SpringLayout.WEST, lblCategory, 10, SpringLayout.WEST, lblNewService);
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
		
		JLabel lblUpdateAService = new JLabel("Update a service");
		sl_panel.putConstraint(SpringLayout.SOUTH, separator, -7, SpringLayout.NORTH, lblUpdateAService);
		sl_panel.putConstraint(SpringLayout.NORTH, lblUpdateAService, 160, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblUpdateAService, 0, SpringLayout.WEST, lblNewService);
		lblUpdateAService.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblUpdateAService);
		
		JLabel lblServiceCode = new JLabel("Service code");
		sl_panel.putConstraint(SpringLayout.EAST, lblServiceCode, 0, SpringLayout.EAST, lblNewService);
		lblServiceCode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblServiceCode);
		
		JSpinner updateServiceCodeSpinner = new JSpinner();
		sl_panel.putConstraint(SpringLayout.NORTH, updateServiceCodeSpinner, 9, SpringLayout.SOUTH, lblUpdateAService);
		sl_panel.putConstraint(SpringLayout.WEST, updateServiceCodeSpinner, 8, SpringLayout.EAST, lblServiceCode);
		sl_panel.putConstraint(SpringLayout.NORTH, lblServiceCode, 1, SpringLayout.NORTH, updateServiceCodeSpinner);
		updateServiceCodeSpinner.setModel(new SpinnerListModel(new String[] {"Service 1"}));
		panel.add(updateServiceCodeSpinner);
		
		JLabel lblDeleteAService = new JLabel("Delete a service");
		sl_panel.putConstraint(SpringLayout.WEST, lblDeleteAService, 0, SpringLayout.WEST, lblNewService);
		lblDeleteAService.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblDeleteAService);
		
		JLabel lblDelServiceCode = new JLabel("Service code");
		sl_panel.putConstraint(SpringLayout.SOUTH, lblDeleteAService, -6, SpringLayout.NORTH, lblDelServiceCode);
		sl_panel.putConstraint(SpringLayout.NORTH, lblDelServiceCode, 272, SpringLayout.NORTH, panel);
		lblDelServiceCode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sl_panel.putConstraint(SpringLayout.WEST, lblDelServiceCode, 21, SpringLayout.WEST, panel);
		panel.add(lblDelServiceCode);
		
		JSpinner deleteServiceCodeSpinner = new JSpinner();
		deleteServiceCodeSpinner.setModel(new SpinnerListModel(new String[] {"Service 1"}));
		sl_panel.putConstraint(SpringLayout.WEST, deleteServiceCodeSpinner, 8, SpringLayout.EAST, lblDelServiceCode);
		panel.add(deleteServiceCodeSpinner);
		
		JButton btnUpdate = new JButton("Update");
		sl_panel.putConstraint(SpringLayout.NORTH, btnUpdate, 38, SpringLayout.SOUTH, separator);
		sl_panel.putConstraint(SpringLayout.EAST, updateServiceCodeSpinner, -13, SpringLayout.WEST, btnUpdate);
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		sl_panel.putConstraint(SpringLayout.WEST, btnUpdate, 0, SpringLayout.WEST, btnDelete);
		sl_panel.putConstraint(SpringLayout.WEST, btnDelete, 410, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, deleteServiceCodeSpinner, -13, SpringLayout.WEST, btnDelete);
		sl_panel.putConstraint(SpringLayout.NORTH, btnDelete, -4, SpringLayout.NORTH, lblDelServiceCode);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnDelete);
		
		JSeparator separator_1 = new JSeparator();
		sl_panel.putConstraint(SpringLayout.NORTH, separator_1, 15, SpringLayout.SOUTH, btnUpdate);
		sl_panel.putConstraint(SpringLayout.WEST, separator_1, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, separator_1, -6, SpringLayout.NORTH, lblDeleteAService);
		sl_panel.putConstraint(SpringLayout.EAST, separator_1, -10, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, deleteServiceCodeSpinner, 36, SpringLayout.SOUTH, separator_1);
		panel.add(separator_1);
		
		JSpinner categorySpinner = new JSpinner();
		sl_panel.putConstraint(SpringLayout.NORTH, categorySpinner, 1, SpringLayout.NORTH, lblCategory);
		sl_panel.putConstraint(SpringLayout.WEST, categorySpinner, 6, SpringLayout.EAST, lblCategory);
		sl_panel.putConstraint(SpringLayout.EAST, categorySpinner, 202, SpringLayout.EAST, lblCategory);
		categorySpinner.setModel(new SpinnerListModel(new String[] {"Category 1"}));
		panel.add(categorySpinner);
		
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
