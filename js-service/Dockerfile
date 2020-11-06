# potřeba přepsat do Vue


FROM node:12.19.0-alpine3.12

WORKDIR /usr/src/js-service

COPY package*.json ./

RUN npm install --only=production

COPY ./src .

CMD [ "node", "app.js" ]
