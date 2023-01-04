package sg.nus.iss.apiDarryl.apiDarryl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sg.nus.iss.apiDarryl.apiDarryl.Model.MemberRole;

@Repository
public interface MemberRoleRepository extends JpaRepository<MemberRole, Long>{
    
}
