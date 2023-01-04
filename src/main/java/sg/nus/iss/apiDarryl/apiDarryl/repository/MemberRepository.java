package sg.nus.iss.apiDarryl.apiDarryl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.nus.iss.apiDarryl.apiDarryl.Model.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
    
}
