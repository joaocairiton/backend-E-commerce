import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/service/login/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginData = {
    username: '',
    password: ''
  }
  constructor(private router: Router, private snack:MatSnackBar, private service: LoginService) { }

  ngOnInit(): void {
  }
  formSubmit(){
    if(this.loginData.username.trim() == '' || this.loginData.username.trim() == null){
      this.snack.open('Enter the email please !!','ok',{
        duration:3000
      })
      return;
    }
    if(this.loginData.password.trim() == '' || this.loginData.password.trim() == null){
      this.snack.open('Enter the password please!!','ok',{
        duration:3000
      })
      return;
    }
    this.service.generateToken(this.loginData).subscribe((data:any) => {
      console.log(data);
      this.service.loginUser(data.token);
      this.service.getCurrentUser().subscribe((user:any) => {
      this.service.setUser(user);
      console.log(user);
      if(this.service.getUserRole() == 'ADMIN'){
        //dashboard admin
        //window.location.href = '/admin';
        this.router.navigate(['admin']);
        this.service.loginStatusSubjec.next(true);
      }else if(this.service.getUserRole() == 'NORMAL'){
        //user dashboard
        //window.location.href = '/user-dashboard';
        this.router.navigate(['user-dashboard']);
        this.service.loginStatusSubjec.next(true);
      }else{
        this.service.logout();
      }

      })
    },(error) => {
      console.log(error);
      this.snack.open('Invalid details , please try again !! !!','OK',{
        duration:3000
    })
  }
  )
}
}
