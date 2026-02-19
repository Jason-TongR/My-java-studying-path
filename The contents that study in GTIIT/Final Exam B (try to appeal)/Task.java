/**
 * Class that represents a task in a task management system. Each task has a title,
 * assignee,priority level , estimated hours to complete, and completion status.
 */
class Task{
    /** title of the task */
    private String title;
    
    /** assigned prerson for the task */
    private String assignee;
    
    /** priority level of the task, where 1 is High, 2 is Medium, and 3 is Low */
    private int priority;
    
    /** estimated time to complete, in hours */
    private int estimatedHours;
    
    /** is the task completed? */
    private boolean completed;
    
    
    
    public Task(String title , String assignee , int estimatedHours){
        assert title != null && !title.isEmpty() : "Task titile cannot be null/empty";
        assert assignee != null && !assignee.isEmpty() : "Assignee cannot be null";
        assert estimatedHours >= 0 : "Estimated hours cannot be negative";
        this.title = title;
        this.assignee = assignee;
        this.priority = 1;
        this.estimatedHours = estimatedHours;
        this.completed = false;
    }
    
    // Getters and setters
    public String getTitle() { return title;}
    public String getAssignee() { return assignee; }
    public int getPriority() { return priority; }
    public int getEstimatedHours() { return estimatedHours; }
    public boolean isCompleted() { return completed; }
    
    public void markCompleted() { this.completed = true; }
    
    public void setPriority(int priority) {
        assert priority >= 1 && priority <= 3 : "Priority must be 1-3";
        this.priority = priority;
    }
    
}