import { Component, OnInit } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import {DataService } from '../data.service'
@Component({
  selector: 'app-add-train',
  templateUrl: './add-train.component.html',
  styleUrls: ['./add-train.component.css']
})
export class AddTrainComponent implements OnInit {
  constructor(private route:ActivatedRoute,
    private router:Router,
    private service:DataService) { }
    train={
      "trainName":"",
      "source":"",
      "destination":"",
      "capacity":"",
      "arrivalTime":"",
      "departureTime":"",
      "reachTime":""
    }
  ngOnInit() {
   
  }
  InsertTrain()
  {
    let status=this.service.InsertTrain(this.train);
    status.subscribe((result)=>{
      console.log(result);
      this.router.navigate(['update-train']);
    });
  }
}





