package backend.models;
import java.time.LocalDate;

public class GrowthLog {
    private int id;                // Unique identifier for the growth log
    private int flowerId;          // Link to the flower (foreign key)
    private LocalDate logDate;     // Date of the growth observation
    private String stage;          // Blooming stage or growth stage
    private String notes;          // Additional notes

    public GrowthLog(){}

    public GrowthLog(int id, int flowerId, LocalDate logDate, String stage, String notes){
        this.id = id;
        this.flowerId = flowerId;
        this.logDate = logDate;
        this.stage = stage;
        this.notes = notes;
    }
    //getters
    public int getId(){
        return id;
    }

    public int getflowerId(){
        return flowerId;
    }

    public LocalDate getLogDate(){
        return logDate;
    }

    public String getStage(){
        return stage;
    }

    public String getnotes(){
        return notes;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setFlowerId(int flowerId) {
        this.flowerId = flowerId;
    }

    public void setLogDate(LocalDate logDate) {
        this.logDate = logDate;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
