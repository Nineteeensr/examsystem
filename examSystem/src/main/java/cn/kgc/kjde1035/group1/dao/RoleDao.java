package cn.kgc.kjde1035.group1.dao;

import java.util.List;
import java.util.Set;

import cn.kgc.kjde1035.group1.entity.Sysrole;

public interface RoleDao {
	List<Sysrole> findRolesLimit(int currentPageNo, int pageSize);

	boolean addRole(Sysrole role);

	Sysrole queryRoleById(Integer id);

	Boolean updateRoel(Sysrole role);

	Set<Integer> getFunction(Integer roleId);

	void clearFunByRoleId(Integer roleId);

	Boolean setFunctoinsToRole(Set<Integer> funIdSet, Integer roleId);

}
