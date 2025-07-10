FROM node:24-alpine

COPY . /grainger-frontend

WORKDIR /grainger-frontend
RUN npm install

CMD ["npm", "run", "dev", "--", "--host"]