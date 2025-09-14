package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Quest_Exclamation_Mark extends Entity{

	public OBJ_Quest_Exclamation_Mark(GamePanel gp) {
		super(gp);
		type = type_item;
		name = "quest_exclamation_mark";
		direction = "default";
		down1 = setup("/objects/green_exclamation", gp.tileSize, gp.tileSize);
	}

}
