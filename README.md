# GritUthyrningAB

Ett REST API utvecklat i Java och Spring Boot som en del av en backend uppgift på Gritacademy.

Applikationen demonstrerar utveckling av REST API:er, CRUD-operationer, relation mellan databaser och entitet.

## Funtioner


- Skapa, hämta, uppdatera och ta bort personer
- Skapa, hämta, uppdatera och ta bort uthyrningsverktyg
- Hantera uthyrningar
- Koppla verktyg till personer genom uthyrningsförfrågningar
- Förhindra dubbeluthyrning av verktyg
- Registrera återlämnade verktyg
- Spara uthyrningshistorik
- Hantera uthyrningsdatum, förfallodatum och återlämningsdatum
- Hantera uthyrningsstatus
- Många-till-många-relation mellan personer och verktyg
- Validering av inkommande data med Jakarta Bean Validation
- Centraliserad felhantering
- Strukturerade felsvar med lämpliga HTTP-statuskoder
- API-dokumentation med Swagger UI
- Datalagring med PostgreSQL

## API

### GritUthyrningAB REST API

Applikationen tillhandahåller REST-endpoints för att hantera personer, verktyg och uthyrningar.

API:et används bland annat för att: 

- Hämta alla personer och verktyg
- Hämta en specifik person eller ett verktyg via ID
- Skapa nya personer och verktyg
- Uppdatera befintliga uppgifter
- Ta bort personer och verktyg
- Skapa nya uthyrningar
- Registrera återlämnade verktyg
- Hämta information om uthyrningar och uthyrningshistorik


## Swagger UI

Swagger UI används för att utforska och testa API:ets tillgängliga endpoints.

När applikkationen körs lokalt finns dokumentationen på: 
    http://localhost:8081/swagger-ui/index.html

## Applikationens struktur

Applikationen är uppdelad i controllers, services, modeller, repositories och request-objekt.

### Person-modell

Person representerar en person som kan hyra utrustning.
Modellen inehåller information som: 
- Personens ID
- Fullständigt namn
- E-postadress
- Telefonnummer
Denna entitet är kopplad till Tool genom många-till-många relation

### Tool-modell

Tool representerar utrustning som kan hyras.

Modellen innehåller information som: 
- Verktygets ID
- Verktygets namn
- Verktygets beskrivning
Denna entitet är kopplad till personer genom många-till-många relation.

### Loan-modell

Loan representerar en enskild uthyrning.

Modellen innehåller information som:
- Uthyrningens ID
- Personen som hyr
- Verktyget som hyrs
- Uthyrningsdatum
- Förfallodatum
- Återlämningsdatum
- Uthyrningsstatus
Loan gör det möjligt att spara uthyrningshistorik även efter att ett verktyg har återlämnats.

### BorrowRequest


BorrowRequest representerar inkommande uthyrningsförfrågningar.

Klassen innehåller den information som behövs för att skapa en uthyrning, exempelvis:
- Personens ID
- Verktygets ID
- Förfallodatum
Förfrågan valideras innan uthyrningen behandlas.

### Controllers

Controllers hanterar inkommande HTTP-förfrågningar och returnerar svar till klienten.
Applikationen innehåller controllers för att hantera personer, verktyg och uthyrningar.
De tillhandahåller endpoints för CRUD-operationer och uthyrningsrelaterade funktioner.

### Services

Service-klasserna innehåller applikationens logik.

De hanterar bland annat:
- Skapande och uppdatering av uppgifter
- Hämtning av personer, verktyg och uthyrningar
- Kontroll av verktygens tillgänglighet
- Förhindrande av dubbeluthyrning
- Registrering av återlämnade verktyg
- Bevarande av uthyrningshistorik

### Repositories

Repository-gränssnitten hanterar kommunikationen med databasen genom Spring Data JPA.
De tillhandahåller funktioner för att hämta, spara, uppdatera och ta bort data.

### Global Exception Handler

GlobalExceptionHandler hanterar valideringsfel centralt.

Den returnerar strukturerade felsvar som innehåller information såsom:
- HTTP-statuskod
- Felrubrik och felbeskrivning
- Ogiltiga fältvärden
- Valideringsmeddelanden
- Tidsstämpel
Detta gör felhanteringen mer enhetlig och hjälper användaren att förstå vad som behöver korrigeras när ogiltiga uppgifter skickas till API:et.

## Tekniker

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- PostgreSQL
- Docker
- Jakarta Bean Validation
- REST API
- JSON
- Maven
- Swagger UI / OpenAPI
- Postman