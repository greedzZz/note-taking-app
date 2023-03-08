package greedzzz.notetakingapp.ui;

import greedzzz.notetakingapp.model.Note;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserOutput {
    public void printCreateResult(boolean created) {
        if (created) System.out.println("The new note has been successfully created.");
        else System.out.println("A note with the same name already exists.");
    }

    public void printDeleteResult(boolean deleted) {
        if (deleted) System.out.println("The note has been successfully deleted.");
        else System.out.println("There was no note with that name.");
    }

    public void printListResult(List<Note> notes) {
        if (!notes.isEmpty()) {
            System.out.println("The list of notes:");
            for (Note note : notes) {
                System.out.println(note.getName());
            }
        } else System.out.println("There are currently no notes.");
    }

    public void printShowResult(String text) {
        if (null == text) System.out.println("There was no note with that name.");
        else {
            System.out.println("The text of this note:");
            System.out.println(text);
        }
    }
}
