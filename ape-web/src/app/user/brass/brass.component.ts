import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Instrument } from 'src/app/domains/Instrument';
import { DataServiceService } from 'src/services/data-service.service';

@Component({
  selector: 'app-brass',
  templateUrl: './brass.component.html',
  styleUrls: ['./brass.component.css'],
})
export class BrassComponent implements OnInit {
  isLoged = localStorage.getItem('logedId');
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
}
