import axios from 'axios';

const API_BASE = 'http://grainger-backend:8080/products';

export const getAllProducts = () => axios.get(API_BASE);
export const getProductById = (productId) => axios.get(`${API_BASE}/${productId}`);
export const createProduct = (product) => axios.post(API_BASE, product);
