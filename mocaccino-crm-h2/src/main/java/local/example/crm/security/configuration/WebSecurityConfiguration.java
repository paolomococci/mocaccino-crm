/**
 *
 * Copyright 2020 paolo mococci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed following in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package local.example.crm.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import local.example.crm.security.cache.CustomizedRequestCache;
import local.example.crm.security.util.SecurityUtil;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration 
		extends WebSecurityConfigurerAdapter {

	private static final String LOGIN_URL = "/login";
	private static final String LOGIN_FAILURE_URL = "/login?error";
	private static final String[] ANT_PATTERNS = { 
			"/VAADIN/**", 
			"robots.txt", 
			"manifest.webmanifest", 
			"offline.html", 
			"/icons/**", 
			"/images/**", 
			"/styles/**", 
			"/h2-console/**"
			};
	private static final String RESTFUL_PATTERN = "/rest/api/**";

	@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) 
			throws Exception {
		authenticationManagerBuilder
			.inMemoryAuthentication()
			.withUser("john")
			.password(this.passwordEncoder().encode("john123"))
			.roles("USER");
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) 
			throws Exception {
		httpSecurity
			.csrf().disable().requestCache().requestCache(new CustomizedRequestCache())
			.and().authorizeRequests()
				.antMatchers(HttpMethod.GET ,RESTFUL_PATTERN).hasRole("USER")
				.antMatchers(HttpMethod.POST ,RESTFUL_PATTERN).hasRole("ADMIN")
				.antMatchers(HttpMethod.PUT ,RESTFUL_PATTERN).hasRole("ADMIN")
				.antMatchers(HttpMethod.PATCH ,RESTFUL_PATTERN).hasRole("ADMIN")
				.antMatchers(HttpMethod.DELETE ,RESTFUL_PATTERN).hasRole("ADMIN")
			.and().authorizeRequests()
				.requestMatchers(SecurityUtil::isFrameworkInternalRequest)
				.permitAll().anyRequest().authenticated()
			.and().formLogin().loginPage(LOGIN_URL).permitAll()
				.loginProcessingUrl(LOGIN_URL)
				.failureUrl(LOGIN_FAILURE_URL)
			.and().logout().logoutSuccessUrl(LOGIN_URL);
	}

	@Override
	public void configure(WebSecurity webSecurity) 
			throws Exception {
		webSecurity.ignoring().antMatchers(ANT_PATTERNS);
	}

	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		UserDetails userDetails = User
			.withUsername("paul")
			.password(this.passwordEncoder()
			.encode("qwerty123"))
			.roles("USER", "ADMIN")
			.build();
		return new InMemoryUserDetailsManager(userDetails);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
