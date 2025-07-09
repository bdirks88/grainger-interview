function ProductDetail({ product }) {
    if (!product) {
    return <p>Loading product...</p>;
  }
  
  return (
    <div>
      <h2>{product.name}</h2>
      {/* Add other fields if needed */}
    </div>
  );
}

export default ProductDetail
