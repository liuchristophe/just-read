import { Overlay } from '@angular/cdk/overlay';
import { ComponentPortal } from '@angular/cdk/portal';
import { Injectable } from '@angular/core';
import { BookDetailsComponent } from 'src/app/features/book/book-details/book-details.component';

@Injectable({
  providedIn: 'root'
})


export class BookDetailsOverlayService {

  constructor(private overlay: Overlay) { }

   openOverlay() {
    // Returns an OverlayRef (which is a PortalHost)
    const overlayRef = this.overlay.create();

    // Create ComponentPortal that can be attached to a PortalHost
    const filePreviewPortal = new ComponentPortal(BookDetailsComponent);

    // Attach ComponentPortal to PortalHost
    overlayRef.attach(filePreviewPortal);
  }
}
