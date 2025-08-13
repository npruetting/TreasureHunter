package main;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

/**
 * Class that implements the sound effects and background music into the game.
 */
public class Sound {

	private Clip clip;
	public URL soundURL[] = new URL[32];
	UtilityTool uTool = new UtilityTool();
	public int volumeMusic;
	public int volumeSFX;

	/**
	 * Constructor that sets each .wav file into the array of URLs such that each
	 * sound file can be accessed.
	 */
	public Sound() {
		volumeMusic = 100;
		volumeSFX = 100;
		soundURL[0] = getClass().getResource("/music/music_MainTheme.wav");
		soundURL[1] = getClass().getResource("/sound/coin.wav");
		soundURL[2] = getClass().getResource("/sound/powerup.wav");
		soundURL[3] = getClass().getResource("/sound/unlock.wav");
		soundURL[4] = getClass().getResource("/music/music_Ominous.wav");
		soundURL[5] = getClass().getResource("/sound/portal.wav");
		soundURL[6] = getClass().getResource("/sound/damage.wav");
		soundURL[7] = getClass().getResource("/sound/game_over_1.wav");
		soundURL[8] = getClass().getResource("/sound/game_over_2.wav");
		soundURL[9] = getClass().getResource("/sound/npc_talk_1.wav");
		soundURL[10] = getClass().getResource("/sound/npc_talk_2.wav");
		soundURL[11] = getClass().getResource("/sound/sword_hits.wav");
		soundURL[12] = getClass().getResource("/sound/sword_misses.wav");
		soundURL[13] = getClass().getResource("/sound/monster_dies.wav");
		soundURL[14] = getClass().getResource("/sound/level_up.wav");
		soundURL[15] = getClass().getResource("/sound/cursor.wav");
		soundURL[16] = getClass().getResource("/sound/equipped.wav");
		soundURL[17] = getClass().getResource("/sound/tree_chop.wav");
		soundURL[18] = getClass().getResource("/sound/tree_fall.wav");
		soundURL[19] = getClass().getResource("/sound/light_on.wav");
		soundURL[20] = getClass().getResource("/sound/error.wav");
		soundURL[21] = getClass().getResource("/music/music_Dungeon.wav");
		soundURL[22] = getClass().getResource("/music/music_Dungeon2.wav");
		soundURL[23] = getClass().getResource("/music/music_BossEncounter.wav");
		soundURL[24] = getClass().getResource("/music/music_Merchant.wav");
		soundURL[25] = getClass().getResource("/sound/pickup.wav");
		soundURL[26] = getClass().getResource("/sound/iron_gate_slide.wav");
		soundURL[27] = getClass().getResource("/music/music_BossFight.wav");
		soundURL[28] = getClass().getResource("/sound/finale.wav");
		soundURL[29] = getClass().getResource("/music/music_OldManEncounter.wav");
		soundURL[30] = getClass().getResource("/music/music_TreasureIsland.wav");
		soundURL[31] = getClass().getResource("/sound/map_change.wav");
	}

	/**
	 * Method called in GamePanel to play music and sound effects.
	 * 
	 * @param i - the index of the sound to play from the soundURL array
	 */
	public void setFile(int i) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
			clip = AudioSystem.getClip();
			clip.open(ais);
		} catch (Exception e) {
		}
	}

	/**
	 * Method that plays the sound once.
	 * 
	 * @param setVolume - volume to set clip that gets scaled with the utility tool
	 */
	public void play(float setVolume) {
		volumeSetter(setVolume);
		clip.start();
	}

	/**
	 * Sets volume for a clip.
	 * 
	 * @param volume to set
	 */
	public void volumeSetter(float volume) {
		FloatControl setVolume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		setVolume.setValue(uTool.scaleVolume(volume));
		
		//FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.VOLUME);
//        float range = control.getMinimum();
//        float result = range * (1 - volume / 100.0f);
//        control.setValue(result);
		
//		float range = volumeControl.getMaximum() - volumeControl.getMinimum();
//		float gain = (range * volume) + volumeControl.getMinimum();
//		System.out.println(gain);
//		if (volumeControl != null) {
//	        volumeControl.setValue(gain);
//	   }
		//volumeControl.setValue(gain);
	}

	/**
	 * Method that loops the sound.
	 */
	public void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

	/**
	 * Method that stops the sound from playing.
	 */
	public void stop() {
		clip.stop();
	}
}
