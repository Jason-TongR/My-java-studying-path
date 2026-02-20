import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

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
    
    
    /**
     * [EX4]
     * Categorizes all non-completed tasks by their priority levels.
     * @return a map where the keys priority levels(1 for High,2 for Medium,
     * 3 for Low), and the values are sets of tasks that are not yet completed and
     * have the corresponding priority level
     */
    public Map<Integer, Set<Task>> categorizeNoncompletedTasksByPriority(){
        assert !tasks.isEmpty() : "list of tasks cannot be empty";
        //create a arraylist contains all non-completed task.
        List<Task> non_completed_list = new ArrayList<Task>();
        for(Task t : tasks){
            if(!t.isCompleted()){
                non_completed_list.add(t);
            }
        }
        //for each priority , we create a set to put tasks into it.
        Set<Task> set_priority_one = new HashSet<Task>();
        Set<Task> set_priority_two = new HashSet<Task>();
        Set<Task> set_priority_three = new HashSet<Task>();
        
        for(Task t : non_completed_list){
            if(t.getPriority() == 1){
                set_priority_one.add(t);
            }
            if(t.getPriority() == 2){
                set_priority_two.add(t);
            }
            if(t.getPriority() == 3){
                set_priority_three.add(t);
            }
        }
        
        //now create the result map
        Map<Integer , Set<Task> > result_map = new HashMap<Integer , Set<Task> >();
        result_map.put(1,set_priority_one);
        result_map.put(2,set_priority_two);
        result_map.put(3,set_priority_three);
        
        
        return result_map;
    }
    
    /**
     *  Merges the tasks from another task list into this task list.
     *  Only tasks that are not completed , and are not already in
     *  this task list are added.Tasks of the other task list that
     *  are added to the this task list are removed from the other
     *  task list. The toBeCompletedCount fields of both task lists
     *  are updated accordingly.
     *  Preconditon: other is not null.
     *  @param other is the other task list whose tasks are to be merged
     *  into this task list, and from which the merged tasks will be remove.
     *  
     *  
     *  [Exercise 5]
     *  Write JUnit unit tests to thoroughly test the behavior of method mergfeTaskList().
     *  make sure all lines of this method are appropriately coverd by your test cases.if
     *  you need to add some method or methods to TaskList or Task in oreder to complete the test,
     *  do so as part of this exercise.
     */
    public void mergeTaskList(TaskList other){
        assert other != null : "Other task list cannot be null";
        for(int i = 0 ; i < other.tasks.size() ; i++){
            Task task = other.tasks.get(i);
            if(!this.tasks.contains(task) && !task.isCompleted() ){
                this.tasks.add(task);
                this.toBeCompletedCount++;
                other.toBeCompletedCount--;
                other.tasks.remove(i);
                i--;
            }
        }
    }
}