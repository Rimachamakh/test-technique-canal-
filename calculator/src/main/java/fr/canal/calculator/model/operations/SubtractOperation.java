package fr.canal.calculator.model.operations;

import fr.canal.calculator.util.Constants;
import lombok.ToString;

@ToString
public class SubtractOperation extends Operation{
    @Override
    public OperationResult calculate() throws Exception {
        OperationResult result = new OperationResult();

        if(this.getOperand1() != null && this.getOperand2()!= null) {
            result.setResult(this.getOperand1().subtract(this.getOperand2()));
            result.setError(Boolean.FALSE);
        }else {
            result.setError(Boolean.TRUE);
            result.setMessage(Constants.ERROR_MESSAGE_OPERAND_NOT_VALID);
        }
        return result;

    }

}
