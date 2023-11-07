package smelt.launcher.ui;

import smelt.launcher.Controller;
import smelt.launcher.ui.panels.Launch;
import smelt.launcher.ui.panels.Login;

import javax.swing.*;
import java.awt.*;

public class Launcher extends JFrame
{
	private Controller ctrl;
	private JPanel     panelSwitch;
	private JPanel     panelLaunch;
	private JPanel     panelLogin;
	private CardLayout crdLyt;

	public Launcher(Controller ctrl)
	{
		this.ctrl = ctrl;

		Image     icon       = getToolkit().getImage( getClass().getResource("/icon.png") );
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		int x  = ((int) screenSize.getWidth() - 1024) / 2;
		int y  = ((int) screenSize.getHeight() - 512) / 2;

		this.setLocation(x, y);
		this.setSize(780, 390);
		this.setTitle("G Launcher");
		this.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
		this.setResizable( false );
		this.setIconImage( icon  );

		this.crdLyt      = new CardLayout();
		this.panelSwitch = new JPanel ( this.crdLyt );
		this.panelLaunch = new Launch ( this.ctrl   );
		this.panelLogin  = new Login  ( this.ctrl   );

		this.panelSwitch.add( this.panelLogin,  "Login"  );
		this.panelSwitch.add( this.panelLaunch, "Launch" );

		this.add( this.panelSwitch );

		this.setVisible( true );
	}

	public void switchLogin()
	{
		this.crdLyt.next( this.panelSwitch );
	}

	public void checkOnline()
	{
		( (Login) this.panelLogin ).checkOnline();
	}

	public void refreshHeadImg() { ((Launch) this.panelLaunch).refreshHeadImg(); }
}
