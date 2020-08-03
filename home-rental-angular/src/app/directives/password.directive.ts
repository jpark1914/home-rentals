import { Directive, ElementRef } from '@angular/core';

@Directive({
  selector: '[appPassword]'
})
export class PasswordDirective {

  shown = false;

  constructor(private el: ElementRef) {
    this.setup();
  }

  setup() {
    this.el.nativeElement.setAttribute("class", "flex-fill border-0 p-0 my-0 ml-0 mr-1");
    this.el.nativeElement.setAttribute("type", "password");
    
    
    const img = document.createElement('img');
    img.setAttribute("src", "../../assets/eye-slash.svg");
    img.style.cssText = "cursor: pointer;";
    img.addEventListener("click", (event) => {
      this.shown = !this.shown;
      if (this.shown) {
        this.el.nativeElement.setAttribute("type", "text");
        img.setAttribute("src", "../../assets/eye.svg");
      } else {
        this.el.nativeElement.setAttribute("type", "password");
        img.setAttribute("src", "../../assets/eye-slash.svg");
      }
    });
    //svg.setAttribute("class", "bi bi-sys-slash-fill");
    //svg.setAttribute("fill", "currentColor");
    //svg.style.cssText = "width: 30px; height: 30px;";
    //svg.innerHTML = this.eyefillslash;
    
    const par = this.el.nativeElement.parentNode;
    par.setAttribute("class", "d-flex border border-dark p-2 mt-2 mb-3 bg-white");
    par.appendChild(img);
  }
  

}
