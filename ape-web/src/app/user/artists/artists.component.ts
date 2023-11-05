import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialog } from '@angular/material/dialog';
import { Artist } from 'src/app/domains/Artist';
import { DataServiceService } from 'src/services/data-service.service';

@Component({
  selector: 'app-artists',
  templateUrl: './artists.component.html',
  styleUrls: ['./artists.component.css'],
})
export class ArtistsComponent implements OnInit {
  artist!: Artist[];
  form: FormGroup;

  displayedColumns2: string[] = ['name', 'recordLabel'];
  constructor(
    private dataService: DataServiceService,
    private formBuilder: FormBuilder,
    public dialog: MatDialog
  ) {
    this.form = this.formBuilder.group({
      name: ['new name of the instrument'],
    });
  }

  ngOnInit(): void {
    this.dataService.fetchArtists().subscribe((data) => {
      this.artist = data;
    });
  }

  onFindArtistByName() {
    if (this.form.valid) {
      this.dataService
        .fetchArtistByName(this.form.value.name)
        .subscribe((data) => {
          this.dialog.open(DialogD, {
            data: data,
          });
        });
    }
  }
}

@Component({
  selector: 'app-artists',
  templateUrl: './Dialog.html',
  styleUrls: ['./artists.component.css'],
})
export class DialogD {
  constructor(@Inject(MAT_DIALOG_DATA) public data: Artist) {}
}
