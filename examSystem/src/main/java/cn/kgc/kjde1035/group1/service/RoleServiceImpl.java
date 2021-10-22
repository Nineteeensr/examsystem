package cn.kgc.kjde1035.group1.service;

import java.util.List;
import java.util.Set;

import cn.kgc.kjde1035.group1.dao.LFunctionDaoImpl;
import cn.kgc.kjde1035.group1.dao.RoleDaoImpl;
import cn.kgc.kjde1035.group1.entity.SysFunction;
import cn.kgc.kjde1035.group1.entity.Sysrole;

public class RoleServiceImpl implements RoleService {
	RoleDaoImpl rd = new RoleDaoImpl();

	@Override
	public List<Sysrole> listLimit(int currentPageNo, int pageSize) {
		// TODO Auto-generated method stub
		return rd.findRolesLimit(currentPageNo, pageSize);
	}

	@Override
	public Integer findCount() {
		// TODO Auto-generated method stub
		return rd.getCount();
	}

	@Override
	public Boolean addRole(Sysrole role) {
		// TODO Auto-generated method stub
		return rd.addRole(role);
	}

	@Override
	public Sysrole findRoleById(Integer id) {
		return rd.queryRoleById(id);
	}

	@Override
	public Boolean doEdit(Sysrole role) {
		// TODO Auto-generated method stub
		return rd.updateRoel(role);
	}

	@Override
	public List<SysFunction> findAllFun() {
		return new LFunctionDaoImpl().queryAllFun();
	}

	@Override
	public Set<Integer> findFunids(Integer roleId) {
		// TODO Auto-generated method stub
		return rd.getFunction(roleId);
	}

	@Override
	public void clearRoleFun(Integer roleId) {
		rd.clearFunByRoleId(roleId);
		
	}

	@Override
	public Boolean setFunctionsToRole(Set<Integer> funIdSet, Integer RoleId) {
		return 	rd.setFunctoinsToRole(funIdSet, RoleId);
	}

}
