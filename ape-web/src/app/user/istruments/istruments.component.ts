import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Instrument } from 'src/app/domains/Instrument';
import { DataServiceService } from 'src/services/data-service.service';

@Component({
  selector: 'app-istruments',
  templateUrl: './istruments.component.html',
  styleUrls: ['./istruments.component.css'],
})
export class IstrumentsComponent implements OnInit {
  instruments: Instrument[] | undefined;
  constructor(
    private dataService: DataServiceService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.dataService.fetchInstruments().subscribe((data) => {
      this.instruments = data;
    });
  }

  goToGitars(): void {
    this.router.navigate(['/guitar']);
  }

  goToBrass(): void {
    this.router.navigate(['/brass']);
  }
}
