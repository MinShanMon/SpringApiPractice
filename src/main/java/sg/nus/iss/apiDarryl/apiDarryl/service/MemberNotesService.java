package sg.nus.iss.apiDarryl.apiDarryl.service;

import sg.nus.iss.apiDarryl.apiDarryl.Model.MemberNote;

public interface MemberNotesService {
    public String createMemberAndAddNote(MemberNote memberNote) throws Exception;
    public MemberNote getNoteListByMemberId(Long id);
}
