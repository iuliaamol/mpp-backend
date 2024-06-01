FROM ubuntu:latest
LABEL authors="moldo"

ENTRYPOINT ["top", "-b"]