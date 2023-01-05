package sg.nus.iss.apiDarryl.apiDarryl.service;

import java.util.List;

import sg.nus.iss.apiDarryl.apiDarryl.Model.Note;

public interface NoteService {
    Note saveNote(Note note);

    List<Note> getNoteList();

    Note updateNote(Note note, Long  noteId);

    Boolean deleteNoteById(Long noteId);

    List<Note> getNotesById(Long memberId);
}
