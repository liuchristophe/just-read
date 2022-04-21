### STAGE 1: Build ###
FROM node:16.14.2 as node
WORKDIR /app
COPY package.json .
RUN npm install
COPY . .
RUN npm run build

### STAGE 2: Run ###
FROM nginx:1.17.1-alpine as angular
COPY --from=node /app/default.conf /etc/nginx/conf.d/default.conf
COPY --from=node /app/dist/just-read-front /usr/share/nginx/html
EXPOSE 80