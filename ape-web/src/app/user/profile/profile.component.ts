import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ItemSale } from 'src/app/domains/ItemSale';
import { UserDate } from 'src/app/domains/UserDate';
import { UserSales } from 'src/app/domains/UserSales';
import { DataServiceService } from 'src/services/data-service.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
})
export class ProfileComponent implements OnInit {
  isLoged!: string | number | null;
  userDate!: UserDate;
  userSales!: UserSales[];
  expandedElement!: ItemSale | null;
  displayedColumns: string[] = ['number', 'amount', 'fulfilled'];

  constructor(
    private dataService: DataServiceService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.isLoged = localStorage.getItem('logedId');
    if (this.isLoged != '0') {
      this.dataService.fetchuserDate(this.isLoged).subscribe((data) => {
        this.userDate = data;
      });
      this.dataService.fetchUserSales(this.isLoged).subscribe((data) => {
        this.userSales = data;
      });
    }
  }

  logOut() {
    localStorage.removeItem('logedId');
  }
}
