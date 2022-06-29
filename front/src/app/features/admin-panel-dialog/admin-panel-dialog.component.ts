import { Component, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { AdminService } from 'src/app/core/services/admin.service';
import { ApiService } from 'src/app/core/services/api.service';

@Component({
  selector: 'app-admin-panel-dialog',
  templateUrl: './admin-panel-dialog.component.html',
  styleUrls: ['./admin-panel-dialog.component.scss']
})
export class AdminPanelDialogComponent implements OnInit {

  emessage: string | undefined;

  constructor(public dialogRef: MatDialogRef<AdminPanelDialogComponent>,
    private apiService: ApiService,
    private adminService: AdminService) { }

  ngOnInit(): void {
  }

  async submit(library_id: string) {
    console.log('submit');
    if (library_id && library_id.length>0) {
      console.log('library_id is string');
      let libraryExist: boolean = false;
      await this.verifyIfLibraryExist(library_id)
        .then(result => {
          libraryExist = result;
          console.log(`libraryExist: ${JSON.stringify(libraryExist)}`);
        })
        .catch(error => {
          this.emessage = 'Mauvaise id de librarie'; 
          console.log('this.emessage');
        });

      if (libraryExist) {
        console.log(`step 2 libraryExist? ${libraryExist}`);
        this.adminService.library_id = library_id;
        console.log(`update ...`);
        this.adminService.update$.next();
        this.dialogRef.close();
      }
      else {
        this.emessage = 'librarie inexistant';
        console.log('this.emessage');
      }
    }
  }

  async verifyIfLibraryExist(library_id: string): Promise<boolean> {
    return new Promise((resolve, reject) => {
      this.apiService.getLibraryById$(library_id).subscribe(data => {
        resolve(true);
      }, error => {
        reject(false);
      });
    })
  }
}
