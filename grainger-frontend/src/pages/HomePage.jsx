import { Link } from 'react-router-dom';

function HomePage() {
  return (
    <div style={{ padding: '2rem' }}>
      <h1>Grainger Interview</h1>

      <nav style={{ marginTop: '1rem' }}>
        <ul>
          <li><Link to="/products">View Products</Link></li>
          <li><Link to="/products/create">Create Product</Link></li>
        </ul>
      </nav>
    </div>
  );
}

export default HomePage;
