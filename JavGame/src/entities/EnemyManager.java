package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import gamestates.Playing;
import utilz.LoadSave;
import utilz.Constants;
import static utilz.Constants.EnemyConstants.*;

public class EnemyManager {	
	
	private Playing playing;
	BufferedImage[][] RhinoArr;
	private ArrayList<Rhino> rhinos = new ArrayList<>();
	
	
	
	public EnemyManager(Playing playing)	
	{
		this.playing = playing;
		loadEnemyImgs();
		addEnemies();
		
		
		
	}
	
	public ArrayList<Rhino> getLstRhino()
	{
		return rhinos;
	}
	
	private void addEnemies() {
		rhinos = LoadSave.GetRhinos();
		
		System.out.println("taille liste de rhinos : " + rhinos.size());
		System.out.println("taille tableau de rhinos : " + RhinoArr.length);
		
		for (int i = 0; i < RhinoArr.length; i++) {
		    for (int j = 0; j < RhinoArr[i].length; j++) {
		        BufferedImage image = RhinoArr[i][j];
		       //System.out.println("Image à l'indice [" + i + "][" + j + "]");
		       
		    }
		}
		

		
		
	}

	public void update(int[][] lvlData)
	{
		for(Rhino r : rhinos)
		{
			r.update(lvlData);
		}
	}	
	
	public void draw(Graphics g, int xLvlOffset)
	{
		//System.out.println("****************** DEssine rhino - fonction draw");
		drawRhinos(g, xLvlOffset);
		
	}	
	
	private void drawRhinos(Graphics g, int xLvlOffset) {
		
		//System.out.println("****************** DEssine rhino- draw Rhino");
		
		  for (Rhino r : rhinos) {
		        g.drawImage(
		            RhinoArr[r.enemyState()][r.getAniIndex()],
		            //(int) r.getX(),
		            //(int) r.getY(),
		            (int)r.getHitbox().x - xLvlOffset - RHINO_DRAWOFFSET_X,
		            (int)r.getHitbox().y - RHINO_DRAWOFFSET_Y,
		            Constants.EnemyConstants.RHINO_WIDTH,
		            Constants.EnemyConstants.RHINO_HEIGHT,
		            null
		        );
		        
				//System.out.println("enemy state : " + RhinoArr[r.enemyState()][r.getAniIndex()]);

		        // ... (autres informations de débogage)
		    }
	}

	private void loadEnemyImgs()
	{
		RhinoArr = new BufferedImage[5][11];
		BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.RHINO_SPRITE);
		
		for(int j=0; j < RhinoArr.length; j++)
		{
			for(int i = 0; i< RhinoArr[j].length; i++)
			{
				RhinoArr[j][i] = temp.getSubimage(i * Constants.EnemyConstants.RHINO_WIDTH_DEFAULT, j * Constants.EnemyConstants.RHINO_HEIGHT_DEFAULT, Constants.EnemyConstants.RHINO_WIDTH_DEFAULT, Constants.EnemyConstants.RHINO_HEIGHT_DEFAULT);

			}
		}
	}
	
	public void resetAllEnemies() {
		for (Rhino r : rhinos)
			r.resetEnemy();
	}
}