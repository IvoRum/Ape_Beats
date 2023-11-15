import { Component, Input } from '@angular/core';
import { UserSales } from 'src/app/domains/UserSales';

@Component({
  selector: 'app-user-sale-data',
  templateUrl: './user-sale-data.component.html',
  styleUrls: ['./user-sale-data.component.css'],
})
export class UserSaleDataComponent {
  @Input() userSales!: UserSales[];
  displayedColumns: string[] = ['number', 'amount', 'fulfilled'];
}
