package main.project.web.point.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import main.project.web.point.vo.PointVO;

public interface IPointService {
	
	void insertPoint(PointVO pointVO);
	void updatePoint(String expertId);
	List<PointVO> selectPoint();
	List<PointVO> selectPointId(String expertId);

}
