package exception;

public class ExceptionTaskCreation extends Exception {
    @Override
    public String toString() {
        return "impossible de créer une task pour une date inférieur à la date d'aujourd'hui";
    }
}
