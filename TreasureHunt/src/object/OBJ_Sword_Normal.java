package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Sword_Normal extends Entity{

	public OBJ_Sword_Normal(GamePanel gp) {
		super(gp);
		type = type_sword;
		name = "sword_normal";
		direction = "down";
		down1 = setup("/objects/" + name, gp.tileSize, gp.tileSize);
		attackValue = 1;
		attackArea.width = 44;
		attackArea.height = 44;
		description = "[Normal Sword]\nAn old sword\ndropped by the\nold man.";
		price = 40;
		forSale = true;
	}
}
