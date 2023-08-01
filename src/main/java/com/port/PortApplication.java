package com.port;

import com.port.persistance.dao.GroupDao;
import com.port.persistance.dao.UserDao;
import com.port.persistance.entities.Group;
import com.port.persistance.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PortApplication implements CommandLineRunner {
    @Autowired
    private UserDao userDao;
    @Autowired
    private GroupDao groupDao;

    @Bean
    public BCryptPasswordEncoder getBCPE() {
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        SpringApplication.run(PortApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
       Group users = new Group(1L, "USER");
        Group admins = new Group(2L, "ADMIN");
        groupDao.saveAndFlush(users);
        groupDao.saveAndFlush(admins);
        User admin = new User(1L, "admin", "admin", "admin", "admin", "admin", "admin", true, null,
        null,"admin", getBCPE().encode("admin"));
        List<Group> admingroups = new ArrayList<>();
        admingroups.add(admins);
        admingroups.add(users);
        admin.setGroups(admingroups);
        userDao.saveAndFlush(admin);

    }
}
