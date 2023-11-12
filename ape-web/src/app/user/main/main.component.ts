import { Component, OnInit } from '@angular/core';
import { Instrument } from 'src/app/domains/Instrument';
import { DataServiceService } from 'src/services/data-service.service';
import { Record } from 'src/app/domains/Record';
import { Item } from 'src/app/domains/Item';
import { Router } from '@angular/router';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css'],
})
export class MainComponent implements OnInit {
  instruments: Instrument[] | undefined;
  records: Record[] | undefined;
  mostSoldItem!: Item;
  instumentFlag: boolean = true;
  recordsFlag: boolean = true;

  constructor(
    private dataService: DataServiceService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.instumentFlag = true;
    this.recordsFlag = true;
    this.dataService.fetchInstruments().subscribe((data) => {
      this.instruments = data;
    });
    this.dataService.fetchRecords().subscribe((data) => {
      this.records = data;
    });
    this.dataService.fetchMostSoldItem().subscribe((data) => {
      this.mostSoldItem = data;
    });
  }

  goInstruments() {
    this.router.navigate(['/instruments']);
  }
  goArtist() {
    this.router.navigate(['/artist']);
  }
  goRecord() {
    this.router.navigate(['/record']);
  }
  goProfle() {
    this.router.navigate(['/profile']);
  }
  goCart() {}
}
