package com.springboot.config.auth;

import com.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity // 스프링 Security 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable().headers().frameOptions().disable()// h2 console화면을 사용하기 위해 해당 옵션들 disable
                .and()
                .authorizeRequests() // URL 별 권한 관리를 설정하는 옵션의 시작점
                .antMatchers("/","/css/**","/images/**","/js/**","/h2-console/") //권한 관리 대상을 지정하는 옵션
                .permitAll() // 위 url들은 전체 열람 권한
                .antMatchers("/api/v1/**").hasRole(Role.USER.name()) // 여긴 user권한을 가진 사람들만 가능
                .anyRequest().authenticated() //설정된 값들 이외 나머지 URL authenticated()로 나저미 URL들은 모두 인증된 유저만 가능
                .and()
                .logout().logoutSuccessUrl("/") // 로그아웃 기능에 대한 여러 설정의 진입점. 성공시 / 주소로
                .and()
                .oauth2Login() // OAuth2 로그인 기능에 대한 여러 설정의 진입점
                .userInfoEndpoint() //로그인 성공 후 사용자 정보를 가져올 때의 설정들을 담당
                .userService(customOAuth2UserService); // 소셜 로그인 성공 시 후속 조치를 진행할 UserService 인터페이스의 구현체 등록
    }
}
