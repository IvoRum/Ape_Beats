import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { DataServiceService } from 'src/services/data-service.service';

@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.css'],
})
export class LogInComponent {
  logInForm!: FormGroup;
  constructor(
    private dataService: DataServiceService,
    private formBuilder: FormBuilder
  ) {
    this.logInForm = this.formBuilder.group({
      email: [''],
      passwod: [''],
    });
  }

  onLogIn() {
    if (this.logInForm.valid) {
      this.dataService.newArtist(this.logInForm.value).subscribe((response) => {
        // Handle the response
      });
    }
  }
}
