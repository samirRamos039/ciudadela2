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
@Document(collection = "activities")
public class ActivityCollection {
    @Id
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
