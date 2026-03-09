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
public class Activity {
    private String id;
    private String tenantId;
    private String userId;
    private String type;
    private String relatedToType;
    private String relatedToId;
    private String description;
    private LocalDateTime dueDate;
    private Boolean isCompleted;
    private LocalDateTime createdAt;
}
