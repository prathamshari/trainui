import { Component, OnInit } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import {DataService } from '../data.service'
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-search-train',
  templateUrl: './search-train.component.html',
  styleUrls: ['./search-train.component.css']
})
export class SearchTrainComponent implements OnInit {

  train={
    "source":"",
    "destination":"",
    "date":""
  };
  constructor(private service:AuthService) { }

  ngOnInit() {
    
  }

  searchTrain(myform)
  {
    let trainCredentials = myform.form.value;
    console.log("in ts of train ")
    console.log(trainCredentials);
     this.service.storeTrain(trainCredentials);
  }

}
 