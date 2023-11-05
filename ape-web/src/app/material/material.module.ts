import { NgModule } from '@angular/core';
import { CommonModule, NgFor } from '@angular/common';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { HttpClientModule } from '@angular/common/http';
import { MatTableModule } from '@angular/material/table';
import { ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FlexLayoutModule } from '@angular/flex-layout';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    MatButtonModule,
    MatCardModule,
    NgFor,
    HttpClientModule,
    MatTableModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    FlexLayoutModule,
  ],
  exports: [
    MatButtonModule,
    MatCardModule,
    NgFor,
    MatTableModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    FlexLayoutModule,
  ],
})
export class MaterialModule {}
