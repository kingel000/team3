package main.project.web.member.service;

import org.springframework.transaction.annotation.Transactional;

import main.project.web.member.vo.ExpertVO;

public interface IExpertService {
	@Transactional 
   void insertExpert(ExpertVO expert);
	@Transactional 
   void insertRankExpert(String id);
	@Transactional 
   void deleteExpert(String id);
	@Transactional 
   void updateExpert(ExpertVO expert);
	@Transactional 
   void updateRankExpert(String id);
	@Transactional 
   void updatePointExpert(ExpertVO expert);
   ExpertVO selectExpert(String id);
   Integer totalMember_expert();
   
}
