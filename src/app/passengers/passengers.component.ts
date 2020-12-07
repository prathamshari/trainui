import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DataService } from '../data.service';

@Component({
  selector: 'app-passengers',
  templateUrl: './passengers.component.html',
  styleUrls: ['./passengers.component.css']
})
export class PassengersComponent implements OnInit {
Seats:any;
  passenger={
    "passenger_Name":"",
    "age":"",
    "seatNo":"",
    "gender":"",
    "status":"CONFIRM"
  }

  u:any;
  id:number;

  constructor(private route:ActivatedRoute,
    private router:Router,
    private service:DataService) { }

    ngOnInit() {
      
      let observableResult=  this.service.SelectSeats();
      observableResult.subscribe(
        (result)=>{
      console.log(result);
      this.Seats = result;
    })
    }
  
  Insert()
  {
    this.u=JSON.parse(sessionStorage.getItem("user"));
    console.log("user is : "+this.u);
    this.id=this.u.userId;
    console.log("user id is : "+this.id)
    let status=this.service.InsertPassenger(this.passenger,this.id);
    status.subscribe((result)=>{
      console.log(result);
    });

    this.passenger.passenger_Name="";
    this.passenger.age="";
    alert("One passenger added");
    this.ngOnInit();
    this.router.navigate(['passengers']);

  }

}
