package TheGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Plansza extends JPanel implements KeyListener, ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int[] wazX = new int[750];
	private int[] wazY = new int[750];
	
	URL title = Plansza.class.getResource("/resources/title.jpg");
	URL upi = Plansza.class.getResource("/resources/up.png");
	URL downi = Plansza.class.getResource("/resources/down.png");
	URL righti = Plansza.class.getResource("/resources/right.png");
	URL lefti = Plansza.class.getResource("/resources/left.png");
	URL foodi = Plansza.class.getResource("/resources/food.png");
	URL bodyi = Plansza.class.getResource("/resources/body.png");
	URL grassi = Plansza.class.getResource("/resources/grass.jpg");
	
	
	
	private boolean left = false;
	private boolean right = false;
	private boolean up = false;
	private boolean down = false;
	
	private ImageIcon rightmouth;
	private ImageIcon leftmouth;
	private ImageIcon upmouth;
	private ImageIcon downmouth; 
	
	private Random random = new Random();
	
	private int foodX = ((random.nextInt(34)+1)*25);
	private int foodY = ((random.nextInt(22)+3)*25);
	
	private int dlwaz = 3;
	private int score = 0;
	
	private Timer timer;
	private int delay = 125;
	
	private int moves = 0;
	
	private ImageIcon snakeimage;
	private ImageIcon TitleImage;
	private ImageIcon Foodimage;
	private ImageIcon grass;
	
	
	public Plansza() {

		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
	}
	public void paint(Graphics g) {
		
		if(moves == 0) { // Starting position if doesn't move
			wazX[2] = 350;
			wazX[1] = 375;
			wazX[0] = 400;
			
			wazY[2] = 350;
			wazY[1] = 350;
			wazY[0] = 350;
		}
		
		g.setColor(Color.white);
		g.drawRect(24, 10, 851, 55);
		
		TitleImage = new ImageIcon(title);
		TitleImage.paintIcon(this, g, 25, 11);
		
		g.setColor(Color.WHITE);
		g.drawRect(24, 74, 851, 577);
		
		grass = new ImageIcon(grassi);  
		grass.paintIcon(this, g, 25, 75);
		
		g.setColor(Color.CYAN);
		g.setFont(new Font("TimesNewRoman", Font.BOLD, 16));
		g.drawString("Wynik: "+score, 780, 45);
		
		rightmouth = new ImageIcon(righti);  
		rightmouth.paintIcon(this, g, wazX[0], wazY[0]);
		
		for(int a=0; a < dlwaz; a++) {
			
			if(a==0 && right) {
				rightmouth = new ImageIcon(righti);
				rightmouth.paintIcon(this, g, wazX[a], wazY[a]);
			}
			if(a==0 && left) {
				leftmouth = new ImageIcon(lefti);
				leftmouth.paintIcon(this, g, wazX[a], wazY[a]);
			}
			if(a==0 && up) {
				upmouth = new ImageIcon(upi);
				upmouth.paintIcon(this, g, wazX[a], wazY[a]);
			}
			if(a==0 && down) {
				downmouth = new ImageIcon(downi);
				downmouth.paintIcon(this, g, wazX[a], wazY[a]);
			}
			if(a!=0) {
				snakeimage = new ImageIcon(bodyi);
				snakeimage.paintIcon(this, g, wazX[a], wazY[a]);
			}
		}
		Foodimage = new ImageIcon(foodi);
		
			if((foodX == wazX[0]) && (foodY == wazY[0])){
			score++;
			dlwaz++;
			foodX = ((random.nextInt(34)+1)*25);
			foodY = ((random.nextInt(22)+3)*25);
			}
			if((foodX == wazX[1]) && (foodY == wazY[1])) {
			foodX = ((random.nextInt(34)+1)*25);
			foodY = ((random.nextInt(22)+3)*25);
			}
			if((foodX == wazX[2]) && (foodY == wazY[2])) {
			foodX = ((random.nextInt(34)+1)*25);
			foodY = ((random.nextInt(22)+3)*25);
			}
		Foodimage.paintIcon(this, g, foodX, foodY);
			
		for(int a=1; a<dlwaz; a++) {
			if(wazX[a] == wazX[0] && wazY[a] == wazY[0]) {
				up = false;
				down = false;
				right = false;
				left = false;
				
				g.setColor(Color.BLACK);
				g.setFont(new Font("arial", Font.BOLD, 64));
				g.drawString("Koniec Gry", 300, 300);
				
				g.setFont(new Font("arial", Font.BOLD, 32));
				g.drawString("Naciœnij R aby zresetowaæ", 265, 350);
			}
		}
		g.dispose();
	}

	@Override
	public void keyPressed(KeyEvent w) {
		// TODO Auto-generated method stub
		if(w.getKeyCode() == KeyEvent.VK_R) {
			score = 0;
			moves = 0;
			dlwaz = 3;
			repaint();
		}
		if((w.getKeyCode() == KeyEvent.VK_RIGHT) && (!left)){
			moves++;
			right = true;
			up = false;
			down = false;
		
		}
		if((w.getKeyCode() == KeyEvent.VK_LEFT) && (!right)) {
			moves++;
			left = true;
			up = false;
			down = false;
		}
		if((w.getKeyCode() == KeyEvent.VK_UP) && (!down)) {
			moves++;
			right = false;
			left = false;
			up = true;
		}
		if((w.getKeyCode() == KeyEvent.VK_DOWN) && (!up)) {
			moves++;
			right = false;
			left = false;
			down = true;
		}
	}
	@Override
	public void keyReleased(KeyEvent w) {
		// TODO Auto-generated method stub
	}	
	
	@Override
	public void keyTyped(KeyEvent w) {
		// TODO Auto-generated method stub
	
	}
	@Override
	public void actionPerformed(ActionEvent w) {
		// TODO Auto-generated method stub
		timer.start();
		if(right) {
			for(int r = dlwaz-1; r>=0; r--) {
					wazY[r+1] = wazY[r];
			}
			for(int r= dlwaz; r>=0; r--) {
				if(r==0) {
					wazX[r] = wazX[r]+25;
				}
				else {
					wazX[r] = wazX[r-1];
				}
				if(wazX[r]>850) {
					wazX[r]= 25;
				}
			}
			repaint();	
		}
		if(left) {
			for(int r = dlwaz-1; r>=0; r--) {
					wazY[r+1] = wazY[r];
			}
			for(int r= dlwaz; r>=0; r--) {
				if(r==0) {
					wazX[r] = wazX[r]-25;
				}
				else {
					wazX[r] = wazX[r-1];
				}
				if(wazX[r]<25) {
					wazX[r]= 850;
				}
			}
			repaint();		
		}
		if(up) {
			for(int r = dlwaz-1; r>=0; r--) {
					wazX[r+1] = wazX[r];
			}
			for(int r= dlwaz; r>=0; r--) {
				if(r==0) {
					wazY[r] = wazY[r]-25;
				}
				else {
					wazY[r] = wazY[r-1];
				}
				if(wazY[r]<75) {
					wazY[r]= 625;
				}
			}
			repaint();	
		}
		if(down) {
			for(int r = dlwaz-1; r>=0; r--) {
					wazX[r+1] = wazX[r];
				}
			for(int r= dlwaz; r>=0; r--) {
				if(r==0) {
					wazY[r] = wazY[r]+25;
				}
				else {
					wazY[r] = wazY[r-1];
				}
				if(wazY[r]>625) {
					wazY[r]= 75;
				}
			}
			repaint();	
		}		
		}		
}
