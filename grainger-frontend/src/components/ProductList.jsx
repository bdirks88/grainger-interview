import { Link } from 'react-router-dom';

export default function ProductList({ products }) {
  return (
    <ul>
      {products.map(product => (
        <li key={product.productId}>
          <Link to={`/products/${product.productId}`}>
            {product.name}
          </Link>
        </li>
      ))}
    </ul>
  );
}
