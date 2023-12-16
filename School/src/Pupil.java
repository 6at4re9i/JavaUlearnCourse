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
