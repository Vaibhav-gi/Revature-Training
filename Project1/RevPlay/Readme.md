🎵 RevPlay – Console-Based Music Streaming Application
## Project Requirements & Technical Documentation

**Project Name:** RevPlay
**Application Type:** Console-Based Java Application
**Technology Stack:** Java 21, JDBC, MySQL
**Architecture:** Layered (UI → Service → DAO → Database)
**Development Model:** Modular / Incremental

----------------------------------------------------------------------------------

## 1. PROJECT OVERVIEW
###  1.1 Project Vision

RevPlay is a console-based music streaming application that allows users to explore songs, manage playlists, mark favorites, and simulate music playback. Artists can register, manage profiles, upload songs, create albums, and track song performance.

The application is designed with a clean backend architecture and normalized database schema, making it easily extendable to a web or microservices-based system in future phases.

### 1.2 Project Objectives
- Provide secure user and artist authentication
- Enable music discovery via search and browsing
- Allow artists to upload and manage music content
- Support playlists, favorites, and listening history
- Track song play counts and analytics
- Maintain strict data ownership and integrity

### 1.3 Success Criteria
- All core user and artist features work via console
- Secure login with hashed credentials
- Relational database integrity enforced via foreign keys
- Clean separation of concerns (UI, Service, DAO)
- No unauthorized data access (ownership enforced)

----------------------------------------------------------------------------------

## 2. USER ROLES

### 2.1 Listener (USER)
- A normal user who consumes music.

### 2.2 Musician / Artist (ARTIST)
- A user with elevated privileges who can upload and manage music content.

Note: Artists are users with role = ARTIST.
There is a single authentication source (users table).

----------------------------------------------------------------------------------

## 3. CORE FUNCTIONAL REQUIREMENTS

### 3.1 User Features
- Register and create an account
- Login with email and password
- Change password
- Recover forgotten password using security question
- Search songs by keyword
- Browse music by artist and album
- Play songs (text-based simulation)
- Automatically increment play count on each play
- View listening history
- Mark songs as favorites
- View and remove favorite songs
- Create playlists (public/private)
- Add songs to playlists
- Remove songs from playlists
- View own playlists
- View public playlists created by other users
- Delete playlists owned by the user

### 3.2 Artist Features
- Register as an artist
- Login securely
- Create and manage artist profile
- Upload songs with metadata (title, genre, duration)
- View uploaded songs
- Delete own songs
- Create albums
- Add songs to albums (ownership enforced)
- View albums created by self
- Track play count of songs
- See which songs are favorited by users

----------------------------------------------------------------------------------

## 4. DATABASE DESIGN (ER OVERVIEW)

### 4.1 Core Tables
* users – authentication & roles
* artists – artist profile (1–1 with users)
* songs – uploaded music
* albums – artist-owned albums
* playlists – user-created playlists
* playlist_songs – playlist–song mapping
* user_favorites – favorite songs
* listening_history – play history

### 4.2 Key Relationships
- One User → Many Playlists
- One Artist (User) → Many Songs
- One Artist → Many Albums
- One Album → Many Songs
- Many Users ↔ Many Songs (Favorites)
- Many Playlists ↔ Many Songs
- Ownership is enforced at query level (artist_id / user_id checks).

----------------------------------------------------------------------------------

## 5. APPLICATION ARCHITECTURE

### 5.1 Layered Architecture

Console UI (Main.java)
        ↓
Service Layer (Business Logic)
        ↓
DAO Layer (JDBC)
        ↓
MySQL Database

### 5.2 Layer Responsibilities
- UI Layer
- Console menus
- User input/output
- No business logic
- No SQL
- Service Layer
- Business rules
- Ownership validation
- Orchestration between DAOs
- User-friendly messages
- DAO Layer
- Pure JDBC operations
- SQL queries only
- No business decisions
- Database Layer
- Normalized schema
- Foreign key constraints
- Data integrity enforcement

----------------------------------------------------------------------------------

## 6. TECHNOLOGY STACK
- Layer	Technology
- Language	Java 21
- Database	MySQL
- Persistence	JDBC
- Security	SHA-based hashing
- IDE	IntelliJ IDEA
- Version Control	Git

----------------------------------------------------------------------------------

## 7. SECURITY MEASURES
- Passwords stored as hashed values
- Security questions for password recovery
- Role-based access control
- Ownership enforced in SQL queries
- No direct database access from UI

----------------------------------------------------------------------------------

## 8. COMPLETION STATUS
Feature Group	Status
Authentication	✅ Completed
Artist Profile	✅ Completed
Song Management	✅ Completed
Album Management	✅ Completed
Playlist Management	✅ Completed
Favorites	✅ Completed
Listening History	✅ Completed
Play Count Analytics	✅ Completed

----------------------------------------------------------------------------------

## 9. LIMITATIONS (INTENTIONAL)
- Console-based UI only
- No streaming (text simulation only)
- No external APIs
- No admin dashboard
- No payment or subscriptions
- These were out of scope by design.

----------------------------------------------------------------------------------

## 10. FUTURE ENHANCEMENTS
- Web interface using Spring Boot
- REST APIs
- JWT-based authentication
- Microservices architecture
- Recommendation engine
- Cloud deployment

----------------------------------------------------------------------------------

## 11. HOW TO RUN THE PROJECT
- Clone the repository
- Import into IntelliJ IDEA
- Configure MySQL database
- Add MySQL Connector JAR to classpath
- Run Main.java
- Use console menus to interact

----------------------------------------------------------------------------------

## 12. CONCLUSION
- RevPlay demonstrates a solid understanding of:
- Java backend development
- JDBC and relational databases
- Clean architecture principles
- Role-based access control
- Data integrity enforcement
- The project is stable, explainable, and evaluation-ready.

----------------------------------------------------------------------------------

** 📌 Author **

Vaibhav Pawar
B.Tech – Information Technology
Java Backend Developer

==================================================================================