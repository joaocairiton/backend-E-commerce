import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/components/model/user';
import { UsersService } from 'src/app/service/users/users.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-edit-form',
  templateUrl: './edit-form.component.html',
  styleUrls: ['./edit-form.component.css']
})
export class EditFormComponent implements OnInit {
  hide = true;
  empForm !: FormGroup;

  id:number;
  user: User = new User();
  constructor(private formBuilder : FormBuilder, private service: UsersService, private snack: MatSnackBar, private route:ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    /*this.empForm = this.formBuilder.group({
          username: ['', Validators.required],
          password: ['', Validators.required],
          name: ['', Validators.required],
          email: ['', Validators.required],
          telefone: ['', Validators.required],

        });*/
      this.id = this.route.snapshot.params['id'];
      this.service.getUser(this.id).subscribe(data =>{
      this.user = data;
    },error => console.log(error));
  }
 /* addUser(){
    this.service.update(this.id,this.user).subscribe((data) => {
      console.log(data);
        Swal.fire('saved user','User successfully registered in the system','success');
    },(error) =>{
      console.log(error);
      this.snack.open('A system error has occurred !!','Accept',{
        duration : 3000
      });
    }
  )
}*/
listaDeCliente(){
  this.router.navigate(['/clientes']);


}


onSubmit(){
  this.service.update(this.id,this.user).subscribe(data => {
    this.listaDeCliente();
  },error => console.log(error));
}

}