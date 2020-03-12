package main.project.web.point.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import main.project.web.point.dao.IPointDAO;
import main.project.web.point.vo.PointVO;

@Service("pointService")
public class PointService implements IPointService {
	
	@Inject
	private IPointDAO pointDAO;

	@Override
	public void insertPoint(PointVO pointVO) {
		pointDAO.insertPoint(pointVO);
	}

	@Override
	public void updatePoint(PointVO pointVO) {
		pointDAO.updatePoint(pointVO);
	}

	@Override
	public List<PointVO> selectPoint() {
		return pointDAO.selectPoint();

	}

	@Override
	public List<PointVO> selectPointId(String expertId) {
		return pointDAO.selectPointId(expertId);

	}

	@Override
	public Integer selectCount() {
		return pointDAO.selectCount();
	}

	@Override
	public Integer selectState(String state) {
		return pointDAO.selectState(state);
	}

}
