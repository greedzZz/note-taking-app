package greedzzz.notetakingapp.services;

import greedzzz.notetakingapp.model.Note;
import greedzzz.notetakingapp.repositories.NoteRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    private final NoteRepository noteRepository;
    private final NoteEditor noteEditor;

    @Autowired
    public NoteService(NoteRepository noteRepository, NoteEditor noteEditor) {
        this.noteRepository = noteRepository;
        this.noteEditor = noteEditor;
    }

    @PostConstruct
    private void init() {
        List<Note> notes = list();
        if (notes.isEmpty()) create("default");
    }

    public boolean create(String name) {
        if (checkIfExists(name)) {
            Note note = new Note();
            note.setName(name);
            note.setText("");
            save(note);
            return true;
        } else return false;
    }

    public boolean delete(String name) {
        if (checkIfExists(name)) {
            noteRepository.deleteByName(name);
            return true;
        } else return false;
    }

    public boolean edit(String name) {
        Optional<Note> possibleNote = find(name);
        if (possibleNote.isPresent()) {
            Note note = noteEditor.edit(possibleNote.get());
            if (null != note) {
                save(note);
                return true;
            } else return false;
        } else return false;
    }

    public List<Note> list() {
        return noteRepository.findAll();
    }

    public String show(String name) {
        Optional<Note> possibleNote = find(name);
        return possibleNote.map(Note::getText).orElse(null);
    }

    private void save(Note note) {
        noteRepository.save(note);
    }

    private Optional<Note> find(String name) {
        return noteRepository.findByName(name);
    }

    private boolean checkIfExists(String name) {
        return noteRepository.existsByName(name);
    }
}
