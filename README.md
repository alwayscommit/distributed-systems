# Distributed Systems

Running a load balanced app service with 5 instances

`docker-compose up --scale api=5 --build`

Running a 3-sharded replica set of mongodb

`docker-compose -f docker-compose-shards.yml up`
