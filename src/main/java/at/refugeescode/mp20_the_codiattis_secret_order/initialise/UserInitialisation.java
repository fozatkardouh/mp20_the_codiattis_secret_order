package at.refugeescode.mp20_the_codiattis_secret_order.initialise;

import at.refugeescode.mp20_the_codiattis_secret_order.persistence.User;
import at.refugeescode.mp20_the_codiattis_secret_order.persistence.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;
import java.util.Optional;

@Configuration
public class UserInitialisation {

    @Bean
    ApplicationRunner initialiseUsers(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        return args -> {
            String username = "fozat";
            Optional<User> oUser = userRepository.findOneByUsername(username);
            if (oUser.isPresent()) {
                return;
            }
            User user = new User();
            user.setUsername(username);
            user.setPassword(passwordEncoder.encode("12345"));
            user.setAuthorities(Collections.singleton("ROLE_COOLGUY"));

            userRepository.save(user);
        };
    }


}
