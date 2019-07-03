import { Injectable } from '@angular/core';
import { PRODUCT_API_URL } from './app.constants';
import { HttpClient, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  getProductServiceName = 'amazonProduct/getAmazonProduct';
  getProductsServiceName = 'amazonProduct/getAmazonProducts';
  constructor(private http: HttpClient) { }

  getProduct(asin) {
    const options = asin ?
    { params: new HttpParams().set('asin', asin) } : {};
    return this.http.get(PRODUCT_API_URL + this.getProductServiceName, options);
  }
  getProducts() {
    return this.http.get(PRODUCT_API_URL + this.getProductsServiceName);
  }

}
