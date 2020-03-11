package main.project.web.banner.dao;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import main.project.web.banner.vo.BannerVO;

@Repository("bannerDAO")
public class BannerDAOImpl implements IBannerDAO {
	
	@Inject
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public BannerVO selectBanner() {
		return sqlSessionTemplate.selectOne("main.project.web.banner.dao.IBannerDAO.selectBanner");
	}

}
