package greedzzz.notetakingapp.services;

import greedzzz.notetakingapp.model.Note;
import greedzzz.notetakingapp.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public boolean create(String name) {
        Note note = new Note();
        note.setName(name);
        note.setText("");
        return save(note);
    }

    public boolean delete(String name) {
        if (checkIfExists(name)) {
            noteRepository.deleteByName(name);
            return true;
        } else return false;
    }

    public String show(String name) {
        Note note = find(name);
        if (null != note) return note.getText();
        else return null;
    }

    public List<Note> list() {
        return noteRepository.findAll();
    }

    public boolean save(Note note) {
        if (checkIfExists(note.getName())) {
            noteRepository.save(note);
            return true;
        } else return false;
    }

    public Note find(String name) {
        if (checkIfExists(name)) return noteRepository.findByName(name);
        else return null;
    }

    private boolean checkIfExists(String name) {
        return noteRepository.existsByName(name);
    }
}
