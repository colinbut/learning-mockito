/**
 * 
 */
package com.mycompany.mockito.reference.documentation.tutorial;

/**
 * @author colin
 *
 */
public class UserServiceImpl implements UserService{

	private User user = new User();
	
	/*
	 * (non-Javadoc)
	 * @see com.mycompany.mockito.reference.documentation.tutorial.UserService#getUserNameByUserId(int)
	 */
	@Override
	public String getUserNameByUserId(int userId) {
		return user.getUsername();
	}

	/*
	 * (non-Javadoc)
	 * @see com.mycompany.mockito.reference.documentation.tutorial.UserService#getUserIdByUserName(java.lang.String)
	 */
	@Override
	public int getUserIdByUserName(String name) {
		return user.getUserId();
	}

}
