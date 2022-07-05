import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { OperationResult } from '../model/operation-result.model';
import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root'
})
export class CalculatorService {

  constructor(private apiService: ApiService) { }

  calculate(operand1: number, operand2: number, operation: string): Observable<OperationResult> {
     return this.apiService.post(operation, { "operand1": operand1, "operand2": operand2 });
  }}
