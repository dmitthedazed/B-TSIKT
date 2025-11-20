# Collaborative Study Platform (Platforma pre spoločné štúdium)

Backendová aplikácia navrhnutá pre študentov na spoluprácu v študijných skupinách, správu úloh, zdieľanie zdrojov a sledovanie pokroku v reálnom čase.

## Funkcionalita

- **Autentifikácia a Autorizácia**: 
  - Bezpečná registrácia a prihlásenie pomocou Spring Security (Session-based).
  - Šifrovanie hesiel pomocou BCrypt.
- **Správa skupín**: 
  - Vytváranie študijných skupín.
  - Pridávanie členov do skupín.
- **Správa úloh**: 
  - Vytváranie úloh v rámci skupín.
  - Nastavenie termínov a aktualizácia stavu úloh (TODO, IN_PROGRESS, DONE).
- **Zdieľanie zdrojov**: 
  - Nahrávanie súborov (PDF, obrázky atď.) do konkrétnych skupín.
  - Sťahovanie zdieľaných zdrojov.
  - Súbory sú uložené lokálne v priečinku `uploads/`.
- **Notifikácie v reálnom čase**: 
  - Integrácia WebSocket (STOMP) na upozornenie členov skupiny o nových úlohách, súboroch alebo členoch.
- **Analytika a Logovanie**: 
  - Sledovanie aktivity používateľov (Activity Logs).
  - Zobrazenie štatistík skupiny (Miera dokončenia úloh).

## Použité technológie

- **Jazyk**: Java 21
- **Framework**: Spring Boot 3.2.3
- **Databáza**: SQLite (s Hibernate dialektom)
- **Bezpečnosť**: Spring Security
- **Real-time**: Spring WebSocket (STOMP)
- **Testovanie**: JUnit 5, Mockito, MockMvc

## Štruktúra projektu

```
Semestralne_Zadanie/
├── src/
│   ├── main/java/com/example/studyplatform/
│   │   ├── config/       # Konfigurácia Security a WebSocket
│   │   ├── controller/   # REST Controllery (API endpointy)
│   │   ├── model/        # JPA Entity (User, Group, Task, atď.)
│   │   ├── repository/   # Spring Data JPA Repozitáre
│   │   └── service/      # Biznis logika
│   └── test/             # Unit a Integračné testy
├── uploads/              # Priečinok pre nahrané súbory
├── study-platform.db     # Súbor SQLite databázy (automaticky generovaný)
├── pom.xml               # Maven závislosti
└── test_api.http         # HTTP požiadavky na testovanie API
```

## Ako spustiť

1. **Prerekvizity**: Uistite sa, že máte nainštalovanú Java 21.
2. **Zostavenie a spustenie**:
   Otvorte terminál v koreňovom adresári projektu a spustite:
   ```bash
   ./mvnw spring-boot:run
   ```
   (Alebo použite tlačidlo "Run" vo vašom IDE).

3. **Prístup**: Server sa spustí na `http://localhost:8080`.

## Použitie API

API môžete testovať pomocou priloženého súboru `test_api.http` vo VS Code (vyžaduje rozšírenie REST Client) alebo pomocou nástroja Postman.

### Kľúčové endpointy:

- **Auth**:
  - `POST /api/auth/register` - Registrácia nového používateľa.
  - `POST /api/auth/login` - Prihlásenie (vráti JSESSIONID).

- **Groups**:
  - `POST /api/groups` - Vytvorenie skupiny.
  - `POST /api/groups/{id}/members` - Pridanie člena.

- **Tasks**:
  - `POST /api/groups/{id}/tasks` - Vytvorenie úlohy.
  - `PUT /api/tasks/{id}/status` - Aktualizácia stavu úlohy.

- **Resources**:
  - `POST /api/groups/{id}/resources` - Nahranie súboru (Multipart).
  - `GET /api/resources/{filename}` - Stiahnutie súboru.

- **Stats**:
  - `GET /api/stats/groups/{id}` - Získanie štatistík skupiny.
