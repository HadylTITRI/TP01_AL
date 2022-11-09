package package1;
import java.awt.Color;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
public class LancerApp1 {

	public static void main(String[] args) throws IOException {
		
		BufferedImage imgVador= ImageIO.read(new File("images/person2.png"));
		BufferedImage imgLeila= ImageIO.read(new File("images/person1.png"));
		
		// cr�ation de la fen�tre de l'application
		JFrame laFenetre= new JFrame("Animation Train, etc.");
		laFenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		laFenetre.setSize(512, 512);
		
		// cr�ation de la z�ne de dessin dans la fen�tre
		
		Dessin d = new Dessin();
		laFenetre.getContentPane().add(d);
		
		// affiche la fen�tre
		laFenetre.setVisible(true);
		
		// les trains de cercles avec image et en couleur
		IObjetDessinable[] lesTrains= new IObjetDessinable[10];
		lesTrains[0] = new TrainCercleImage(d, 10, imgVador); d.ajouterObjet(lesTrains[0]);
		lesTrains[1] = new TrainCercleImage(d, 10, imgLeila); d.ajouterObjet(lesTrains[1]);
		for (int i = 2; i < 10; i++) {
			lesTrains[i] = new TrainCercleCouleur(new Color((float) Math.random(), (float) Math.random(),
		(float) Math.random()), d, 10, 10);
		d.ajouterObjet(lesTrains[i]);
		}
		
		//Ajouter un visage
		d.ajouterObjet(new Visage(d));
		
		//Ajouter une étoile et un polygone
		d.ajouterObjet((IObjetDessinable) new Etoile(255,350,20,1,new Color(0,255,0),new Color(0,255,0)));
		d.ajouterObjet((IObjetDessinable) new PolygoneRegulier(5,255,150,20,1,new Color(0),new Color(0)));
		
		d.ajouterObjet(new AnimationForme(new PolygoneRegulier(4,255,150,20,1,new Color(220,220,220),new Color(220,220,220)),new MvtCirculaire(255,150,70,15,15)));
		d.ajouterObjet(new AnimationForme(new Etoile(255,350,30,20,new Color(255,255,0),new Color(255,255,0)),new MvtCirculaire(255,350,70,50,15)));
		
		d.ajouterObjet(new AnimationForme(new Visage(d),new MvtCirculaire(80,80,40,100,20)));
		
		while(true) {
		// la zone de dessin se r�affiche
		d.repaint();
		// un temps de pause pour avoir le temps de voir le nouveau dessin
		d.pause(50);
		//r�aliser � tous les trains un d�placement �l�mentaire
		d.animer();
		
		}

	}

}
