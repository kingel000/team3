package main.project.web.banner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.project.web.banner.dao.IBannerDAO;
import main.project.web.banner.vo.BannerVO;

@Service("bannerService")
public class BannerService implements IBannerService {

	@Autowired
	private IBannerDAO bannerDAO;
	
	@Override
	public BannerVO selectBanner() {
		return bannerDAO.selectBanner();
	}

	@Override
	public void updateBanner(BannerVO bannerVO) {
		bannerDAO.updateBanner(bannerVO);
		
	}

	@Override
	public void updateBannerText(BannerVO bannerVO) {
		bannerDAO.updateBannerText(bannerVO);
		
	}

	@Override
	public void updateBanner2(BannerVO bannerVO) {
		bannerDAO.updateBanner2(bannerVO);
		
	}

	

}
