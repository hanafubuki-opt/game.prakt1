
import java.util.Random;
import java.util.Scanner;
public class Battle {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random(); // Random ініціалізується статично

    public static void main(String[] args) {
        Character obito = new ObitoUchiha();
        Character kakashi = new KakashiHatake();

        // Create and equip items
        Equipment kunai = new Equipment("Kunai", 0, 10, 5);
        Equipment armor = new Equipment("Armor", 20, 20, 0);

        // Interactive gameplay loop
        while (obito.isAlive() && kakashi.isAlive()) {
            System.out.println("\n--- Your Turn ---");
            playerTurn(kakashi, obito, kunai, armor);
            if (!obito.isAlive()) {
                System.out.println("Obito has been defeated!");
                break;
            }
            System.out.println("\n--- Obito's Turn ---");
            aiTurn(obito, kakashi, kunai, armor); // Передача kunai і armor
            if (!kakashi.isAlive()) {
                System.out.println("Kakashi has been defeated!");
                break;
            }
        }
        scanner.close();
    }

    // Method for player's turn
    public static void playerTurn(Character player, Character opponent, Equipment kunai, Equipment armor) {
        System.out.println("Choose an action:");
        System.out.println("1. Attack");
        System.out.println("2. Use Ability");
        System.out.println("3. Heal");
        System.out.println("4. Equip Kunai");
        System.out.println("5. Equip Armor");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                player.attack(opponent);
                break;
            case 2:
                player.useAbility(opponent);
                break;
            case 3:
                player.heal(20); // Heals 20 health points
                break;
            case 4:
                kunai.equip(player);
                break;
            case 5:
                armor.equip(player);
                break;
            default:
                System.out.println("Invalid choice, skipping turn.");
                break;
        }
    }

   
    // AI turn for Obito with random behavior
    public static void aiTurn(Character obito, Character kakashi, Equipment kunai, Equipment armor) {
        int action = random.nextInt(5) + 1; // Не статичний виклик nextInt()

        switch (action) {
            case 1:
                obito.attack(kakashi);
                break;
            case 2:
                obito.useAbility(kakashi);
                break;
            case 3:
                obito.heal(20); // AI heals itself
                break;
            case 4:
                kunai.equip(obito); // AI equips Kunai
                break;
            case 5:
                armor.equip(obito); // AI equips Armor
                break;
        }
    }
}