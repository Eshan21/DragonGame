

import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class DragonFight {
	// 1. Create a main method and put all of the code below inside of it
	public static void main(String[] args) {

		Random random = new Random();

		int dragonToughness = 1;
		int playerHealth = 100;
		int dragonHealth = 100*dragonToughness;
		int playerDamage;
		int dragonDamage;
		
		int money = 150;
		int potion = 3;
		boolean pATK = false;
		
		int WeaponPower = 1;
		int Armor = 1;
		int upgradeWeaponPrice = 100;
		int upgradeArmorPrice = 150;
		
		int slashUses= 50;
		int uppercutUses= 50;
		
		ImageIcon dragon = new ImageIcon("src/dragonPicture.jpg");
		ImageIcon town = new ImageIcon("src/town.jpg");

		while (pATK == false) {
			
			String tOption = (String) JOptionPane.showInputDialog(null, "Where do yo want to go?", "Dragon Fighter", 0, town, null, town);
			
			//shop
			if (tOption.equalsIgnoreCase("shop")) {
				
				//shop item V
				String sItem = JOptionPane.showInputDialog("Potion: 50 each \n Upgrade Weapon: " + upgradeWeaponPrice +" \n Upgrade Armor: " + upgradeArmorPrice);
				if (sItem.equalsIgnoreCase("potion") && money >= 50) {
					
					potion += 1;
					
				}else if (sItem.equalsIgnoreCase("Upgrade Weapon") && money >= upgradeWeaponPrice) {
					
					WeaponPower += 1;
					upgradeWeaponPrice += 100;
					
				}else if (sItem.equalsIgnoreCase("Upgrade armor") && money >= upgradeArmorPrice) {
					
					Armor += 0.5;
					upgradeArmorPrice += 100;
					
				}
			}
					
			
			if (tOption.equalsIgnoreCase("stats")) {
				
				JOptionPane.showMessageDialog(null, "Weapons: " + WeaponPower + " Armor: " + Armor + "\n Potions: " + potion + " Health: " + playerHealth);
				
				
			}	
			
			if (tOption.equalsIgnoreCase("adventure")) {
				
				pATK = true;
				
			}
			
		}
		if (pATK == true) {
			
				JOptionPane.showMessageDialog(null, "Defeat the dragon to take its treasure!", "Dragon Fighter", 0, dragon);
	
		}
		
		while (pATK == true) {



			
				

		
				String player_ATK = JOptionPane.showInputDialog(null,
						"WHICH MOVE WILL YOU USE? \n OP1: SLASH    OP2: UPPERCUT  \n  OP3: POTIONS   OP4: INFO", "P1 ATK", JOptionPane.PLAIN_MESSAGE);
				if (player_ATK.equalsIgnoreCase("slash")) {
					if(slashUses>0) {
					slashUses-=1;
					dragonDamage=random.nextInt(11*WeaponPower);
					dragonHealth= dragonHealth - dragonDamage;
					if (dragonDamage >= 6*WeaponPower && dragonDamage < 10*WeaponPower) {
						JOptionPane.showMessageDialog(null, "ATK <SLASH> WAS CRITICAL! \n DAMAGE: " + dragonDamage);
					}else if(dragonDamage > 0 && dragonDamage < 6*WeaponPower) {
						JOptionPane.showMessageDialog(null, "ATK <SLASH> WAS SUCCESSFUL! \n DAMAGE: " + dragonDamage);
					}else if(dragonDamage == 0) {
						JOptionPane.showMessageDialog(null, "ATK <SLASH> HAS FAILED! \n DAMAGE: " + dragonDamage);
					}else if(dragonDamage == 10*WeaponPower) {
						JOptionPane.showMessageDialog(null, "ATK <SLASH> WAS SUPER CRITICAL! \n DAMAGE: " + dragonDamage);
					}
					}else {
						JOptionPane.showMessageDialog(null, "ATK <SLASH> HAS RUN OUT OF USES!");
					}
				
				} else if (player_ATK.equalsIgnoreCase("uppercut") && uppercutUses > 0) {
					uppercutUses += 1;
					uppercutUses -= 1;
					dragonDamage=random.nextInt(26*WeaponPower);
					dragonHealth= dragonHealth - dragonDamage;
					if (dragonDamage >= 6*WeaponPower && dragonDamage < 10*WeaponPower) {
						JOptionPane.showMessageDialog(null, "ATK <UPPERCUT> WAS CRITICAL! \n DAMAGE: " + dragonDamage);
					}else if(dragonDamage > 0 && dragonDamage < 6*WeaponPower) {
						JOptionPane.showMessageDialog(null, "ATK <UPPERCUT> WAS SUCCESSFUL! \n DAMAGE: " + dragonDamage);
					}else if(dragonDamage == 0) {
						JOptionPane.showMessageDialog(null, "ATK <UPPERCUT> HAS FAILED! \n DAMAGE: " + dragonDamage);
					}else if(dragonDamage == 10*WeaponPower) {
						JOptionPane.showMessageDialog(null, "ATK <UPPERCUT> WAS SUPER CRITICAL! \n DAMAGE: " + dragonDamage);
					}else {
					JOptionPane.showMessageDialog(null, "ATK <UPPERCUT> HAS RUN OUT OF USES!");
					}
			
				} else if (player_ATK.equalsIgnoreCase("info")) {
					JOptionPane.showMessageDialog(null, "ATK <SLASH> STATS: \n USES: " + slashUses + "/10 \n The <SLASH> ATK, a skill recieved \n at the start of the game dealing \n 0-10 DMG, +5 per level.", "ATK <SLASH> STATS", JOptionPane.PLAIN_MESSAGE);
				} else if (player_ATK.equalsIgnoreCase("potions") && potion > 0) {
					int PCon = JOptionPane.showConfirmDialog(null, "Are you sure you want to use a potion");
					if (PCon == 0) {
						playerHealth += 25;
					}
				} else if (dragonHealth <= 0) {
					
					playerHealth = 100*Armor;
					money += 100;
					pATK = false;
					slashUses = 50;
					uppercutUses = 50;
					
					
				}
			}



		}
	}

