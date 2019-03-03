package hr.com.deak.querydsldemo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Limit {
    private String clientReferenceId;
    private LocalDate transactionDate;
    private LimitType limitType;
    private ApplicationType applicationType;
    private BigDecimal dailyLimit;
    private BigDecimal monthlyLimit;
}
