package Cvik7.Uloha3;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    // HashMap для зберігання слів і їх перекладів
    private Map<String, String> dictionary;

    // Конструктор
    public Dictionary() {
        dictionary = new HashMap<>();
    }

    // Метод для додавання нового слова та його перекладу
    public void addWord(String word, String translation) {
        dictionary.put(word, translation);
    }

    // Метод для виведення всіх слів і їх перекладів
    public void displayAllWords() {
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    // Метод для пошуку перекладу слова
    public String findTranslation(String word) {
        return dictionary.get(word);
    }
}
