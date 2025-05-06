import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Settings {
    public static String player1 = "Гравець 1";
    public static String player2 = "Гравець 2";
    public static int size = 3;

    public static void loadSettings() {
        try {
            File file = new File("settings.txt");
            if (!file.exists()) return;
            Scanner sc = new Scanner(file);
            player1 = sc.nextLine();
            player2 = sc.nextLine();
            size = Integer.parseInt(sc.nextLine());
            sc.close();
        } catch (Exception e) {
            System.out.println("Помилка читання налаштувань. Використано значення за замовчуванням.");
        }
    }

    public static void configure(Scanner sc) {
        System.out.print("Введіть ім’я гравця 1: ");
        player1 = sc.nextLine();
        System.out.print("Введіть ім’я гравця 2: ");
        player2 = sc.nextLine();
        System.out.print("Введіть розмір поля (наприклад, 3): ");
        size = sc.nextInt();
        sc.nextLine();

        try {
            FileWriter fw = new FileWriter("settings.txt");
            fw.write(player1 + "\n");
            fw.write(player2 + "\n");
            fw.write(size + "\n");
            fw.close();
            System.out.println("Налаштування збережено.");
        } catch (IOException e) {
            System.out.println("Помилка збереження.");
        }
    }
}

