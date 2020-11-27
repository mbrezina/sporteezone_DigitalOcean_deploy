# potřeba přepsat do Vue

#FROM node:12.19.0-alpine3.12
#WORKDIR /usr/src/js-service
#COPY package*.json ./
#RUN npm install --only=production
#COPY ./src .
#CMD [ "node", "app.js" ]


FROM node:lts-alpine

# install simple http server for serving static content
RUN npm update && npm install -g http-server

# make the 'app' folder the current working directory
WORKDIR /usr/src/js-service/sportee-vue

# copy both 'package.json' and 'package-lock.json' (if available)
COPY package*.json ./

# install project dependencies
RUN npm install

# copy project files and folders to the current working directory (i.e. 'app' folder)
COPY ./sportee-vue .

# build app for production with minification
RUN npm run build

EXPOSE 8082
CMD [ "npm", "run", "serve" ]
