package greedzzz.notetakingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class NoteTakingAppApplication {

    public static void main(String[] args) {
        List<String> argList = new ArrayList<>(Arrays.asList(args));
        argList.add("--spring.shell.command.history.enabled=false");
        argList.add("--spring.shell.command.script.enabled=false");
        argList.add("--spring.shell.command.stacktrace.enabled=false");
        args = argList.toArray(new String[0]);
        SpringApplication.run(NoteTakingAppApplication.class, args);
    }

}
