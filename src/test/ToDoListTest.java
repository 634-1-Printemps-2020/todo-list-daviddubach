package test;

import domaine.Task;
import domaine.ToDoList;
import exception.ExceptionTaskCreation;
import org.junit.Assert;
import org.junit.Test;
import outils.TaskStatus;
import java.time.LocalDate;

public class ToDoListTest {

    @Test (expected = ExceptionTaskCreation.class)
    public void addTask() throws  ExceptionTaskCreation{
        ToDoList tdl = new ToDoList();
        tdl.addTask(new Task(LocalDate.of(2010, 1,1), "tâche 2010"));
    }

    @Test
    public void getTask() {
        ToDoList tdl = new ToDoList();
        try {
            tdl.addTask(new Task(LocalDate.now(), "tâche 1"));
            tdl.addTask(new Task(LocalDate.of(2030,1,1), "tâche 2"));
            tdl.addTask(new Task(LocalDate.of(2040,1,1), "tâche 3"));
            tdl.addTask(new Task(LocalDate.of(2050,1,1), "tâche 3"));
        }
        catch (Exception e){
            System.out.println(e);
        }
        Assert.assertEquals(1, tdl.getTask(TaskStatus.open, LocalDate.of(2029,1,1)).size()); // open before 2030
        Assert.assertEquals(2, tdl.getTask(TaskStatus.open, LocalDate.of(2039,1,1)).size()); // open before 2040

        tdl.getTask(1).cancel();

        Assert.assertEquals(0, tdl.getTask(TaskStatus.canceled, LocalDate.of(2029,1,1)).size()); // canceled before 2030
        Assert.assertEquals(1, tdl.getTask(TaskStatus.canceled, LocalDate.of(2049,1,1)).size()); // canceled before 2050
    }
}