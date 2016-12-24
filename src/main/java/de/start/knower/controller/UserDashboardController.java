package de.start.knower.controller;

import de.start.knower.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users-dashboard/{userId}")
public class UserDashboardController {
    
    private final UserRepository userRepository;

    public UserDashboardController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    
    @GetMapping
    public String index(final @PathVariable Long userId, final Model model) {
        model.addAttribute("user", userRepository.findOne(userId)); 
        
        
        return "/userdashboard/index";
    }

}
