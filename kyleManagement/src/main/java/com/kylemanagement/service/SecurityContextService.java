package com.kylemanagement.service;

import com.kylemanagement.model.User;
import org.springframework.security.core.Authentication;

public interface SecurityContextService {

	Authentication getAuthentication();

	User getLoggedUser();

}
