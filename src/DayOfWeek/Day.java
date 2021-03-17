package DayOfWeek;

public class Day {
    public static void main(String[] args) {
        getWorkingHours(DayOfWeek.MONDAY);
    }
    public static void getWorkingHours (DayOfWeek p){
        int workingHours;
        switch (p){
            case MONDAY:
                workingHours = 40;
                System.out.println("До выходного осталось " + workingHours + " рабочих часов");
                break;
            case TUESDAY:
                workingHours = 32;
                System.out.println("До выходного осталось " + workingHours + " рабочих часа");
               break;
            case FRIDAY:
                workingHours = 8;
                System.out.println("До выходного осталось " + workingHours + " рабочих часа");
                break;
            case SUNDAY:
                System.out.println("Сегодня выходной");
                break;
            case SATURDAY:
                System.out.println("Сегодня выходной");
                break;
            case THURSDAY:
                workingHours = 16;
                System.out.println("До выходного осталось " + workingHours + " рабочих часа");
                break;
            case WEDNESDAY:
                workingHours = 24;
                System.out.println("До выходного осталось " + workingHours + " рабочих часа");
                break;
        }
    }
}
