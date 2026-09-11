public class Task {
    private String title;
    private String dueDate;
    private String priority;
    private boolean completed=false;

    public Task(String title, String dueDate, String priority) {
        this.title = title;
        this.dueDate = dueDate;
        this.priority = priority;
    }

    public void markComplete(){
        this.completed=true;
    }
    public  boolean isCompleted(){
        return this.completed;
    }

    public String getTitle() {
        return title;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getPriority() {
        return priority;
    }
}
