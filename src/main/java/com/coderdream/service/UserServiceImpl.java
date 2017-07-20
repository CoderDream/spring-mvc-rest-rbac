package com.coderdream.service;

import com.coderdream.dao.UserDao;
import com.coderdream.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 * User: Zhang Kaitao
 * <p>
 * Date: 14-1-28
 * <p>
 * Version: 1.0
 */
@Service

public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private PasswordHelper passwordHelper;
	@Autowired
	private RoleService roleService;

	/**
	 * 创建用户
	 * 
	 * @param user
	 */
	public User createUser(User user) {
		// 加密密码
		passwordHelper.encryptPassword(user);
		return userDao.createUser(user);
	}

	@Override
	public void deleteUser(Long userId) {
		userDao.deleteUser(userId);
	}

	/**
	 * 修改密码
	 * 
	 * @param userId
	 * @param newPassword
	 */
	public void changePassword(Long userId, String newPassword) {
		User user = userDao.findOne(userId);
		user.setPassword(newPassword);
		passwordHelper.encryptPassword(user);
		userDao.updateUser(user);
	}

	@Override
	public User findOne(Long userId) {
		return userDao.findOne(userId);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	/**
	 * 根据用户名查找用户
	 * 
	 * @param username
	 * @return
	 */
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	/**
	 * 根据用户名查找其角色
	 * 
	 * @param username
	 * @return
	 */
	public Set<String> findRoles(String username) {
		User user = findByUsername(username);
		if (user == null) {
			return Collections.EMPTY_SET;
		}
		return roleService.findRoles(user.getRoleIds().toArray(new Long[0]));
	}

	/**
	 * 根据用户名查找其权限
	 * 
	 * @param username
	 * @return
	 */
	public Set<String> findPermissions(String username) {
		User user = findByUsername(username);
		if (user == null) {
			return Collections.EMPTY_SET;
		}
		return roleService
				.findPermissions(user.getRoleIds().toArray(new Long[0]));
	}
	
	/**
	 * 根据用户名查找其权限ID
	 * 
	 * @param username
	 * @return
	 */
	public Set<Long> findResourceIds(String username) {
		User user = findByUsername(username);
		if (user == null) {
			return Collections.EMPTY_SET;
		}
		return roleService
				.findResourceIds(user.getRoleIds().toArray(new Long[0]));
	}

	private static List<User> users;

	static {
		users = populateDummyUsers();
	}

	public List<User> findAllUsers() {
		return users;
	}

	public User findById(long id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public User findByName(String username) {
		for (User user : users) {
			if (user.getUsername().equalsIgnoreCase(username)) {
				return user;
			}
		}
		return null;
	}

	public void saveUser(User user) {
		users.add(user);
	}

	// public void updateUser(User user) {
	// int index = users.indexOf(user);
	// users.set(index, user);
	// }

	public void deleteUserById(long id) {

		for (Iterator<User> iterator = users.iterator(); iterator.hasNext();) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
			}
		}
	}

	public boolean isUserExist(User user) {
		return findByName(user.getUsername()) != null;
	}

	private static List<User> populateDummyUsers() {
		List<User> users = new ArrayList<User>();
		// users.add(new User(1,"Sam",30, 70000));
		// users.add(new User(2,"Tom",40, 50000));
		// users.add(new User(counter.incrementAndGet(),"Jerome",45, 30000));
		// users.add(new User(counter.incrementAndGet(),"Silvia",50, 40000));
		return users;
	}

	public void deleteAllUsers() {
		users.clear();
	}

	@Override
	public User updateUser(User user) {
		return updateUser(user);
	}
}
