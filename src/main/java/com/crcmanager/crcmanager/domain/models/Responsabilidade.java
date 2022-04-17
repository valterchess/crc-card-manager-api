package com.crcmanager.crcmanager.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Responsabilidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String responsabilidade;
    @ManyToOne
    @JsonIgnoreProperties("responsabilidades")
    private Card card;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Responsabilidade that = (Responsabilidade) o;
        return id != null && Objects.equals(this.id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
