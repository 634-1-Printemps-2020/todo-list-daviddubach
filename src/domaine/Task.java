package domaine;

import exception.ExceptionTaskChangeDate;
import exception.ExceptionTaskCreation;
import outils.TaskResolution;
import outils.TaskStatus;
import java.time.LocalDate;

public class Task {

    private LocalDate dateFin;
    private String description;
    private TaskStatus status;
    private TaskResolution resolution;

    public Task (LocalDate dateFin, String description) throws ExceptionTaskCreation {
        if (checkDate(dateFin)){
            throw new ExceptionTaskCreation();
        }
        this.dateFin = dateFin;
        this.description = description;
        this.status = TaskStatus.open;
    }

    public Task(String description) throws ExceptionTaskCreation{
        new Task(LocalDate.now(), description);
    }

    public TaskStatus getStatus() {
        return status;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    /**
    * Change la date de la tâche en s'assurant qu'elle n'est pas avant la date d'aujourd'hui
    * */
    public void changeDate (LocalDate dateFin) throws ExceptionTaskChangeDate {
        if (checkDate(dateFin)){
            throw new ExceptionTaskChangeDate();
        }
        this.dateFin = dateFin;
    }

    /**
    * Annule la tâche en changeant son status
    * */
    public void cancel() {
        this.status = TaskStatus.canceled;
    }

    /**
    * Check si la date de fin de la tâche n'est pas avant la date d'aujourd'hui
    * */
    private boolean checkDate (LocalDate date){
        return LocalDate.now().compareTo(date) > 0;
    }

    @Override
    public String toString() {
        return "Task{" + "dateFin=" + dateFin + ", description='" + description + '\'' + ", status=" + status + ", resolution=" + resolution + '}';
    }
}
