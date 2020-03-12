package main.project.web.point.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import main.project.web.point.dao.IPointDAO;
import main.project.web.point.vo.PointVO;

@Service("pointService")
public class PointService implements IPointService {
	
	@Inject
	private IPointDAO PointDAO;

	@Override
	public void insertPoint(PointVO pointVO) {
		System.out.println("AAA insert Point " + pointVO);
		PointDAO.insertPoint(pointVO);
	}

	@Override
	public void updatePoint(String expertId) {
		PointDAO.updatePoint(expertId);
	}

	@Override
	public List<PointVO> selectPoint() {
		return PointDAO.selectPoint();

	}

	@Override
	public List<PointVO> selectPointId(String expertId) {
		return PointDAO.selectPointId(expertId);

	}

}
