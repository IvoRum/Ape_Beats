import { Component, OnInit } from '@angular/core';
import { Instrument } from 'src/app/domains/Instrument';
import { DataServiceService } from 'src/services/data-service.service';

@Component({
  selector: 'app-istruments',
  templateUrl: './istruments.component.html',
  styleUrls: ['./istruments.component.css'],
})
export class IstrumentsComponent implements OnInit {
  instruments: Instrument[] | undefined;
  constructor(private dataService: DataServiceService) {}

  ngOnInit(): void {
    this.dataService.fetchInstruments().subscribe((data) => {
      this.instruments = data;
    });
  }
}
