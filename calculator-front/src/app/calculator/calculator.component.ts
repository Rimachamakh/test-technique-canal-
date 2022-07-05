import { Component, OnInit } from '@angular/core';
import { CalculatorService } from '../service/calculator.service';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {

  operation: string
  firstValue: any
  displayedValue: string = '0'
  operator1: string
  operator2: string
  errorMessage: string;

  constructor( private calculatorService : CalculatorService) { 
    this.firstValue = true;
  }

  ngOnInit() {
  }

  click(numberInput: string){
    console.log("displayed value "+ this.displayedValue)
    console.log("numberInput"+ numberInput)
    this.displayedValue = this.displayedValue.concat(numberInput);
    console.log("displayed value afterconcat "+ this.displayedValue)

    if(this.operation == undefined){
      if(this.firstValue){
        this.operator1 = numberInput.toString()
        this.displayedValue = numberInput.toString()
        this.firstValue = false
      }else{        
        this.operator1 = numberInput
      }
    }else{
      console.log("operator 2")
      this.operator2 = numberInput
    }
  }

  defineOperation(operation: string, symbol: string){
    console.log("operation : "+ operation)
    console.log("displayed value" + this.displayedValue)
    console.log("symbole : " + symbol)
    this.operation = operation
    this.displayedValue = this.displayedValue.concat(symbol)
  }

  delete(){
    this.operator1 = '0';
    this.operator2 = '';
    this.firstValue = true;
    this.operation = undefined;
    this.errorMessage = '';
    this.displayedValue = '0';
  }

  calculate(){
    this.calculatorService.calculate(Number.parseFloat(this.operator1), Number.parseFloat(this.operator2), this.operation).subscribe(
      res =>{
        if(!res.error){
          this.displayedValue = res.result.toString();
          this.operator1 = res.result.toString();
          this.operator2 = '';
          this.operation = undefined;
        }else{
          this.errorMessage = res.message;
        }
      },
      error => {
        console.log(error);
      });
  }

}
