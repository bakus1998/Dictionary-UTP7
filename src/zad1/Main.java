package zad1;

public class Main {
    public static void main(String[] args) {

        String path =System.getProperty("user.home") + "/dictionary.txt";
        Dictionary dictionary = new Dictionary(path);
        System.out.println("Szukanie definicji java: ");
        dictionary.lookup("java");
        System.out.println("\n");

        System.out.println("Dodawanie definicji do klucza Java");
        dictionary.add("java","programming language");
        dictionary.add("java","jezyk programowania");
        dictionary.lookup("java");
        System.out.println("\n");

        System.out.println("Usuwanie definicji w kluczu Java: ");
        dictionary.delete("java",3);
        dictionary.lookup("java");
        System.out.println("\n");

        System.out.println("Tworzenie nowego klucza zupa: ");
        dictionary.add("zupa","smaczne jedzenie");
        dictionary.lookup("zupa");

        System.out.println("\nUsuwanie definicji w kluczu zupa: ");
        dictionary.delete("zupa",1);
        dictionary.lookup("zupa");
        System.out.println("\n");

        System.out.println("Sprawdzanie metody Update: ");
        dictionary.update("java", "programming language", "coffee");
        dictionary.update("java", "programming language", "coffee"); //brak definicji
        dictionary.update("kolega", "praca", "dom"); //brak klucza
        dictionary.lookup("java");
        System.out.println("\n");

        dictionary.add("Rower","Uzywany do transportu");
        dictionary.add("Rower","Uzywany do transportu");
        dictionary.save();

    }
}
