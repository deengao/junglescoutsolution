import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material';
import { ProductService } from '../product.service';
import { Product } from '../product';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  asin = '';
  loading = false;

  constructor(public snackBar: MatSnackBar, private productService: ProductService) {}

  ngOnInit() {
  }

  getProduct() {
    this.loading = true;
    this.productService.getProduct(this.asin).subscribe(
      (d: Product) => {
        this.loading = false;
        this.snackBar.open(`Product fetched #${this.asin}`, 'Dimiss', {
          duration: 2000
        });
      },
      error => {
        this.loading = false;
        this.snackBar.open(`Sorry we have problem fetching #${this.asin}`, 'Dimiss', {
          duration: 2000
        });
      }
    );
  }

}
