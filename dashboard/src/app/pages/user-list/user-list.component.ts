import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import {MatSort} from '@angular/material/sort';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { User } from 'src/app/components/model/user';
import { UsersService } from 'src/app/service/users/users.service';
import { EditFormComponent } from '../edit-form/edit-form.component';
import { AddFormComponent } from '../add-form/add-form.component';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  

  displayedColumns: string[] = ['id','username', 'name', 'email', 'phone', 'action'];
  dataSource: MatTableDataSource<any>;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

 
  users: User[];
  constructor(private _dialog: MatDialog, private service: UsersService,private router: Router) { }

  ngOnInit(): void {
    this.getAllUser();
  }

  openDialog(){
  this._dialog.open(AddFormComponent,{
  width: '35%',
  height: '60%',
  
})

}
editUser(){
  this._dialog.open(EditFormComponent,{
  width: '35%',
  height: '60%',
  
})

}
 

  userFilter(event: Event){
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  getAllUser(){
    console.log("funfou");
    this.service.userList().subscribe({
      next:(result) =>{
    this.dataSource = new MatTableDataSource(result);
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
      },error:(err) =>{
        alert("Error nao funfou");
      }
    })
  }

}
