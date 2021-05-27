import { TestBed } from '@angular/core/testing';

import { ParadaLiniaService } from './parada-linia.service';

describe('ParadaLiniaService', () => {
  let service: ParadaLiniaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ParadaLiniaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
