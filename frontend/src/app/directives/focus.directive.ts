import {Directive, Input, ElementRef, Inject} from '@angular/core';

@Directive({
  selector: '[defaultFocus]'
})
export class FocusDirective {
  constructor(private elementRef: ElementRef) {
  }

  ngAfterViewInit() {
    // set focus when element first appears
    // this.elementRef.nativeElement.focus();
  }
}
