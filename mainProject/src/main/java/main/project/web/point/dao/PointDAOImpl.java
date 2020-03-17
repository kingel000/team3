package main.project.web.point.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import main.project.web.point.vo.PointVO;
import main.project.web.product.vo.findVO;


@Repository("pointDAO")
public class PointDAOImpl implements IPointDAO {
	
	@Inject
	private SqlSessionTemplate sqlSessionTemplate;

	public void insertPoint(PointVO pointVO) {
		System.out.println("+++ insert Point " + pointVO);
		 sqlSessionTemplate.insert("main.project.web.point.dao.IPointDAO.insertPoint",pointVO);
		
	}

	public void updatePoint(PointVO pointVO) {
		 sqlSessionTemplate.update("main.project.web.point.dao.IPointDAO.updatePoint",pointVO);		
	}

	@Override
	public List<PointVO> selectPoint(int displayPost, int postNum) throws Exception {
		HashMap<String, Integer> data = new HashMap<String, Integer>();
		data.put("displayPost", displayPost);
		data.put("postNum", postNum);
		return sqlSessionTemplate.selectList("main.project.web.point.dao.IPointDAO.selectPoint", data);
	}

	@Override
	public List<PointVO> selectPointId(String expertId) {
		return sqlSessionTemplate.selectList("main.project.web.point.dao.IPointDAO.selectPointId",expertId);		
	}

	@Override
	public Integer selectCount() {
		return sqlSessionTemplate.selectOne("main.project.web.point.dao.IPointDAO.selectCount");
	}

	@Override
	public Integer selectState(String state) {
		return sqlSessionTemplate.selectOne("main.project.web.point.dao.IPointDAO.selectState",state);
	}

	@Override
	public List<PointVO> pointFindList(findVO find) {
		return sqlSessionTemplate.selectList("main.project.web.point.dao.IPointDAO.pointFindList",find);	
	}
}
