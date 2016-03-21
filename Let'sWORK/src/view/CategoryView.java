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


public class CategoryView extends AbstractView implements ActionListener {

	private CategoryFacade facade;
	
	public CategoryView() {
		this.facade = new CategoryFacade();
		setLayout(new SpringLayout());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
