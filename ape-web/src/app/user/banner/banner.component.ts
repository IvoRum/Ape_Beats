import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { DataServiceService } from 'src/services/data-service.service';

@Component({
  selector: 'app-banner',
  templateUrl: './banner.component.html',
  styleUrls: ['./banner.component.css'],
})
export class BannerComponent {
  isLoged = localStorage.getItem('logedId');
  constructor(
    private dataService: DataServiceService,
    private router: Router
  ) {}

  goProfle() {
    this.router.navigate(['/profile']);
  }
  goCart() {
    this.router.navigate(['/cart']);
  }
}
