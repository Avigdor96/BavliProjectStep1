package Level1;

import java.io.File;
import java.util.Scanner;

public class FuncLevel1 {
    // הפונקציה מקבלת שם ספר ומבקשת את הדף המבוקש ומדפיסה אותו
    public static void pageFound(String book) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter page: ");
        String page = "דף " + scanner.nextLine();
        String res = ""; // מחרוזת שתכיל את תוכן הדף
        boolean pageFound = false;
        boolean bookFound = false;
        File file = new File("C:\\Users\\a0556\\OneDrive\\שולחן העבודה\\__תלמוד בבלי טקסט_.txt");
        try {
            Scanner scanner1 = new Scanner(file);
            while (scanner1.hasNextLine()) {
                String line = scanner1.nextLine();
                if (!line.isEmpty()) {
                    if (line.startsWith(book)) { // מציאת הספר
                        bookFound = true;
                    }
                    if (bookFound) { // מציאת הדף
                        if (line.startsWith(page + " ")) {
                            pageFound = true;
                        }
                    }
                    if (bookFound && pageFound) { // אם הגעת לדף חדש, תצא
                        if (line.startsWith("דף ") && !line.startsWith(page + " ")) {
                            break;
                        }
                        if (!line.startsWith(page + " ")) { // מוסיף למחרוזת את תוכן הדף
                            res += "\n" + line;
                        }
                    }
                }
            }
            if (!pageFound) { // אם ספר לא נמצא מחזיר לתחילת הפונקציה
                System.out.println("Page not found");
                pageFound(book);
            }
            System.out.println(res);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    // פונקציה שמבקשת שם ספר ומחזירה שם הספר אם קיים
    public static String bookFound() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book");
        String book = "מסכת " + scanner.nextLine();
        boolean bookFound = false;
        File file = new File("C:\\Users\\a0556\\OneDrive\\שולחן העבודה\\__תלמוד בבלי טקסט_.txt");
        try {
            Scanner scanner1 = new Scanner(file);
            while (scanner1.hasNextLine()) {
                String line = scanner1.nextLine();
                if (!line.isEmpty()) {
                    if (line.startsWith(book + " ")) {
                        bookFound = true;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        if (!bookFound) { // אם הספר לא נמצא, מחזיר לתחילת הפונקציה
            System.out.println("Book is not found \nEnter again:");
            return bookFound();
        }
        return book;
}   // מקבלת את כל השס כמחרוזת, מבקשת ציטוט ובודקת האם קיים
    public static void searchParagraph(String allBavli) {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter paragraph: ");
        String paragraph = scanner1.nextLine();
        if (allBavli.contains(paragraph)){
            System.out.println("found");
        }
        else{
            System.out.println("Not found");
        }


    }
    // יצירת מחרוזת של כל השס, פותר חיפוש ציטוט שנמצא בשורות נפרדות
    public static String createStrBavli(){
        File file = new File("C:\\Users\\a0556\\OneDrive\\שולחן העבודה\\__תלמוד בבלי טקסט_.txt");
        String allBavli = "";
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.isEmpty()) {
                    if (!line.startsWith("דף ")) {
                        if (!line.startsWith("משנה ") || line.startsWith("גמרא ")) {
                            allBavli += line;
                        } else {
                            allBavli += line.substring(7);
                        }

                    }

                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return allBavli;
    }
}
