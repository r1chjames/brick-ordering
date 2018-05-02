package com.richjames.brickordering.steps;

import com.richjames.brickordering.Application;

public class UtilSteps {

    public static void startService() throws Throwable {
        String[] args = new String[2];
        args[0] = "server";
        args[1] = "config/application_test.yml";
        Application.main(args);
    }

    public static void stopService() throws Exception {
        Application.stop();
    }
}
