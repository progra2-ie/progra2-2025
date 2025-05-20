package cr.ac.ucr.paraiso.progra2.proyecto1;

enum DayOfWeek {
    // Each constant is an instance of the DayOfWeek enum
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY; // Semicolon is optional here

    // Example of adding a method to the enum
    public boolean isWeekend() {
        return this == SUNDAY || this == SATURDAY;
    }

    // Example of adding a constructor and field (more advanced)
    private final String shortName;

    DayOfWeek(String shortName) {
        this.shortName = shortName;
    }

    DayOfWeek() {
        this.shortName = this.name().substring(0, 3); // Default short name
    }

    public String getShortName() {
        return this.shortName;
    }
    // Example of an overridden method
    @Override
    public String toString() {
        return this.name() + " (" + this.shortName + ")";
    }
}

public class EnumExample {
    public static void main(String[] args) {
        // Using the DayOfWeek enum
        DayOfWeek today = DayOfWeek.WEDNESDAY;
        String dia = String.valueOf(DayOfWeek.SUNDAY);
        System.out.println("Today is " + today); // Output: Today is WEDNESDAY (WED)

        // Using the isWeekend() method
        if (today.isWeekend()) {
            System.out.println("It's the weekend!");
        } else {
            System.out.println("It's a weekday."); // This will be printed
        }

        // Iterating through enum constants
        System.out.println("Days of the week:");
        for (DayOfWeek day : DayOfWeek.values()) {
            System.out.println(day + " - Weekend: " + day.isWeekend() + ", Short Name: " + day.getShortName());
        }

        // Using enum in a switch statement
        switch (today) {
            case MONDAY:
                System.out.println("Start of the work week");
                break;
            case WEDNESDAY:
                System.out.println("Midweek"); // This will be printed
                break;
            case FRIDAY:
                System.out.println("Almost the weekend!");
                break;
            default:
                System.out.println("Another day");
        }

        // Comparing enums using == (preferred) and .equals()
        DayOfWeek anotherDay = DayOfWeek.WEDNESDAY;
        if (today == anotherDay) {
            System.out.println("today and anotherDay are the same day"); // This will be printed
        }
        if (today.equals(anotherDay)) {
            System.out.println("today and anotherDay are the same day (using equals)"); //This will be printed
        }

        DayOfWeek weekendDay = DayOfWeek.SUNDAY;
        System.out.println(weekendDay.getShortName()); // Output: SUN
    }
}