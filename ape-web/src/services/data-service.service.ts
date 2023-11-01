import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class DataServiceService {
  private apiUrl = 'http://your-backend-server/api'; // Replace with your actual API URL

  constructor(private http: HttpClient) {}

  // Example method to fetch data using an HTTP GET request
  fetchData(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/fetch-data`);
  }
}
