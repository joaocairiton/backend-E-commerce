import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { User } from 'src/app/components/model/user';
import { UsersService } from 'src/app/service/users/users.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-form',
  templateUrl: './add-form.component.html',
  styleUrls: ['./add-form.component.css']
})
export class AddFormComponent implements OnInit {
  hide = true;
  empForm !: FormGroup;
  
  user: User = new User();
  constructor(private formBuilder : FormBuilder, private service: UsersService, private snack: MatSnackBar) { }

  ngOnInit(): void {
    this.empForm = this.formBuilder.group({
          username: ['', Validators.required],
          password: ['', Validators.required],
          name: ['', Validators.required],
          email: ['', Validators.required],
          telefone: ['', Validators.required],

        });
  }
  addClient(){
    this.service.registerUser(this.user).subscribe((data) => {
      console.log(data);
        Swal.fire('saved user','User successfully registered in the system','success');
    },(error) =>{
      console.log(error);
      this.snack.open('A system error has occurred !!','Accept',{
        duration : 3000
      });
    }
  )
}

}