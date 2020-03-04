package main.project.web.member.dao;

import org.apache.ibatis.annotations.Param;
import main.project.web.member.vo.ExpertVO;

public interface IExpertDAO {

   void insertExpert(ExpertVO expert);
   void insertRankExpert(@Param("id")String id);
   void deleteExpert(String id);
   void updateExpert(ExpertVO expert);
   void updateRankExpert(String id);
  
   ExpertVO selectExpert(@Param("expert_id")String id);
   
}