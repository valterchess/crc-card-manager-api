package com.crcmanager.crcmanager.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "colaboracao")
public class Colaboracao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "colaboracao")
    private String Colaboracao;

    @ManyToOne
    @JoinColumn(name = "card_id")
    @JsonIgnoreProperties("colaboracoes")
    private Card card;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Colaboracao that = (Colaboracao) o;
        return id != null && Objects.equals(this.id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}