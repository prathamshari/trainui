import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DataService } from '../data.service';

@Component({
  selector: 'app-passengerdelete',
  templateUrl: './passengerdelete.component.html',
  styleUrls: ['./passengerdelete.component.css']
})
export class PassengerdeleteComponent implements OnInit {

  passenger:any;

  constructor(private route:ActivatedRoute,
    private router:Router,
    private service:DataService) { }
 
  ngOnInit() {
    console.log("in ts of delete passenger")
    this.route.paramMap.subscribe((result)=>{
      let No=result.get("passengerId");
      console.log(No);
      let observableResult=this.service.DeletePassenger(No);
      observableResult.subscribe((result)=>{
        console.log(result);
        this.router.navigate(['passengerlist']);
      
      });
    });
  }

  

}
