import { RouteInfo } from './sidebar.metadata';

export const ROUTES_EMPRENDEDOR: RouteInfo[] = [

    {
        path: '/dashboard', title: 'Inicio', icon: 'ft-layout', class: '', badge: '', badgeClass: '', isExternalLink: false, submenu: []
    },

    {
        path: '', title: 'EMPRENDEDOR', class: 'has-sub', icon: 'ft-align-left', badgeClass: '', badge: '', 
        isExternalLink: false,
        submenu: [
            {
                path: '/emprendedor/registro', title: 'Registrar', icon: 'ft-file-text', class: '', badge: '', 
                badgeClass: '', isExternalLink: false, submenu: []
            },
            {
                path: '/emprendedor/gestion', title: 'Gestion de emprendimientos', icon: 'ft-file-text', class: '', 
                badge: '', badgeClass: '', isExternalLink: false, submenu: []
            },
        ]
    },
    
];

export const ROUTES_INVERSOR: RouteInfo[] = [

    {
        path: '/dashboard', title: 'Inicio', icon: 'ft-layout', class: '', badge: '', badgeClass: '', isExternalLink: false, submenu: []
    },
   
];
