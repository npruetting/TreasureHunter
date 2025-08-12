package object;

import entity.Projectile;
import main.GamePanel;

public class PROJ_Arrow_Purple extends Projectile{
	
	public PROJ_Arrow_Purple(GamePanel gp, int attack) {
		super(gp);
		solidArea.x = 26;
		solidArea.y = 26;
		solidArea.width = 16;
		solidArea.height = 16;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		name = "purple_arrow";
		speed = 12;
		maxHealth = 35;
		health = maxHealth;
		this.attack = attack;
		alive = false;
		getImage();
	}
	
	public void getImage() {
		up1 = setup("/projectiles/arrow_purple_up");
		up2 = setup("/projectiles/arrow_purple_up");
		down1 = setup("/projectiles/arrow_purple_down");
		down2 = setup("/projectiles/arrow_purple_down");
		left1 = setup("/projectiles/arrow_purple_left");
		left2 = setup("/projectiles/arrow_purple_left");
		right1 = setup("/projectiles/arrow_purple_right");
		right2 = setup("/projectiles/arrow_purple_right");
	}
}
