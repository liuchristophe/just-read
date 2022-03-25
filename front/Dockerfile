FROM node:16.14.2 as node
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build --prod

FROM nginx:alpine
COPY --from=node /app/dist/just-read-front /usr/share/nginx/html