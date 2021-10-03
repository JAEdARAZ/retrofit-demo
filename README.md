# retrofit base structure dockerized
Create docker image: `docker build --tag movies-api:1.0 .`

Run container: `docker run -d -p 8080:8080 --env tmdb.api.key=INSERT_HERE_TMDB_API_KEY movies-api:1.0`
