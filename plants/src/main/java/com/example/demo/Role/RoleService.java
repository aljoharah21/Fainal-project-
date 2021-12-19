package com.example.demo.Role;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class RoleService {

    private final RoleService roleService;

@Autowired
    public RoleService(RoleService roleService) {
        this.roleService = roleService;
    }


    @PostMapping
    public Role saveRole(@RequestBody Role role){
        return roleService.saveRole(role);
    }
}
