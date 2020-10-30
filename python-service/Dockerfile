FROM python:3.6.6-slim

ADD requirements.txt /usr/src/python-service/
ADD src /usr/src/python-service/src

RUN cd /usr/src/python-service && pip install -r requirements.txt --no-cache-dir

WORKDIR "/usr/src/python-service"

CMD [ "python3", "./src/main.py" ]
