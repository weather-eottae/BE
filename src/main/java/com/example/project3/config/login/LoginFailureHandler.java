package com.example.project3.config.login;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {

        @Override
        public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                            AuthenticationException exception) throws IOException {
            log.info("로그인에 실패해 LoginFailureHandler가 실행됩니다.");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

            // 미설정 시 한글 깨짐
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/plain;charset=UTF-8");

            response.getWriter().write("로그인 실패! 이메일이나 비밀번호를 확인해주세요.");

            log.info("로그인에 실패했습니다. 메시지 : {}", exception.getMessage());
        }
    }