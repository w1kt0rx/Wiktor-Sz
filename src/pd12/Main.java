package pd12;

import java.util.HashMap;
import java.util.HashSet;

public class Main {
    static void main(String[] args) {
        eksperymentA();
        eksperymentB();
        eksperymentC();
        eksperymentD();

    }

    private static void eksperymentA() {
        System.out.println("Klasa bez napisywania equals i hashcode");
        UserAccountV1 object1 = UserAccountV1.of(1, "marek@o2.pl", "Marek");
        UserAccountV1 object2 = UserAccountV1.of(1, "marek@o2.pl", "Marek");
        HashSet<UserAccountV1> setOfAccounts = new HashSet<>();
        setOfAccounts.add(object1);
        setOfAccounts.add(object2);
        System.out.println("Wyniki metody size(): " + setOfAccounts.size());
        System.out.println("Wynik metody equals(): " + object1.equals(object2));
        System.out.println();
        //Kolekcja nie znalazła w liście hashy hashcodu obiektów, a nawet jeśli to nienadpisana metoda equals zwróciła false, dlatego elementy zostały wpisane
    }

    private static void eksperymentB() {
        System.out.println("Klasa z nadpisanym equals bez hashcode");
        UserAccountV2 object1 = UserAccountV2.of(1, "marek@o2.pl", "Marek");
        UserAccountV2 object2 = UserAccountV2.of(1, "marek@o2.pl", "Marek");
        HashSet<UserAccountV2> setOfAccounts = new HashSet<>();
        setOfAccounts.add(object1);
        setOfAccounts.add(object2);
        System.out.println("Wyniki metody size(): " + setOfAccounts.size());
        System.out.println("Wynik metody contains(): " + setOfAccounts.contains(UserAccountV2.of(1, "marek@o2.pl", "Marek")));
        System.out.println();
        //Samo equals nie wystarcza, ponieważ na początku elementy listy są szukane poprzez hash, który w tym przypadku jest nieprawidłowy, ponieważ metoda nie została nadpisana
    }

    private static void eksperymentC() {
        System.out.println("Klasa z nadpisanym equals i hashcode");
        UserAccountV3 object1 = UserAccountV3.of(1, "marek@o2.pl", "Marek");
        UserAccountV3 object2 = UserAccountV3.of(1, "marek@o2.pl", "Marek");
        UserAccountV3 object3 = UserAccountV3.of(2, "marek@o2.pl", "Marek");
        HashSet<UserAccountV3> setOfAccounts = new HashSet<>();
        setOfAccounts.add(object1);
        setOfAccounts.add(object2);
        setOfAccounts.add(object3);
        HashMap<UserAccountV3, String> mapOfAccounts = new HashMap<>();
        mapOfAccounts.put(object1, object1.getDisplayName());
        mapOfAccounts.put(object2, object2.getDisplayName());
        mapOfAccounts.put(object3, object3.getDisplayName());
        System.out.println("Set z obiektami");
        setOfAccounts.forEach(System.out::println);
        System.out.println("Mapa z obiektami");
        mapOfAccounts.forEach((k, v) -> {
            System.out.println(k + " " + v);
        });
        System.out.println("Wyniki metody contains() dla setu: " + setOfAccounts.contains(UserAccountV3.of(1, "marek@o2.pl", "Marek")));
        System.out.println("Wyniki metody contains() dla setu (account nie ma): " + setOfAccounts.contains(UserAccountV3.of(5, "marek@o2.pl", "Marek")));

        System.out.println("Wynik metody get() dla mapy: " + mapOfAccounts.get(UserAccountV3.of(1, "marek@o2.pl", "Marek")));
        System.out.println("Wynik metody get() dla mapy (klucza nie ma): " + mapOfAccounts.get(UserAccountV3.of(4, "dsfsfd", "Jarek")));
        //Kolekcje działają zgodnie z intuicją, ponieważ nadpisanie equals i hashcode pozwala na poprawne działanie. Hashcode jest poprawnie przypisany, a metoda equals poprawnie sprawdza równość obiektów
    }

    private static void eksperymentD() {
        System.out.println("Klasa z mutowalnym dodatkowym polem i nadpisanymi metodami");
        UserAccountV4 object1 = UserAccountV4.of(1, "marek@o2.pl", "Marek", "Wolny");
        UserAccountV4 object2 = UserAccountV4.of(1, "marek@o2.pl", "Marek", "Szybki");
        HashSet<UserAccountV4> setOfAccounts = new HashSet<>();
        setOfAccounts.add(object1);
        setOfAccounts.add(object2);
        object2.setStatus("Prędki");
        System.out.println("Wyniki metody contains(): " + setOfAccounts.contains(UserAccountV4.of(1, "marek@o2.pl", "Marek", "Prędki")));
        System.out.println("Wynik metody remove(): " + setOfAccounts.remove(UserAccountV4.of(1, "marek@o2.pl", "Marek", "Prędki")));
        System.out.println("Zawartość setu: ");
        setOfAccounts.forEach(System.out::println);
        System.out.println();
        //Zmiana pola używanego w equals i hashcode sprawia, że obiekt jest w innym bucket'cie niż powinien być przez co całe działanie setu jest zaburzone.
    }
}
