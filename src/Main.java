import Excpections.ProgrammerBusyException;
import Excpections.ProgrammerUnavailableNowException;

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
        Programmers programmer = new Programmers("Іван", ProgrammersStatus.AVAILABLE);


        System.out.println(programmer);
        programmer.setStatus(ProgrammersStatus.AVAILABLE);


        System.out.println("------Зміна статусу------");
        programmer.setStatus(ProgrammersStatus.NOT_AVAILABLE);
        System.out.println(programmer);
        try {
            System.out.println(programmer.doWork("Java"));
        } catch (ProgrammerUnavailableNowException e) {
            System.out.println(e.getMessage());
        }


        System.out.println("------Зміна статусу------");
        programmer.setStatus(ProgrammersStatus.BUSY);
        System.out.println(programmer);

        try {
            System.out.println(programmer.doWork("C++"));
        } catch (ProgrammerBusyException e) {
            System.out.println(e.getMessage());
        }


    }
}