// import {ConnectedPosition, Overlay,OverlayRef} from '@angular/cdk/overlay';
// import { Component } from '@angular/core';

// @Component({
//   selector: 'app-overlay-location',
//   templateUrl: './overlay-location.component.html',
//   styleUrls: ['./overlay-location.component.scss'],
// })
// export class OverlayLocationComponent {
// isOverlayOpen = false;
// positions: ConnectedPosition[] = [
//   {
//     originX: 'center',
//     originY: 'bottom',
//     overlayX: 'center',
//     overlayY: 'top',
//     offsetY: -21,
//   },
//   {
//     originX: 'center',
//     originY: 'top',
//     overlayX: 'center',
//     overlayY: 'bottom',
//     panelClass: 'no-enogh-space-at-bottom',
//   },
// ];

// }


import {
  Component,
  OnInit,
  ChangeDetectionStrategy,
  ViewChild,
  ElementRef,
  SimpleChanges,
} from '@angular/core';
import { Observable, merge, iif, EMPTY } from 'rxjs';
import {
  map,
  filter,
  mapTo,
  startWith,
  switchMap,
  delay,
} from 'rxjs/operators';
import { FocusMonitor } from '@angular/cdk/a11y';
import { MatInput } from '@angular/material/input';
import {
  CdkConnectedOverlay,
  ConnectedPosition,
  ScrollStrategyOptions,
  ScrollStrategy,
} from '@angular/cdk/overlay';
import { FormControl } from '@angular/forms';
import { MatSlideToggleChange } from '@angular/material/slide-toggle';
import { ESCAPE } from '@angular/cdk/keycodes';
import { OverlayReference } from '@angular/cdk/overlay/overlay-reference';
import { BookDetailsOverlayService } from 'src/app/core/services/book-details-overlay.service';
import { ApiService } from 'src/app/core/services/api.service';
import { CacheAdresse } from 'src/app/core/services/cacheAdresse';
export interface State {
  flag: string;
  name: string;
  population: string;
}
@Component({
  selector: 'app-overlay-location',
  templateUrl: './overlay-location.component.html',
  styleUrls: ['./overlay-location.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class OverlayLocationComponent implements OnInit {

  adresses: any;
  test: string = "7 allée de la frégate";
  adressesTest$!: Observable<any>;

  showPanel$!: Observable<boolean>;

  stateCtrl = new FormControl();
  filteredStates$!: Observable<State[]>;
  isCaseSensitive: boolean = false;
  positions: ConnectedPosition[] = [
    {
      originX: 'center',
      originY: 'bottom',
      overlayX: 'center',
      overlayY: 'top',
      offsetY: -21,
    },
    {
      originX: 'center',
      originY: 'top',
      overlayX: 'center',
      overlayY: 'bottom',
      panelClass: 'no-enogh-space-at-bottom',
    },
  ];

  scrollStrategy!: ScrollStrategy;

  @ViewChild(MatInput, { read: ElementRef, static: true })
  private inputEl!: ElementRef;

  @ViewChild(CdkConnectedOverlay, { static: true })
  private connectedOverlay!: CdkConnectedOverlay;

  private isPanelVisible$!: Observable<boolean>;
  private isPanelHidden$!: Observable<boolean>;
  private isOverlayDetached$!: Observable<void>;

  constructor(
    private focusMonitor: FocusMonitor,
    private scrollStrategies: ScrollStrategyOptions,
    private apiService : ApiService,
  ) {}

  saveText(text: string, latitude: string, longitude: string): void{
    this.stateCtrl.setValue(text);
    localStorage.setItem("label", text);
    localStorage.setItem("latitude", latitude);
    localStorage.setItem("longitude", longitude);
  }

  saveAdresse(): void{

  }

  actu(): void{
    window.location.reload();
  }
  ngOnInit(): void {

    if(localStorage.getItem("label") == null){
      localStorage.setItem("label", "3 Rue Jean Douat, Fontenay-sous-Bois, France");
      localStorage.setItem("latitude", ""+48.84798812866211);
      localStorage.setItem("longitude",  ""+2.4737184047698975);
      window.location.reload();
    }
    this.stateCtrl.setValue(localStorage.getItem("label"));

    this.adressesTest$ = this.stateCtrl.valueChanges.pipe( startWith(''),
    map((adresse) => {
        this.apiService.getAdresse$(adresse).subscribe((data) => {
          this.adresses = data;
          if(this.adresses.features[0] != undefined){

            localStorage.setItem("label", this.adresses.features[0].properties.label);
            localStorage.setItem("latitude", this.adresses.features[0].geometry.coordinates[1]);
            localStorage.setItem("longitude", this.adresses.features[0].geometry.coordinates[0]);
            // CacheAdresse.label = this.adresses.features[0].properties.label;
            // CacheAdresse.latitude = this.adresses.features[0].geometry.coordinates[0];
            // CacheAdresse.longitude = this.adresses.features[0].geometry.coordinates[1];
          }
        });
        return this.adresses==undefined ? undefined : this.adresses.features;

      })
    );
    this.scrollStrategy = new ConfirmScrollStrategy(this.inputEl);

    this.isPanelVisible$ = this.focusMonitor.monitor(this.inputEl).pipe(
      filter((focused) => !!focused),
      mapTo(true)
    );
    this.isOverlayDetached$ = this.isPanelVisible$.pipe(
      delay(0),
      switchMap(() =>
        iif(
          () => !!this.connectedOverlay.overlayRef,
          this.connectedOverlay.overlayRef.detachments(),
          EMPTY
        )
      )
    );
    this.isPanelHidden$ = merge(
      this.isOverlayDetached$,
      this.connectedOverlay.backdropClick
    ).pipe(mapTo(false));
    this.showPanel$ = merge(this.isPanelHidden$, this.isPanelVisible$);

  }
}

class ConfirmScrollStrategy implements ScrollStrategy {
  _overlay!: OverlayReference;

  constructor(private inputRef: ElementRef) {}

  attach(overlayRef: OverlayReference) {
    this._overlay = overlayRef;
  }

  enable() {
    document.addEventListener('scroll', this.scrollListener);
  }

  disable() {
    document.removeEventListener('scroll', this.scrollListener);
  }

  private scrollListener = () => {
      this._overlay.detach();
      this.inputRef.nativeElement.blur();
      return;
  };


}
