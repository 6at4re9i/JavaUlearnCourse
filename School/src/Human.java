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
