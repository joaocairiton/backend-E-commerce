import { Injectable } from '@angular/core';


import { HttpClient } from '@angular/common/http';
import { User } from 'src/app/components/model/user';
import { Observable } from 'rxjs';
import baserUrl from '../helper';


@Injectable({
  providedIn: 'root'
})
export class UsersService {

  constructor(private http: HttpClient) { }

  public registerUser(user:any){
    return this.http.post(`${baserUrl}/users/`,user);
  }
  userList(): Observable<User[]> {
    return this.http.get<User[]>(`${baserUrl}/users/`);
  }
  update(id: number, user: User): Observable<Object> {
    return this.http.put<Object>(`${baserUrl}/${id}`, user);
  }
  getUser(id: number): Observable<User> {
    return this.http.get<User>(`${baserUrl}/${id}`);
  }

}