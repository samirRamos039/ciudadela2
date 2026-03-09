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
public class Tenant {
    private String id;
    private String name;
    private String subscriptionPlan;
    private String status;
    private String domain;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
