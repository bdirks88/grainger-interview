import React, { useEffect, useState } from 'react';
import { getAllProducts } from '../api/productApi';
import ProductList from '../components/ProductList';

function ProductPage() {
  const [products, setProducts] = useState([]);

useEffect(() => {
  getAllProducts()
    .then(res => {
      console.log(res.data);
      setProducts(res.data);
    })
    .catch(err => {
      console.error("Failed to fetch products:", err);
    });
}, []);

  return (
    <div>
      <h1>Products</h1>
      <ProductList products={products} />
    </div>
  );
}

export default ProductPage;
