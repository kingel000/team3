package main.project.web.banner.dao;

import main.project.web.banner.vo.BannerVO;

public interface IBannerDAO {
	BannerVO selectBanner();
	void updateBanner(BannerVO bannerVO);
	void updateBannerText(BannerVO bannerVO);
	void updateBanner2(BannerVO bannerVO);
	void updateBannerText2(BannerVO bannerVO);
}
