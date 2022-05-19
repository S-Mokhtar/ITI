import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DepartmentListComponent } from './department-list/department-list.component';
import { DepartmentAddComponent } from './department-add/department-add.component';
import { FormsModule } from '@angular/forms';
import { RouterModule,Routes } from '@angular/router';

const routes: Routes = [
  { path: 'list', component: DepartmentListComponent },
  { path: 'add', component: DepartmentAddComponent },
];

@NgModule({
  declarations: [DepartmentListComponent, DepartmentAddComponent],
  imports: [CommonModule, FormsModule, RouterModule.forChild(routes)],
  exports: [DepartmentListComponent, DepartmentAddComponent],
})
export class DepartmentModule {}
