import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormLibraryCreationComponent } from './form-library-creation.component';

describe('FormLibraryCreationComponent', () => {
  let component: FormLibraryCreationComponent;
  let fixture: ComponentFixture<FormLibraryCreationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormLibraryCreationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormLibraryCreationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
