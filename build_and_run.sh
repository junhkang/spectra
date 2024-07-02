#!/bin/bash
npm run build --prefix src/main/frontend
cp -r src/main/frontend/build/* src/main/resources/static/
./mvnw spring-boot:run
