package view;

import javax.swing.JFrame;

import persistence.User;

public class LetsWorkWindow extends JFrame implements WindowIF {
	
	private static final long serialVersionUID = 1L;
	
	private static int width = 800;
	private static int height = 630;
	
	private User user = null;
	
	public LetsWorkWindow() {
		super();
		//Definit un titre pour notre fenetre
		this.setTitle("Let's WORK!");
		//Definit sa taille : 800 pixels de large et 600 pixels de haut
		this.setSize(width, height);
		//Nous demandons maintenant à notre objet de se positionner au centre
		this.setLocationRelativeTo(null);
		//Termine le processus lorsqu on clique sur la croix rouge
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//On previent notre JFrame que notre JPanel sera son content pane
		this.setView(new LoginView());
		//On rend la fenetre visible    
		this.setVisible(true);
	}
	
	@Override
	public void setView(AbstractView view) {
		this.setContentPane(view);
		this.setVisible(true);
		view.setWindow(this);
	}
	
	public User getUser() {
		return this.user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}
