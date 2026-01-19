import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class EvidencijaPolaznika {

    //    private static HashMap<String, Polaznik> map = new HashMap<>();
    private static TreeMap<String, Polaznik> map = new TreeMap<>();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int izbor;

        do {
            ispisiIzbornik();
            izbor = ucitajIzbor();

            switch (izbor) {
                case 1 -> dodajPolaznika();
                case 2 -> ispisiPolaznike();
                case 0 -> System.out.println("Izlaz iz programa.");
                default -> System.out.println("Neispravan odabir.");
            }
        } while (izbor != 0);
    }

    private static void ispisiIzbornik() {
        System.out.println("\n--- IZBORNIK ---");
        System.out.println("1. Unos novog polaznika");
        System.out.println("2. Ispis svih polaznika");
        System.out.println("0. Izlaz");
    }

    private static int ucitajIzbor() {
        while (true) {
            System.out.print("Odabir: ");
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Unesite broj!");
            }
        }
    }

    private static void dodajPolaznika() {

        String ime = ucitajTekst("Unesi ime: ");
        String prezime = ucitajTekst("Unesi prezime: ");
        String email = ucitajTekst("Unesi e-mail: ");

        if (map.containsKey(email)) {
            System.out.println("Polaznik nije dodan.\nPolaznik s tim e-mailom već postoji.");
            return;
        }

        Polaznik noviPolaznik = new Polaznik(ime, prezime, email);
        map.put(email, noviPolaznik);

        System.out.println("Polaznik uspješno dodan.");

    }

    private static void ispisiPolaznike() {
        if (map.isEmpty()) {
            System.out.println("Nema unesenih polaznika.");
            return;
        }

        map.forEach((k, v) -> System.out.println("\nPolaznik s e-mail adresom " + k + ": \n" + v));
    }

    private static String ucitajTekst(String poruka) {
        System.out.println(poruka);
        return scanner.nextLine();
    }


}
