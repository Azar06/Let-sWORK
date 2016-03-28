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
import business.utils.CategoryReturnState;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.SpinnerListModel;
import javax.swing.JList;


public class ServiceView extends AbstractContentView implements ActionListener {

	private CategoryFacade facade;
	private JTextField newLabelField;
	private JTextArea newDescrArea;
	private JTextField updateNameField;
	private JTextArea updateDescrArea;
	private JSpinner updateServiceCodeSpinner;
	private JSpinner deleteServiceCodeSpinner;
	private JTextField newCodeField;
	private JTextField updateLabelField;
	
	public ServiceView() {
		this.facade = new CategoryFacade();
		setLayout(null);
		
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
		lblLabel.setBounds(237, 75, 39, 19);
		lblLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblLabel);
		
		newLabelField = new JTextField();
		newLabelField.setBounds(288, 74, 222, 22);
		panel.add(newLabelField);
		newLabelField.setColumns(10);
		
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
		
		JLabel lblUpdateAService = new JLabel("Update a service");
		lblUpdateAService.setBounds(10, 160, 164, 25);
		lblUpdateAService.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblUpdateAService);
		
		JLabel lblServiceCode = new JLabel("Service code");
		lblServiceCode.setBounds(23, 195, 96, 19);
		lblServiceCode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblServiceCode);
		
		updateServiceCodeSpinner = new JSpinner();
		updateServiceCodeSpinner.setBounds(119, 194, 267, 22);
		updateServiceCodeSpinner.setModel(new SpinnerListModel(new String[] {"Service 1"}));
		panel.add(updateServiceCodeSpinner);
		
		JLabel lblDeleteAService = new JLabel("Delete a service");
		lblDeleteAService.setBounds(10, 393, 159, 25);
		lblDeleteAService.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblDeleteAService);
		
		JLabel lblDelServiceCode = new JLabel("Service code");
		lblDelServiceCode.setBounds(23, 424, 96, 19);
		lblDelServiceCode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblDelServiceCode);
		
		deleteServiceCodeSpinner = new JSpinner();
		deleteServiceCodeSpinner.setBounds(119, 423, 267, 22);
		deleteServiceCodeSpinner.setModel(new SpinnerListModel(new String[] {" ", "Service 1", "Service 2"}));
		panel.add(deleteServiceCodeSpinner);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(417, 352, 96, 27);
		btnUpdate.setEnabled(false);
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(417, 420, 96, 27);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnDelete);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 385, 503, 2);
		panel.add(separator_1);
		
		JLabel lblUpdateCode = new JLabel("Code");
		lblUpdateCode.setBounds(54, 268, 33, 16);
		lblUpdateCode.setEnabled(false);
		panel.add(lblUpdateCode);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(433, 118, 80, 27);
		panel.add(btnAdd);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdd.addActionListener(this);
		btnAdd.setActionCommand("add");
		
		updateNameField = new JTextField();
		updateNameField.setBounds(100, 265, 136, 22);
		updateNameField.setEnabled(false);
		panel.add(updateNameField);
		updateNameField.setColumns(10);
		
		JLabel lblUpdateDescription = new JLabel("Description");
		lblUpdateDescription.setBounds(54, 300, 69, 16);
		lblUpdateDescription.setEnabled(false);
		panel.add(lblUpdateDescription);
		
		updateDescrArea = new JTextArea();
		updateDescrArea.setBounds(130, 297, 283, 42);
		updateDescrArea.setEnabled(false);
		panel.add(updateDescrArea);
		
		newCodeField = new JTextField();
		newCodeField.setBounds(68, 74, 136, 22);
		panel.add(newCodeField);
		newCodeField.setColumns(10);
		
		JLabel lblCode = new JLabel("Code");
		lblCode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCode.setBounds(20, 76, 39, 16);
		panel.add(lblCode);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCategory.setBounds(20, 44, 69, 18);
		panel.add(lblCategory);
		
		JSpinner categorySpinner = new JSpinner();
		categorySpinner.setModel(new SpinnerListModel(new String[] {"Category 1"}));
		categorySpinner.setBounds(92, 42, 164, 22);
		panel.add(categorySpinner);
		
		JLabel lblUpdateLabel = new JLabel("Label");
		lblUpdateLabel.setEnabled(false);
		lblUpdateLabel.setBounds(253, 268, 39, 16);
		panel.add(lblUpdateLabel);
		
		updateLabelField = new JTextField();
		updateLabelField.setEnabled(false);
		updateLabelField.setBounds(297, 265, 148, 22);
		panel.add(updateLabelField);
		updateLabelField.setColumns(10);
		
		JLabel lblUpdateCategory = new JLabel("Category");
		lblUpdateCategory.setEnabled(false);
		lblUpdateCategory.setBounds(54, 236, 56, 16);
		panel.add(lblUpdateCategory);
		
		JSpinner updateCategorySpinner = new JSpinner();
		updateCategorySpinner.setEnabled(false);
		updateCategorySpinner.setModel(new SpinnerListModel(new String[] {"Category 1"}));
		updateCategorySpinner.setBounds(119, 233, 121, 22);
		panel.add(updateCategorySpinner);
	}
	
	//Recupere le nouveau nom de la categorie a ajouter
	public String getNewNameText()
	{
		return this.newLabelField.getText();
	}
	
	//Recupere le nouveau descriptif de la categorie a ajouter
	public String getNewDescrText()
	{
		return this.newDescrArea.getText();
	}

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
					String message = "Category " + newName + "created.";
					JOptionPane.showMessageDialog(null, message, "Creation completed", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					String message = "Error at the creation of the new category. Maybe a category with the same name is already existent.";
					JOptionPane.showMessageDialog(null, message, "Creation failed", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
	
	@Override
	public String getTitle() {
		return "Categories";
	}
}
