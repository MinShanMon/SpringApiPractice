package sg.nus.iss.apiDarryl.apiDarryl.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.nus.iss.apiDarryl.apiDarryl.Model.Announcement;
import sg.nus.iss.apiDarryl.apiDarryl.repository.AnnouncementRepository;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    @Autowired
    AnnouncementRepository announcementRepository;

    public AnnouncementServiceImpl(AnnouncementRepository repo){
        this.announcementRepository = repo;
    }

    @Override
    public Announcement saveAnnouncement(Announcement announcement) {
        return announcementRepository.save(announcement);
    }

    @Override
    public List<Announcement> getAnnouncementList() {
        return announcementRepository.findAll();
    }

    @Override
    public Announcement updateAnnouncement(Announcement announcement, Long announcementId) {
        Announcement announcementEnt = announcementRepository.findById(announcementId).get();
        //check not null or whitespace
        if(Objects.nonNull(announcement.getText()) && !"".equalsIgnoreCase(announcement.getText())){
            announcementEnt.setText(announcement.getText());
        }
        return announcementRepository.save(announcementEnt);
    }

    @Override
    public Boolean deleteAnnouncementById(Long announcementId) {
        try{
            announcementRepository.deleteById(announcementId);
            return true;
        }
        catch(Exception e){
            return false;
        }
        
    }
    
}
