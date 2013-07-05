package com.pokle.dd;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Command line app that takes in a CSV file with two dates from standard input, and spits out their difference.
 */
public class Command {
    private static Pattern LINE_PATTERN = Pattern.compile("(\\d{2}) (\\d{2}) (\\d{4}), (\\d{2}) (\\d{2}) (\\d{4})");
    
    public static void main(String args[]) {

        System.out.println("hey!");


        LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(System.in));
        try {
            String line;
            while(null != (line = lineNumberReader.readLine())) {
                processLine(line);
            }
        } catch (IOException ioe) {
            Logger.getAnonymousLogger().log(Level.SEVERE, "Can't read std input", ioe);
        } finally {
            try {lineNumberReader.close();} catch(IOException e) {/* innocuous */}
        }
    }

    private static void processLine(String line) {
        Matcher matcher = LINE_PATTERN.matcher(line);
        if (matcher.matches()) {
            TDate d1 = new TDate(Integer.valueOf(matcher.group(3)), Integer.valueOf(matcher.group(2)), Integer.valueOf(matcher.group(1)));
            TDate d2 = new TDate(Integer.valueOf(matcher.group(6)), Integer.valueOf(matcher.group(5)), Integer.valueOf(matcher.group(4)));
            System.out.println(d1 + ", " + d2 + ", " + d1.diff(d2));
        } else {
            System.err.println("ERROR: " + line);
        }

    }

}
