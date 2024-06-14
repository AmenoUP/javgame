package object;

import static utilz.Constants.*;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

import main.Game;

public class GameObject {
	
	protected int x,y,objType;
	protected Rectangle2D.Float hitbox;
	protected boolean doAnimation,active=true;
	protected int aniTick,aniIndex;
	protected int xDrawOffset,yDrawOffset;
	
	
	public GameObject(int x,int y,int objType) {
		this.x=x;
		this.y=y;
		this.objType=objType;
		
	}
	
	protected void initHitbox(int width, int height) {
		hitbox = new Rectangle2D.Float(x, y,(int)(width*Game.SCALE),(int)(height*Game.SCALE));
	}
	
	protected void drawHitbox(Graphics g,int xLevlOffset) {
		// For debugging the hitbox
		g.setColor(Color.PINK);
		g.drawRect((int) hitbox.x, (int) hitbox.y, (int) hitbox.width, (int) hitbox.height);

}

	public int getObjType() {
		return objType;
	}


	public Rectangle2D.Float getHitbox() {
		return hitbox;
	}
	
	public void setActive(boolean active) {
		this.active=active;
	}


	public boolean isActive() {
		return active;
	}


	public int getxDrawOffset() {
		return xDrawOffset;
	}


	public int getyDrawOffset() {
		return yDrawOffset;
	}

	public int getAniIndex() {
		return aniIndex;
	}
	
	}
