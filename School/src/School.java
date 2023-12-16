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