package coding_maverick.todo_webapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.security.Security;
import java.util.function.Function;

@Configuration // Configure the things that you want spring to manage - Marks the class as source of bean definition
public class SpringSecurityConfiguration {


    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {
//        UserDetails userDetails = User.withDefaultPasswordEncoder().username("siyo").password("dummy").roles("USER","ADMIN").build();
        UserDetails userDetail1 = createNewUser("siyo", "123");
        UserDetails userDetail2 = createNewUser("batman", "bat");
        return new InMemoryUserDetailsManager(userDetail1, userDetail2);
    }

    private UserDetails createNewUser(String username, String password) {
        UserDetails userDetails = User.builder()
                .passwordEncoder(input -> passwordEncoder().encode(input))
                .username(username).password(password).roles("USER", "ADMIN").build();
        return userDetails;
    }

    // CustomPasswordEncoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
        httpSecurity.formLogin(Customizer.withDefaults());
        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();  // h2-console uses frames - so we are disabling the frameOptions in headers

        return httpSecurity.build();

    }

}
