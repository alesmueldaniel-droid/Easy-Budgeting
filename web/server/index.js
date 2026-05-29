import express from 'express';
import cors from 'cors';
import bodyParser from 'body-parser';
import Database from 'better-sqlite3';
import path from 'path';
import { fileURLToPath } from 'url';

const __dirname = path.dirname(fileURLToPath(import.meta.url));
const app = express();
const PORT = process.env.PORT || 5000;

// Middleware
app.use(cors());
app.use(bodyParser.json());

// Initialize Database
const db = new Database(path.join(__dirname, 'budgeting.db'));

// Create tables if not exist
db.exec(`
  CREATE TABLE IF NOT EXISTS expenses (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    description TEXT NOT NULL,
    amount REAL NOT NULL,
    category TEXT NOT NULL,
    type TEXT NOT NULL,
    date INTEGER NOT NULL,
    createdAt INTEGER DEFAULT (strftime('%s', 'now'))
  );

  CREATE TABLE IF NOT EXISTS budgets (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    category TEXT NOT NULL,
    budgetAmount REAL NOT NULL,
    period TEXT NOT NULL,
    year INTEGER NOT NULL,
    month INTEGER,
    day INTEGER
  );
`);

// Routes - Expenses
app.get('/api/expenses', (req, res) => {
  try {
    const expenses = db.prepare('SELECT * FROM expenses ORDER BY date DESC').all();
    res.json(expenses);
  } catch (error) {
    res.status(500).json({ error: error.message });
  }
});

app.get('/api/expenses/:id', (req, res) => {
  try {
    const expense = db.prepare('SELECT * FROM expenses WHERE id = ?').get(req.params.id);
    if (!expense) {
      return res.status(404).json({ error: 'Expense not found' });
    }
    res.json(expense);
  } catch (error) {
    res.status(500).json({ error: error.message });
  }
});

app.post('/api/expenses', (req, res) => {
  try {
    const { description, amount, category, type, date } = req.body;
    const result = db.prepare(`
      INSERT INTO expenses (description, amount, category, type, date)
      VALUES (?, ?, ?, ?, ?)
    `).run(description, amount, category, type, date);
    
    res.status(201).json({ id: result.lastInsertRowid, ...req.body });
  } catch (error) {
    res.status(500).json({ error: error.message });
  }
});

app.put('/api/expenses/:id', (req, res) => {
  try {
    const { description, amount, category, type, date } = req.body;
    db.prepare(`
      UPDATE expenses
      SET description = ?, amount = ?, category = ?, type = ?, date = ?
      WHERE id = ?
    `).run(description, amount, category, type, date, req.params.id);
    
    res.json({ id: req.params.id, ...req.body });
  } catch (error) {
    res.status(500).json({ error: error.message });
  }
});

app.delete('/api/expenses/:id', (req, res) => {
  try {
    db.prepare('DELETE FROM expenses WHERE id = ?').run(req.params.id);
    res.json({ message: 'Expense deleted' });
  } catch (error) {
    res.status(500).json({ error: error.message });
  }
});

// Routes - Budgets
app.get('/api/budgets', (req, res) => {
  try {
    const budgets = db.prepare('SELECT * FROM budgets').all();
    res.json(budgets);
  } catch (error) {
    res.status(500).json({ error: error.message });
  }
});

app.post('/api/budgets', (req, res) => {
  try {
    const { category, budgetAmount, period, year, month, day } = req.body;
    const result = db.prepare(`
      INSERT INTO budgets (category, budgetAmount, period, year, month, day)
      VALUES (?, ?, ?, ?, ?, ?)
    `).run(category, budgetAmount, period, year, month, day);
    
    res.status(201).json({ id: result.lastInsertRowid, ...req.body });
  } catch (error) {
    res.status(500).json({ error: error.message });
  }
});

app.delete('/api/budgets/:id', (req, res) => {
  try {
    db.prepare('DELETE FROM budgets WHERE id = ?').run(req.params.id);
    res.json({ message: 'Budget deleted' });
  } catch (error) {
    res.status(500).json({ error: error.message });
  }
});

// Statistics
app.get('/api/stats/total-by-type/:type', (req, res) => {
  try {
    const result = db.prepare(
      'SELECT SUM(amount) as total FROM expenses WHERE type = ?'
    ).get(req.params.type);
    res.json(result);
  } catch (error) {
    res.status(500).json({ error: error.message });
  }
});

app.get('/api/stats/by-category/:type', (req, res) => {
  try {
    const result = db.prepare(`
      SELECT category, SUM(amount) as total
      FROM expenses
      WHERE type = ?
      GROUP BY category
    `).all(req.params.type);
    res.json(result);
  } catch (error) {
    res.status(500).json({ error: error.message });
  }
});

// Health check
app.get('/api/health', (req, res) => {
  res.json({ status: 'OK', message: 'Server is running' });
});

app.listen(PORT, () => {
  console.log(`✅ Server running at http://localhost:${PORT}`);
  console.log(`📊 API available at http://localhost:${PORT}/api`);
});
