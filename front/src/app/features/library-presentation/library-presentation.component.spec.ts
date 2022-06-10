import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LibraryPresentationComponent } from './library-presentation.component';

describe('LibraryPresentationComponent', () => {
  let component: LibraryPresentationComponent;
  let fixture: ComponentFixture<LibraryPresentationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LibraryPresentationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LibraryPresentationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
