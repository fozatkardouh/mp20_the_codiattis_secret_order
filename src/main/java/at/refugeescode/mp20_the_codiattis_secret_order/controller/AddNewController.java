package at.refugeescode.mp20_the_codiattis_secret_order.controller;

import at.refugeescode.mp20_the_codiattis_secret_order.persistence.User;
import at.refugeescode.mp20_the_codiattis_secret_order.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Role;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;
import java.util.Collections;

@Controller
@RequestMapping("/addMember")
@RequiredArgsConstructor
public class AddNewController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @ModelAttribute("newUser")
    User newUser() {
        return new User();
    }

    @RolesAllowed("ROLE_COOLGUY")
    @GetMapping
    String addMember() {
        return "newMember";
    }

    @RolesAllowed("ROLE_COOLGUY")
    @PostMapping
    String post(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setAuthorities(Collections.singleton("ROLE_COOLGUY"));
        userRepository.save(user);
        return "redirect:/";
    }

}
