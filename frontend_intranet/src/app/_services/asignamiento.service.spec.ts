import { TestBed } from '@angular/core/testing';

import { AsignamientoService } from './asignamiento.service';

describe('AsignamientoService', () => {
  let service: AsignamientoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AsignamientoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
