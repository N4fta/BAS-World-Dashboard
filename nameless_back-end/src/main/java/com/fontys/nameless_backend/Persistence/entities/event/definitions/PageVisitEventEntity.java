package com.fontys.nameless_backend.Persistence.entities.event.definitions;

import com.fontys.nameless_backend.Persistence.entities.event.definitions.data.PageVisitDataEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageVisitEventEntity {
    private String eventName;
    private PageVisitDataEntity data;
    private Map<String, Object> additionalData;
}
