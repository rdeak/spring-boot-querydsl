package hr.com.deak.querydsldemo.entity;

import hr.com.deak.querydsldemo.entity.embeddable.LimitIdEmbeddable;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "limits")
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
public class LimitEntity implements Serializable {
    @EmbeddedId
    private LimitIdEmbeddable id;
    private BigDecimal amount;
    private Integer totalOrders;
    @CreatedDate
    private LocalDateTime created;
    @LastModifiedDate
    private LocalDateTime modified;
}
