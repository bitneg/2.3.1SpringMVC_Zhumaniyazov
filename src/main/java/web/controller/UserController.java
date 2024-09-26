package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {
    private final UserService userService;
    String s = "redirect:/users";

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "userlist"; // Имя представления
    }

    @PostMapping("/users/add")
    public String addUser(@ModelAttribute User user) {
           userService.save(user);
        return s;
    }

    @PostMapping("/users/delete")
    public String deleteUser(@RequestParam int id) {
        userService.delete(id);
        return s;
    }

    @PostMapping("/users/update")
    public String updateUser(@RequestParam int id, @RequestParam String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        userService.update(user);
        return s;
    }
}