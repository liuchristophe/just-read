import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagementDisplayStockComponent } from './management-display-stock.component';

describe('ManagementDisplayStockComponent', () => {
  let component: ManagementDisplayStockComponent;
  let fixture: ComponentFixture<ManagementDisplayStockComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ManagementDisplayStockComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagementDisplayStockComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
