import { Component } from '@angular/core';
import { AuthService } from './auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'AngularApp';
  constructor(private service:AuthService,
    private router:Router) 
    { }

    Logout()
    {
      this.service.LogOut();
      this.router.navigate(['login']);
    }
}
