import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BrassComponent } from './brass.component';

describe('BrassComponent', () => {
  let component: BrassComponent;
  let fixture: ComponentFixture<BrassComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BrassComponent]
    });
    fixture = TestBed.createComponent(BrassComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
