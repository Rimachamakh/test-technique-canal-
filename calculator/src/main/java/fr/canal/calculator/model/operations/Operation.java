package fr.canal.calculator.model.operations;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public abstract class Operation implements OperationInterface{
    private BigDecimal operand1;
    private BigDecimal operand2;
}
