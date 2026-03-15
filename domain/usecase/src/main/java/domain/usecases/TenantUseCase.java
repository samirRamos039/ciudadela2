package domain.usecases;

import domain.entities.models.Tenant;
import domain.ports.TenantGateway;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TenantUseCase {

    private final TenantGateway tenantGateway;

    public TenantUseCase(TenantGateway tenantGateway) {
        this.tenantGateway = tenantGateway;
    }

    public Mono<Tenant> save(Tenant tenant) {
        return tenantGateway.save(tenant);
    }

    public Mono<Tenant> findById(String id) {
        return tenantGateway.findById(id);
    }

    public Flux<Tenant> findAll() {
        return tenantGateway.findAll();
    }

    public Mono<Void> deleteById(String id) {
        return tenantGateway.deleteById(id);
    }
}
