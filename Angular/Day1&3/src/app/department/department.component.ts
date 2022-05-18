import { Component, OnInit } from '@angular/core';
import { Department } from 'src/app/_models/department';

@Component({
  selector: 'app-department',
  templateUrl: './department.component.html',
  styleUrls: ['./department.component.css'],
})
export class DepartmentComponent implements OnInit {
  names: string[] = ['Ahmed', 'Ali', 'Aliaa', 'Shaimaa'];

  productToEdit: string | null = null;
  product: Department = new Department('', '', new Date(), 0, 0, 'os logo.png');
  products: Department[] = [];
  showImage = false;
  constructor() {}

  ngOnInit(): void {}

  showImages() {
    this.showImage = true;
  }

  add() {
    let product: Department = new Department(
      this.product.name,
      this.product.code,
      this.product.available,
      parseInt(this.product.price.toString()),
      parseInt(this.product.rate.toString()),
      this.product.image
    );
    this.products.push(product);
  }

  show(name: string) {
    this.products.forEach((product) => {
      if (product.name === name) {
        this.product = product;
      }
    });
  }

  delete(name: string) {
    this.products.forEach((product, index) => {
      if (product.name === name) {
        this.products.splice(index, 1);
      }
    });
  }

  edit(name: string) {
    this.productToEdit = name;
  }

  update() {
    this.products.forEach((product) => {
      if (product.name === this.productToEdit) {
        let productUpdated: Department = new Department(
          this.product.name,
          this.product.code,
          this.product.available,
          parseInt(this.product.price.toString()),
          parseInt(this.product.rate.toString()),
          this.product.image
        );
        product.name = productUpdated.name;
        product.code = productUpdated.code;
        product.available = productUpdated.available;
        product.price = productUpdated.price;
        product.rate = productUpdated.rate;
      }
    });
  }
}
