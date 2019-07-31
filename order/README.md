###Step 1 : Configure Postgres Database using docker

```bash
$ docker run --name or_postgres --network my-net -p 5431:5432 -e POSTGRES_USER=or_dbuser -e POSTGRES_DB=order_db -e POSTGRES_PASSWORD=or_pass -d postgres
```

Note : if the container is already running :

```bash
$ docker start or_postgres 
```

To create orders_db :

```bash
docker exec -it or_postgres psql -d postgres -U or_dbuser -c "CREATE DATABASE order_db;
docker exec -it or_postgres psql -d postgres -U or_dbuser -c "GRANT ALL PRIVILEGES ON DATABASE order_db TO or_dbuser;
```

###Step 2: Build Order service using mvn

```bash
mvn clean install -DskipTests
```

###Step 3: Building the docker image from project

```bash
docker image build -f Dockerfile -t 'order:1.0.0' .
```

Once the above process is completed, you can verify whether the docker image is built successfully with following command.

```bash
docker image ls
```

###Step 4: Run the order service

```bash
docker run -d --name order --network my-net --link or_postgres:postgres -p 8081:8081 order:1.0.0
```


# Docker with k8 in Minikube


###Step 1:  Start minikube and refer local docker repo
```bash
$ sudo minikube start
$ eval $(sudo minikube docker-env)
```

###Step 2:  Configure Postgres Database using docker
```bash
$ kubectl apply -f Postgrs-config.yaml
```

###Step 2: Build Order service using mvn

```bash
$ mvn clean install -DskipTests
```

###Step 3: Building the docker image from project

```bash
$ docker image build -f Dockerfile -t 'order:1.0.0' .
```

Once the above process is completed, you can verify whether the docker image is built successfully with following command.

```bash
$ docker image ls
```

###Step 4: Run the order service

```bash
$ kubectl apply -f order.yaml
```

###Step 5: Access product service

To access a service exposed via a node port, run this command in a shell after starting Minikube to get the address:

```bash
$ sudo minikube service order-service
```


