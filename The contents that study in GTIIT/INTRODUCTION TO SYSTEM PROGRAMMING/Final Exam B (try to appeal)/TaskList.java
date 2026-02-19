import java.util.List;
import java.util.ArrayList;

/**
 * This class represents a list of tasks, where each task has a title , assignee,
 * completion status, ect.
 */

class TaskList{
    
    /** list of tasks in this task list */
    private List<Task> tasks;
    
    /** number of tasks in this task list to be completed */
    private int toBeCompletedCount;
    
    
    
    
    public TaskList(String name){
        this.tasks = new ArrayList<>();
        this.toBeCompletedCount = 0;
    }
    
    
    /** 
     * adds a task to this task list.
     * Precondition: task is not null, is not in the taskk list, and is not completed.
     */
    public void addTask(Task task){
        assert task != null : "Task to add cannot be null.";
        assert !task.isCompleted() : "Cannot add a completed task to the task list.";
        assert !tasks.contains(task) : "Task is already in the task list.";
        tasks.add(task);
        toBeCompletedCount++;
    }
    
    /**
     * marks a task in this task list as completed.
     * Precondition: task is not null , is in the task list , and is not completed.
     */
    public void marktaskCompleted(Task task){
        assert task != null : "Task to mark as completed cannot be null";
        assert !task.isCompleted() : "Task is already completed";
        assert tasks.contains(task) : "Task is not in the task list";
        task.markCompleted();
        toBeCompletedCount--;
    }
    
    
    
    /**
     * [EXERCISE 2]
     * TO DO:
     * Reassigns all non-completed tasks assigned to origAssignee to newAssignee.
     * @param origAssignee the orignial assignee whose tasks are to be reassigned
     * @param newAssignee the new assignee to whom the tasks will be reassigned
     * Preconditon:origAssignee and newAssignee are not null or empty,
     * and origAssignee is not the same as newAssignee.
     */
    public void reassignTasks(String origAssignee , String newAssignee) {
        assert( !origAssignee.equals(null) ) && (!newAssignee.equals(null) ) : "origAssignee and newAssigneee cannot be null";   //wroing comparison!!
        assert( !origAssignee.equals(newAssignee) ) : "origA cannot equal to newAss";
        for( Task t : tasks ) {
            if(t.getAssignee().equals(origAssignee)){
                if(!t.isCompleted()){
                    String orign_title = t.getTitle();
                    int orign_estimatedHours = t.getEstimatedHours();
                    int orign_priority = t.getPriority();
                    tasks.remove(t);
                    Task new_task = new Task(orign_title , newAssignee,orign_estimatedHours);
                    new_task.setPriority(orign_priority);
                    tasks.add(new_task);
                }
            }
        }
    }
}