import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MainComponent } from './main/main.component';
import { MaterialModule } from '../material/material.module';
import { ItemModule } from '../item/item.module';

@NgModule({
  declarations: [MainComponent],
  imports: [CommonModule, MaterialModule, ItemModule],
})
export class UserModule {}
