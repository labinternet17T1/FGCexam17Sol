package cat.tecnocampus.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String USERS_QUERY = "select username, password, enabled from user where username = ?";

    private static final String AUTHORITIES_QUERY = "select username, role from user_roles where username = ?";
	
	
    @Autowired
    private DataSource dataSource;

    @Bean
    public PasswordEncoder passEncoder() {
        return new BCryptPasswordEncoder();
    }
   
     //Configure authentication manager
     @Override
     public void configure(AuthenticationManagerBuilder auth) throws Exception {
         auth.jdbcAuthentication()
                 .dataSource(dataSource)
                 .usersByUsernameQuery(USERS_QUERY)
                 .authoritiesByUsernameQuery(AUTHORITIES_QUERY)
                 .passwordEncoder(passEncoder());
     }
    //Configure Spring security's filter chain
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }

    //Configure how requests are secured by interceptors
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .mvcMatchers("/**").permitAll()
                    .antMatchers("/static/**").permitAll()
                    .antMatchers("/h2-console/**").permitAll()
                    .mvcMatchers("/stations").permitAll()
                    .mvcMatchers("/user/**").authenticated()
                    .mvcMatchers("/users/**").hasRole("ADMIN")
                    .antMatchers("/byebye").permitAll()
                    .antMatchers("/api/**").permitAll()
                    .anyRequest().authenticated()
                .and()
                .formLogin() //a login form is showed when no authenticated request
                .and()
                .rememberMe()
                    .tokenValiditySeconds(2419200)
                    .key("fgc")
                .and()
                .logout()
                .logoutSuccessUrl("/byebye"); //where to go when logout is successful

        //Required to allow h2-console work
        http
                .csrf().disable()
                .headers()
                .frameOptions().disable();
    }
}

