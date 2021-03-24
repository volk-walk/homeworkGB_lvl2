import java.util.*;

public class Phonebook {
    Map<String, List<String>> map1 = new HashMap<>();
    public void listOfContacts(){
        map1.put("Pupkin", new ArrayList<>(Arrays.asList("2222222", "3333333")));
        map1.put("Ivanov", new ArrayList<>(Arrays.asList("8800045535")));
        map1.put("Ribov", new ArrayList<>(Arrays.asList("1111111")));
        System.out.println(map1);
    }
    /**
    * The method adds a contact to the phone book
     * @param name contact surname
     * @param numbers contact number
    * */
    public void addNewContact(String name, String numbers){
        map1.put(name, Collections.singletonList((numbers)));
    }
    /**
     * The method returns the contact number
     * @param name ontact surname
     * */
    public List<String> getNumbers(String name){
        for (Map.Entry<String, List<String>> o : map1.entrySet()){
            if (name.equalsIgnoreCase(o.getKey())){
                System.out.println("Номер контакта "+ name + ": " + o.getValue());
                return o.getValue();
            }
        }
        return map1.get(name);
    }
}
