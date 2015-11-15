// Created by Hyen Bin Doh

package src.dnd.test;

import java.applet.Applet;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import src.dnd.map.StartClass;

public class Menu implements KeyListener {

	private Image newg, loadg, options, extra, highlight;
	private Drawing hiL;
	
	public Menu(StartClass sc, ArrayList<Drawing> drwlist)
	{
		System.out.println("Menu Created!");
		newg = sc.getImage(sc.getDocumentBase(),"pic/NewGame.png");
		loadg = sc.getImage(sc.getDocumentBase(), "pic/LoadGame.png");
		options = sc.getImage(sc.getDocumentBase(), "pic/Options.png");
		extra = sc.getImage(sc.getDocumentBase(), "pic/Extra.png");
		highlight = sc.getImage(sc.getDocumentBase(), "pic/Highlight.png");
		
		hiL = new Drawing(highlight, 200, 120);
		drwlist.add(hiL);
		
		drwlist.add(new Drawing(newg, 200, 120));
		drwlist.add(new Drawing(loadg, 200, 190));
		drwlist.add(new Drawing(options, 200, 260));
		drwlist.add(new Drawing(extra, 200, 330));
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_UP:
			System.out.println("UP!");
			if(hiL.getY() > 120)
				hiL.setY(hiL.getY()-70);
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("DOWN!");
			if(hiL.getY() < 330)
				hiL.setY(hiL.getY()+70);
			break;
		default:
			System.out.println("Some other key...");
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
