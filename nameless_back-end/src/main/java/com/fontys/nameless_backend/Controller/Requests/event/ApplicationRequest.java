package com.fontys.nameless_backend.Controller.Requests.event;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApplicationRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String version;
    @NotBlank
    private String environment;
}
