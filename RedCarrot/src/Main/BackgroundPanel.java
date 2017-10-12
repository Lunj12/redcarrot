/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;
/**
 *
 * @author 仑
 */
public class BackgroundPanel extends JPanel {
        String myCurrentDir = System.getProperty("user.dir"); 
	protected ImageIcon icon;
	public BackgroundPanel() {
	super();
        icon = new ImageIcon(myCurrentDir + "//background.jpg");
	}
	protected void paintComponent(Graphics graphic) {
		super.paintComponent(graphic);
		Image image = icon.getImage();
		graphic.drawImage(image, 0, 0,this.getWidth(),this.getHeight(),getParent());
	}
}