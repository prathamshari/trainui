import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DataService } from '../data.service';

@Component({
  selector: 'app-passengeredit',
  templateUrl: './passengeredit.component.html',
  styleUrls: ['./passengeredit.component.css']
})
export class PassengereditComponent implements OnInit {

  Passenger:any;

  constructor(private route:ActivatedRoute,
    private router:Router,
    private service:DataService) { }

    ngOnInit() {
      this.route.paramMap.subscribe((result)=>{
       // debugger;
        let id=result.get("passengerId");
      let observableResult=this.service.SelectPassengerById(id);
       observableResult.subscribe((result)=>{
         //debugger;
         console.log(result);
         this.Passenger=result;
         console.log(this.Passenger);
       });
       });
    }

    OnUpdateCallMe(entireFormContent)
    {
      console.log("--------------------------------------");
      console.log(this.Passenger);
      console.log("--------------------------------------");
      console.log(entireFormContent);
      
      let observableResultOfUpdate = 
         this.service.UpdatePassenger(this.Passenger);
  
      observableResultOfUpdate.subscribe((resultOfUpdate)=>{
  
        console.log(resultOfUpdate);
          this.router.navigate(['/passengerlist']);
      });
    }
    CancelUpdate()
    {
      this.router.navigate(['/passengerlist']);
    }

}
