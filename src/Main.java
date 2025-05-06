import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Settings.loadSettings();

        while (true) {
            System.out.println("\n--- МЕНЮ ---");
            System.out.println("1. Грати");
            System.out.println("2. Налаштування");
            System.out.println("3. Статистика");
            System.out.println("4. Вихід");
            System.out.print("Оберіть опцію: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                Game.play(sc);
            } else if (choice == 2) {
                Settings.configure(sc);
            } else if (choice == 3) {
                Statistics.show();
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Невірна опція. Повторіть.");
            }
        }
    }
}
