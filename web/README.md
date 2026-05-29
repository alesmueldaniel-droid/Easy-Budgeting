# Easy Budgeting - Web Version

A modern web application for tracking daily, monthly, and yearly expenses.

## Tech Stack

- **Frontend**: React 18 + Vite + Tailwind CSS
- **Backend**: Node.js + Express
- **Database**: SQLite
- **Package Manager**: npm

## Features

✅ Track expenses by category
✅ View daily, monthly, and yearly expenses
✅ Add, edit, delete expenses
✅ Real-time statistics
✅ Responsive design
✅ RESTful API

## Installation & Setup

### Prerequisites
- Node.js 16+ installed
- npm or yarn

### Step 1: Clone Repository
```bash
git clone https://github.com/alesmueldaniel-droid/easy-budgeting.git
cd easy-budgeting/web
```

### Step 2: Install Dependencies

**Root level:**
```bash
npm install
```

**Frontend:**
```bash
cd client
npm install
cd ..
```

**Backend:**
```bash
cd server
npm install
cd ..
```

### Step 3: Run Development Server

**Option 1: Run both frontend and backend together**
```bash
npm run dev
```

**Option 2: Run separately**
```bash
# Terminal 1 - Backend
cd server
npm run dev

# Terminal 2 - Frontend
cd client
npm run dev
```

### Step 4: Open Browser
- Frontend: http://localhost:3000
- Backend API: http://localhost:5000/api

## API Endpoints

### Expenses
- `GET /api/expenses` - Get all expenses
- `GET /api/expenses/:id` - Get single expense
- `POST /api/expenses` - Create new expense
- `PUT /api/expenses/:id` - Update expense
- `DELETE /api/expenses/:id` - Delete expense

### Statistics
- `GET /api/stats/total-by-type/:type` - Get total by type
- `GET /api/stats/by-category/:type` - Get breakdown by category

## Build for Production

```bash
npm run build
```

This will create optimized production build in `client/dist` folder.

## Deploy to Internet

### Option 1: Vercel (Free)
1. Push code to GitHub
2. Visit https://vercel.com
3. Import repository
4. Deploy

### Option 2: Netlify (Free)
1. Build: `npm run build`
2. Visit https://netlify.com
3. Drag & drop `client/dist` folder

### Option 3: Railway.app (Free)
1. Visit https://railway.app
2. Connect GitHub
3. Deploy

## File Structure

```
web/
├── server/
│   ├── index.js
│   ├── package.json
│   └── budgeting.db
├── client/
│   ├── src/
│   │   ├── components/
│   │   │   ├── AddExpenseForm.jsx
│   │   │   ├── ExpenseList.jsx
│   │   │   └── Statistics.jsx
│   │   ├── App.jsx
│   │   ├── main.jsx
│   │   └── index.css
│   ├── index.html
│   ├── vite.config.js
│   ├── tailwind.config.js
│   └── package.json
├── package.json
└── README.md
```

## Troubleshooting

### Port already in use
```bash
# Change port in vite.config.js or express server
```

### Database errors
```bash
# Delete budgeting.db and restart server
rm server/budgeting.db
```

### CORS errors
- Make sure backend is running on http://localhost:5000
- Check API_URL in App.jsx

## License

MIT
