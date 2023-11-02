import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ItemTableComponent } from './item-table/item-table.component';
import { ItemComponent } from './item/item.component';
import { MaterialModule } from '../material/material.module';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [ItemTableComponent, ItemComponent],
  imports: [CommonModule, MaterialModule, RouterModule],
})
export class ItemModule {}
