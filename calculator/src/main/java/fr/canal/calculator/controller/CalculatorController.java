package fr.canal.calculator.controller;

import fr.canal.calculator.model.OperationResult;
import fr.canal.calculator.service.operations.*;
import fr.canal.calculator.util.Constants;
import org.apache.logging.log4j.LogManager;
import org.springframework.web.bind.annotation.*;

import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping(Constants.CALCULATOR_PATH)
@CrossOrigin()
public class CalculatorController {
        private static final Logger logger = LogManager.getLogger(fr.canal.calculator.controller.CalculatorController.class);

        @PostMapping("/add")
        public OperationResult add(@RequestBody AddOperation operation) {

            logger.info("Starting add operation!");

            OperationResult result = new OperationResult();

            if(operation != null) {
                logger.info("Input data:" + operation.toString());
                result = this.calculate(operation);
            }else {
                logger.error("Operation is null");
                result.setError(Boolean.TRUE);
                result.setMessage("Operation is not initialized");
            }

            return result;
        }

        @PostMapping("/subtract")
        public OperationResult subtract(@RequestBody SubtractOperation operation) {

            logger.info("Starting subtract operation!");

            OperationResult result = new OperationResult();

            if(operation != null) {
                logger.info("Input data:" + operation.toString());
                result = this.calculate(operation);
            }else {
                logger.error("Operation is null");
                result.setError(Boolean.TRUE);
                result.setMessage("Operation is not initialized");
            }

            return result;
        }

        @PostMapping("/multiply")
        public OperationResult multiply(@RequestBody MultiplyOperation operation) {

            logger.info("Starting subtract operation!");

            OperationResult result = new OperationResult();

            if(operation != null) {
                logger.info("Input data:" + operation.toString());
                result = this.calculate(operation);
            }else {
                logger.error("Operation is null");
                result.setError(Boolean.TRUE);
                result.setMessage("Operation is not initialized");
            }

            return result;
        }

        @PostMapping("/divide")
        public OperationResult divide(@RequestBody DivideOperation operation) {

            logger.info("Starting subtract operation!");

            OperationResult result = new OperationResult();

            if(operation != null) {
                logger.info("Input data:" + operation.toString());
                result = this.calculate(operation);
            }else {
                logger.error("Operation is null");
                result.setError(Boolean.TRUE);
                result.setMessage("Operation is not initialized");
            }

            return result;
        }

        private OperationResult calculate(OperationInterface operation){

            OperationResult result = null;
            try {
                logger.info("Executing the operation..");
                result = operation.calculate();
            }catch(Exception ex) {
                logger.error("Error executing the operation: ", ex);
                result.setError(Boolean.TRUE);
                result.setMessage("Ops! something went wrong while executing the operation!");
            }
            logger.info("Final operation result : " + result.toString());

            return result;
        }
}
