// Created by Hyen Bin Doh

package src.dnd.map;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.ArrayList;

import src.dnd.test.Animation;
import src.dnd.test.Drawing;

public class StartClass extends Applet implements Runnable, KeyListener, MouseListener{

	public StartClass()
	{	}
	
	public static String state;
	private URL base;
	private Graphics graphic;
	private Image image, background1, background2, background3;
	private ArrayList<Drawing> drawings;
	private Animation backanim;
	private Rectangle[] tile = new Rectangle[900];
	private State _curState;
	

	@Override
	public void init()
	{
		setSize(700, 700);
		setBackground(Color.WHITE);
		setFocusable(true);
		addKeyListener(this);
		Frame frame = (Frame) this.getParent().getParent();
		frame.setTitle("D&D Revolution");
		Grid.initialize();
		state = "Start";
		_curState = new CreateWallState();
		try
		{
			base = getDocumentBase();
			addMouseListener(this);
		}
		catch (Exception e)
		{

		}
		for(int i=0; i < 900; i++){
			tile[i] = new Rectangle(20,20);
		}
	}

	@Override
	public void start()
	{
		Thread starting = new Thread(this);
		starting.start();
	}
	
	@Override
	public void run()
	{
		while(state.equals("Start"))
		{
			repaint();
			try{
				Thread.sleep(20);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void animate() {

	}
	
	@Override
	public void update(Graphics g) {
		if (image == null) {
			image = createImage(this.getWidth(), this.getHeight());
			graphic = image.getGraphics();
		}

		graphic.setColor(getBackground());
		graphic.fillRect(0, 0, getWidth(), getHeight());
		graphic.setColor(getForeground());

		paint(graphic);
		
		g.drawImage(image, 0, 0, this);
	}

	@Override
	public void paint(Graphics g)
	{
		_curState.render(g);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		_curState.handleClick(x, y);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("Key Pressed!");
		_curState.handleKeyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
