import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GutarsComponent } from './gutars.component';

describe('GutarsComponent', () => {
  let component: GutarsComponent;
  let fixture: ComponentFixture<GutarsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [GutarsComponent]
    });
    fixture = TestBed.createComponent(GutarsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
