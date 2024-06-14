package entities;

import main.Game;
import static utilz.Constants.EnemyConstants.*;
import static utilz.HelpMethods.*;
import static utilz.Constants.Directions.*;
import static utilz.Constants.*;

public abstract class Enemy extends Entity{
	
	protected int aniIndex, enemyState, enemyType;
	protected int aniTick, aniSpeed = 25;
	protected boolean firstUpdate = false;
	protected boolean inAir = true;
	protected float fallSpeed;
	protected float gravity = 0.04f * Game.SCALE;
	protected float walkSpeed = 0.35f * Game.SCALE;
	protected float walkDir = LEFT;

	protected float xSpeed = 0;
	
	public Enemy(float x, float y, int width, int height, int enemyType)
	{
		super(x, y, width, height);
		this.enemyType = enemyType;
		initHitbox(20,27);
		
	}
	
	protected void firstUpdateCheck(int[][]lvlData)
	{
		if(!IsEntityOnFloor(hitbox, lvlData))
		{
			inAir = true; 
		}
		firstUpdate = false; 
	}
	
	protected void updateInAir(int[][]lvlData)
	{
		if(CanMoveHere(hitbox.x, hitbox.y + fallSpeed, hitbox.width, hitbox.height, lvlData))
		{
			hitbox.y += fallSpeed;
			fallSpeed += GRAVITY;
		}
		else
		{
			inAir = false;
			hitbox.y = GetEntityYPosUnderRoofOrAboveFloor(hitbox, fallSpeed);
		}
	}
	
	protected void newState(int enemyState)
	{
		this.enemyState = enemyState;
		aniTick = 0;
		aniIndex = 0;
	}
	protected void updateAnimationTick()
	{
		aniTick++;
		if(aniTick >= aniSpeed) {
			aniTick = 0;
			aniIndex++;
			if(aniIndex >= GetSpritAmount(enemyType, enemyState))
			{
				aniIndex = 0;
			}
		}
	}
	
	
	
	
	
	private void changeWalkDir() {
		
		if(walkDir == LEFT)
		{
			walkDir = RIGHT;
		}
		else
		{
			walkDir = LEFT;
		}
	}

	public int getAniIndex()
	{
		return aniIndex;
	}
	
	public int enemyState()
	{
		return enemyState;
	}
	
	public void resetEnemy() {
		hitbox.x = x;
		hitbox.y = y;
		firstUpdate = true;		
		newState(IDLE_LEFT);		
		fallSpeed = 0;
	}
	
	
	

}
