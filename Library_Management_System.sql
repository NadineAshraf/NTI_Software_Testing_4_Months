CREATE DATABASE LibraryDB;
USE LibraryDB;
CREATE TABLE Books
(
    BookID INT AUTO_INCREMENT PRIMARY KEY,
    Title VARCHAR(50) NOT NULL,
    Author VARCHAR(50) NOT NULL,
    Category VARCHAR(50),
    ISBN BIGINT NOT NULL UNIQUE,
    PublishYear DATE,
    Quantity INT NOT NULL CHECK (Quantity >= 0)
);

CREATE TABLE Members
(
    MemberID INT AUTO_INCREMENT PRIMARY KEY,
    FullName VARCHAR(50) NOT NULL,
    Email VARCHAR(50) NOT NULL UNIQUE,
    Phone VARCHAR(15),
    MembershipDate DATE NOT NULL DEFAULT (CURRENT_DATE)
);


CREATE TABLE Borrowing
(
    BorrowingID INT AUTO_INCREMENT PRIMARY KEY,
    MemberID INT NOT NULL,
    BookID INT NOT NULL,
    BorrowDate DATE NOT NULL,
    DueDate DATE NOT NULL,
    ReturnDate DATE,
    Status VARCHAR(20) NOT NULL,

    CONSTRAINT fk_borrowing_member
        FOREIGN KEY (MemberID)
        REFERENCES Members(MemberID),

    CONSTRAINT fk_borrowing_book
        FOREIGN KEY (BookID)
        REFERENCES Books(BookID)
);
DELIMITER $$

CREATE TRIGGER trg_borrowing_bi
BEFORE INSERT ON Borrowing
FOR EACH ROW
BEGIN
    SET NEW.Status = 'Borrowed';
END$$

DELIMITER ;
DELIMITER $$

CREATE TRIGGER trg_borrowing_bu
BEFORE UPDATE ON Borrowing
FOR EACH ROW
BEGIN
    IF NEW.ReturnDate IS NOT NULL THEN
        IF NEW.ReturnDate > OLD.DueDate THEN
            SET NEW.Status = 'Late Return';
        ELSE
            SET NEW.Status = 'Returned';
        END IF;
    END IF;
END$$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE AddBook
(
    IN pTitle VARCHAR(50),
    IN pAuthor VARCHAR(50),
    IN pCategory VARCHAR(50),
    IN pISBN BIGINT,
    IN pPublishYear DATE,
    IN pQuantity INT
)
BEGIN
    IF pQuantity < 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Quantity must be >= 0';
    END IF;

    INSERT INTO Books
    (Title, Author, Category, ISBN, PublishYear, Quantity)
    VALUES
    (pTitle, pAuthor, pCategory, pISBN, pPublishYear, pQuantity);
END$$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE RegisterMember
(
    IN pFullName VARCHAR(50),
    IN pEmail VARCHAR(50),
    IN pPhone VARCHAR(15)
)
BEGIN
    INSERT INTO Members
    (FullName, Email, Phone)
    VALUES
    (pFullName, pEmail, pPhone);
END$$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE BorrowBook
(
    IN pMemberID INT,
    IN pBookID INT
)
BEGIN
    DECLARE vQty INT;
    DECLARE vCount INT;
    DECLARE vBorrowDate DATE;
    DECLARE vDueDate DATE;

    SET vBorrowDate = CURRENT_DATE;
    SET vDueDate = DATE_ADD(vBorrowDate, INTERVAL 14 DAY);

    SELECT Quantity
    INTO vQty
    FROM Books
    WHERE BookID = pBookID;

    IF vQty IS NULL THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Book not found';
    END IF;

    IF vQty <= 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Book not available';
    END IF;

    SELECT COUNT(*)
    INTO vCount
    FROM Borrowing
    WHERE MemberID = pMemberID
      AND ReturnDate IS NULL;

    IF vCount >= 5 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Member reached borrowing limit';
    END IF;

    START TRANSACTION;

    INSERT INTO Borrowing
    (
        MemberID, BookID, BorrowDate, DueDate, ReturnDate
    )
    VALUES
    (
        pMemberID, pBookID, vBorrowDate, vDueDate, NULL
    );

    UPDATE Books
    SET Quantity = Quantity - 1
    WHERE BookID = pBookID;

    COMMIT;
END$$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE ReturnBook
(
    IN pBorrowingID INT,
    IN pReturnDate DATE
)
BEGIN
    DECLARE vBookID INT;

    SELECT BookID
    INTO vBookID
    FROM Borrowing
    WHERE BorrowingID = pBorrowingID
      AND ReturnDate IS NULL;

    IF vBookID IS NULL THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Borrowing not found or already returned';
    END IF;

    START TRANSACTION;

    UPDATE Borrowing
    SET ReturnDate = pReturnDate
    WHERE BorrowingID = pBorrowingID;

    UPDATE Books
    SET Quantity = Quantity + 1
    WHERE BookID = vBookID;

    COMMIT;
END$$

DELIMITER ;


-- -------------------------------------------
insert into books(Title, Author, Category, ISBN, PublishYear, Quantity)
VALUES ('Atomic Habbits','James','Self Development',12,'2000-05-18',20);

INSERT INTO Books (Title, Author, Category, ISBN, PublishYear, Quantity) VALUES
('The Alchemist', 'Paulo Coelho', 'Fiction', 0061122415, '1988-05-01', 15),
('Clean Code', 'Robert C. Martin', 'Programming', 0132350884, '2008-08-01', 10),
('The 7 Habits of Highly Effective People', 'Stephen R. Covey', 'Self Development', 0743269513, '1989-08-15', 25),
('To Kill a Mockingbird', 'Harper Lee', 'Fiction', 0060935467, '1960-07-11', 12),
('Deep Work', 'Cal Newport', 'Productivity', 1455586691, '2016-01-05', 18),
('Thinking, Fast and Slow', 'Daniel Kahneman', 'Psychology', 0374533557, '2011-10-25', 14),
('Introduction to Algorithms', 'Thomas H. Cormen', 'Programming', 0262033848, '2009-07-31', 8),
('The Power of Habit', 'Charles Duhigg', 'Self Development', 0812981605, '2012-02-28', 22),
('1984', 'George Orwell', 'Fiction', 0451524935, '1949-06-08', 30);

INSERT INTO Members (FullName, Email, Phone, MembershipDate)
 VALUES
('Alice Johnson', 'alice.johnson@example.com', '01234567890', '2025-01-15'),
('Bob Smith', 'bob.smith@example.com', '02345678901', '2025-02-10'),
('Clara Williams', 'clara.williams@example.com', '03456789012', '2025-03-05'),
('David Brown', 'david.brown@example.com', '04567890123', '2025-04-20'),
('Eva Davis', 'eva.davis@example.com', '05678901234', '2025-05-18'),
('Frank Miller', 'frank.miller@example.com', '06789012345', '2025-06-12'),
('Grace Wilson', 'grace.wilson@example.com', '07890123456', '2025-07-01'),
('Henry Moore', 'henry.moore@example.com', '08901234567', '2025-08-23'),
('Isabella Taylor', 'isabella.taylor@example.com', '09012345678', '2025-09-15'),
('Jack Anderson', 'jack.anderson@example.com', '01122334455', '2025-10-10');




call BorrowBook(1, 7);
call ReturnBook(13,'2026-02-10');
call BorrowBook(8, 8);
call ReturnBook(19,'1999-02-10');
call ReturnBook(2,'2026-05-06');
