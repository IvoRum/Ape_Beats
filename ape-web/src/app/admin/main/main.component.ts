import { Component, OnInit } from '@angular/core';
import { Instrument } from 'src/app/domains/Instrument';
import { Item } from 'src/app/domains/Item';
import { DataServiceService } from 'src/services/data-service.service';
import { Record } from 'src/app/domains/Record';
import { Artist } from 'src/app/domains/Artist';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css'],
})
export class MainComponent implements OnInit {
  instruments!: Instrument[];
  records!: Record[];
  mostSoldItem!: Item;
  artist!: Artist[];
  displayedColumns: string[] = [
    'type',
    'name',
    'company',
    'price',
    'inStock',
    'genre',
  ];
  displayedColumns1: string[] = [
    'price',
    'name',
    'artistName',
    'recordLableName',
  ];
  displayedColumns2: string[] = ['name', 'recordLabel'];
  forminstument: FormGroup;
  formCreateInstument: FormGroup;
  formrecord: FormGroup;
  formCreateRecord: FormGroup;
  formCreateArtist: FormGroup;

  constructor(
    private dataService: DataServiceService,
    private formBuilder: FormBuilder
  ) {
    this.forminstument = this.formBuilder.group({
      // Define your form controls here, e.g., name, email, etc.
      id: ['id of the instrument'],
      name: ['new name of the instrument'],
      // Add validators if needed, e.g., Validators.required
    });
    this.formrecord = this.formBuilder.group({
      id: ['id of the Record'],
      name: ['new name of the Record'],
    });
    this.formCreateRecord = this.formBuilder.group({
      price: ['price'],
      description: ['description'],
      manufacturingDate: ['2012-10-10'],
      name: ['name'],
      genreId: ['genreId'],
      companyId: ['companyId'],
      date: ['2023-01-01'],
      artistId: ['artist Id'],
      recordLabelId: ['1'],
    });
    this.formCreateInstument = this.formBuilder.group({
      price: ['price'],
      genraId: ['genraId'],
      description: ['description'],
      manufacturingDate: ['manufacturingDate'],
      name: ['name'],
      genreId: ['genreId'],
      companyId: ['companyId'],
      date: ['date'],
      type: ['type'],
    });
    this.formCreateArtist = this.formBuilder.group({
      artistName: ['artistName'],
      recordLabelID: ['recordLabelID'],
      date: ['date'],
    });
  }

  onSubmitNewIstrumentName() {
    if (this.forminstument.valid) {
      // Make the PUT request to update the data using the values in this.form.value
      this.dataService
        .updateItemName(this.forminstument.value)
        .subscribe((response) => {
          // Handle the response
        });
    }
  }

  onSubmitNewIstrument() {
    if (this.formCreateInstument.valid) {
      // Make the PUT request to update the data using the values in this.form.value
      this.dataService
        .newInstrument(this.formCreateInstument.value)
        .subscribe((response) => {
          // Handle the response
        });
    }
  }

  onSubmitNewRecordName() {
    if (this.formrecord.valid) {
      // Make the PUT request to update the data using the values in this.form.value
      this.dataService
        .updateItemName(this.formrecord.value)
        .subscribe((response) => {
          // Handle the response
        });
    }
  }

  onSubmitNewRecord() {
    if (this.formCreateRecord.valid) {
      // Make the PUT request to update the data using the values in this.form.value
      this.dataService
        .newrecord(this.formCreateRecord.value)
        .subscribe((response) => {
          // Handle the response
        });
    }
  }
  onSubmitNewArtist() {
    if (this.formCreateArtist.valid) {
      // Make the PUT request to update the data using the values in this.form.value
      this.dataService
        .newArtist(this.formCreateArtist.value)
        .subscribe((response) => {
          // Handle the response
        });
    }
  }

  ngOnInit(): void {
    this.dataService.fetchInstruments().subscribe((data) => {
      this.instruments = data;
    });
    this.dataService.fetchRecords().subscribe((data) => {
      this.records = data;
    });
    this.dataService.fetchMostSoldItem().subscribe((data) => {
      this.mostSoldItem = data;
    });
    this.dataService.fetchArtists().subscribe((data) => {
      this.artist = data;
    });
  }
}
