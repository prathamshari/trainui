import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DataService } from '../data.service';

@Component({
  selector: 'app-update-train',
  templateUrl: './update-train.component.html',
  styleUrls: ['./update-train.component.css']
})
export class UpdateTrainComponent implements OnInit {
   Train:any;
  constructor(private route:ActivatedRoute,
    private router:Router,
    private service:DataService) { }

  ngOnInit() {
    let observableResult=  this.service.SelectAllTrains();
    observableResult.subscribe(
      (result)=>{
    console.log(result);
    this.Train = result;
  })
  }

}
