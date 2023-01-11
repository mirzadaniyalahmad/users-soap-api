package com.cyberdiverge.userssoapapi.repository;


import com.cyberdiverge.users_soap_api.User;

import com.cyberdiverge.userssoapapi.model.UserEntity;
import com.cyberdiverge.userssoapapi.util.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	UserRepository empRepository;

	// READ
	public List<UserEntity> getUsers() {
		return empRepository.findAll();
	}

	public User findById(String id) {
		try {
			UserEntity user = jdbcTemplate.queryForObject("SELECT * FROM soapusers WHERE id=?",
					BeanPropertyRowMapper.newInstance(UserEntity.class), id);

			return AppUtils.getUser(user);
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}

	public int save(UserEntity user) {
		return jdbcTemplate.update("INSERT INTO soapusers (id, username, firstname, lastname, email) VALUES(?,?,?,?,?)",
				new Object[] { user.getId(), user.getUserName(), user.getFirstName(), user.getLastName(), user.getEmail()});
	}

	public int update(UserEntity user) {
		return jdbcTemplate.update("UPDATE soapusers SET username=?, firstname=?, lastname=?, email=? WHERE id=?",
				new Object[] { user.getUserName(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getId()});
	}

	public int deleteById(String id) {
		return jdbcTemplate.update("DELETE FROM soapusers WHERE id=?", id);
	}

	public List<String> searchCapabilityById(String id) {
		String sql = "SELECT capability FROM soapcapabilities where id = '" + id + "'";

		List<String> c = new ArrayList<String>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

		for (Map row : rows) {

			c.add((String) row.get("capability"));
		}

		return c;
	}
}