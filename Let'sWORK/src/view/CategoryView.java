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


public class CategoryView extends AbstractContentView implements ActionListener {

	private CategoryFacade facade;
	private JTextField newNameField;
	private JTextArea newDescrArea;
	private JTextField updateNameField;
	private JTextArea updateDescrArea;
	private JSpinner updateCategorynameSpinner;
	private JSpinner deleteCategorynameSpinner;
	
	public CategoryView() {
		this.facade = new CategoryFacade();
		setLayout(null);
		
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
		
		updateCategorynameSpinner = new JSpinner();
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
		
		deleteCategorynameSpinner = new JSpinner();
		deleteCategorynameSpinner.setBounds(130, 423, 267, 22);
		deleteCategorynameSpinner.setModel(new SpinnerListModel(new String[] {"Category 1"}));
		panel.add(deleteCategorynameSpinner);
		
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
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(433, 118, 80, 27);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdd.addActionListener(this);
		btnAdd.setActionCommand("add");
		this.add(btnAdd);
		
		JLabel lblUpdateName = new JLabel("Name");
		lblUpdateName.setBounds(54, 233, 33, 16);
		lblUpdateName.setEnabled(false);
		panel.add(lblUpdateName);
		
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
	}
	
	//Recupere le nouveau nom de la categorie a ajouter
	public String getNewNameText()
	{
		return this.newNameField.getText();
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
