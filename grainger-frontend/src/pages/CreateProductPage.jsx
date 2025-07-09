import { createProduct } from '../api/productApi';
import CreateProduct from '../components/CreateProduct';
import { useNavigate } from 'react-router-dom';

export default function CreateProductPage() {
  const navigate = useNavigate();

  const handleCreate = (newProduct) => {
    createProduct(newProduct)
      .then(() => navigate('/'))
      .catch(err => console.error(err));
  };

  return <CreateProduct onCreate={handleCreate} />;
}
