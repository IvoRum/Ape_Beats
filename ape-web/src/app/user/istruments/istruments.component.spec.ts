import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IstrumentsComponent } from './istruments.component';

describe('IstrumentsComponent', () => {
  let component: IstrumentsComponent;
  let fixture: ComponentFixture<IstrumentsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [IstrumentsComponent]
    });
    fixture = TestBed.createComponent(IstrumentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
