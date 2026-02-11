# NTI_Software_Testing_4_Months
**Task 1** 
___________________________________
📘 Business Requirements Document (BRD) – Library Management System
________________________________________
1. Introduction
1.1 Purpose
This BRD describes the requirements for a Library Management System (LMS) that manages books, members, borrowing transactions, and returns using a database called LibraryDB.
1.2 Scope
The system will allow:
•	Adding & managing books
•	Registering library members
•	Borrowing and returning books
•	Tracking due dates and overdue books
•	Viewing borrowing history
________________________________________
2. System Overview
The LMS will be used by librarians and system administrators.
All actions must be stored in the LibraryDB.
________________________________________
3. Functional Requirements
________________________________________
FR-1: Add Book
The system shall allow the librarian to add a new book with the following fields:
•	Title (mandatory)
•	Author (mandatory)
•	Category
•	ISBN (unique, mandatory)
•	Publish Year
•	Quantity (number of available copies)
Business Rules:
•	ISBN must be unique.
•	Quantity must be ≥ 0.
________________________________________
FR-2: Register Member
The system shall allow registering a new library member with:
•	Full Name (mandatory)
•	Email (mandatory, unique)
•	Phone
•	Membership Date (auto default = today)
________________________________________
FR-3: Borrow Book
The librarian shall be able to issue a book to a member.
Input:
•	Member ID
•	Book ID
•	Borrow Date (default today)
•	Due Date (Borrow Date + 14 days)
Business Rules:
•	Book quantity must be > 0
•	Member cannot borrow more than 5 active books
•	On borrow: quantity decreases by 1
System Action:
•	Insert record into Borrowing table
________________________________________
FR-4: Return Book
The librarian shall mark a book as returned.
Input:
•	Borrowing ID
•	Return Date
System Action:
•	Update Borrowing record
•	Increase Book quantity by 1
•	If Return Date > Due Date → mark as “Late Return”
________________________________________
FR-5: View Borrowing History
The librarian can search:
•	Borrowing by Member ID
•	Borrowing by Book ID
•	Overdue books
•	Books currently borrowed
________________________________________
4. Non-Functional Requirements
NFR-1 Performance
Database queries must return results within < 2 seconds.
NFR-2 Security
Only authorized librarian/admin can modify book and member data.
NFR-3 Data Integrity
Foreign key relationships must be enforced between tables.
________________________________________
5. Assumptions
•	A simple UI exists for the librarian.
•	System clock is correct.
•	Members must be registered before borrowing.
________________________________________
6. High-Level LibraryDB Schema
Tables:
•	Books
•	Members
•	Borrowing
________________________________________
________________________________________
🚀 Agile User Stories (For the Same System)
________________________________________
📌 Epic 1: Book Management
US-1: Add Book
As a librarian
I want to add new books to the system
So that they are available for borrowing.
Acceptance Criteria:
•	Must include title, author, ISBN
•	ISBN must be unique
•	Quantity must be ≥ 0
________________________________________
US-2: Edit Book Information
As a librarian
I want to update book details
So that incorrect information can be fixed.
Acceptance Criteria:
•	Only title, author, category, quantity can be changed
•	ISBN cannot be changed
________________________________________
📌 Epic 2: Member Management
US-3: Register new member
As a librarian
I want to register a new member
So that they can borrow books.
Acceptance Criteria:
•	Email must be unique
•	Membership date auto-set to today
________________________________________
📌 Epic 3: Borrowing & Returning
US-4: Borrow a book
As a librarian
I want to issue a book to a member
So that the system records borrowing transactions.
Acceptance Criteria:
•	Member cannot borrow > 5 books
•	Book quantity must be > 0
•	Due date auto-set to 14 days
________________________________________
US-5: Return a book
As a librarian
I want to mark books as returned
So that availability is updated.
Acceptance Criteria:
•	Return date must be stored
•	Quantity increases by 1
•	System marks if overdue
________________________________________
📌 Epic 4: Reporting
US-6: View borrowing history
As a librarian
I want to see borrowing history for any member
So that I can check overdue or returned items.
________________________________________
US-7: View overdue books
As a librarian
I want to see a list of overdue books
So that I can contact members.

# Implementation
**Team work by members:**
- Nadine Ashraf.
- Amira Samy.
- Habeba Abdelhady.
- Karima Ayman.
- Maria Fekry
  
**The work is done on JIRA tool**

  **Link:** https://habebaabdelhady54-1770709554543.atlassian.net/projects/LMS?selectedItem=com.atlassian.plugins.atlassian-connect-plugin:com.kanoah.test-manager__main-project-page#!/v2/testCase/NTI-T65
