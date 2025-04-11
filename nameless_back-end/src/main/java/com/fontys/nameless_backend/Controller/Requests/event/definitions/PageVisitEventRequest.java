package com.fontys.nameless_backend.Controller.Requests.event.definitions;

import com.fontys.nameless_backend.Controller.Requests.event.definitions.Data.PageVisitDataRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class PageVisitEventRequest {
    @NotBlank
    private String eventName;
    @NotNull
    private PageVisitDataRequest data;
    @NotEmpty
    private Map<String, Object> additionalData;
}


