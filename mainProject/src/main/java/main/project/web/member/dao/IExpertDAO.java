package main.project.web.member.dao;

import org.apache.ibatis.annotations.Param;
import main.project.web.member.vo.ExpertVO;

public interface IExpertDAO {

   void insertExpert(ExpertVO expert);
   void deleteExpert(@Param("expert_id")String id);
   void updateExpert(ExpertVO expert);
   ExpertVO selectExpert(@Param("expert_id")String id);
   
}