import { Component, OnInit } from '@angular/core';
import { CarsService } from './cars.service';

@Component({
  selector: 'app-cars',
  templateUrl: 'cars.component.html',
  styles: [
  ]
})
export class CarsComponent implements OnInit {


  constructor(private carService: CarsService) {

  }

  private isLoopOn = false;
  private intervalId: number = 0;
  

  ngOnInit(): void {
  }

  

  public saveCar(){
	if (this.isLoopOn && this.intervalId) {
		clearInterval(this.intervalId);
		this.isLoopOn = false;
    console.log("LOOP ON", this.isLoopOn);
	} else {
		this.isLoopOn = true;
    console.log("LOOP ON", this.isLoopOn);
		this.callInLoop(10);
	}
		
  }

  private callInLoop(seconds: number){
	  this.intervalId = window.setInterval(() => {
      console.log("In Loop");
		  this.callLambdas();
    }, seconds * 1000);
}

  private async callLambdas(){
	console.log("call Lambdas");
	return this.carService.callLambda1().subscribe(data => console.log(data));
	}

}
