package greedzzz.notetakingapp.repositories;

import greedzzz.notetakingapp.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Integer> {
}
