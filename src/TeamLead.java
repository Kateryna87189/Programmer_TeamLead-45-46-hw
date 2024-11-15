import Excpections.AllProgrammersAreBusyNowException;
import Excpections.TeamLeadUnavailableNowException;

import java.util.List;

public class TeamLead {
    private String name;
    private Status status;
    private List<Programmers> programmers;

    public TeamLead(String name, Status status, List<Programmers> programmers) {
        this.name = name;
        this.status = status;
        this.programmers = programmers;
    }

    public String getName() {
        return name;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String toTask (String taskMsg){
        if (status== Status.NOT_AVAILABLE){
            throw new TeamLeadUnavailableNowException("TeamLead вийшов на нараду до директора");
        }
        for (Programmers programmer:programmers){
            if (status==Status.AVAILABLE){
                return programmer.doWork(taskMsg);
            }
        }
        throw new AllProgrammersAreBusyNowException("Не вистачає програмістів");
    }

    @Override
    public String toString() {
        return name + "(" + status + ")";
    }
}
