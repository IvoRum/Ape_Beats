import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { UserSales } from 'src/app/domains/UserSales';

@Component({
  selector: 'app-user-sale-data',
  templateUrl: './user-sale-data.component.html',
  styleUrls: ['./user-sale-data.component.css'],
})
export class UserSaleDataComponent {
  userSales: UserSales[];
  displayedColumns: string[] = ['number', 'amount', 'fulfilled'];
  constructor(@Inject(MAT_DIALOG_DATA) data: UserSales[]) {
    this.userSales = data;
  }
}
