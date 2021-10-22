package cn.kgc.kjde1035.group1.service;

import java.util.List;
import java.util.Set;

import cn.kgc.kjde1035.group1.entity.SysFunction;
import cn.kgc.kjde1035.group1.entity.Sysrole;

public interface RoleService {
	List<Sysrole> listLimit(int currentPageNo, int pageSize);
	Integer findCount();
	Boolean addRole(Sysrole role);
	Sysrole findRoleById(Integer id);
	Boolean doEdit(Sysrole role);
	List<SysFunction> findAllFun();
	Set<Integer> findFunids(Integer roleId);
	void clearRoleFun(Integer roleId);
	Boolean setFunctionsToRole(Set<Integer> funIdSet,Integer RoleId);
}
