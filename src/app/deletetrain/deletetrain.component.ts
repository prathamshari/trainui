import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DataService } from '../data.service';

@Component({
  selector: 'app-deletetrain',
  templateUrl: './deletetrain.component.html',
  styleUrls: ['./deletetrain.component.css']
})
export class DeletetrainComponent implements OnInit {

  constructor(private route:ActivatedRoute,
    private router:Router,
    private service:DataService) { }

  ngOnInit() {
    this.route.paramMap.subscribe((result)=>{
      let No=result.get("trainId");
      console.log(No);
      let observableResult=this.service.DeleteTrain(No);
      observableResult.subscribe((result)=>{
        console.log(result);
        this.router.navigate(['update-train']);
      
      });
    });
  }

}
