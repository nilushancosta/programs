FROM python:3.9-alpine

RUN addgroup -S runuser \
    && adduser -S appuser -G runusergroup

RUN LC_ALL=C tr -dc A-Za-z0-9 </dev/urandom | head -c 20000000 > 20MB.txt
COPY *MB.txt .
COPY requirements.txt .
COPY app.py .

USER runuser

RUN python3 -m pip install -r requirements.txt
CMD python3 app.py
