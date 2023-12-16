import java.util.ArrayList;

public class School {
    //напишите класс School
    public ArrayList<Human> school = new ArrayList<>();

    public String getPeoplesInSchool() {
        /* реализуйте метод получения учителей и учеников в школе
           в формате:

           В школе:
           Игорь Николаев Математика 20
           Иван Иванов 2010
         */
        StringBuilder sb = new StringBuilder("В школе:\n");
        for (int i = 0; i < school.size(); i++) {
            Human object = school.get(i);
            if (!object.isInSchool())
                continue;
            if (i == school.size() - 1) {
                sb.append(school.get(i).toString());
            }
            else {
                sb.append(school.get(i).toString());
                sb.append("\n");
            }
        }

        return sb.toString();
    }

    public void add (Human human){
        //добавление человека в школу
        school.add(human);
    }
}
public abstract class Human {
    //напишите класс Human
//goInSchool() — пришел в школу,
// outFromSchool() — вышел из школы
// isInSchool() — статус в школе/не в школе типа boolean
    protected final String mainName;
    protected final String mainSurname;
    protected boolean isinschool;

    public Human(String name, String surname) {
        this.mainName = name;
        this.mainSurname = surname;
    }
    public void goInSchool(){
        isinschool = true;
    }
    public void outFromSchool(){
        isinschool = false;
    }
    public boolean isInSchool(){
        return isinschool;
    }
}
public class Pupil extends Human{
    /*напишите класс Pupil
      формат вывода toString(): имя фамилия год поступления
     */
   public int freshmanYear;
   public Pupil(String name, String surname, int freshmanYear){
       super(name, surname);
       this.freshmanYear = freshmanYear;
   }
   public String getName(){
       return mainName;
   }
   public String getSurname(){
       return mainSurname;
   }
   public int getYear(){
       return freshmanYear;
   }
   public String toString(){
       return mainName + " " + mainSurname + " " + freshmanYear;
   }
}
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
