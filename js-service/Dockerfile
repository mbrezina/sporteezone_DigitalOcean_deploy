
FROM node:lts-alpine
WORKDIR /usr/src/js-service/sportee-vue
COPY ./sportee-vue .
RUN npm install
EXPOSE 8081
CMD [ "npm", "run", "serve" ]
