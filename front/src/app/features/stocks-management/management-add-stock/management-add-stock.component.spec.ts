import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagementAddStockComponent } from './management-add-stock.component';

describe('ManagementAddStockComponent', () => {
  let component: ManagementAddStockComponent;
  let fixture: ComponentFixture<ManagementAddStockComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ManagementAddStockComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagementAddStockComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
