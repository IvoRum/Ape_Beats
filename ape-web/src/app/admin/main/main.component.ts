import { Component, Inject, OnInit } from '@angular/core';
import { Instrument } from 'src/app/domains/Instrument';
import { Item } from 'src/app/domains/Item';
import { DataServiceService } from 'src/services/data-service.service';
import { Record } from 'src/app/domains/Record';
import { Artist } from 'src/app/domains/Artist';
import { FormBuilder, FormGroup } from '@angular/forms';
import { StatitcInfomation } from 'src/app/domains/StatitcInfomation';
import { UserSales } from 'src/app/domains/UserSales';
import { MAT_DIALOG_DATA, MatDialog } from '@angular/material/dialog';
import { UserSaleDataComponent } from '../user-sale-data/user-sale-data.component';
import { UserDateShort } from 'src/app/domains/UserDateShort';

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
  staticInformation!: StatitcInfomation;
  userData!: UserDateShort[];

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
  purchesForm: FormGroup;

  constructor(
    private dataService: DataServiceService,
    private formBuilder: FormBuilder,
    public dialog: MatDialog
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
      genreId: ['genreId'],
      description: ['description'],
      manufacturingDate: ['manufacturingDate'],
      name: ['name'],
      companyId: ['companyId'],
      date: ['date'],
      type: ['type'],
    });
    this.formCreateArtist = this.formBuilder.group({
      artistName: ['artistName'],
      recordLabelID: ['recordLabelID'],
      date: ['date'],
    });
    this.purchesForm = this.formBuilder.group({
      userId: ['userId'],
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
      window.location.reload();
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
      window.location.reload();
    }
  }

  onSubmitNewRecordName() {
    if (this.formrecord.valid) {
      // Make the PUT request to update the data using the values in this.form.value
      this.dataService
        .updateItemName(this.formrecord.value)
        .subscribe((response) => {
          // Handle the response
          console.log(response);
        });
      window.location.reload();
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
      window.location.reload();
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
      window.location.reload();
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
    this.dataService.fetchStaticInformation().subscribe((data) => {
      this.staticInformation = data;
    });
    this.dataService.fetchAllUser().subscribe((data) => {
      this.userData = data;
    });
  }
  userSaleData!: UserSales[];

  getUserSaleData() {
    if (this.purchesForm.valid) {
      console.log(this.purchesForm.value.userId);
      this.dataService
        .fetchUserSales(this.purchesForm.value.userId)
        .subscribe((data) => {
          this.dialog.open(UserSaleDataComponent, {
            data: data,
          });
        });
    }
  }
}
@Component({
  selector: 'app-main',
  templateUrl: './Dialog.html',
  styleUrls: ['./main.component.css'],
})
export class DialogD {
  userSales!: UserSales[];
  constructor(@Inject(MAT_DIALOG_DATA) public data: UserSales[]) {
    this.userSales = data;
  }
  displayedColumns: string[] = ['number', 'amount', 'fulfilled'];
}
