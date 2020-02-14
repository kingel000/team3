package main.project.web.member.service;

import main.project.web.member.vo.ExpertVO;

public interface IExpertService {
	
   void insertExpert(ExpertVO expert);
   void deleteExpert(String id);
   void updateExpert(ExpertVO expert);
   ExpertVO selectExpert(String id);
   
}
