import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> tasks=new ArrayList<>();

    public void addTask(Task task){
        tasks.add(task);
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void deleteTask(int index){
        if(index>=0&&index<tasks.size()){
            tasks.remove(index);
        }

    }

    public void completeTask(int index){
        if(index>=0&&index<tasks.size()){
            tasks.get(index).markComplete();
        }
    }

    public void show(){
        for(int i=0;i< tasks.size();i++){
            Task t=tasks.get(i);
            System.out.println(i +". "+t.getTitle() +"|" +
                    t.getDueDate()+"|"+t.getDueDate()+
                    "|"+"Compeleted "+t.isCompleted());
        }
    }
}
