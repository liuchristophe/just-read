import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagementBookCardComponent } from './management-book-card.component';

describe('ManagementBookCardComponent', () => {
  let component: ManagementBookCardComponent;
  let fixture: ComponentFixture<ManagementBookCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ManagementBookCardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagementBookCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
