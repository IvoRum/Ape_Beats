import { NgModule } from '@angular/core';
import { CommonModule, NgFor } from '@angular/common';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    MatButtonModule,
    MatCardModule,
    NgFor,
    HttpClientModule,
  ],
  exports: [MatButtonModule, MatCardModule, NgFor],
})
export class MaterialModule {}
