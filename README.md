Deploying Spring Boot on Railway with PostgreSQL

**Tech Stack**
- Spring Boot 4.0.2, Java 21, Hibernate 7.2.1, HikariCP, PostgreSQL driver 42.7.9
- Build tool: Gradle
- Platform: Railway

---

**1. Deploy the App**
1. Go to [railway.app](https://railway.app) → New Project → Deploy from GitHub repo
2. Select your repository — Railway auto-detects Gradle and builds it
3. Make sure "gradlew" and "build.gradle" are committed to the repo
4. Add this to "application.properties" so Railway's injected port is used:

   server.port=${PORT:8080}

**2. Add PostgreSQL**
1. Inside Railway project, click **+ New → Database → Add PostgreSQL**
2. Railway spins up a managed PostgreSQL instance automatically

**3. Link the Database to Your App**
1. Open **app service** in Railway
2. Go to the **Variables** tab
3. Click **Add Reference** → select the PostgreSQL service
4. Save — Railway will inject the DB variables into app container

---

### 4. Configure application.properties
Railway injects "DATABASE_URL" as a "postgresql://" URL which the JDBC driver **rejects**. Use the individual variables instead:


spring.datasource.url=jdbc:postgresql://${PGHOST}:${PGPORT}/${PGDATABASE}
spring.datasource.username=${PGUSER}
spring.datasource.password=${PGPASSWORD}
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update

server.port=${PORT:8080}

**5. Redeploy**
Push changes to GitHub, Railway redeploys automatically. Check the logs for a successful startup message.
