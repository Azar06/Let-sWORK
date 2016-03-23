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
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(189, 65, 525, 506);
		add(scrollPane);
		
		JLabel lblCategories = new JLabel("Categories");
		lblCategories.setBounds(307, 10, 185, 49);
		lblCategories.setFont(new Font("Tahoma", Font.PLAIN, 40));
		add(lblCategories);
		
		JButton btnMenuProducts = new JButton("Products");
		btnMenuProducts.setBounds(72, 155, 101, 31);
		btnMenuProducts.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(btnMenuProducts);
		
		JButton btnMenuServices = new JButton("Services");
		btnMenuServices.setBounds(78, 194, 95, 31);
		btnMenuServices.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(btnMenuServices);
		
		JButton btnMenuCategories = new JButton("Categories");
		btnMenuCategories.setBounds(58, 231, 115, 31);
		btnMenuCategories.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
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
		
		JLabel lblShortDescription = new JLabel("Short description");
		lblShortDescription.setBounds(25, 72, 107, 19);
		lblShortDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblShortDescription);
		
		newShortdescrField = new JTextField();
		newShortdescrField.setBounds(138, 71, 352, 22);
		panel.add(newShortdescrField);
		newShortdescrField.setColumns(10);
		
		JLabel lblLongDescription = new JLabel("Long description");
		lblLongDescription.setBounds(20, 104, 104, 19);
		lblLongDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblLongDescription);
		
		JTextArea newLongdescrArea = new JTextArea();
		newLongdescrArea.setBounds(130, 103, 297, 42);
		panel.add(newLongdescrArea);
		
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
		
		JSpinner updateCategorynameSpinner = new JSpinner();
		updateCategorynameSpinner.setBounds(130, 194, 267, 22);
		updateCategorynameSpinner.setModel(new SpinnerListModel(new String[] {"Category 1"}));
		panel.add(updateCategorynameSpinner);
		
		JLabel lblDeleteACategory = new JLabel("Delete a category");
		lblDeleteACategory.setBounds(10, 393, 159, 25);
		lblDeleteACategory.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblDeleteACategory);
		
		JLabel lblDelCategoryName = new JLabel("Category name");
		lblDelCategoryName.setBounds(23, 424, 101, 19);
		lblDelCategoryName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblDelCategoryName);
		
		JSpinner deleteCategorynameSpinner = new JSpinner();
		deleteCategorynameSpinner.setBounds(130, 423, 267, 22);
		deleteCategorynameSpinner.setModel(new SpinnerListModel(new String[] {"Category 1"}));
		panel.add(deleteCategorynameSpinner);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(417, 352, 79, 27);
		btnUpdate.setEnabled(false);
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(417, 420, 73, 27);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnDelete);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 385, 503, 2);
		panel.add(separator_1);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(433, 118, 57, 27);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnAdd);
		
		JLabel lblUpdateName = new JLabel("Name");
		lblUpdateName.setBounds(54, 233, 33, 16);
		lblUpdateName.setEnabled(false);
		panel.add(lblUpdateName);
		
		updateNameField = new JTextField();
		updateNameField.setBounds(93, 233, 222, 22);
		updateNameField.setEnabled(false);
		panel.add(updateNameField);
		updateNameField.setColumns(10);
		
		JLabel lblUpdateShortDescription = new JLabel("Short description");
		lblUpdateShortDescription.setBounds(54, 264, 97, 16);
		lblUpdateShortDescription.setEnabled(false);
		panel.add(lblUpdateShortDescription);
		
		updateShortdescrField = new JTextField();
		updateShortdescrField.setBounds(157, 261, 333, 22);
		updateShortdescrField.setEnabled(false);
		panel.add(updateShortdescrField);
		updateShortdescrField.setColumns(10);
		
		JLabel lblUpdateLongDescription = new JLabel("Long description");
		lblUpdateLongDescription.setBounds(54, 297, 93, 16);
		lblUpdateLongDescription.setEnabled(false);
		panel.add(lblUpdateLongDescription);
		
		JTextArea updateLongdescrArea = new JTextArea();
		updateLongdescrArea.setBounds(157, 294, 254, 71);
		updateLongdescrArea.setEnabled(false);
		panel.add(updateLongdescrArea);
		btnMenuCategories.setEnabled(false);
		add(btnMenuCategories);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setBounds(639, 34, 75, 25);
		add(btnLogOut);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
