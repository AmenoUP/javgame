package object;

import main.Game;

public class spike  extends GameObject{
	public spike(int x,int y,int objType) {
		super(x,y,objType);
		
		initHitbox(32,16);
		xDrawOffset=0;
		yDrawOffset=(int)(Game.SCALE*16);
		hitbox.y+=yDrawOffset;
	}

}
