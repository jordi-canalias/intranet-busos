import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InforutaComponent } from './inforuta.component';

describe('InforutaComponent', () => {
  let component: InforutaComponent;
  let fixture: ComponentFixture<InforutaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InforutaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InforutaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
