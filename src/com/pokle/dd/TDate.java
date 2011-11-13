package com.pokle.dd;

/**
 * Tushar's Date class.
 *
 * Treats the year 0 as the epoch.
 */
public class TDate {

    private final int year;
    private final int month;
    private final int day;

    private static int[] daysInMonth = {
            0,
            31,   // J
            31 + 28,   // F
            31 + 28 + 31,   // M
            31 + 28 + 31 + 30,  // A
            31 + 28 + 31 + 30 + 31,   // M
            31 + 28 + 31 + 30 + 31 + 30,    // J
            31 + 28 + 31 + 30 + 31 + 30 + 31,     // J
            31 + 28 + 31 + 30 + 31 + 30 + 31 + 31,      // A
            31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30,      // S
            31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31,      // O
            31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30,      // N
            31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30 + 31      // D
    };

    public TDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * @return The number of days between the epoch and the start of the year
     */
    public int daysToYearSinceEpoch() {
        return 365*year + year/4 - year/100 + year/400;
    }

    public boolean isLeapYear() {
        return year%4 == 0 ? (year%100 == 0 ? (year%400 == 0) : true) : false;
    }

    /**
     * @return Number of days to the start of the month since the start of the year. For example
     *         any date in January results in 0, any date in February results in 31, any date
     *         in March results in 31 + 28 or 31 + 29 depending on the leap year, etc...
     */
    public int daysToMonthSinceYear() {
        final int FEB = 2;

        int result = daysInMonth[month-1];
        if (month > FEB && isLeapYear()) {
            return result + 1;
        } else {
            return result;
        }
    }

    /**
     * @return The number of days since the epoch
     */
    public int daysSinceEpoch() {
        return daysToYearSinceEpoch() + daysToMonthSinceYear() + day;
    }

    /**
     * Compares this date to another date.
     *
     * @param other
     * @return The absolute difference in days
     */
    public int diff(TDate other) {
        return Math.abs(daysSinceEpoch() - other.daysSinceEpoch());
    }

    public String toString() {
        return String.format("%02d %02d %04d", day, month, year);
    }
}
