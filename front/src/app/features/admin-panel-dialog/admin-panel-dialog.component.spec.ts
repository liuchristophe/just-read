import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminPanelDialogComponent } from './admin-panel-dialog.component';

describe('AdminPanelDialogComponent', () => {
  let component: AdminPanelDialogComponent;
  let fixture: ComponentFixture<AdminPanelDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminPanelDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminPanelDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
