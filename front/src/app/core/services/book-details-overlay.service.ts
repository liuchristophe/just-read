import { Overlay } from '@angular/cdk/overlay';
import { ComponentPortal } from '@angular/cdk/portal';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { BookDetailsComponent } from 'src/app/features/book/book-details/book-details.component';

@Injectable({
  providedIn: 'root'
})


export class BookDetailsOverlayService {

  detailClicked: boolean = false;

  update$ = new Subject<void>();

  book_id?: string;

  constructor(private overlay: Overlay) { }

  //  openOverlay() {
  //   // Returns an OverlayRef (which is a PortalHost)
  //   const overlayRef = this.overlay.create();

  //   // Create ComponentPortal that can be attached to a PortalHost
  //   const filePreviewPortal = new ComponentPortal(BookDetailsComponent);

  //   // Attach ComponentPortal to PortalHost
  //   overlayRef.attach(filePreviewPortal);
  // }

  _refresh() {
    this.update$.next();
  }

  detailIsClicked(book_id: string) {
    this.detailClicked = true;
    this.book_id = book_id;
    this._refresh();
    console.log(`detailIsClicked ...`);
  }

  detailIsClosed() {
    this.detailClicked = false;
    this.book_id = undefined;
    this._refresh();
  }
}
