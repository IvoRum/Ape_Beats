import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Instrument } from 'src/app/domains/Instrument';
import { Record } from 'src/app/domains/Record';
import { Item } from 'src/app/domains/Item';
import { Artist } from 'src/app/domains/Artist';
import { StatitcInfomation } from 'src/app/domains/StatitcInfomation';
import { UserDate } from 'src/app/domains/UserDate';
import { UserSales } from 'src/app/domains/UserSales';
import { CartItem } from 'src/app/domains/CartItem';
import { UserDateShort } from 'src/app/domains/UserDateShort';

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

  fetchInstrumentsBrass(): Observable<Instrument[]> {
    return this.http.get<Instrument[]>(
      `http://localhost:8080/api/v1/instrument/brass`
    );
  }

  fetchInstrumentsGutars(): Observable<Instrument[]> {
    return this.http.get<Instrument[]>(
      `http://localhost:8080/api/v1/instrument/guitar`
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

  fetchStaticInformation(): Observable<StatitcInfomation> {
    return this.http.get<StatitcInfomation>(
      `http://localhost:8080/api/v1/static`
    );
  }

  fetchGenreInformation(): Observable<string[]> {
    return this.http.get<string[]>(
      `http://localhost:8080/api/v1/static/genres`
    );
  }

  fetchTypeInformation(): Observable<string[]> {
    return this.http.get<string[]>(`http://localhost:8080/api/v1/static/types`);
  }

  fetchCompanyInformation(): Observable<string[]> {
    return this.http.get<string[]>(
      `http://localhost:8080/api/v1/static/company`
    );
  }

  fetchArtistByName(name: string): Observable<Artist> {
    return this.http.get<Artist>(`http://localhost:8080/api/v1/artist/` + name);
  }

  fetchArtists(): Observable<Artist[]> {
    return this.http.get<Artist[]>(`http://localhost:8080/api/v1/artist`);
  }

  updateItemName(data: any) {
    return this.http.post('http://localhost:8080/api/v1/instrument', data);
  }

  newInstrument(data: any) {
    return this.http.put('http://localhost:8080/api/v1/instrument', data);
  }

  newrecord(data: any) {
    return this.http.put('http://localhost:8080/api/v1/record', data);
  }

  delRecord(data: any) {
    return this.http.delete('http://localhost:8080/api/v1/record/' + data.id);
  }

  delInstrument(data: any) {
    return this.http.delete(
      'http://localhost:8080/api/v1/instrument/' + data.id
    );
  }

  newArtist(data: any) {
    return this.http.put('http://localhost:8080/api/v1/artist', data);
  }

  logIn(data: any) {
    return this.http.get(
      'http://localhost:8080/api/v1/user/' + data.email + '/' + data.pass
    );
  }
  fetchuserDate(data: any): Observable<UserDate> {
    return this.http.get<UserDate>('http://localhost:8080/api/v1/user/' + data);
  }

  fetchUserSales(userId: any): Observable<UserSales[]> {
    return this.http.get<UserSales[]>(
      `http://localhost:8080/api/v1/user/sale/` + userId
    );
  }

  fetchUserCartItems(userId: any): Observable<CartItem[]> {
    return this.http.get<CartItem[]>(
      `http://localhost:8080/api/v1/sale/` + userId
    );
  }

  fetchAllUser(): Observable<UserDateShort[]> {
    return this.http.get<UserDateShort[]>(`http://localhost:8080/api/v1/user`);
  }

  async addItemToCart(userId: string, itemID: number) {
    console.log(userId);
    console.log(itemID);
    const result = await this.http.get(
      'http://localhost:8080/api/v1/sale/cart/' + userId + '/' + itemID
    );
    return result;
  }

  removeItemToCart(userId: string, itemID: number) {
    console.log(userId);
    console.log(itemID);
    return this.http.get(
      'http://localhost:8080/api/v1/sale/delete/' + userId + '/' + itemID
    );
  }

  checkOut(userId: string) {
    return this.http.get('http://localhost:8080/api/v1/sale/finish/' + userId);
  }
}
function timeout(
  arg0: number
): import('rxjs').OperatorFunction<Object, unknown> {
  throw new Error('Function not implemented.');
}
