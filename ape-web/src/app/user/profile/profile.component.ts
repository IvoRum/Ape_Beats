import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserDate } from 'src/app/domains/UserDate';
import { DataServiceService } from 'src/services/data-service.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
})
export class ProfileComponent implements OnInit {
  isLoged!: string | number | null;
  userDate!: UserDate;
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
    }
  }
}
