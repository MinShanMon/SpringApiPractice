package sg.nus.iss.apiDarryl.apiDarryl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sg.nus.iss.apiDarryl.apiDarryl.Model.Announcement;


@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Long>{
    
}
