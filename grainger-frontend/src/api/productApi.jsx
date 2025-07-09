import axios from 'axios';

const API_BASE = 'http://localhost:8080/products'; // change if needed

export const getAllProducts = () => axios.get(API_BASE);
export const getProductById = (id) => axios.get(`${API_BASE}/${id}`);
export const createProduct = (product) => axios.post(API_BASE, product);
