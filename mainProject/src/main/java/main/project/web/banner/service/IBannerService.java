package main.project.web.banner.service;

import main.project.web.banner.vo.BannerVO;

public interface IBannerService {
	BannerVO selectBanner();
	void updateBanner(BannerVO bannerVO);
	void updateBannerText(BannerVO bannerVO);
	void updateBanner2(BannerVO bannerVO);
}
