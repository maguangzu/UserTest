package com.zccp.bms.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.zccp.bms.dao.UserInfoDAO;
import com.zccp.bms.entity.UserInfo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;


public class UserBiz {

	UserInfoDAO dao = new UserInfoDAO();

	// 查询人员信息
	public List<UserInfo> findUser(String name) {
		if (StringUtils.isBlank(name)){
			return dao.queryData();
		}
		return dao.queryData(name);
	}

	// 查询人员信息
	public List<UserInfo> findUserID(String name) {
		List<UserInfo> ll = null;
		if (StringUtils.isBlank(name)){
			ll = dao.queryData();
		}else{
			ll = dao.queryData(name);
		}
		if (CollectionUtils.isNotEmpty(ll)){
			List<UserInfo> ls = ll.stream().sorted(Comparator.comparing(UserInfo::getId)).collect(Collectors.toList());
			return ls;
		}
		return ll;
	}

	// 查询人员信息
	public List<UserInfo> findUserName(String name) {
		List<UserInfo> ll = null;
		if (StringUtils.isBlank(name)){
			ll = dao.queryData();
		}else{
			ll = dao.queryData(name);
		}
		if (CollectionUtils.isNotEmpty(ll)){
			List<UserInfo> ls = ll.stream().sorted(Comparator.comparing(UserInfo::getLoginname)).collect(Collectors.toList());
			return ls;
		}
		return ll;
	}

}
