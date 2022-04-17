package com.crcmanager.crcmanager.domain.dtos;

import com.crcmanager.crcmanager.domain.actors.Actor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
public record CardDto(@NotBlank String className, @NotBlank String descricao) implements Serializable, Actor.Command {
}
