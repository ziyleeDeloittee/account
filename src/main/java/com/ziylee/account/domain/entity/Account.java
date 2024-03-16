package com.ziylee.account.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Account extends BaseEntity{

    private Long customerId;

    @Id
    private Long accountNumber;
    private String accountType;
    private String branchAddress;
}
