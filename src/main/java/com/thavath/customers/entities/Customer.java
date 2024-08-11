package com.thavath.customers.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cm_customers")
public class Customer implements Persistable<String> {
    @Id
    @Column("id")
    private String id;
    @Column("name")
    private String name;
    @Column("gender")
    private String gender;
    @Column("phone")
    private String phone;
    @Column("email")
    private String email;
    @Transient
    @Builder.Default
    private boolean isNewEntry = true;
    public boolean isNew() {
        return isNewEntry;
    }
}
