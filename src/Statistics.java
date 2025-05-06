import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Statistics {
    public static void save(String winnerName, char symbol) {
        try {
            FileWriter fw = new FileWriter("statistics.txt", true);
            String now = new java.util.Date().toString();
            fw.write("Переможець: " + winnerName + ", Символ: " + symbol + ", Розмір поля: " + Settings.size + ", Дата: " + now + "\n");
            fw.close();
        } catch (IOException e) {
            System.out.println("Помилка запису статистики.");
        }
    }

    public static void show() {
        try {
            File file = new File("statistics.txt");
            if (!file.exists()) {
                System.out.println("Статистика відсутня.");
                return;
            }

            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Помилка читання статистики.");
        }
    }
}

