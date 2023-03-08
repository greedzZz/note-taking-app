package greedzzz.notetakingapp.services;

import greedzzz.notetakingapp.model.Note;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOutput {
    public String getCreateResult(boolean created) {
        if (created) return "The new note has been successfully created.";
        else return "A note with the same name already exists.";
    }

    public String getDeleteResult(boolean deleted) {
        if (deleted) return "The note has been successfully deleted.";
        else return "There was no note with that name.";
    }

    public String getEditResult(boolean edited) {
        if (edited) return "The note has been successfully edited.";
        else return "Unable to edit note with that name.";
    }

    public String getListResult(List<Note> notes) {
        if (!notes.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("The list of notes:\n");
            for (Note note : notes) {
                sb.append(note.getName());
                sb.append("\n");
            }
            return sb.toString();
        } else return "There are currently no notes.";
    }

    public String getShowResult(String text) {
        if (null == text) return "There was no note with that name.";
        else return "The text of this note:\n" + text;
    }
}
