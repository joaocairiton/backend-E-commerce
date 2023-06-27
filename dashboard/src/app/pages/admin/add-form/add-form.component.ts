import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';

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
  empForm : FormGroup;
 
  
  user: User = new User();
  constructor(private formBuilder : FormBuilder,
    private _dialogRef: MatDialogRef<AddFormComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
     private service: UsersService, 
     
     
     ) { 
      this.empForm = this.formBuilder.group({
        username: ['', Validators.required],
        password: ['', Validators.required],
        name: ['', Validators.required],
        email: ['', Validators.required],
        telefone: ['', Validators.required],

      });

     }

  ngOnInit(): void {
    this.empForm.patchValue(this.data);
  }


  onFormSubmit() {
    if (this.empForm.valid) {


      if (this.data) {
        this.service
          .updateUser(this.data.id, this.empForm.value)
          .subscribe({
            next: (val: any) => {
              Swal.fire('saved user','User successfully registered in the system','success');
              this._dialogRef.close(true);
            },
            error: (err: any) => {
              console.error(err);
            },
          });
      } else {
        this.service.registerUser(this.empForm.value).subscribe({
          next: (val: any) => {
            Swal.fire('saved user','User successfully registered in the system','success');
            this._dialogRef.close(true);
          },
          error: (err: any) => {
            console.error(err);
          },
        });
      }
    }
  }
}
