#correr la imagen docker
docker run --name api-peliculas -e POSTGRES_PASSWORD=sebaj -e POSTGRES_USER=jabes -e POSTGRES_DB=pelicula-management -p 15432:5432 -d postgres