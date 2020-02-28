package domaine;
import outils.TaskStatus;

import java.time.LocalDate;
import java.util.*;

public class ToDoList {

    ArrayList<Task> list;

    public ToDoList() {
        this.list = new ArrayList<Task>();
    }

    /**
    * Ajoute une tâche à notre ToDoList
    * */
    public void addTask (Task task){
        this.list.add(task);
    }

    /**
     * Retourne une liste de tâche selon les arguments status et date de fin max
     * */
    public ArrayList<Task> getTask(TaskStatus status, LocalDate dateFin){
        ArrayList <Task> resultatRecherche = new ArrayList<Task>();
        for (Task tmp: list) {
            if((tmp.getStatus() == status) && (tmp.getDateFin().compareTo(dateFin) <= 0)){
                resultatRecherche.add(tmp);
            }
        }
        return resultatRecherche;
    }

    public Task getTask(int index){
        return list.get(index);
    }

    @Override
    public String toString() {
        return "ToDoList{" + "list=" + list + '}';
    }
}
