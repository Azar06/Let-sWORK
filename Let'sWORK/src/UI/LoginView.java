package UI;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
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

public class LoginView extends JFrame implements ActionListener {

	private JPanel container = new JPanel();
	private int width = 800;
	private int height = 600;
	private JTextField textField;
	private JPasswordField passwordField;

	public LoginView(){
		//Definit un titre pour notre fenetre
		this.setTitle("Login - Let's WORK!");
		//Definit sa taille : 800 pixels de large et 600 pixels de haut
		this.setSize(width, height);
		//Nous demandons maintenant à notre objet de se positionner au centre
		this.setLocationRelativeTo(null);
		//Termine le processus lorsqu on clique sur la croix rouge
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		//On previent notre JFrame que notre JPanel sera son content pane
		this.setContentPane(container);  
		SpringLayout sl_container = new SpringLayout();
		container.setLayout(sl_container);

		JLabel lblWelcome = new JLabel("Welcome!");
		sl_container.putConstraint(SpringLayout.NORTH, lblWelcome, 93, SpringLayout.NORTH, container);
		sl_container.putConstraint(SpringLayout.WEST, lblWelcome, 281, SpringLayout.WEST, container);
		sl_container.putConstraint(SpringLayout.EAST, lblWelcome, -281, SpringLayout.EAST, container);
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 40));
		container.add(lblWelcome);

		JLabel lblLogin = new JLabel("Login");
		sl_container.putConstraint(SpringLayout.SOUTH, lblWelcome, -50, SpringLayout.NORTH, lblLogin);
		sl_container.putConstraint(SpringLayout.EAST, lblLogin, -367, SpringLayout.EAST, container);
		sl_container.putConstraint(SpringLayout.NORTH, lblLogin, 184, SpringLayout.NORTH, container);
		sl_container.putConstraint(SpringLayout.WEST, lblLogin, 367, SpringLayout.WEST, container);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		container.add(lblLogin);

		JLabel lblPassword = new JLabel("Password");
		sl_container.putConstraint(SpringLayout.WEST, lblPassword, 355, SpringLayout.WEST, container);
		sl_container.putConstraint(SpringLayout.EAST, lblPassword, -343, SpringLayout.EAST, container);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		container.add(lblPassword);

		textField = new JTextField();
		sl_container.putConstraint(SpringLayout.NORTH, textField, 17, SpringLayout.SOUTH, lblLogin);
		sl_container.putConstraint(SpringLayout.WEST, textField, 296, SpringLayout.WEST, container);
		sl_container.putConstraint(SpringLayout.EAST, textField, -297, SpringLayout.EAST, container);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		container.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		sl_container.putConstraint(SpringLayout.SOUTH, lblPassword, -17, SpringLayout.NORTH, passwordField);
		sl_container.putConstraint(SpringLayout.NORTH, passwordField, 321, SpringLayout.NORTH, container);
		sl_container.putConstraint(SpringLayout.WEST, passwordField, 0, SpringLayout.WEST, textField);
		sl_container.putConstraint(SpringLayout.EAST, passwordField, -297, SpringLayout.EAST, container);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		container.add(passwordField);

		JButton btnEnter = new JButton("Enter");
		sl_container.putConstraint(SpringLayout.NORTH, btnEnter, 37, SpringLayout.SOUTH, passwordField);
		sl_container.putConstraint(SpringLayout.WEST, btnEnter, 352, SpringLayout.WEST, container);
		sl_container.putConstraint(SpringLayout.EAST, btnEnter, -352, SpringLayout.EAST, container);
		btnEnter.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEnter.addActionListener(this);
		btnEnter.setActionCommand("enter");
		container.add(btnEnter);

		JLabel label = new JLabel("");
		sl_container.putConstraint(SpringLayout.NORTH, label, 66, SpringLayout.NORTH, container);
		sl_container.putConstraint(SpringLayout.WEST, label, 80, SpringLayout.WEST, container);
		container.add(label);
		//On rend la fenetre visible    
		this.setVisible(true);

	}

	public String getLoginText()
	{
		return this.textField.getText(); 
	}

	public String getPasswdText()
	{
		return new String( this.passwordField.getPassword() );
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		String cmd = arg0.getActionCommand();
		if(cmd.equals("enter"))
		{
			if((!getLoginText().equals("")) && (!getPasswdText().equals("")))
			{
				System.out.println("ok!");
			}
			else
			{
				System.out.println("not ok!");
			}
		}		
	}
}
