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
import business.facade.ProductFacade;
import business.facade.ServiceFacade;
import business.facade.UserFacade;
import business.utils.CategoryReturnState;
import business.utils.ProductReturnState;
import business.utils.ServiceReturnState;
import persistence.Category;
import persistence.CategorySet;
import persistence.Product;
import persistence.ProductSet;
import persistence.Service;
import persistence.ServiceSet;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.SpinnerListModel;


public class ProductView extends AbstractContentView implements ActionListener {

	private CategoryFacade catFacade;
	private ProductFacade prFacade;
	private JTextField newLabelField;
	private JTextArea newDescrArea;
	private JTextField updateLabelField;
	private JTextArea updateDescrArea;
	private JSpinner updateProductlabelSpinner;
	private JSpinner deleteProductlabelSpinner;
	private JSpinner categorySpinner;
	private JSpinner updateServicecategorySpinner;
	private CategorySet categories;
	private Category selectedCategoryForCreation = null;
	private Category selectedCategory = null;
	private ProductSet products;
	private Product selectedProduct;
	private Product selectedProductToDelete = null;
	private JTextField newBrandField;
	private JTextField updateBrandField;

	public ProductView() {
		this.catFacade = new CategoryFacade();
		this.prFacade = new ProductFacade();
		setLayout(null);
		this.categories = this.catFacade.getCategorySet();
		this.products = this.prFacade.getProductSet();
		this.selectedProduct = null;

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 25, 525, 506);
		add(scrollPane);

		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);

		JLabel lblNewProduct = new JLabel("New product");
		lblNewProduct.setBounds(10, 10, 122, 25);
		lblNewProduct.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblNewProduct);

		JLabel lblLabel = new JLabel("Label");
		lblLabel.setBounds(20, 44, 39, 19);
		lblLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblLabel);

		newLabelField = new JTextField();
		newLabelField.setBounds(65, 43, 188, 22);
		panel.add(newLabelField);
		newLabelField.setColumns(10);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCategory.setBounds(265, 41, 69, 25);
		panel.add(lblCategory);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(20, 104, 78, 19);
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblDescription);

		newDescrArea = new JTextArea();
		newDescrArea.setBounds(100, 103, 327, 42);
		panel.add(newDescrArea);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 151, 503, 2);
		panel.add(separator);

		JLabel lblUpdateAProduct = new JLabel("Update a product");
		lblUpdateAProduct.setBounds(10, 160, 164, 25);
		lblUpdateAProduct.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblUpdateAProduct);

		JLabel lblProductLabel = new JLabel("Product label");
		lblProductLabel.setBounds(23, 195, 88, 19);
		lblProductLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblProductLabel);

		JLabel lblDeleteAProduct = new JLabel("Delete a product");
		lblDeleteAProduct.setBounds(10, 393, 159, 25);
		lblDeleteAProduct.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblDeleteAProduct);

		JLabel lblDelProductLabel = new JLabel("Product label");
		lblDelProductLabel.setBounds(23, 424, 88, 19);
		lblDelProductLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblDelProductLabel);

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

		JLabel lblUpdateLabel = new JLabel("Label");
		lblUpdateLabel.setBounds(54, 236, 33, 16);
		lblUpdateLabel.setEnabled(false);
		panel.add(lblUpdateLabel);

		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(433, 118, 80, 27);
		panel.add(btnAdd);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdd.addActionListener(this);
		btnAdd.setActionCommand("add");

		updateLabelField = new JTextField();
		updateLabelField.setBounds(93, 233, 188, 22);
		updateLabelField.setEnabled(false);
		panel.add(updateLabelField);
		updateLabelField.setColumns(10);
		
		JLabel lblUpdateCategory = new JLabel("Category");
		lblUpdateCategory.setEnabled(false);
		lblUpdateCategory.setBounds(295, 236, 56, 16);
		panel.add(lblUpdateCategory);

		JLabel lblUpdateDescription = new JLabel("Description");
		lblUpdateDescription.setBounds(54, 300, 69, 16);
		lblUpdateDescription.setEnabled(false);
		panel.add(lblUpdateDescription);

		updateDescrArea = new JTextArea();
		updateDescrArea.setBounds(130, 297, 283, 42);
		updateDescrArea.setEnabled(false);
		panel.add(updateDescrArea);
		
		JLabel lblUpdateBrand = new JLabel("Brand");
		lblUpdateBrand.setEnabled(false);
		lblUpdateBrand.setBounds(54, 271, 39, 16);
		panel.add(lblUpdateBrand);
		
		updateBrandField = new JTextField();
		updateBrandField.setEnabled(false);
		updateBrandField.setBounds(96, 265, 185, 22);
		panel.add(updateBrandField);
		updateBrandField.setColumns(10);

		categorySpinner = new JSpinner();
		categorySpinner.setBounds(337, 43, 153, 22);
		updateServicecategorySpinner = new JSpinner();
		updateServicecategorySpinner.setBounds(354, 233, 136, 22);
		updateServicecategorySpinner.setEnabled(false);
		
		updateProductlabelSpinner = new JSpinner();
		updateProductlabelSpinner.setBounds(117, 194, 267, 22);
		deleteProductlabelSpinner = new JSpinner();
		deleteProductlabelSpinner.setBounds(117, 423, 267, 22);
		
		
		ArrayList<String> catList = new ArrayList<String>();
		catList.add("");
		catList.addAll(this.categories.getNames());
		categorySpinner.setModel(new SpinnerListModel(catList));
		updateServicecategorySpinner.setModel(new SpinnerListModel(catList));
		categorySpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				String nameWrite = (String) categorySpinner.getValue();
				selectedCategoryForCreation = categories.getCategoryWithName(nameWrite);
			}
		});
		updateServicecategorySpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				String nameWrite = (String) updateServicecategorySpinner.getValue();
				selectedCategory = categories.getCategoryWithName(nameWrite);
			}
		});
		panel.add(categorySpinner);
		panel.add(updateServicecategorySpinner);

		ArrayList<String> sList = new ArrayList<String>();
		sList.add("");
		sList.addAll(this.products.getLabels());
		updateProductlabelSpinner.setModel(new SpinnerListModel(sList));
		deleteProductlabelSpinner.setModel(new SpinnerListModel(sList));
		updateProductlabelSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				String labelWrite = (String) updateProductlabelSpinner.getValue();
				selectedProduct = products.getProductWithLabel(labelWrite);
				if(selectedProduct == null) {
					updateLabelField.setText("");
					updateDescrArea.setText("");
					lblUpdateLabel.setEnabled(false);
					updateLabelField.setEnabled(false);
					lblUpdateDescription.setEnabled(false);
					updateDescrArea.setEnabled(false);
					btnUpdate.setEnabled(false);
					lblUpdateCategory.setEnabled(false);
					updateServicecategorySpinner.setEnabled(false);
					lblUpdateBrand.setEnabled(false);
					updateBrandField.setEnabled(false);
				}
				else {
					lblUpdateLabel.setEnabled(true);
					updateLabelField.setEnabled(true);
					lblUpdateDescription.setEnabled(true);
					updateDescrArea.setEnabled(true);
					btnUpdate.setEnabled(true);
					lblUpdateCategory.setEnabled(true);
					updateServicecategorySpinner.setEnabled(true);
					lblUpdateBrand.setEnabled(false);
					updateBrandField.setEnabled(false);
					updateLabelField.setText(selectedProduct.getLabel());
					updateDescrArea.setText(selectedProduct.getDescription());
					updateServicecategorySpinner.setValue(selectedProduct.getCategory());
					updateBrandField.setText(selectedProduct.getBrandName());
				}
			}
		});
		deleteProductlabelSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				String labelWrite = (String) deleteProductlabelSpinner.getValue();
				selectedProductToDelete = products.getProductWithLabel(labelWrite);
				if(selectedProductToDelete == null) {
					btnDelete.setEnabled(false);
				}
				else {
					btnDelete.setEnabled(true);
				}
			}
		});
		panel.add(updateProductlabelSpinner);
		panel.add(deleteProductlabelSpinner);
		
		JLabel lblBrand = new JLabel("Brand");
		lblBrand.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBrand.setBounds(20, 76, 47, 16);
		panel.add(lblBrand);
		
		newBrandField = new JTextField();
		newBrandField.setBounds(70, 74, 183, 22);
		panel.add(newBrandField);
		newBrandField.setColumns(10);
		
		
		
	}

	/**
	 * Get the label of the product to create, write in the text field from the panel INSERT
	 * @return the text write in the text field from the panel INSERT
	 */
	public String getNewLabelText()
	{
		return this.newLabelField.getText();
	}

	/**
	 * Get the description of the product to create, write in the text field from the panel INSERT
	 * @return the text write in the text field from the panel INSERT
	 */
	public String getNewDescrText()
	{
		return this.newDescrArea.getText();
	}
	
	/**
	 * Get the category of the product to create
	 * @return the category chosen
	 */
	public Category getNewCategory()
	{
		return this.selectedCategoryForCreation;
	}
	
	/**
	 * Get the brand of the product to create, write in the text field from the panel INSERT
	 * @return the text write in the text field from the panel INSERT
	 */
	public String getNewBrandText()
	{
		return this.newBrandField.getText();
	}

	/**
	 * Get the label of the product to update, write in the text field from the panel UPDATE
	 * @return the text write in the text field from the panel UPDATE
	 */
	public String getUpdateLabelText()
	{
		return this.updateLabelField.getText();
	}

	/**
	 * Get the description of the product to update, write in the text field from the panel UPDATE
	 * @return the text write in the text field from the panel UPDATE
	 */
	public String getUpdateDescrText()
	{
		return this.updateDescrArea.getText();
	}
	
	/**
	 * Get the category of the product to update
	 * @return the category chosen
	 */
	public Category getUpdateCategory()
	{
		return this.selectedCategory;
	}
	
	/**
	 * Get the brand of the product to update, write in the text field from the panel UPDATE
	 * @return the text write in the text field from the panel UPDATE
	 */
	public String getUpdateBrandText()
	{
		return this.updateBrandField.getText();
	}

	/**
	 * After the click on the button, the function start the insertion, the modification or the suppression of a category
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String cmd = arg0.getActionCommand();
		if(cmd.equals("add"))
		{
			String newLabel = getNewLabelText();
			String newDescr = getNewDescrText();
			String newBrand = getNewBrandText();
			Category newCat = getNewCategory();
			if(newLabel.equals("") || newDescr.equals("") || newCat.equals(null)) { // si tous les champs ne sont pas renseignes
				String message = "All fields must be filled in.";
				JOptionPane.showMessageDialog(null, message, "Missing fields", JOptionPane.ERROR_MESSAGE);
			}
			else {
				ProductReturnState returnState = this.prFacade.create(newLabel, newDescr, newBrand, newCat);
				if(returnState.isRight()) {
					String message = "Product " + newLabel + " created.";
					JOptionPane.showMessageDialog(null, message, "Creation completed", JOptionPane.INFORMATION_MESSAGE);
					this.getMainView().setContentView(new ProductView());
				}
				else {
					String message = "Error at the creation of the new product. Maybe a product with the same name is already existent.";
					JOptionPane.showMessageDialog(null, message, "Creation failed", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		else if(cmd.equals("update")) {
			String updLabel = getUpdateLabelText();
			String updDescr = getUpdateDescrText();
			String updBrand = getNewBrandText();
			Category updCat = getUpdateCategory();
			if(updLabel.equals("") || updDescr.equals("") ||updCat.equals(null)) { // si tous les champs ne sont pas renseignes
				String message = "All fields must be filled in.";
				JOptionPane.showMessageDialog(null, message, "Missing fields", JOptionPane.ERROR_MESSAGE);
			}
			else {
				if(this.selectedProduct != null) {
					String oldLabel = this.selectedProduct.getLabel();
					this.selectedProduct.setLabel(updLabel);
					this.selectedProduct.setDescription(updDescr);
					this.selectedProduct.setBrandName(updBrand);
					this.selectedProduct.setCategory(updCat);
					ProductReturnState returnState = this.prFacade.save(this.selectedProduct);
					if(returnState.isRight()) {
						String message = "Service " + oldLabel + " updated to " + updLabel + ".";
						JOptionPane.showMessageDialog(null, message, "Update completed", JOptionPane.INFORMATION_MESSAGE);
						this.getMainView().setContentView(new ProductView());
					}
					else {
						String message = "Error at the update of the service. Maybe a service with the same name is already existent.";
						JOptionPane.showMessageDialog(null, message, "Update failed", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
		else if(cmd.equals("delete")) {
			if(this.selectedProductToDelete != null) {
				String oldLabel = this.selectedProductToDelete.getLabel();
				boolean delete = this.prFacade.delete(this.selectedProductToDelete);
				if(delete) {
					String message = "Service " + oldLabel + " is deleted.";
					JOptionPane.showMessageDialog(null, message, "Deletion completed", JOptionPane.INFORMATION_MESSAGE);
					this.getMainView().setContentView(new ProductView());
				}
				else {
					String message = "Error at the deletion of the service.";
					JOptionPane.showMessageDialog(null, message, "Deletion failed", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	/**
	 * Display "Categories" for the title of the view
	 */
	@Override
	public String getTitle() {
		return "Products";
	}
}
