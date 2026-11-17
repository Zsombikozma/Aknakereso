package AKNAKERESO;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AknakeresoMain {
    public static void main(String[] args) {
        char[][] tabla = {
                {'0', 'a', '0', '0'},
                {'0', '0', '0', 'a'},
                {'0', '0', '0', '0'}
        };

        Scanner sc = new Scanner(System.in);

        try {
            Aknakereso j = new Aknakereso(tabla);
            boolean fut = true;

            while (fut) {
                System.out.print("Sor és oszlop (pl. 1 2): ");
                try {
                    int x = sc.nextInt();
                    int y = sc.nextInt();

                    String valasz = j.tipp(x, y);
                    System.out.println(valasz);

                    if (valasz.startsWith("Aknára") || valasz.startsWith("Megnyerted")) {
                        fut = false;
                    }
                } catch (AknakeresoException e) {
                    System.out.println("Hiba: " + e.getMessage());
                } catch (InputMismatchException e) {
                    System.out.println("Hiba: számokat írj be");
                    sc.nextLine();
                }
            }
        } catch (AknakeresoException e) {
            System.out.println("Hibás tábla: " + e.getMessage());
        }

        sc.close();
    }
}