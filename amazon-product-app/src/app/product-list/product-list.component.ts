
import { Component, OnInit, ViewChild, AfterViewInit} from '@angular/core';
import {MatTableDataSource, MatPaginator, MatSort,MatSnackBar} from '@angular/material';
import { Product } from '../product';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit, AfterViewInit {

  products: Product[];

  loading = false;

  dataSource = new MatTableDataSource<any>(this.products);

  displayedColumns = ['productTitle', 'asin', 'category', 'rank', 'dimensions'];
  pageSize = 4;

  @ViewChild(MatPaginator, {static: false}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: false}) sort: MatSort;

  constructor(public snackBar: MatSnackBar, private productService: ProductService) {}

  deleteCustomer(id) {
    let snackBarRef = this.snackBar.open(`Deleting customer #${id}`);
  }

  editCustomer(id) {
    let snackBarRef = this.snackBar.open(`Editing customer #${id}`);
  }
  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  ngOnInit(): void {
    this.loading = true;
    this.productService.getProducts().subscribe(
      (d: Product[]) => {
        this.dataSource.data = d;
        this.loading = false;
      }
    );
  }

}
