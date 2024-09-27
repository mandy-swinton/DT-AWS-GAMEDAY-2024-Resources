import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CarsService {

  constructor(private http: HttpClient) { }

  callLambda1(){
	console.log("made it to call lambda1");
	return this.http.get<String>('./lambda1');
}

}