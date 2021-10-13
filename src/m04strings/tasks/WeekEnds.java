package m04strings.tasks;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Необходимо реализовать метод , определяющий относиться ли параметр dataTime к выходным
 * Выходным считается промежуток между 22:00 пятницы и 23:00 воскресенья
 * при попаданиb параметра в указанный промежуток метод возвращает true
 */

public class WeekEnds {
    public static void main(String[] args) {
        LocalDateTime dataTime = LocalDateTime.of(2021,10,10,22,59);
        boolean result = isWeekend(dataTime);
        System.out.println(result);
        dataTime = LocalDateTime.of(2021,10,8,21,0);
        result = isWeekend(dataTime);
        System.out.println(result);
        dataTime = LocalDateTime.of(2021,10,8,22,0);
        result = isWeekend(dataTime);
        System.out.println(result);
        dataTime = LocalDateTime.of(2021,10,10,23,0);
        result = isWeekend(dataTime);
        System.out.println(result);
    }

    public static boolean isWeekend(LocalDateTime dataTime) {
        switch (dataTime.getDayOfWeek()) {
            case FRIDAY:
                return dataTime.toLocalTime().isBefore(LocalTime.of(21, 59, 59, 999999999));
            case SATURDAY:
                return true;
            case SUNDAY:
                return dataTime.toLocalTime().isBefore(LocalTime.of(22, 59, 59, 999999999));
            default:
                return false;
        }
    }
}
