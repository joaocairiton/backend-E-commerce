import { Injectable } from '@angular/core';

import {
  HttpClient,
  HttpErrorResponse,
  HttpHeaders,
} from '@angular/common/http';
import { User } from 'src/app/components/model/user';
import { Observable, catchError } from 'rxjs';
import baserUrl from '../helper';

@Injectable({
  providedIn: 'root',
})
export class UsersService {
  constructor(private http: HttpClient) {}

  public registerUser(user: any) {
    return this.http.post(`${baserUrl}/users/`, user);
  }
  userList(): Observable<User[]> {
    return this.http.get<User[]>(`${baserUrl}/users`);
  }

  updateUser(id: number, user: User): Observable<User> {
    return this.http.put<User>(`${baserUrl}/users/${id}`, user);
  }

  getUser(id: number): Observable<User> {
    return this.http.get<User>(`${baserUrl}/users/${id}`);
  }
  deleteUser(id: number): Observable<any> {
    return this.http.delete(`${baserUrl}/users/${id}`);
  }
}
