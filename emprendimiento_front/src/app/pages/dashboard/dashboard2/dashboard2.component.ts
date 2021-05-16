import { Component, APP_INITIALIZER, OnInit, ViewChild } from '@angular/core';
import { DatatableComponent } from '@swimlane/ngx-datatable';
import { EmprendimientoService } from 'app/pages/emprendedor/services/emprendimiento.service';
import * as Chartist from 'chartist';
import { ChartType, ChartEvent } from "ng-chartist";

declare var require: any;

const data: any = require('../../../shared/data/chartist.json');


export interface Chart {
    type: ChartType;
    data: Chartist.IChartistData;
    options?: any;
    responsiveOptions?: any;
    events?: ChartEvent;
}

@Component({
    selector: 'app-dashboard2',
    templateUrl: './dashboard2.component.html',
    styleUrls: ['./dashboard2.component.scss']
})

export class Dashboard2Component implements OnInit {
    nombre$;
    emprendimientos$;
    @ViewChild(DatatableComponent) table: DatatableComponent;
    emprendimiento$;
    rows = [];
    columns = [{name: 'nombre'},{name: 'descripcion'}];
    temp = [];
    constructor(private emprendimientoService: EmprendimientoService) {

    }
    ngOnInit(): void {
        this.nombre$ = localStorage.getItem('nombre');
        this.emprendimientoService.obtenerEmprendimientos()
        .subscribe(
          data => {
            console.log(data);
            this.emprendimientos$ = data;
            this.temp = data;
            this.rows = data;
          },
          error => {}
        );
    }

    updateFilter(event) {
        //this.piarescolarItem = null;
        const val = event.target.value.toLowerCase();
    
        // filter our data
        const temp = this.temp.filter(function (d) {
            return d.nombre.toString().toLowerCase().indexOf(val) !== -1 || !val;
        });
    
        // update the rows
        this.rows = temp;
        // Whenever the filter changes, always go back to the first page
        this.table.offset = 0;
    }

}
