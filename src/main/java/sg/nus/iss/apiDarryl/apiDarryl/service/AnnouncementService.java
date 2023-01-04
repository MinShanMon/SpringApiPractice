package sg.nus.iss.apiDarryl.apiDarryl.service;

import java.util.List;

import sg.nus.iss.apiDarryl.apiDarryl.Model.Announcement;

public interface AnnouncementService {
    Announcement saveAnnouncement(Announcement announcement);
    
    List<Announcement> getAnnouncementList();
    
    Announcement updateAnnouncement(Announcement announcement, Long announcementId);

    Boolean deleteAnnouncementById(Long announcementId);
}
