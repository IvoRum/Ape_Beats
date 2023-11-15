import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Instrument } from 'src/app/domains/Instrument';
import { DataServiceService } from 'src/services/data-service.service';

@Component({
  selector: 'app-gutars',
  templateUrl: './gutars.component.html',
  styleUrls: ['./gutars.component.css'],
})
export class GutarsComponent implements OnInit {
  isLoged = localStorage.getItem('logedId');
  instruments: Instrument[] | undefined;
  constructor(
    private dataService: DataServiceService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.dataService.fetchInstrumentsGutars().subscribe((data) => {
      this.instruments = data;
    });
  }
}
