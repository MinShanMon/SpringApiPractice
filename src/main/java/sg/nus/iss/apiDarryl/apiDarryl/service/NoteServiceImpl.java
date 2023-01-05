package sg.nus.iss.apiDarryl.apiDarryl.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import sg.nus.iss.apiDarryl.apiDarryl.Model.Note;
import sg.nus.iss.apiDarryl.apiDarryl.repository.NoteRepository;

public class NoteServiceImpl implements NoteService{

    @Autowired
    NoteRepository noteRepository;

    @Override
    public Note saveNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public List<Note> getNoteList() {
        return noteRepository.findAll();
    }

    @Override
    public Note updateNote(Note note, Long noteId) {
        Note notes = noteRepository.findById(noteId).get();

        if(Objects.nonNull(note.getTitle())&& !"".equalsIgnoreCase(note.getTitle())){
            notes.setTitle(note.getTitle());
        }
        if(Objects.nonNull(note.getMessage()) && !"".equalsIgnoreCase(note.getMessage())){
            notes.setMessage(note.getMessage());
        }
        return noteRepository.save(notes);
    }

    @Override
    public Boolean deleteNoteById(Long noteId) {
        try{
            noteRepository.deleteById(noteId);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    @Override
    public List<Note> getNotesById(Long memberId) {
        return noteRepository.findAll().stream()
        .filter(m->m.getMemberDetails().getId().equals(memberId))
        .collect(Collectors.toList());
    }
    
}
