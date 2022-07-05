import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpHeaders,HttpClient } from '@angular/common/http';
import { OperationResult } from '../model/operation-result.model';
import { Observable } from 'rxjs';


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  })
};

@Injectable({
  providedIn: 'root'
})

export class ApiService {

  baseUrl = environment.baseUrl;

  constructor(private http: HttpClient) { }

  post(path: String, body: Object = {}): Observable<OperationResult> {
    return this.http.post<OperationResult>(`${this.baseUrl}${path}`, JSON.stringify(body), httpOptions);
  }

  get(path: String, value: string): Observable<OperationResult> {
    console.log("executing get method : " + path + " val : " + value);
    return this.http.get<OperationResult>(`${this.baseUrl}${path}/${value}`, httpOptions);
  }}
