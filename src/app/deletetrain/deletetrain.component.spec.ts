import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeletetrainComponent } from './deletetrain.component';

describe('DeletetrainComponent', () => {
  let component: DeletetrainComponent;
  let fixture: ComponentFixture<DeletetrainComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeletetrainComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeletetrainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
