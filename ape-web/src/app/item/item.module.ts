import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ItemComponent } from './item/item.component';
import { MaterialModule } from '../material/material.module';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [ItemComponent],
  imports: [CommonModule, MaterialModule, RouterModule],
  exports: [ItemComponent],
})
export class ItemModule {}
