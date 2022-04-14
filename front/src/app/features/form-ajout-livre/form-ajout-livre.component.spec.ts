import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormAjoutLivreComponent } from './form-ajout-livre.component';

describe('FormAjoutLivreComponent', () => {
  let component: FormAjoutLivreComponent;
  let fixture: ComponentFixture<FormAjoutLivreComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormAjoutLivreComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormAjoutLivreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
