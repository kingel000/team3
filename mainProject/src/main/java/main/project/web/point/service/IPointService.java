package main.project.web.point.service;

import java.util.List;
import main.project.web.point.vo.PointVO;

public interface IPointService {
	
	void insertPoint(PointVO pointVO);
	void updatePoint(PointVO pointVO);
	List<PointVO> selectPoint();
	List<PointVO> selectPointId(String expertId);
	Integer selectCount();
	Integer selectState(String state);
}
