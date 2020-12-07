import { Component, OnInit } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import {DataService } from '../data.service'

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {
 
  emp:any;
  constructor(private route:ActivatedRoute,
    private router:Router,
    private service:DataService) { }

  ngOnInit() {
    this.route.paramMap.subscribe((result)=>{
      let No=result.get("userId");
      console.log(No);
      let observableResult=this.service.DeleteAdmin(No);
      observableResult.subscribe((result)=>{
        console.log(result);
        this.router.navigate(['user-list']);
      
      });
    });
  }

}
