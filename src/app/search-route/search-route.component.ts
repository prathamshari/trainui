import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DataService } from '../data.service';

@Component({
  selector: 'app-search-route',
  templateUrl: './search-route.component.html',
  styleUrls: ['./search-route.component.css']
})
export class SearchRouteComponent implements OnInit {

  train:any;
  constructor(private route:ActivatedRoute,
    private router:Router,
    private service:DataService) { }

  ngOnInit() {
    this.route.paramMap.subscribe((result)=>{
      let source=result.get("source");
      let destination=result.get("destination");
      console.log("source : "+source+" destination : "+destination);
      
      let observableResult=this.service.SearchTrains(source,destination);
     observableResult.subscribe((result)=>{
       this.train=result;
       console.log("train stored in session is : "+this.train);
      sessionStorage.setItem("selectedTrain",JSON.stringify(this.train));
     console.log(result);
     this.train = result;
     });
    });
  }

}
