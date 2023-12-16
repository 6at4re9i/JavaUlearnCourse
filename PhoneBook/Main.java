import java.util.Scanner;
import java.util.Set;

public class Main{
    public static void main(String[] args) {
        //TODO напишите консольное приложение для взаимодействия с телефонной книгой
        PhoneBook phoneBook = new PhoneBook();
        while(true){
            System.out.println("Введите номер, имя или команду: ");
            String input = new Scanner(System.in).nextLine();
            switch(phoneBook.check(input)) {
                case 1:
                    if (phoneBook.checkContacts(input)) {
                        Set<String> numbers = phoneBook.getPhonesByName(input);
                        StringBuilder allNumbers = phoneBook.getNumbersToString(numbers);
                        System.out.println(input + " - " + allNumbers);
                    } else {
                        System.out.println("Данные не найдены.");
                        System.out.println("Введите номер телефона абонента " + input + ":");
                        String Number = new Scanner(System.in).nextLine();
                        phoneBook.addContact(Number, input);
                        System.out.println("Сохранено.");
                    }
                    break;
                case 2:
                    System.out.println("Такого номера нет в книге.");
                    System.out.println("Введите имя абонента для номера " + input + ":");
                    String name = new Scanner(System.in).nextLine();
                    phoneBook.addContact(input, name);
                    System.out.println("Сохранено.");
                    break;
                case 3:
                    System.out.println(phoneBook.getAllContacts());
                    break;
                case 4:
                    System.out.println("Выход.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Команда не найдена.");
                    break;
            }
        }
    }
}

