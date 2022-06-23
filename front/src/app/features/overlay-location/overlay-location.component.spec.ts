import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OverlayLocationComponent } from './overlay-location.component';

describe('OverlayLocationComponent', () => {
  let component: OverlayLocationComponent;
  let fixture: ComponentFixture<OverlayLocationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OverlayLocationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OverlayLocationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
