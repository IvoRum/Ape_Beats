import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { timeout } from 'rxjs';
import { DataServiceService } from 'src/services/data-service.service';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css'],
})
export class ItemComponent {
  @Input() projectList: any[] | undefined;
  isLoged = localStorage.getItem('logedId');

  constructor(
    private dataService: DataServiceService,
    private router: Router
  ) {}

  async addItemToShpoinCart(itemId: number) {
    console.log(itemId);
    console.log(this.isLoged);
    this.addTheItem(itemId);
    timeout(110);
    this.router.navigate(['/cart']);
  }

  async addTheItem(itemId: number) {
    if (this.isLoged) {
      await (await this.dataService.addItemToCart(this.isLoged, itemId))
        .pipe(timeout(110))
        .subscribe((response) => {
          console.log(response);
        });
    }
  }

  async removeItemToShpoinCart(itemId: number) {
    if (this.isLoged) {
      this.dataService
        .removeItemToCart(this.isLoged, itemId)
        .subscribe((response) => {
          console.log(response);
          this.router.navigate(['/cart']);
        });
      window.location.reload();
    }
  }
}
