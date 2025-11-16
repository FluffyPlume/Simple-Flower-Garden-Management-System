package backend.models;

import java.time.LocalDateTime;

public class Reminder {
    private int id;                    // Unique identifier
    private int flowerId;              // Link to the flower
    private LocalDateTime remindAt;    // Date and time of the reminder
    private String message;            // What the reminder is about
    private boolean completed;         // True if reminder was handled

    public Reminder(){}

    public Reminder(int id, int flowerId, LocalDateTime remindAt, String message, boolean completed){
        this.id = id;
        this.flowerId = flowerId;
        this.remindAt = remindAt;
        this.message = message;
        this.completed = completed;
    }

    //getters
    public int getId(){
        return id;
    }

    public int getflowerId(){
        return flowerId;
    }

    public LocalDateTime getRemindAt(){
        return remindAt;
    }

    public String getMessage(){
        return message;
    }

    public boolean isCompleted(){
        return completed;
    }

    //setters
    public void setId(int id){
        this.id = id;
    }

    public void setFlowerId(int flowerId){
        this.flowerId = flowerId;
    }

    public void setRemindAt(LocalDateTime remindAt){
        this.remindAt = remindAt;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public void setCompleted(boolean completed){
        this.completed = completed;
    }
}
