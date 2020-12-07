import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Payment1Component } from './payment1.component';

describe('Payment1Component', () => {
  let component: Payment1Component;
  let fixture: ComponentFixture<Payment1Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Payment1Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Payment1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
