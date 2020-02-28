package test;

import domaine.Task;
import exception.ExceptionTaskChangeDate;
import exception.ExceptionTaskCreation;
import org.junit.Assert;
import org.junit.Test;
import outils.TaskStatus;
import java.time.LocalDate;

public class TaskTest {

    @Test
    public void changeDate() throws ExceptionTaskCreation, ExceptionTaskChangeDate {
        Task t = new Task(LocalDate.now(), "tâche de test");
        LocalDate nouvelleDate = LocalDate.of(2030, 1,1);
        t.changeDate(nouvelleDate);
        Assert.assertEquals(nouvelleDate, t.getDateFin());
    }

    @Test
    public void cancel() throws ExceptionTaskCreation {
        Task t = new Task(LocalDate.now(), "tâche de test");
        t.cancel();
        Assert.assertEquals(TaskStatus.canceled,t.getStatus());
    }
}