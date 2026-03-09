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
@Document(collection = "tenants")
public class TenantCollection {
    @Id
    private String id;
    private String name;
    private String subscriptionPlan;
    private String status;
    private String domain;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
