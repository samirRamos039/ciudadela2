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
@Document(collection = "users")
public class UserCollection {
    @Id
    private String id;
    private String tenantId;
    private String email;
    private String passwordHash;
    private String fullName;
    private String role;
    private String status;
    private LocalDateTime createdAt;
}
