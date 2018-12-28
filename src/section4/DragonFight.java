package section4;

import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class DragonFight {
	// 1. Create a main method and put all of the code below inside of it
	public static void main(String[] args) {

		Random random = new Random();
		ImageIcon dragon = new ImageIcon("src/section4/dragonPicture.jpg");

		JOptionPane.showMessageDialog(null, "Defeat the dragon to take its treasure!", "Dragon Fighter", 0, dragon);
		int playerHealth = 100;
		int dragonHealth = 500;
		int playerDamage;
		int dragonDamage;

		while (playerHealth > 0 && dragonHealth > 0) {

			boolean pATK = false;
			int slashUses=10;
			int uppercutUses=5;
			while (pATK == false) {

				String player_ATK = JOptionPane.showInputDialog(null,
						"WHICH MOVE WILL YOU USE? \n OP1: SLASH    OP2: UPPERCUT  \n  OP3:POTIONS   OP4: INFO", "P1 ATK", JOptionPane.PLAIN_MESSAGE);
				if (player_ATK.equalsIgnoreCase("slash")) {
					if(slashUses>0) {
					slashUses-=1;
					dragonDamage=random.nextInt(11);
					dragonHealth= dragonHealth - dragonDamage;
					if (dragonDamage >= 6 && dragonDamage < 10) {
						JOptionPane.showMessageDialog(null, "ATK <SLASH> WAS CRITICAL! \n DAMAGE: " + dragonDamage);
					}else if(dragonDamage > 0 && dragonDamage < 6) {
						JOptionPane.showMessageDialog(null, "ATK <SLASH> WAS SUCCESSFUL! \n DAMAGE: " + dragonDamage);
					}else if(dragonDamage == 0) {
						JOptionPane.showMessageDialog(null, "ATK <SLASH> HAS FAILED! \n DAMAGE: " + dragonDamage);
					}else if(dragonDamage == 10) {
						JOptionPane.showMessageDialog(null, "ATK <SLASH> WAS SUPER CRITICAL! \n DAMAGE: " + dragonDamage);
					}
					}else {
						JOptionPane.showMessageDialog(null, "ATK <SLASH> HAS RUN OUT OF USES!");
					}
				} else if (player_ATK.equalsIgnoreCase("uppercut")) {
					if(uppercutUses>0) {
					uppercutUses-=1;
					dragonDamage=random.nextInt(26);
					dragonHealth= dragonHealth - dragonDamage;
					if (dragonDamage >= 6 && dragonDamage < 10) {
						JOptionPane.showMessageDialog(null, "ATK <UPPERCUT> WAS CRITICAL! \n DAMAGE: " + dragonDamage);
					}else if(dragonDamage > 0 && dragonDamage < 6) {
						JOptionPane.showMessageDialog(null, "ATK <UPPERCUT> WAS SUCCESSFUL! \n DAMAGE: " + dragonDamage);
					}else if(dragonDamage == 0) {
						JOptionPane.showMessageDialog(null, "ATK <UPPERCUT> HAS FAILED! \n DAMAGE: " + dragonDamage);
					}else if(dragonDamage == 10) {
						JOptionPane.showMessageDialog(null, "ATK <UPPERCUT> WAS SUPER CRITICAL! \n DAMAGE: " + dragonDamage);
					}
					}else {
					JOptionPane.showMessageDialog(null, "ATK <SLASH> HAS RUN OUT OF USES!");
					}
				}else if (player_ATK.equalsIgnoreCase("info")) {
					JOptionPane.showMessageDialog(null, "ATK <SLASH> STATS: \n USES: " + slashUses + "/10 \n The <SLASH> ATK, a skill recieved \n at the start of the game dealing \n 0-10 DMG, +5 per level.", "ATK <SLASH> STATS", JOptionPane.PLAIN_MESSAGE);
				}
			}



		}
	}
}
