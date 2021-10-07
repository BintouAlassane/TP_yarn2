package com.opstty;

import com.opstty.job.DistinctDistricts;
import org.apache.hadoop.util.ProgramDriver;

public class AppDriver {
    public static void main(String argv[]) {
        int exitCode = -1;
        ProgramDriver programDriver = new ProgramDriver();

        try {
            programDriver.addClass("distinctDistricts", DistinctDistricts.class,
                "A map/reduce program that returns the distinct districts with trees in a predefined CSV formatting.");

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.exit(exitCode);
    }
}
