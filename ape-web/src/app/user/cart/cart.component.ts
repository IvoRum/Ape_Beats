import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartItem } from 'src/app/domains/CartItem';
import { DataServiceService } from 'src/services/data-service.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css'],
})
export class CartComponent implements OnInit {
  constructor(
    private dataService: DataServiceService,
    private router: Router
  ) {}
  isLoged = localStorage.getItem('logedId');
  cartItems!: CartItem[];

  ngOnInit() {
    this.dataService.fetchUserCartItems(this.isLoged).subscribe((data) => {
      this.cartItems = data;
      this.cartItems.forEach((element) => {
        element.cart = true;
      });
    });
  }

  gotoMain(): void {
    this.router.navigate(['']);
  }
  checkOut(): void {
    if (this.isLoged) {
      this.dataService.checkOut(this.isLoged).subscribe((data) => {
        this.router.navigate(['/cart']);
      });
    }
  }
}
