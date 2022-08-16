package br.com.prismo.account.domain;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity(name = "operations_type")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class OperationsType {

    @Id
    private Long operationTypeId;
    @Column(length = 50)
    private String description;

}
