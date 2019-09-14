package com.example.booking.entrypoint;

import com.example.booking.entities.Resource;
import com.example.booking.usecases.ResourceListingUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/resource")
public class ResourceEndPoint {
    private ResourceListingUseCase resourceListingUseCase;

    public ResourceEndPoint(ResourceListingUseCase resourceListingUseCase) {
        this.resourceListingUseCase = resourceListingUseCase;
    }

    @GetMapping
    public  List<Resource> list() {
        return this.resourceListingUseCase.list();
    }

}
