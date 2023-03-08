package greedzzz.notetakingapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class NoteCommands {
    private final NoteService noteService;
    private final UserOutput userOutput;

    @Autowired
    public NoteCommands(NoteService noteService, UserOutput userOutput) {
        this.noteService = noteService;
        this.userOutput = userOutput;
    }

    @ShellMethod("Creates a new note with the specified name.")
    public String create(@ShellOption String noteName) {
        return userOutput.getCreateResult(noteService.create(noteName));
    }

    @ShellMethod("Deletes the specified note.")
    public String delete(@ShellOption String noteName) {
        return userOutput.getDeleteResult(noteService.delete(noteName));
    }

    @ShellMethod("Starts editing the specified note.")
    public String edit(@ShellOption String noteName) {
        return userOutput.getEditResult(noteService.edit(noteName));
    }

    @ShellMethod("Displays a list of all notes.")
    public String list() {
        return userOutput.getListResult(noteService.list());
    }

    @ShellMethod("Displays the text of the specified note.")
    public String show(@ShellOption String noteName) {
        return userOutput.getShowResult(noteService.show(noteName));
    }
}
