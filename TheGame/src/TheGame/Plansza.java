package TheGame;

import java.awt.Color;
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
		
		if(moves == 0) { // Starting position if doesn't move
			wazX[2] = 50;
			wazX[1] = 75;
			wazX[0] = 100;
			
			wazY[2] = 100;
			wazY[1] = 100;
			wazY[0] = 100;
		}
		
		g.setColor(Color.white);
		g.drawRect(24, 10, 851, 55);
		
		TitleImage = new ImageIcon("snaketitle.jpg");
		TitleImage.paintIcon(this, g, 25, 11);
		
		g.setColor(Color.WHITE);
		g.drawRect(24, 74, 851, 577);
		
		g.setColor(Color.black);
		g.fillRect(25, 75, 850, 575);
		
		rightmouth = new ImageIcon("rightmouth.png"); //Add picture to variable 
		rightmouth.paintIcon(this, g, wazX[0], wazY[0]);
		
		for(int a=0; a < dlwaz; a++) {
			
			if(a==0 && right) {
				rightmouth = new ImageIcon("rightmouth.png");
				rightmouth.paintIcon(this, g, wazX[a], wazY[a]);
			}
			if(a==0 && left) {
				leftmouth = new ImageIcon("leftmouth.png");
				leftmouth.paintIcon(this, g, wazX[a], wazY[a]);
			}
			if(a==0 && up) {
				upmouth = new ImageIcon("upmouth.png");
				upmouth.paintIcon(this, g, wazX[a], wazY[a]);
			}
			if(a==0 && down) {
				downmouth = new ImageIcon("downmouth.png");
				downmouth.paintIcon(this, g, wazX[a], wazY[a]);
			}
			if(a!=0) {
				snakeimage = new ImageIcon("snakeimage.png");
				snakeimage.paintIcon(this, g, wazX[a], wazY[a]);
			}
		}
			
		g.dispose();
	}
	@Override
	public void keyPressed(KeyEvent w) {
		// TODO Auto-generated method stub
		if(w.getKeyCode() == KeyEvent.VK_RIGHT) {
			moves++;
			right = true;
			left = false;
			up = false;
			down = false;
		}
		if(w.getKeyCode() == KeyEvent.VK_LEFT) {
			moves++;
			right = false;
			left = true;
			up = false;
			down = false;
		}
		if(w.getKeyCode() == KeyEvent.VK_UP) {
			moves++;
			right = false;
			left = false;
			up = true;
			down = false;
		}
		if(w.getKeyCode() == KeyEvent.VK_DOWN) {
			moves++;
			right = false;
			left = false;
			up = false;
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
				if(wazX[r]>25) {
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
					wazY[r] = wazY[r]+25;
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
				if(wazX[r]>625) {
					wazX[r]= 75;
				}
			}
			repaint();	
		}		
		}		
}
