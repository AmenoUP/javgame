package object;

import java.awt.Graphics;

import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import entities.Player;
import gamestates.Playing;
import levels.Level;
import objects.Spike;
import utilz.LoadSave;
import static utilz.Constants.ObjectConstants.*;

public class ObjectManager {


	private Playing playing;
	private BufferedImage spikeImg;
	private ArrayList<Spike> spikes;

	public ObjectManager(Playing playing) {
		this.playing = playing;
		loadImgs();
		spikes = new ArrayList<>();
	}

	public void checkSpikesTouched(Player p) {
		for (Spike s : spikes)
			if (s.getHitbox().intersects(p.getHitbox()))
				p.kill();
	}




	public void loadObjects(Level newLevel) {
		spikes = newLevel.getSpikes();
	}

	private void loadImgs() {
		spikeImg = LoadSave.GetSpriteAtlas(LoadSave.TRAP_ATLAS);
	}

	public void draw(Graphics g, int xLvlOffset) {
		drawTraps(g, xLvlOffset);
	}

	private void drawTraps(Graphics g, int xLvlOffset) {
		for (Spike s : spikes)
			g.drawImage(spikeImg, (int) (s.getHitbox().x - xLvlOffset), (int) (s.getHitbox().y - s.getyDrawOffset()), SPIKE_WIDTH, SPIKE_HEIGHT, null);

	}



}
