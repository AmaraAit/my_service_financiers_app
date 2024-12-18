import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
        {
        path: 'acceuil',
        component: AccountComponent
        },
        {
        path: 'services',
        component: AccountComponent
        },
        {
        path: 'login',
        component: LoginComponent
        }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
