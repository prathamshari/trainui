import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PassengereditComponent } from './passengeredit.component';

describe('PassengereditComponent', () => {
  let component: PassengereditComponent;
  let fixture: ComponentFixture<PassengereditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PassengereditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PassengereditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
