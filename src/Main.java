import Excpections.AllProgrammersAreBusyNowException;
import Excpections.ProgrammerBusyException;
import Excpections.ProgrammerUnavailableNowException;
import Excpections.TeamLeadUnavailableNowException;

import java.util.List;

/*
 Допустим, у вас в программе есть класс Programmer.
 Кроме имени у нег есть поле String status;
 и этот статус может иметь значение «доступен» «занят» и «не доступен».
 У программиста необходимо реализовать метод String doWork(String taskMsg) который в качестве результата,
 либо возвращает stringMsg большими буквами, либо ProgrammerBusyException,
 либо ProgrammerUnavailableNowException в зависимости от текущего состояния программера.
В зависимости от результата, вызывающий main выводить результат работы или сообщение
«Программист занят другой задачей» или «Программист не доступен».
2. реализовать Programmer используя Enum
 */
public class Main {
    public static void main(String[] args) {
        Programmers programmer = new Programmers("Іван", Status.AVAILABLE);
        System.out.println("Programmer: "+programmer);


         //Programmer
        System.out.println();
        System.out.println("------Зміна статусу programmer------");
        programmer.setStatus(Status.NOT_AVAILABLE);
        System.out.println("Programmer: "+programmer);
        try {
            System.out.println(programmer.doWork("Java"));
        } catch (ProgrammerUnavailableNowException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        System.out.println("------Зміна статусу programmer------");
        programmer.setStatus(Status.BUSY);
        System.out.println("Programmer: "+programmer);
        try {
            System.out.println(programmer.doWork("C++"));
        } catch (ProgrammerBusyException e) {
            System.out.println(e.getMessage());
        }


        //TeamLead
        System.out.println("------------------------------------------------------------------------");
        TeamLead teamLead = new TeamLead("Петро", Status.AVAILABLE, List.of(programmer));
        System.out.println("TeamLead: "+teamLead);

        System.out.println();
        System.out.println("------Зміна статусу TeamLead------");
        teamLead.setStatus(Status.NOT_AVAILABLE);
        System.out.println("Team Lead: "+teamLead);
        try {
            String result = teamLead.toTask("task");
            System.out.println("Результат роботи:"+result);
        } catch (TeamLeadUnavailableNowException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        System.out.println("------Зміна статусу TeamLead------");
        teamLead.setStatus(Status.BUSY);
        System.out.println("TeamLead: "+ teamLead);
        try {
            String result = teamLead.toTask("task");
            System.out.println("Результат роботи:"+result);
        }  catch (AllProgrammersAreBusyNowException e) {
        System.out.println(e.getMessage());
    }


    }
}