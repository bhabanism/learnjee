# Learning JEE

## Concepts
* Authentication
* Data Validation, Integrity, Consistency, Encryption
* Security
* Code Reusabilty
* Seperation of Concerns 
* Tiered Architecture
* Less Interdependencies, Decoupled
* Transaction Management


## Architecture
* Interface - Textual/Markdown (Presentation Layer)
* App - Business Layer
* Data Layer (SQL/Text Files)

## Flow 
1. Authentication
2. Commands/Requests
3. Persistance of data (sensitive data)

## Idea
* Fake Wallet
    - Open Account
    - Close Account
    - View Balance (/ Statement - out of scope)
    - Deposit Amount
    - Purchase Item

## Creating a Maven Project
    mvn archetype:generate -DgroupId=com.bsm -DartifactId=fake-wallet -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

### Tasks
* Open in IDEA
* Move code to appropriate package structure
* Add unit tests, mock the data source

