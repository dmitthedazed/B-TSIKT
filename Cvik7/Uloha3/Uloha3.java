package Cvik7.Uloha3;

public class Uloha3 {
    public static void main(String[] args) {
        // Створення об'єкта Dictionary
        Dictionary myDictionary = new Dictionary();

        // Додавання слів та їх перекладів
        myDictionary.addWord("Hello", "Hola");
        myDictionary.addWord("Goodbye", "Adiós");
        myDictionary.addWord("Please", "Por favor");
        myDictionary.addWord("Thank you", "Gracias");

        // Виведення всіх слів і їх перекладів
        System.out.println("All words in the dictionary:");
        myDictionary.displayAllWords();

        // Пошук перекладу для слова
        String translation = myDictionary.findTranslation("Please");
        System.out.println("Translation for 'Please': " + translation);
    }
}

