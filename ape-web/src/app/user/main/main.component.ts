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
  instumentFlag: boolean = true;
  recordsFlag: boolean = true;

  constructor(private dataService: DataServiceService) {}

  ngOnInit(): void {
    this.instumentFlag = true;
    this.recordsFlag = true;
    this.dataService.fetchInstruments().subscribe((data) => {
      this.instruments = data;
    });
    this.dataService.fetchRecords().subscribe((data) => {
      this.records = data;
    });
  }

  setIstrumets() {
    this.instumentFlag = true;
    this.recordsFlag = false;
  }

  setRecords() {
    this.instumentFlag = false;
    this.recordsFlag = true;
  }
}
