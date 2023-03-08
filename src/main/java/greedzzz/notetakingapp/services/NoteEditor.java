package greedzzz.notetakingapp.services;

import greedzzz.notetakingapp.model.Note;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.stream.Collectors;

@Service
public class NoteEditor {
    public Note edit(Note note) {
        try {
            String text = note.getText();

            File tempFile = File.createTempFile("text", ".txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            writer.write(text);
            writer.close();

            String osName = System.getProperty("os.name").toLowerCase();
            String command;
            if (osName.contains("win")) command = "notepad";
            else if (osName.contains("mac")) command = "open -t";
            else command = "xdg-open";

            ProcessBuilder processBuilder = new ProcessBuilder(command, tempFile.getAbsolutePath());
            processBuilder.inheritIO();
            int exitCode = processBuilder.start().waitFor();
            if (exitCode != 0) return null;

            BufferedReader reader = new BufferedReader(new FileReader(tempFile));
            String newText = reader.lines().collect(Collectors.joining(System.lineSeparator()));
            reader.close();
            tempFile.delete();

            note.setText(newText);
            return note;
        } catch (IOException | InterruptedException e) {
            return null;
        }
    }
}
