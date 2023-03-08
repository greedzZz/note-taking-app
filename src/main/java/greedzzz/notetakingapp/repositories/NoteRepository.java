package greedzzz.notetakingapp.repositories;

import greedzzz.notetakingapp.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, Integer> {
    boolean existsByName(String name);
    void deleteByName(String name);
    Optional<Note> findByName(String name);
}
