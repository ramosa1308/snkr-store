package com.snkrstore.trades.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.sql.Timestamp;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "ask", schema = "sneaker_store")
public class Ask {
    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    private String productId;
    @NotEmpty
    @Email
    private String userId;
    @Positive
    private Float size;
    @Positive
    private Float askPrice;
    @Column(name="expiration")
    private LocalDate expiration;
    private String status;
    private String product_condition;
    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdDate;
    @UpdateTimestamp
    private Timestamp lastModifiedDate;
}
