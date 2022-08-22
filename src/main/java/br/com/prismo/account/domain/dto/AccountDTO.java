package br.com.prismo.account.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountDTO {

    @NotBlank
    private String documentNumber;
    @Min(0)
    private BigDecimal availableCreditLimit = new BigDecimal("5000");

}
