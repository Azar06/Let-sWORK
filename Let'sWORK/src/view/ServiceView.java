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
import business.facade.ServiceFacade;
import business.facade.UserFacade;
import business.utils.CategoryReturnState;
import business.utils.ServiceReturnState;
import persistence.Category;
import persistence.CategorySet;
import persistence.Service;
import persistence.ServiceSet;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.SpinnerListModel;


public class ServiceView extends AbstractContentView implements ActionListener {

	private CategoryFacade catFacade;
	private ServiceFacade servFacade;
	private JTextField newLabelField;
	private JTextArea newDescrArea;
	private JTextField updateLabelField;
	private JTextArea updateDescrArea;
	private JSpinner updateServicelabelSpinner;
	private JSpinner deleteServicelabelSpinner;
	private CategorySet categories;
	private Category selectedCategory;
	private ServiceSet services;
	private Service selectedService;
	private Service selectedServiceToDelete = null;

	public ServiceView() {
		this.catFacade = new CategoryFacade();
		this.servFacade = new ServiceFacade();
		setLayout(null);
		this.categories = this.catFacade.getCategorySet();
		this.selectedCategory = null;
		this.services = this.servFacade.getServiceSet();
		this.selectedService = null;

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 25, 525, 506);
		add(scrollPane);

		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);

		JLabel lblNewService = new JLabel("New service");
		lblNewService.setBounds(10, 10, 122, 25);
		lblNewService.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblNewService);

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
		
		JSpinner categorySpinner = new JSpinner();
		categorySpinner.setBounds(337, 43, 153, 22);
		panel.add(categorySpinner);
		
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

		JLabel lblUpdateAService = new JLabel("Update a service");
		lblUpdateAService.setBounds(10, 160, 164, 25);
		lblUpdateAService.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblUpdateAService);

		JLabel lblServiceLabel = new JLabel("Service label");
		lblServiceLabel.setBounds(23, 195, 88, 19);
		lblServiceLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblServiceLabel);

		JLabel lblDeleteAService = new JLabel("Delete a service");
		lblDeleteAService.setBounds(10, 393, 159, 25);
		lblDeleteAService.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblDeleteAService);

		JLabel lblDelServiceLabel = new JLabel("Service label");
		lblDelServiceLabel.setBounds(23, 424, 88, 19);
		lblDelServiceLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblDelServiceLabel);

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
		
		JSpinner updateServicecategorySpinner = new JSpinner();
		updateServicecategorySpinner.setEnabled(false);
		updateServicecategorySpinner.setBounds(354, 233, 136, 22);
		panel.add(updateServicecategorySpinner);

		JLabel lblUpdateDescription = new JLabel("Description");
		lblUpdateDescription.setBounds(54, 271, 69, 16);
		lblUpdateDescription.setEnabled(false);
		panel.add(lblUpdateDescription);

		updateDescrArea = new JTextArea();
		updateDescrArea.setBounds(130, 268, 283, 71);
		updateDescrArea.setEnabled(false);
		panel.add(updateDescrArea);

		updateServicelabelSpinner = new JSpinner();
		updateServicelabelSpinner.setBounds(117, 194, 267, 22);
		deleteServicelabelSpinner = new JSpinner();
		deleteServicelabelSpinner.setBounds(117, 423, 267, 22);

		ArrayList<String> sList = new ArrayList<String>();
		sList.add("");
		sList.addAll(this.services.getLabels());
		updateServicelabelSpinner.setModel(new SpinnerListModel(sList));
		deleteServicelabelSpinner.setModel(new SpinnerListModel(sList));
		updateServicelabelSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				String labelWrite = (String) updateServicelabelSpinner.getValue();
				selectedService = services.getServiceWithLabel(labelWrite);
				if(selectedService == null) {
					updateLabelField.setText("");
					updateDescrArea.setText("");
					lblUpdateLabel.setEnabled(false);
					updateLabelField.setEnabled(false);
					lblUpdateDescription.setEnabled(false);
					updateDescrArea.setEnabled(false);
					btnUpdate.setEnabled(false);
				}
				else {
					lblUpdateLabel.setEnabled(true);
					updateLabelField.setEnabled(true);
					lblUpdateDescription.setEnabled(true);
					updateDescrArea.setEnabled(true);
					btnUpdate.setEnabled(true);
					updateLabelField.setText(selectedService.getLabel());
					updateDescrArea.setText(selectedService.getDescription());
				}
			}
		});
		deleteServicelabelSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				String labelWrite = (String) deleteServicelabelSpinner.getValue();
				selectedServiceToDelete = services.getServiceWithLabel(labelWrite);
				if(selectedServiceToDelete == null) {
					btnDelete.setEnabled(false);
				}
				else {
					btnDelete.setEnabled(true);
				}
			}
		});
		panel.add(updateServicelabelSpinner);
		panel.add(deleteServicelabelSpinner);
		
	}

	/**
	 * Get the label of the service to create, write in the text field from the panel INSERT
	 * @return the text write in the text field from the panel INSERT
	 */
	public String getNewLabelText()
	{
		return this.newLabelField.getText();
	}

	/**
	 * Get the description of the service to create, write in the text field from the panel INSERT
	 * @return the text write in the text field from the panel INSERT
	 */
	public String getNewDescrText()
	{
		return this.newDescrArea.getText();
	}

	/**
	 * Get the label of the service to update, write in the text field from the panel UPDATE
	 * @return the text write in the text field from the panel UPDATE
	 */
	public String getUpdateLabelText()
	{
		return this.updateLabelField.getText();
	}

	/**
	 * Get the description of the service to update, write in the text field from the panel UPDATE
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
			String newLabel = getNewLabelText();
			String newDescr = getNewDescrText();
			if(newLabel.equals("") || newDescr.equals("")) { // si tous les champs ne sont pas renseignes
				String message = "All fields must be filled in.";
				JOptionPane.showMessageDialog(null, message, "Missing fields", JOptionPane.ERROR_MESSAGE);
			}
			else {
				ServiceReturnState returnState = this.servFacade.create(newLabel, newDescr);
				if(returnState.isRight()) {
					String message = "Service " + newLabel + " created.";
					JOptionPane.showMessageDialog(null, message, "Creation completed", JOptionPane.INFORMATION_MESSAGE);
					this.getMainView().setContentView(new ServiceView());
				}
				else {
					String message = "Error at the creation of the new service. Maybe a service with the same name is already existent.";
					JOptionPane.showMessageDialog(null, message, "Creation failed", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		else if(cmd.equals("update")) {
			String updLabel = getUpdateLabelText();
			String updDescr = getUpdateDescrText();
			if(updLabel.equals("") || updDescr.equals("")) { // si tous les champs ne sont pas renseignes
				String message = "All fields must be filled in.";
				JOptionPane.showMessageDialog(null, message, "Missing fields", JOptionPane.ERROR_MESSAGE);
			}
			else {
				if(this.selectedService != null) {
					String oldLabel = this.selectedService.getLabel();
					this.selectedService.setLabel(updLabel);
					this.selectedService.setDescription(updDescr);
					ServiceReturnState returnState = this.servFacade.save(this.selectedService);
					if(returnState.isRight()) {
						String message = "Service " + oldLabel + " updated to " + updLabel + ".";
						JOptionPane.showMessageDialog(null, message, "Update completed", JOptionPane.INFORMATION_MESSAGE);
						this.getMainView().setContentView(new ServiceView());
					}
					else {
						String message = "Error at the update of the service. Maybe a service with the same name is already existent.";
						JOptionPane.showMessageDialog(null, message, "Update failed", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
		else if(cmd.equals("delete")) {
			if(this.selectedServiceToDelete != null) {
				String oldLabel = this.selectedServiceToDelete.getLabel();
				boolean delete = this.servFacade.delete(this.selectedServiceToDelete);
				if(delete) {
					String message = "Service " + oldLabel + " is deleted.";
					JOptionPane.showMessageDialog(null, message, "Deletion completed", JOptionPane.INFORMATION_MESSAGE);
					this.getMainView().setContentView(new ServiceView());
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
		return "Categories";
	}
}
