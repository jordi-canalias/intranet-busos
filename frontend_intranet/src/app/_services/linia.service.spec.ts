import { TestBed } from '@angular/core/testing';

import { LiniaService } from './linia.service';

describe('LiniaService', () => {
  let service: LiniaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LiniaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
