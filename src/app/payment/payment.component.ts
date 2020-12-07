import { Component, OnInit } from '@angular/core';
import { Router,ActivatedRoute } from '@angular/router';
import { DataService } from '../data.service';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  price:number;
  flag:number=0;
  questions:any;
  student:any;
  questionNo:any;
  options:any[];
  public init2:number =20;
  public counter:number = 0;
  public seconds:number = 0;
  id:any;
  u:any;
   t={
    "arrivalTime": "",
    "capacity": "",
    "departureTime": "",
    "destination": "",
    "price": "",
    "reachTime": "",
    "source": "",
    "trainName": "",
    "train_Id": ""
   }

   countOfPassengers:any;

   totalFair:number;

  constructor(private router:Router,
    private Service:DataService,
    private route:ActivatedRoute) { }

  ngOnInit() {

    console.log("selected train is");
    this.t = JSON.parse(sessionStorage.getItem("selectedTrain"));
    this.u=JSON.parse(sessionStorage.getItem("user"));
    this.id=this.u.userId;

    console.log(this.t);
    this.price = this.t[0].price;
    console.log("price is : "+this.price);

    let count=this.Service.GetCount(this.id)
    count.subscribe((result)=>{
      console.log("total number of passenger count : "+result)
      this.countOfPassengers=result;
    })

    this.startCoundown();
  }


  pay()
  {
    alert("payment successfully received");
    this.flag=1;
    this.Service.makePayment(this.price*this.countOfPassengers,this.u.userId);
    this.router.navigate(['home']);
  }
  startCoundown()
  {
    if(this.init2 && this.init2 >0)
    {
      //this.counter = this.init;
      this.seconds = this.init2;
      console.log(this.displayTimeElapsed());
      this.doCountdown();
    }
  }
  doCountdown(){
    setTimeout(()=>{
       // this.counter = this.counter-1;
        this.seconds = this.seconds-1;
        this.processCountDown();
    },1000);
  }
  processCountDown()
  {
    //console.log(this.counter)
    if( this.seconds == 0)
    {
      if(this.flag == 0)
      {
        alert("Payment session timeout!!");
        this.Service.deleteAllConfirmSeats(this.id);
        this.router.navigate(["/search-train"]);
      }
    
    }
    else
    {
       
      this.displayTimeElapsed();
      this.doCountdown();
    }
  }

  displayTimeElapsed() {
    return Math.floor(this.seconds / 3600) + ':' + Math.floor(this.seconds / 60) + ':' + Math.floor(this.seconds % 60);
  }
}
