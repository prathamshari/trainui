import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PassengerdeleteComponent } from './passengerdelete.component';

describe('PassengerdeleteComponent', () => {
  let component: PassengerdeleteComponent;
  let fixture: ComponentFixture<PassengerdeleteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PassengerdeleteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PassengerdeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
