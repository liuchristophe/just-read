import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root'
  })
export class CacheAdresse{
    
    static longitude: number = 0;
    static latitude: number = 0;

    static label: string = "";


}