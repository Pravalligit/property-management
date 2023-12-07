package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.dto.UserDTO;
import com.mycompany.propertymanagement.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/api/v1/user")
//public class UserController {
//
////    @Operation(summary = "register", description = "This method is used for user registration")
//    @Autowired
//    private UserService userService;
//    @PostMapping("/register")
//    public ResponseEntity<UserDTO> register(@Valid @RequestBody UserDTO userDTO) {
//        userDTO = userService.register(userDTO);
//        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<UserDTO> login(@Valid @RequestBody UserDTO userDTO) {
//        userDTO = userService.login(userDTO.getOwnerEmail(), userDTO.getPassword());
//        return new ResponseEntity<>(userDTO, HttpStatus.OK);
//    }
//}

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Operation(summary = "register", description = "This method is used for user registration")
    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@Parameter(
            example = "user information") @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "User Data",required = true
    ) @Valid @RequestBody UserDTO userDTO){
        userDTO = userService.register(userDTO);
        ResponseEntity<UserDTO> responseEntity = new ResponseEntity<>(userDTO, HttpStatus.CREATED);
        return responseEntity;
    }
    @PostMapping(path = "/login",consumes = "application/json", produces = "application/json")
    public ResponseEntity<UserDTO> login( @Valid @RequestBody UserDTO userDTO){
        userDTO = userService.login(userDTO.getOwnerEmail(),userDTO.getPassword());
        ResponseEntity<UserDTO> responseEntity = new ResponseEntity<>(userDTO, HttpStatus.OK);
        return responseEntity;
    }
}
