import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {
    private ArrayList<String> todoList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TodoList newTodoList = new TodoList();
        while (true){
            System.out.println("Введите команду: ");
            String option = scanner.nextLine();
            switch (option){
                case "LIST":
                    ArrayList<String>todoList = newTodoList.getTodos();
                    System.out.println(todoList);
                case "ADD":
                    System.out.println("Введите задачу, или индекс и задачу, которую вы хотите добавить.");
                    String input1 = scanner.nextLine();
                    String[] arrayInput1 = input1.split(" ", 2);
                    if (arrayInput1.length == 2) {
                        int index = Integer.parseInt(arrayInput1[0]);
                        newTodoList.add(index, arrayInput1[1]);
                    }
                    else{
                        newTodoList.add(arrayInput1[0]);
                    }
                    break;
                case "EDIT":
                    System.out.println("Введите задачу, и индекс, который хотите заменить.");
                    String input2 = scanner.nextLine();
                    String[] arrayInput2 = input2.split(" ", 2);
                    if (arrayInput2.length == 2){
                        int index = Integer.parseInt(arrayInput2[0]);
                        newTodoList.edit(arrayInput2[1], index);
                    }
                    break;
                case "DELETE":
                    System.out.println("Введите индекс задачи, которую хотите удалить.");
                    int deletedIndex = scanner.nextInt();
                    newTodoList.delete(deletedIndex);
                    break;
            }
        }
    }
    public void add(String todo){
        todoList.add(todo);
    }
    public void add(int index, String todo){
        if(index >= 0 && index < todoList.size()) {
            todoList.add(index, todo);
        }
    }
    public void edit(String todo, int index){
        if(index >= 0 && index < todoList.size()) {
            todoList.set(index, todo);
        }
    }
    public void delete(int index){
        if(index >= 0 && index < todoList.size()) {
            todoList.remove(index);
        }
    }
    public ArrayList<String>getTodos(){
        return todoList;
    }
}
