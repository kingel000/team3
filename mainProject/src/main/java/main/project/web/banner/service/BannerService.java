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

}
