import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DataService } from '../data.service';

@Component({
  selector: 'app-passengerlist',
  templateUrl: './passengerlist.component.html',
  styleUrls: ['./passengerlist.component.css']
})
export class PassengerlistComponent implements OnInit {

  Passengers:any;

  u:any;
  

  setBookingId={
    "id":Number
  }
    

  constructor(public http:HttpClient,
    private service:DataService) { }

    ngOnInit() {
      console.log("before getting booking id");
      this.u = JSON.parse(sessionStorage.getItem("user"));
      this.setBookingId.id=this.u.userId;

      console.log("booking id : "+this.setBookingId.id)
      console.log("after getting booking id");


      let observableResult=  this.service.SelectPassengers(this.setBookingId.id);
      observableResult.subscribe(
        (result)=>{
      console.log(result);
      this.Passengers = result;
    })
    }

}
