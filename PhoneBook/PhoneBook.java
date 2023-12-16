import java.util.*;

public class PhoneBook {
Map<String, ArrayList<String>> phonebook = new HashMap<String, ArrayList<String>>();
    public int check(String input){
        if (input.equals("LIST")) {
            return 4;
        }
        if (input.equals("EXIT")){
            return 3;
        }
        try{
            Double.parseDouble(input);
            return 2;
        }
        catch(NumberFormatException e){
            return 1;
        }
    }
    public void addContact(String phone, String name) {
        //TODO проверьте корректность формата имени и телефона
        // если такой номер уже есть в списке, то перезаписать имя абонента
        if(!isCorrect(name, phone))
            return;
        if(!checkContacts(name)){
            ArrayList<String> phones = new ArrayList<>();
            phones.add(phone);
            phonebook.put(name, phones);
        }
        else{
            ArrayList<String> names = phonebook.get(name);
            names.add(phone);
        }
    }

    public String getNameByPhone(String phone) {
        //TODO формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
        if (!phonebook.isEmpty()) {
            for (String keys : phonebook.keySet()) {
                ArrayList<String> phones = phonebook.get(keys);
                if (phones.contains(phone)) {
                    return keys;
                }
            }
        }
        return null;
    }

    public Set<String> getPhonesByName(String name) {
        //TODO по имени вернуть список номеров
            if(!phonebook.keySet().isEmpty()){
                ArrayList<String> PhonesByNames = phonebook.get(name);
                return new HashSet<>(PhonesByNames);
            }
            else
                return null;
    }

    public StringBuilder getNumbersToString(Set<String> numbers) {
        //TODO вернуть номера в формате строки <номер>, <номер>.
        String Nums = String.join(", ",numbers);
        return new StringBuilder(Nums);
    }

    public Set<String> getAllContacts() {
        //TODO вернуть все контакты в формате <имя> — <номер>, <номер> и тд
        if(!phonebook.isEmpty()){
            Set<String> contacts = new HashSet<>();
            for(String name : phonebook.keySet()){
                Set<String> numbers = getPhonesByName(name);
                StringBuilder StringNumbers = getNumbersToString(numbers);
                String result = name + " - " + StringNumbers + "\n";
                contacts.add(result);
            }
            return contacts;
        }
        else
            return null;
    }

    public boolean checkContacts(String name) {
        //TODO проверьте корректность формата имени и телефона
        // если такой номер уже есть в списке, то перезаписать имя абонента
        if(phonebook.containsKey(name))
            return true;
        else {
            int count = 0;
            for (String name1 : phonebook.keySet()){
                ArrayList<String> numbers = phonebook.get(name1);
                if(numbers.contains(name)){
                    count+=1;
                }
            }
            return count > 0;
        }
    }

    public boolean isCorrect(String name, String phone) {
        //TODO проверьте корректность номера
        return name.matches("[a-zA-Zа-яА-ЯёЁ]+") && phone.matches("\\d{11}");
    }
}
