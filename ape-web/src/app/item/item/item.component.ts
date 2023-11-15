import { Component, Input } from '@angular/core';
import { DataServiceService } from 'src/services/data-service.service';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css'],
})
export class ItemComponent {
  @Input() projectList: any[] | undefined;
  isLoged = localStorage.getItem('logedId');

  constructor(private dataService: DataServiceService) {}

  addItemToShpoinCart(itemId: number) {
    console.log(itemId);
    console.log(this.isLoged);
    if (this.isLoged) {
      this.dataService
        .addItemToCart(this.isLoged, itemId)
        .subscribe((response) => {
          console.log(response);
        });
    }
  }

  removeItemToShpoinCart(itemId: number) {
    if (this.isLoged) {
      this.dataService
        .removeItemToCart(this.isLoged, itemId)
        .subscribe((response) => {
          console.log(response);
        });
    }
  }
}
