package main.service.bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import goals.model.dao.GoalsDAO;
import report.model.dao.ReportDAO;


@Service
public class MainServiceImpl implements MainService {
	
	@Autowired
	private ReportDAO reportDAO = null;
	@Autowired
	private GoalsDAO goalsDAO = null;
	
	
	@Override
	//현재 예산에서 총 사용액
	public int selectOutcomeSumByBudgetId(int num) {
		int sum = reportDAO.selectOutcomeSumByBudgetId(num);
		return sum;
	}
	
	@Override
	public List selectMostGoals(String id) throws SQLException {
		List goalsList = new ArrayList();
		goalsList.add(goalsDAO.selectMostPersonalGoal(id));
		goalsList.add(goalsDAO.selectMostTeamGoal(id));
		
		return goalsList;
	}
	

}
