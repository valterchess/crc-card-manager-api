package com.crcmanager.crcmanager.domain.dtos;

import com.crcmanager.crcmanager.domain.models.Card;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
public record ColaboracaoDto(@NotBlank String Colaboracao,
                             @NotNull Card card) implements Serializable {
}
