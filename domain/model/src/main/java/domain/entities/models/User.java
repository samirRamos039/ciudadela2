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
public class User {
    private String id;
    private String tenantId;
    private String email;
    private String passwordHash;
    private String fullName;
    private String role;
    private String status;
    private LocalDateTime createdAt;
}
