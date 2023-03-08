package greedzzz.notetakingapp.ui;

import greedzzz.notetakingapp.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class UserCommands {
    private final NoteService noteService;
    private final UserOutput userOutput;

    @Autowired
    public UserCommands(NoteService noteService, UserOutput userOutput) {
        this.noteService = noteService;
        this.userOutput = userOutput;
    }

    @ShellMethod("Creates a new note with the specified name.")
    public void create(@ShellOption String noteName) {
        userOutput.printCreateResult(noteService.create(noteName));
    }

    @ShellMethod("Deletes the specified note.")
    public void delete(@ShellOption String noteName) {
        userOutput.printDeleteResult(noteService.delete(noteName));
    }

    @ShellMethod("Starts editing the specified note.")
    public void edit(@ShellOption String noteName) {

    }

    @ShellMethod("Displays a list of all notes.")
    public void list() {
        userOutput.printListResult(noteService.list());
    }

    @ShellMethod("Displays the text of the specified note.")
    public void show(@ShellOption String noteName) {
        userOutput.printShowResult(noteService.show(noteName));
    }
}
