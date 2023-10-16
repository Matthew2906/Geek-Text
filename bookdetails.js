const express = require('express');
const bodyParser = require('body-parser');
const mysql = require('mysql2/promise');

const app = express();

app.use(bodyParser.json());

// MySQL database connection configuration
const dbConfig = {
  host: 'localhost',
  user: 'team19admin',
  password: 'cen4010',
  database: 'team19server'
};

// Create a connection pool
const pool = mysql.createPool(dbConfig);

// Route to create a book
app.post('/books', async (req, res) => {
    const book = req.body;
    try {
        const [result] = await pool.execute(
            `INSERT INTO books (ISBN, name, description, price, author, genre, publisher, yearPublished, copiesSold) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)`,
            [book.ISBN, book.name, book.description, book.price, book.author, book.genre, book.publisher, book.yearPublished, book.copiesSold]
        );
        res.status(201).send('Book added successfully.');
    } catch (error) {
        console.error(error);
        res.status(500).send('Error adding book.');
    }
});

// retrieves a book by ISBN
app.get('/books/:isbn', async (req, res) => {
    const isbn = req.params.isbn;
    try {
        const [rows] = await pool.query(`SELECT * FROM books WHERE ISBN = ?`, [isbn]);
        if (rows.length) {
            res.json(rows[0]);
        } else {
            res.status(404).send('Book not found.');
        }
    } catch (error) {
        console.error(error);
        res.status(500).send('Error fetching book.');
    }
});

// creates an author
app.post('/authors', async (req, res) => {
    const author = req.body;
    try {
        const [result] = await pool.execute(
            `INSERT INTO authors (firstName, lastName, biography, publisher) VALUES (?, ?, ?, ?)`,
            [author.firstName, author.lastName, author.biography, author.publisher]
        );
        res.status(201).send('Author added successfully.');
    } catch (error) {
        console.error(error);
        res.status(500).send('Error adding author.');
    }
});

// Route to retrieve books by author ID
app.get('/authors/:authorId/books', async (req, res) => {
    const authorId = req.params.authorId;
    try {
        const [rows] = await pool.query(`SELECT * FROM books WHERE authorId = ?`, [authorId]);
        res.json(rows);
    } catch (error) {
        console.error(error);
        res.status(500).send('Error fetching books.');
    }
});

const PORT = 3000;
app.listen(PORT, () => {
    console.log(`Server started on http://localhost:${PORT}`);
});
