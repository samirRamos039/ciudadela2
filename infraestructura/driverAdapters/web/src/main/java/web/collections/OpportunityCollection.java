package web.collections;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Document(collection = "opportunities")
public class OpportunityCollection {
    @Id
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
