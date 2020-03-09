package main.project.web.member.service;

import main.project.web.member.vo.ExpertVO;

public interface IExpertService {
	
   void insertExpert(ExpertVO expert);
   void insertRankExpert(String id);
   void deleteExpert(String id);
   void updateExpert(ExpertVO expert);
   void updateRankExpert(String id);
   ExpertVO selectExpert(String id);
   Integer totalMember_expert();
   
}
