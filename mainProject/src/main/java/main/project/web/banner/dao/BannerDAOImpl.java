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

	@Override
	public void updateBanner(BannerVO bannerVO) {
		sqlSessionTemplate.update("main.project.web.banner.dao.IBannerDAO.updateBanner", bannerVO);
		
	}

	@Override
	public void updateBannerText(BannerVO bannerVO) {
		sqlSessionTemplate.update("main.project.web.banner.dao.IBannerDAO.updateBannerText", bannerVO);
		
	}

	@Override
	public void updateBanner2(BannerVO bannerVO) {
		sqlSessionTemplate.update("main.project.web.banner.dao.IBannerDAO.updateBanner2", bannerVO);
		
	}

	@Override
	public void updateBannerText2(BannerVO bannerVO) {
		sqlSessionTemplate.update("main.project.web.banner.dao.IBannerDAO.updateBannerText2", bannerVO);
		
	}

	


}
