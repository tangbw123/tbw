package com.newer.task.data.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.newer.task.data.dao.IRoleDAO;
import com.newer.task.data.eneity.TbRole;
import com.newer.task.data.util.DBUtil;

@Component("roleDao")
public class RoleDaoImpl implements IRoleDAO {
	private JdbcTemplate template = new JdbcTemplate(DBUtil.getDataSource());

	public TbRole selectByRoleId(Integer roleId) {
		return (TbRole) template.queryForObject(
				"select * from t_role where role_id=?",
				new Object[] { roleId }, new RowMapper() {

					public Object mapRow(ResultSet rs, int index)
							throws SQLException {
						TbRole role = new TbRole();
						role.setRoleId(rs.getInt("role_id"));
						role.setRoleName(rs.getString("role_name"));
						role.setRoleDesc(rs.getString("role_desc"));
						return role;
					}

				});
	}

	public List<TbRole> findAllRoles() {
		System.out.println("ȫ����ѯ��ɫ");
		return template.query("select * from t_role", new RowMapper() {

			public Object mapRow(ResultSet rs, int index) throws SQLException {
				TbRole role = new TbRole();
				role.setRoleId(rs.getInt("role_id"));
				role.setRoleName(rs.getString("role_name"));
				role.setRoleDesc(rs.getString("role_desc"));
				return role;
			}
		});
	}

}
