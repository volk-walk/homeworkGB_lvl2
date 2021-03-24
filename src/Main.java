import java.util.*;

public class Main {
    public static void main(String[] args) {
        searchOfUniqueWords();
        Phonebook phonebook = new Phonebook();
        phonebook.listOfContacts();
        phonebook.addNewContact("Stulov", "5555555");
        phonebook.listOfContacts();
        phonebook.getNumbers("pupkin");
    }
    public static void searchOfUniqueWords(){
        List <String> arr1 = new ArrayList<String>(Arrays.asList("озеро", "дорога", "весна", "велосипед", "солнышко", "травка", "дорога", "речка", "лесок", "велосипед", "дорога"));
        System.out.print("Массив слов: " + arr1);
        System.out.println();
        Set<String> st1 = new HashSet<>(arr1);
        System.out.println("Уникальные слова массива: " + st1);
        Map<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < arr1.size(); i++) {

           map1.put(arr1.get(i),map1.getOrDefault(arr1.get(i), 0) + 1);
        }
        System.out.println("Количество встречающихся слов: " + map1);
    }
}
