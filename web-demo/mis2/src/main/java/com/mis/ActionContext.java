package com.mis;

import javax.servlet.http.HttpSession;

import com.mis.domain.User;
import com.mis.util.Constants;

public class ActionContext {

	public static User getSessionUser(HttpSession session) {
		User user = (User) session.getAttribute(Constants.SESSION_USER);
		if (user != null) {
			return user;
		} else {
			return null;
		}
	}

}
