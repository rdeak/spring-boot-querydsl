package hr.com.deak.querydsldemo.entity.embeddable;

import hr.com.deak.querydsldemo.dto.ApplicationType;
import hr.com.deak.querydsldemo.dto.LimitType;
import lombok.Value;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
@Value
public class LimitIdEmbeddable implements Serializable {
    private String clientReferenceId;
    private LocalDate transactionDate;
    private ApplicationType applicationType;
    private LimitType limitType;
}
