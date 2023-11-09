import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MainComponent } from './user/main/main.component';
import { ArtistsComponent } from './user/artists/artists.component';
import { IstrumentsComponent } from './user/istruments/istruments.component';
import { RecordsComponent } from './user/records/records.component';
import { ProfileComponent } from './user/profile/profile.component';

const routes: Routes = [
  { path: '', component: MainComponent },
  { path: 'artist', component: ArtistsComponent },
  { path: 'instruments', component: IstrumentsComponent },
  { path: 'record', component: RecordsComponent },
  { path: 'profile', component: ProfileComponent },

  {
    path: 'user',
    loadChildren: () => import('./user/user.module').then((m) => m.UserModule),
  },
  {
    path: 'admin',
    loadChildren: () =>
      import('./admin/admin.module').then((m) => m.AdminModule),
  },
  { path: '**', redirectTo: '' },
];
@NgModule({
  imports: [
    RouterModule.forRoot(routes, {
      useHash: true,
    }),
  ],
  exports: [RouterModule],
})
export class AppRoutingModule {}
