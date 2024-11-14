import Excpections.ProgrammerBusyException;
import Excpections.ProgrammerUnavailableNowException;

public class Programmers {
private final String name;
private ProgrammersStatus status;

    public Programmers(String name, ProgrammersStatus status) {
        this.name = name;
        this.status = status;
    }


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name +"(" + status + ")";
    }
    public String doWork(String taskMsg){
         if (status==ProgrammersStatus.AVAILABLE){
             return taskMsg.toUpperCase();
         }
         if (status==ProgrammersStatus.BUSY){
             throw new ProgrammerBusyException("Програміст зайнятий іншим завданням");
         }
         if (status==ProgrammersStatus.NOT_AVAILABLE){
             throw new ProgrammerUnavailableNowException("Програміст не на місці");
         }
         return "";
    }
    public void setStatus(ProgrammersStatus status) {
        this.status = status;
    }

}

