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
    public void create(@ShellOption String noteName) {
        userOutput.printCreateResult(noteService.create(noteName));
    }

    @ShellMethod("Deletes the specified note.")
    public void delete(@ShellOption String noteName) {
        userOutput.printDeleteResult(noteService.delete(noteName));
    }

    @ShellMethod("Starts editing the specified note.")
    public void edit(@ShellOption String noteName) {
        userOutput.printEditResult(noteService.edit(noteName));
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
