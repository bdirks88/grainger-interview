import { useState } from 'react';

function CreateProduct({ onCreate }) {
  const [name, setName] = useState('');

  const handleSubmit = e => {
    e.preventDefault();
    onCreate({ name });
    setName('');
  };

  return (
    <form onSubmit={handleSubmit}>
      <input
        value={name}
        onChange={e => setName(e.target.value)}
        placeholder="Product name"
        required
      />
      <button type="submit">Create</button>
    </form>
  );
}

export default CreateProduct