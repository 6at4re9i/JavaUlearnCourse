public class Teacher extends Human {
    /*напишите класс Teacher
      формат вывода toString(): имя фамилия предмет стаж работы
     */
    public String subject;
    public int yearsWorking;
    public Teacher(String name, String surname, String subject, int yearsWorking){
        super(name, surname);
        this.subject = subject;
        this.yearsWorking = yearsWorking;
    }
    public String getName(){
        return mainName;
    }
    public String getSurname(){
        return mainSurname;
    }
    public String getSubject(){
        return subject;
    }
    public int getYear(){
        return yearsWorking;
    }
    public String toString(){
        return mainName + " " + mainSurname + " " + subject + " " + yearsWorking;
    }
}
