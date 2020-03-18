package main.project.web.point.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import main.project.web.point.vo.PointVO;
import main.project.web.product.vo.findVO;

public interface IPointService {
	@Transactional 
	void insertPoint(PointVO pointVO);
	void updatePoint(PointVO pointVO);
	List<PointVO> selectPoint(int displayPost, int postNum) throws Exception;
	List<PointVO> selectPointId(String expertId);
	Integer selectCount();
	Integer selectState(String state);
	List<PointVO> pointFindList(findVO find);
}
