import Excpections.ProgrammerBusyException;
import Excpections.ProgrammerUnavailableNowException;

public class Programmers {
private final String name;
private Status status;

    public Programmers(String name, Status status) {
        this.name = name;
        this.status = status;
    }


    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return name +"(" + status + ")";
    }
    public String doWork(String taskMsg){
         if (status== Status.AVAILABLE){
             return taskMsg.toUpperCase();
         }
         if (status== Status.BUSY){
             throw new ProgrammerBusyException("Програміст зайнятий іншим завданням");
         }
         if (status== Status.NOT_AVAILABLE){
             throw new ProgrammerUnavailableNowException("Програміст не на місці");
         }
         return "";
    }
    public void setStatus(Status status) {
        this.status = status;
    }

}

