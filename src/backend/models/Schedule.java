package backend.models;

import java.time.LocalDate;

public class Schedule {
    private int id;                // Unique identifier
    private int flowerId;          // Link to the flower
    private LocalDate scheduledDate;  // When the task should happen
    private String taskType;       // "Watering", "Fertilizing", "Pruning", etc.
    private boolean completed;     // True if task has been done
    private String notes;          // Optional additional info

    public Schedule(){}

    public Schedule(int id, int flowerId, LocalDate scheduledDate, String taskType, boolean completed, String notes){
        this.id = id;
        this.flowerId = flowerId;
        this.scheduledDate = scheduledDate;
        this.taskType = taskType;
        this.completed = completed;
        this.notes = notes;
    }

    //getters
    public int getId(){
        return id;
    }

    public int getFlowerId(){
        return flowerId;
    }

    public LocalDate getscheduledDate(){
        return scheduledDate;
    }

    public String getTaskType(){
        return taskType;
    }

    public boolean isCompleted(){
        return completed;
    }

    public String getNotes(){
        return notes;
    }

    //setters
    public void setId(int id){
        this.id = id;
    }

    public void setFlowerId(int flowerId){
        this.flowerId = flowerId;
    }
    
    public void setscheduledDate(LocalDate scheduledDate){
        this.scheduledDate = scheduledDate;
    }

    public void setTaskType(String taskType){
        this.taskType = taskType;
    }

    public void setCompleted(boolean completed){
        this.completed = completed;
    }

    public void setNotes(String notes){
        this.notes = notes;
    }
    
}
