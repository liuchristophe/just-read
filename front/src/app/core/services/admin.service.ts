import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  update$ = new Subject<void>();

  library_id: string = '3b3b3d57-6f2d-4dd9-a374-d7e35b761ad0';

  constructor() { }
}
