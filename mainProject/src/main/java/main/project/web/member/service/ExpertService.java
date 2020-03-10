package main.project.web.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.project.web.member.dao.ExpertDAOImpl;
import main.project.web.member.vo.ExpertVO;

@Service("expertService")
public class ExpertService implements IExpertService {

	@Autowired
	private ExpertDAOImpl expertDAO;

	@Override
	public void insertExpert(ExpertVO expert) {
		expertDAO.insertExpert(expert);

	}

	@Override
	public void deleteExpert(String id) {
		expertDAO.deleteExpert(id);

	}

	@Override
	public void updateExpert(ExpertVO expert) {
		expertDAO.updateExpert(expert);

	}

	@Override
	public ExpertVO selectExpert(String id) {
		return expertDAO.selectExpert(id);
	}

	@Override
	public void updateRankExpert(String id) {
		expertDAO.updateRankExpert(id);

		
	}

	@Override
	public void insertRankExpert(String id) {
		expertDAO.insertRankExpert(id);

		
	}

	@Override
	public Integer totalMember_expert() {
		return expertDAO.totalMember_expert();
	}

}
