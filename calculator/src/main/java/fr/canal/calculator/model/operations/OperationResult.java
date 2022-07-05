package fr.canal.calculator.model.operations;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OperationResult {
    private String message = "";
    private Boolean error = Boolean.FALSE;
    private BigDecimal result = null;
}
