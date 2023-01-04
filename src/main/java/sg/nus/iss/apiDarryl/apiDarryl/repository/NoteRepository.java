package sg.nus.iss.apiDarryl.apiDarryl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.nus.iss.apiDarryl.apiDarryl.Model.Note;

public interface NoteRepository extends JpaRepository<Note, Long>{
    
}
