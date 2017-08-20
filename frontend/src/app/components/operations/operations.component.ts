import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';

@Component({
  selector: 'operations-component',
  templateUrl: './operations.component.html',
  styleUrls: ['./operations.component.css']
})
export class OperationsComponent implements OnInit {

  @ViewChild('pinText') pin: ElementRef;
  @ViewChild('cardNumberText') card: ElementRef;

  cardActive: boolean = false;
  pinActive: boolean = false;

  constructor() { }

  ngOnInit() {
  }

  activatePin() {
    this.setFocus(this.pin);
    this.pinActive = true;
    this.cardActive = false;
  }

  activateCard() {
    this.setFocus(this.card);
    this.cardActive = true;
    this.pinActive = false;
  }

  private setFocus(el: ElementRef) {
    el.nativeElement.focus();
  }

}
