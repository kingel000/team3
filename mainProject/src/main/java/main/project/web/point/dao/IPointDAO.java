package main.project.web.point.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import main.project.web.point.vo.PointVO;

public interface IPointDAO {
	
	void insertPoint(PointVO pointVO);
	void updatePoint(@Param("expertId")String expertId);
	List<PointVO> selectPoint();
	List<PointVO> selectPointId(@Param("expertId")String expertId);
	
}
