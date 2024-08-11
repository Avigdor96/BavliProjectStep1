package Level1;

import java.util.Scanner;

public class Level1 {
    public static void main(String[] args) {
        String bavliTxt = ""; // מחרוזת של כל השס
        boolean flag = true;
        while (flag) {
            System.out.println("Press 1 for search page: ");
            System.out.println("Press 2 for search paragraph: ");
            System.out.println("Press 3 to exit: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    String book = FuncLevel1.bookFound();
                    FuncLevel1.pageFound(book);
                    break;
                case 2:
                    if (bavliTxt.isEmpty()){
                        bavliTxt = FuncLevel1.createStrBavli();
                    }
                    FuncLevel1.searchParagraph(bavliTxt);
                    break;
                case 3:
                    flag = false;
                    break;
            }
        }

    }
}
