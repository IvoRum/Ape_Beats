import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MainComponent } from './main/main.component';
import { MaterialModule } from '../material/material.module';
import { ItemModule } from '../item/item.module';
import { ArtistsComponent } from './artists/artists.component';
import { IstrumentsComponent } from './istruments/istruments.component';
import { RecordsComponent } from './records/records.component';

@NgModule({
  declarations: [
    MainComponent,
    ArtistsComponent,
    IstrumentsComponent,
    RecordsComponent,
  ],
  imports: [CommonModule, MaterialModule, ItemModule],
})
export class UserModule {}
