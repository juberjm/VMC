package com.app.service;

import com.app.model.User;
import com.app.payload.SignUpRequest;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface AuthService {

    User registerUser(SignUpRequest signUpRequest, String siteURL) throws MessagingException, UnsupportedEncodingException;

    Boolean verify(String verificationCode);
}
