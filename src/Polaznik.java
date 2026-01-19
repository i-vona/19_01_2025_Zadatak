/*
Napiši program za evidenciju polaznika na tečaju koji osigurava jedinstvenost e-mail adresa polaznika.
Program treba omogućiti unos polaznika i njihovih podataka te provjeriti jesu li e-mail adrese jedinstvene.

Koristi klasu Polaznik s atributima: ime, prezime i e-mail
Koristi HashMap<String, Polaznik> za pohranu polaznika, gdje će ključ biti e-mail adresa, a vrijednost objekt klase Polaznik.
Napravi glavnu klasu EvidencijaPolaznika koja sadrži main metodu.
Omogući korisniku unos novih polaznika (ime, prezime, e-mail).
Pri dodavanju novog polaznika, provjeri je li e-mail adresa već prisutna u evidenciji polaznika.
Ako je e-mail adresa već prisutna, ispiši odgovarajuću poruku i ne dopusti unos polaznika s istom e-mail adresom.
Omogući ispis svih polaznika na tečaju nakon unosa.

Što bi trebalo izmijeniti u rješenju ako dodamo novi zahtjev?
Svi polaznici moraju biti cijelo vrijeme sortirani po emailu uzlazno
 */

public class Polaznik implements Comparable<Polaznik> {

    private String ime;
    private String prezime;
    private String email;

    public Polaznik(String ime, String prezime, String email) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Ime: " + ime +
                "\nPrezime: " + prezime +
                "\nE-mail: " + email;
    }

    @Override
    public int compareTo(Polaznik o) {
        return this.email.compareToIgnoreCase(o.email);
    }
}
