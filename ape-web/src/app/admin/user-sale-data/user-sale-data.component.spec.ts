import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserSaleDataComponent } from './user-sale-data.component';

describe('UserSaleDataComponent', () => {
  let component: UserSaleDataComponent;
  let fixture: ComponentFixture<UserSaleDataComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UserSaleDataComponent]
    });
    fixture = TestBed.createComponent(UserSaleDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
