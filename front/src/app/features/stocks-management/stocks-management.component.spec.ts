import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StocksManagementComponent } from './stocks-management.component';

describe('StockManagementComponent', () => {
  let component: StocksManagementComponent;
  let fixture: ComponentFixture<StocksManagementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StocksManagementComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StocksManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
