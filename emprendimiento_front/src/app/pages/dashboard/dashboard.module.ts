import { NgModule } from '@angular/core';
import { CommonModule } from "@angular/common";

import { DashboardRoutingModule } from "./dashboard-routing.module";
import { ChartistModule } from 'ng-chartist';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MatchHeightModule } from "../../shared/directives/match-height.directive";
import { Dashboard2Component } from "./dashboard2/dashboard2.component";
import { NgxDatatableModule } from '@swimlane/ngx-datatable';


@NgModule({
    imports: [
        CommonModule,
        DashboardRoutingModule,
        ChartistModule,
        NgbModule,
        MatchHeightModule,
        NgxDatatableModule
    ],
    exports: [],
    declarations: [
        Dashboard2Component
    ],
    providers: [],
})
export class DashboardModule { }
