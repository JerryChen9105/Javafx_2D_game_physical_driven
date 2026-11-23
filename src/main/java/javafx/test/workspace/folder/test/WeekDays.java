package javafx.test.workspace.folder.test;

public enum WeekDays {

    MON, TUE, WED, THU, FRI, SAT, SUN;

    WeekDays() {
    }

    public boolean isWeekend() {
        return this == SAT || this == SUN;
    }

}
