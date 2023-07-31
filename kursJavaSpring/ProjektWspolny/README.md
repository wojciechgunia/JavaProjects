Docker command to run database: 
docker run --name sklepdb -p 5432:5432 -e POSTGRES_PASSWORD=postgres -d postgres