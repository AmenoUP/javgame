package entities;
import static utilz.Constants.EnemyConstants.*;
import static utilz.HelpMethods.CanMoveHere;
import static utilz.HelpMethods.*;
import static utilz.HelpMethods.IsEntityOnFloor;
import static utilz.HelpMethods.IsFloor;

import main.Game;
public class Rhino extends Enemy{

	public Rhino(float x, float y)
	{
		super(x, y, RHINO_WIDTH, RHINO_HEIGHT, RHINO);
		
		initHitbox(22 ,19);
		
		System.out.println("X rhino : " + x);
		System.out.println("Y rhino : " + y);
	}
	
	public void update(int[][] lvlData)
	{
		updateMove(lvlData);
		updateAnimationTick();		
	}
	
	private void updateMove(int[][] lvlData)
	{
		if(firstUpdate)
		{
			firstUpdateCheck(lvlData);
		}
		
		if(inAir)
		{
			updateInAir(lvlData);
		}
		else
		{	
			float xSpeed = 0;
			
			switch (enemyState) {
			case IDLE_RIGHT:
				enemyState = RUNNING_RIGHT;
				break;
				
			case IDLE_LEFT:
				enemyState = RUNNING_LEFT;
				break;
				
			case RUNNING_RIGHT:
				
				//System.out.println("Cours à droite");
				xSpeed -= walkSpeed;
				enemyState = RUNNING_RIGHT;

				if (CanMoveHere(hitbox.x + xSpeed, hitbox.y, hitbox.width, hitbox.height, lvlData))
				{

					if (IsFloor(hitbox, xSpeed, lvlData)) {
						hitbox.x += xSpeed;
						
						return;
					}
					newState(RUNNING_LEFT);
				}

				//enemyState = RUNNING_LEFT;
				
			case RUNNING_LEFT:
				//System.out.println("Cours à gauche");
				xSpeed += walkSpeed;
				enemyState = RUNNING_LEFT;

				if (CanMoveHere(hitbox.x + xSpeed, hitbox.y, hitbox.width, hitbox.height, lvlData))
					if (IsFloor(hitbox, xSpeed, lvlData)) {
						hitbox.x += xSpeed;
						
						return;
					}
				newState(RUNNING_RIGHT);

				//enemyState = RUNNING_RIGHT;
				

				break;
			}
		}
	}
	
	public int getX()
	{
		return (int) super.x;
	}
	
	public int getY()
	{
		return (int)super.y;
	}
}