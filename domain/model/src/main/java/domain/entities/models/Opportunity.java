package domain.entities.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Opportunity {
    private String id;
    private String tenantId;
    private String contactId;
    private String assignedUserId;
    private String title;
    private Double value;
    private String currency;
    private String pipelineStage;
    private LocalDateTime expectedCloseDate;
    private String notes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
