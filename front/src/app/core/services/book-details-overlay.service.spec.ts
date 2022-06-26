import { TestBed } from '@angular/core/testing';

import { BookDetailsOverlayService } from './book-details-overlay.service';

describe('BookDetailsOverlayServiceService', () => {
  let service: BookDetailsOverlayService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BookDetailsOverlayService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
