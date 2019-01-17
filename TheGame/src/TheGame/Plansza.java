package TheGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JComponent;


public class Plansza extends JPanel implements KeyListener, ActionListener{
	
	private int[] wazX = new int[750];
	private int[] wazY = new int[750];
	
	private boolean left = false;
	private boolean right = false;
	private boolean up = false;
	private boolean down = false;
	
	private ImageIcon rightmouth;
	private ImageIcon leftmouth;
	private ImageIcon upmouth;
	private ImageIcon downmouth;
	
	private int dlwaz = 3;
	
	private Timer timer;
	private int delay = 100;
	
	private int moves = 0;
	
	private ImageIcon snakeimage;
	private ImageIcon TitleImage;
	
	public Plansza() {

		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
	}
	public void paint(Graphics g) {
		
		if(moves == 0) {
			wazX[2] = 50;
			wazX[1] = 75;
			wazX[0] = 100;
			
			wazY[2] = 100;
			wazY[1] = 100;
			wazY[0] = 100;
		}
		
		//Dodajemy granice tytu³u
		g.setColor(Color.white);
		g.drawRect(24, 10, 851, 55);
		
		//Dodajemy rysunek w tutule
		TitleImage = new ImageIcon("snaketitle.jpg");
		TitleImage.paintIcon(this, g, 25, 11);
		
		//Dodawanie tablicy
		g.setColor(Color.WHITE);
		g.drawRect(24, 74, 851, 577);
		
		//Tworzenie t³a planszy gry
		g.setColor(Color.black);
		g.fillRect(25, 75, 850, 575);
	
		rightmouth = new ImageIcon("rightmouth.jpg");
		rightmouth.paintIcon(this, g, wazX[0], wazY[0]);
		
		for(int a=0; a<dlwaz; a++) {
			if(a==0 && right) {
				rightmouth = new ImageIcon("rightmouth.jpg");
				rightmouth.paintIcon(this, g, wazX[a], wazY[a]);
			}
			if(a==0 && left) {
				leftmouth = new ImageIcon("leftmouth.jpg");
				leftmouth.paintIcon(this, g, wazX[a], wazY[a]);
			}
			if(a==0 && up) {
				upmouth = new ImageIcon("upmouth.jpg");
				upmouth.paintIcon(this, g, wazX[a], wazY[a]);
			}
			if(a==0 && down) {
				downmouth = new ImageIcon("downmouth.jpg");
				downmouth.paintIcon(this, g, wazX[a], wazY[a]);
			}
			if(a!=0) {
				snakeimage = new ImageIcon("upmouth.png");
				upmouth.paintIcon(this, g, wazX[a], wazY[a]);
			}
		}
			
		g.dispose();
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	
	}

}
