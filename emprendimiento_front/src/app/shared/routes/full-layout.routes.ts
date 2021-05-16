import { Routes, RouterModule } from '@angular/router';
import { AuthGuardEmprendimientoService } from '../auth/auth-guard-emprendimiento.service';

//Route for content layout with sidebar, navbar and footer
export const Full_ROUTES: Routes = [
  {
    path: 'changelog',
    loadChildren: () => import('../../changelog/changelog.module').then(m => m.ChangeLogModule)
  },
  {
    path: 'full-layout',
    loadChildren: () => import('../../pages/full-layout-page/full-pages.module').then(m => m.FullPagesModule)
  },
  {
    path: 'dashboard',
    loadChildren: () => import('../../pages/dashboard/dashboard.module').then(m => m.DashboardModule)
  },
  {
    path: 'emprendedor',
    canActivate : [AuthGuardEmprendimientoService],
    loadChildren: () => import('../../pages/emprendedor/emprendedor.module').then(m => m.EmprendedorModule)
  }
];
