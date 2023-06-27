import {
  Component,
  EventEmitter,
  Input,
  OnInit,
  Output,
  ViewChild,
} from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { MatSort } from '@angular/material/sort';
import { Router } from '@angular/router';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { User } from 'src/app/components/model/user';
import { UsersService } from 'src/app/service/users/users.service';

import { AddFormComponent } from '../add-form/add-form.component';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css'],
})
export class UserListComponent implements OnInit {
  displayedColumns: string[] = [
    'id',
    'username',
    'name',
    'email',
    'phone',
    'action',
  ];
  dataSource: MatTableDataSource<any>;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  id: any;
  users: User[] = [];
  constructor(
    private _dialog: MatDialog,
    private service: UsersService,
    private router: Router,
    private snack: MatSnackBar
  ) {}

  ngOnInit(): void {
    this.getAllUser();
  }

  addEditEmpForm() {
    const dialogRef = this._dialog.open(AddFormComponent);

    dialogRef.afterClosed().subscribe({
      next: (val) => {
        if (val) {
          this.getAllUser();
        }
      },
    });
  }
  openEditForm(data: any) {
    const dialogRef = this._dialog.open(AddFormComponent, {
      height: '400px',
      width: '650px',

      data,
    });

    dialogRef.afterClosed().subscribe({
      next: (val) => {
        if (val) {
          this.getAllUser();
        }
      },
    });
  }

  userFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  getAllUser() {
    this.service.userList().subscribe({
      next: (result) => {
        this.dataSource = new MatTableDataSource(result);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
      },
      error: (err) => {
        alert('A system error has occurred !!');
      },
    });
  }

  delete(id: number) {
    this.service.deleteUser(id).subscribe({
      next: (res) => {
        this.snack.open('The record has been deleted successfully !!', 'Accept', {
          duration: 3000,
        });
        this.getAllUser();
      },
      error: console.log,
    });
  }
}
