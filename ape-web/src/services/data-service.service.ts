import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Instrument } from 'src/app/domains/Instrument';
import { Record } from 'src/app/domains/Record';

@Injectable({
  providedIn: 'root',
})
export class DataServiceService {
  private apiUrl = 'https://localhost:8080/api/v1/';

  constructor(private http: HttpClient) {}

  fetchInstruments(): Observable<Instrument[]> {
    return this.http.get<Instrument[]>(
      `http://localhost:8080/api/v1/instrument`
    );
  }

  fetchRecords(): Observable<Record[]> {
    return this.http.get<Record[]>(`http://localhost:8080/api/v1/record`);
  }
}
