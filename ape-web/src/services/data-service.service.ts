import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Instrument } from 'src/app/domains/Instrument';
import { Record } from 'src/app/domains/Record';
import { Item } from 'src/app/domains/Item';
import { Artist } from 'src/app/domains/Artist';

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

  fetchMostSoldItem(): Observable<Item> {
    return this.http.get<Item>(
      `http://localhost:8080/api/v1/sale/most_sold_item`
    );
  }

  fetchArtists(): Observable<Artist[]> {
    return this.http.get<Artist[]>(`http://localhost:8080/api/v1/artist`);
  }

  updateItemName(data: any) {
    return this.http.post('http://localhost:8080/api/v1/instrument', data);
  }
}
