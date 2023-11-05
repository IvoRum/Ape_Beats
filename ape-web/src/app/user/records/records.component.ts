import { Component } from '@angular/core';
import { DataServiceService } from 'src/services/data-service.service';
import { Record } from 'src/app/domains/Record';

@Component({
  selector: 'app-records',
  templateUrl: './records.component.html',
  styleUrls: ['./records.component.css'],
})
export class RecordsComponent {
  records: Record[] | undefined;

  constructor(private dataService: DataServiceService) {}
  ngOnInit(): void {
    this.dataService.fetchRecords().subscribe((data) => {
      this.records = data;
    });
  }
}
