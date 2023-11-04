import { Component, OnInit } from '@angular/core';
import { Instrument } from 'src/app/domains/Instrument';
import { DataServiceService } from 'src/services/data-service.service';
import { Record } from 'src/app/domains/Record';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css'],
})
export class MainComponent implements OnInit {
  instruments: Instrument[] | undefined;
  records: Record[] | undefined;

  constructor(private dataService: DataServiceService) {}

  ngOnInit(): void {
    this.dataService.fetchInstruments().subscribe((data) => {
      this.instruments = data;
    });
    this.dataService.fetchRecords().subscribe((data) => {
      this.records = data;
    });
  }
}
