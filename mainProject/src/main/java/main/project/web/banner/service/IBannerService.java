package main.project.web.banner.service;

import org.springframework.transaction.annotation.Transactional;

import main.project.web.banner.vo.BannerVO;

public interface IBannerService {
	BannerVO selectBanner();
	@Transactional 
	void updateBanner(BannerVO bannerVO);
	@Transactional 
	void updateBannerText(BannerVO bannerVO);
	@Transactional 
	void updateBanner2(BannerVO bannerVO);
	@Transactional 
	void updateBannerText2(BannerVO bannerVO);
}
