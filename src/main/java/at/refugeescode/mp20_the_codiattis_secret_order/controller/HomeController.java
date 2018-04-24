package at.refugeescode.mp20_the_codiattis_secret_order.controller;

import at.refugeescode.mp20_the_codiattis_secret_order.persistence.User;
import at.refugeescode.mp20_the_codiattis_secret_order.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {

    private final UserRepository userRepository;

    @RolesAllowed("COOLGUY")
    @GetMapping
    String home() {
        return "home";
    }

    @ModelAttribute("members")
    List<User> users() {
        return userRepository.findAll();
    }

}
