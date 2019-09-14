package com.example.booking.entrypoint;

import com.example.booking.entities.User;
import com.example.booking.usecases.UserListingUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserEndPoint {

    private UserListingUseCase userListingUseCase;

    public UserEndPoint(UserListingUseCase userListingUseCase) {
        this.userListingUseCase = userListingUseCase;
    }

    @GetMapping
    public List<User> list() {
        return this.userListingUseCase.list();
    }
}
