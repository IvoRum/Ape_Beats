import { Component, Input } from '@angular/core';
import { Item } from 'src/app/domains/Item';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css'],
})
export class ItemComponent {
  @Input() projectList: Item[] | undefined;
}
