package exception;

public class ExceptionTaskChangeDate extends Throwable {
    @Override
    public String toString() {
        return "impossible de changer la date pour une date inférieur à la date d'aujourd'hui";
    }
}
