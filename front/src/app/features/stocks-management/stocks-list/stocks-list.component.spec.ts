import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StocksListComponent } from './stocks-list.component';

describe('StocksListeComponent', () => {
  let component: StocksListComponent;
  let fixture: ComponentFixture<StocksListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StocksListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StocksListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
