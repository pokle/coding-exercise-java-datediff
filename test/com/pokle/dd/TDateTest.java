package com.pokle.dd;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TDateTest {

    @Test
    public void shouldBeAbleToGenerateAStringRepresentation() {
        assertEquals("01 01 0001", new TDate(1, 1, 1).toString());
        assertEquals("13 11 2011", new TDate(2011, 11, 13).toString());
    }

    @Test
    public void daysToYearSinceEpochShouldBe0ForTheEpoch() {
        TDate epoch = new TDate(0, 0, 0);
        assertEquals(0, epoch.daysToYearSinceEpoch());
    }

    @Test
    public void daysToYearSinceEpochShouldBe0ForTheLastDayOfTheEpoch() {
        TDate lastDayOfEpoch= new TDate(0, 12, 31);
        assertEquals(0, lastDayOfEpoch.daysToYearSinceEpoch());
    }

    @Test
    public void daysToYearSinceEpochShouldBe365ForTheFirstDayOfTheYearAfterTheEpoch() {
        TDate firstDayOfTheYearAfterTheEpoch = new TDate(1, 1, 1);
        assertEquals(365, firstDayOfTheYearAfterTheEpoch.daysToYearSinceEpoch());
    }

    @Test
    public void daysToYearSinceEpochShouldBe1461ForTheFourthYearBecauseItIsALeapYear() {
        assertEquals(4 * 365 + 1, new TDate(4, 1, 1).daysToYearSinceEpoch());
    }

    @Test
    public void daysToYearSinceEpochShouldBe1826ForTheFifthYearBecauseItIsNotALeapYearButTheYearBeforeItIs() {
        assertEquals(5 * 365 + 1, new TDate(5, 1, 1).daysToYearSinceEpoch());
    }

    @Test
    public void year2000Has366Days() {
        assertEquals(366 - 31, new TDate(2000, 12, 31).daysToMonthSinceYear());
    }
    
    @Test
    public void isLeapYearShouldMatchWikipedia() {
        // http://en.wikipedia.org/wiki/List_of_leap_years
        int[] leapYearsAccordingToWikipedia = {
                1600,1604,1608,1612,1616,1620,1624,1628,1632,1636,1640,1644,1648,1652,1656,1660,1664,1668,1672,1676,1680,1684,1688,1692,1696,1704,1708,1712,1716,1720,1724,1728,1732,1736,1740,1744,1748,1752,1756,1760,1764,1768,1772,1776,1780,1784,1788,1792,1796,1804,1808,1812,1816,1820,1824,1828,1832,1836,1840,1844,1848,1852,1856,1860,1864,1868,1872,1876,1880,1884,1888,1892,1896,1904,1908,1912,1916,1920,1924,1928,1932,1936,1940,1944,1948,1952,1956,1960,1964,1968,1972,1976,1980,1984,1988,1992,1996,2000,2004,2008,2012,2016,2020,2024,2028,2032,2036,2040,2044,2048,2052,2056,2060,2064,2068,2072,2076,2080,2084,2088,2092,2096,2104,2108
        };
        
        for(int i=0; i < leapYearsAccordingToWikipedia.length; i++) {
            int leapYear = leapYearsAccordingToWikipedia[i];
            assertTrue (new TDate(leapYear+0, 1, 1).isLeapYear());
            assertFalse(new TDate(leapYear+1, 1, 1).isLeapYear());
            assertFalse(new TDate(leapYear+2, 1, 1).isLeapYear());
            assertFalse(new TDate(leapYear+3, 1, 1).isLeapYear());
        }
    }

    private static int diff(int y1, int m1, int d1, int y2, int m2, int d2) {
        return new TDate(y1, m1, d1).diff(new TDate(y2, m2, d2));
    }

    @Test
    public void diffBetweenSameDatesIsZero() {
        assertEquals(0, diff(2011, 11, 13, 2011, 11, 13));
    }

    @Test
    public void diffBetweenConsequentDatesIsOne() {
        assertEquals(1, diff(2011, 11, 13, 2011, 11, 14));
    }


    /**
     *
     * The difference between two dates as compared to timeanddate.com
     *
     * http://www.timeanddate.com/date/durationresult.html?d1=13&m1=11&y1=1995&d2=13&m2=11&y2=2011
     */
    @Test
    public void diffBetweenTwoKnownDates() {
        assertEquals(5844, diff(1995, 11, 13, 2011, 11, 13));
    }

    /**
     * Again, according to timeanddate.com, I'm 13204 days old today (2011-11-13)
     *
     * http://www.timeanddate.com/date/durationresult.html?d1=19&m1=09&y1=1975&d2=13&m2=11&y2=2011
     */
    @Test
    public void howOldIsTushar() {
        assertEquals(13204, diff(1975, 9, 19, 2011, 11, 13));
    }


}
