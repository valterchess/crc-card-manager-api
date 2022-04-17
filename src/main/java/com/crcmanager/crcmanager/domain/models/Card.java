package com.crcmanager.crcmanager.domain.models;

import com.crcmanager.crcmanager.domain.actors.Actor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "class_name")
    private String className;
    private String descricao;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("card")
    @ToString.Exclude
    private List<Responsabilidade> responsabilidades;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("card")
    @ToString.Exclude
    private List<Colaboracao> colaboracoes = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Card that = (Card) o;
        return id != null && Objects.equals(this.id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
