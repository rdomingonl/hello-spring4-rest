package hello;


//@Configuration
//@EnableWebMvcSecurity
public class WebSecurityConfig {
    // public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    // @Override
    // protected void configure(HttpSecurity http) throws Exception {
    // http.authorizeRequests().antMatchers("/hello").authenticated();
    // http.httpBasic();
    // http.authorizeRequests().antMatchers("/*", "/**").permitAll().anyRequest().authenticated();
    // http.formLogin().loginPage("/login").permitAll().and().logout().permitAll();
    // }

    // @Configuration
    // protected static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {
    //
    // @Override
    // public void init(AuthenticationManagerBuilder auth) throws Exception {
    // auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
    // }
    // }
}