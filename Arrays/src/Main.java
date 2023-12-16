import java.util.Scanner;

public class Main {
    /**
     * В классе Main реализуется консольное приложение для управления методами класса Hospital
     * В нем можно получать различную информацию по отдельности или всю сразу в виде Отчета*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество пациентов: ");
        int patienceCount = scanner.nextInt();
        Hospital hospital = new Hospital(patienceCount);
        hospital.generatePatientsTemperatures();
        while (true){
            System.out.println("Введите опцию: ");
            String option = new Scanner(System.in).nextLine();
            switch (option){
                case "Количество здоровых пациентов":
                    System.out.println(hospital.getCountHealthy());
                    break;
                case "Весь список температур":
                    System.out.println(hospital.getTemperaturesToString());
                    break;
                case "Средняя температура пациентов":
                    System.out.println(hospital.getAverageTemp());
                    break;
                case "Отчет":
                    System.out.println(hospital.getReport());
                    break;
            }
        }
    }
}
