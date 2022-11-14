package com.guillerdev97.userservice;

import com.guillerdev97.userservice.domain.AppRole;
import com.guillerdev97.userservice.domain.AppUser;
import com.guillerdev97.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.management.relation.Role;
import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserserviceApplication.class, args);
    }

	@Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
			userService.saveRole(new AppRole(null, "ROLE_USER"));
			userService.saveRole(new AppRole(null, "ROLE_MANAGER"));
			userService.saveRole(new AppRole(null, "ROLE_ADMIN"));
			userService.saveRole(new AppRole(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new AppUser(null, "John Spencer", "John", "password", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Peter Sparrow", "Peter", "password", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Louis Vert", "Louis", "password", new ArrayList<>()));

			userService.addAppRoleToAppUser("john", "ROLE_USER");
			userService.addAppRoleToAppUser("john", "ROLE_ADMIN");
			userService.addAppRoleToAppUser("Peter", "ROLE_USER");
			userService.addAppRoleToAppUser("Peter", "ROLE_ADMIN");
			userService.addAppRoleToAppUser("Louis", "ROLE_MANAGER");
        };
    }
}
