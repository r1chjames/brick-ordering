package com.richjames.brickordering.steps;

import com.richjames.brickordering.Application;
import com.richjames.brickordering.config.JdbiProviderModule;
import org.jdbi.v3.core.Handle;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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

    public static void truncateTables() {
        try {
            Handle handle = new JdbiProviderModule().prepareJdbi(Application.getApplicationEnvironment(), Application.getConfiguration()).open();
            handle.createCall("delete from order_lines cascade").invoke();
            handle.createCall("delete from order_headers cascade").invoke();
        } catch (Exception e) {
            System.out.println("Unable to truncate tables");
        }
    }

    public static String readFile(String path) throws IOException {
        if (!path.equals("")) {
            return new String(Files.readAllBytes(Paths.get(path)));
        }
        return null;
    }
}
