import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DataService } from '../data.service';

@Component({
  selector: 'app-user-edit',
  templateUrl: './user-edit.component.html',
  styleUrls: ['./user-edit.component.css']
})
export class UserEditComponent implements OnInit {

user:any;

  constructor(private route:ActivatedRoute,
    private router:Router,
    private service:DataService) {

   }

  ngOnInit() {
     this.route.paramMap.subscribe((result)=>{
      // debugger;
       let userId=result.get("userId");
     let observableResult=this.service.SelectByNo(userId);
      observableResult.subscribe((result)=>{
        //debugger;
        console.log(result);
        this.user=result;
        console.log(this.user);
      });
      });

}
OnUpdateCallMe(entireFormContent)
  {
    console.log("--------------------------------------");
    console.log(this.user);
    console.log("--------------------------------------");
    console.log(entireFormContent);
    
    let observableResultOfUpdate = 
       this.service.Update(this.user);

    observableResultOfUpdate.subscribe((resultOfUpdate)=>{

      console.log(resultOfUpdate);
      //Check if no error

      this.router.navigate(['/user-list']);
    });
  }
CancelUpdate()
{
  this.router.navigate(['/user-list']);
}
}
