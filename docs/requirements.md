Requirements 
## 1. Project Purpose It is a web-based career management application that allows users to track job postings and their applications through a single system.

## 2. Users The entity contains name, lastname, user title, user id

## 3. Applications --> Application id, application link, application date, application status, 

## 4. Companies --> Company name, company location 

## 5. Jobs --> Job title, job work style, 

## 6. Notes --> Late notes 


## 7. Relationships ...

## 7. Relationships

User - Application
- One User can have many Applications.
- One Application belongs to one User.

Job - Application
- One Job can have many Applications.
- One Application belongs to one Job.

Company - Job
- One Company can have many Jobs.
- One Job belongs to one Company.

Application - Note
- One Application can have many Notes.
- One Note belongs to one Application.



