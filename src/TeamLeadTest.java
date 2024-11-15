import Excpections.AllProgrammersAreBusyNowException;
import Excpections.TeamLeadUnavailableNowException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TeamLeadTest {
    private Programmers programmer;
    private TeamLead teamLead;

    @BeforeEach
    public void setUp(){
        programmer =new Programmers("Іван", Status.AVAILABLE);
        List<Programmers> programmers=List.of(programmer);
        teamLead =new TeamLead("Петро",Status.AVAILABLE, programmers);
    }
    @Test
    public void testToTask_Success(){
        String result = teamLead.toTask("task");
        assertEquals("TASK", result);
    }
    @Test
    public void testToTask_TeamLeadUnavailable(){
        teamLead.setStatus(Status.NOT_AVAILABLE);
        TeamLeadUnavailableNowException exception = assertThrows(TeamLeadUnavailableNowException.class,
                ()->{
            teamLead.toTask("task");
        });
        assertEquals("TeamLead вийшов на нараду до директора",exception.getMessage());
    }
    @Test
    public void testToTask_AllProgrammersBusy(){
        programmer.setStatus(Status.BUSY);
        AllProgrammersAreBusyNowException exception = assertThrows(AllProgrammersAreBusyNowException.class,
                ()->{
                    teamLead.toTask("task");
                });
        assertEquals("Не вистачає програмістів", exception.getMessage());
    }
    @Test
    public void testToTask_ProgrammerUnavailable(){
        programmer.setStatus(Status.NOT_AVAILABLE);
        AllProgrammersAreBusyNowException exception = assertThrows(AllProgrammersAreBusyNowException.class,()->{
            teamLead.toTask("task");
        });
        assertEquals("Не вистачає програмістів", exception.getMessage());
    }



    @Test
    public void testToString(){
        String result =teamLead.toString();
        assertEquals("Петро (AVAILABLE)", result);
    }
}
