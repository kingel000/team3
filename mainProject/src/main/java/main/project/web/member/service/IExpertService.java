package main.project.web.member.service;

import org.springframework.transaction.annotation.Transactional;

import main.project.web.member.vo.ExpertVO;

public interface IExpertService {
	@Transactional 
   void insertExpert(ExpertVO expert);
	
   void insertRankExpert(String id); 
   void deleteExpert(String id);
	@Transactional 
   void updateExpert(ExpertVO expert);
	
   void updateRankExpert(String id);
   void updatePointExpert(ExpertVO expert);
   ExpertVO selectExpert(String id);
   Integer totalMember_expert();
   
}
