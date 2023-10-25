import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ItemTableComponent } from './item-table/item-table.component';
import { ItemComponent } from './item/item.component';



@NgModule({
  declarations: [
    ItemTableComponent,
    ItemComponent
  ],
  imports: [
    CommonModule
  ]
})
export class ItemModule { }
