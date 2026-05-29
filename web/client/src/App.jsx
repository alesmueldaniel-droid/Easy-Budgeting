import { useState, useEffect } from 'react'
import axios from 'axios'
import ExpenseList from './components/ExpenseList'
import AddExpenseForm from './components/AddExpenseForm'
import Statistics from './components/Statistics'
import './App.css'

const API_URL = 'http://localhost:5000/api'

function App() {
  const [expenses, setExpenses] = useState([])
  const [activeTab, setActiveTab] = useState('daily')
  const [showForm, setShowForm] = useState(false)

  useEffect(() => {
    fetchExpenses()
  }, [])

  const fetchExpenses = async () => {
    try {
      const response = await axios.get(`${API_URL}/expenses`)
      setExpenses(response.data)
    } catch (error) {
      console.error('Error fetching expenses:', error)
    }
  }

  const handleAddExpense = async (expenseData) => {
    try {
      await axios.post(`${API_URL}/expenses`, expenseData)
      fetchExpenses()
      setShowForm(false)
    } catch (error) {
      console.error('Error adding expense:', error)
    }
  }

  const handleDeleteExpense = async (id) => {
    try {
      await axios.delete(`${API_URL}/expenses/${id}`)
      fetchExpenses()
    } catch (error) {
      console.error('Error deleting expense:', error)
    }
  }

  const filteredExpenses = expenses.filter(exp => exp.type === activeTab)

  return (
    <div className="min-h-screen bg-gradient-to-br from-blue-50 to-indigo-100">
      {/* Header */}
      <header className="bg-gradient-to-r from-blue-600 to-indigo-600 text-white shadow-lg">
        <div className="max-w-6xl mx-auto px-4 py-8">
          <h1 className="text-4xl font-bold mb-2">💰 Easy Budgeting</h1>
          <p className="text-blue-100">Track your daily, monthly, and yearly expenses</p>
        </div>
      </header>

      {/* Main Content */}
      <main className="max-w-6xl mx-auto px-4 py-8">
        {/* Statistics */}
        <Statistics expenses={expenses} />

        {/* Tabs and Controls */}
        <div className="bg-white rounded-lg shadow-md p-6 mb-8">
          <div className="flex justify-between items-center mb-6">
            <div className="flex gap-4">
              {['daily', 'monthly', 'yearly'].map(tab => (
                <button
                  key={tab}
                  onClick={() => setActiveTab(tab)}
                  className={`px-6 py-2 rounded-lg font-semibold transition-all ${
                    activeTab === tab
                      ? 'bg-blue-600 text-white'
                      : 'bg-gray-200 text-gray-700 hover:bg-gray-300'
                  }`}
                >
                  {tab.charAt(0).toUpperCase() + tab.slice(1)}
                </button>
              ))}
            </div>
            <button
              onClick={() => setShowForm(!showForm)}
              className="bg-green-500 hover:bg-green-600 text-white px-6 py-2 rounded-lg font-semibold transition-all"
            >
              {showForm ? '✕ Close' : '+ Add Expense'}
            </button>
          </div>

          {/* Add Expense Form */}
          {showForm && (
            <AddExpenseForm
              onSubmit={handleAddExpense}
              defaultType={activeTab}
            />
          )}
        </div>

        {/* Expense List */}
        <ExpenseList
          expenses={filteredExpenses}
          onDelete={handleDeleteExpense}
          type={activeTab}
        />
      </main>
    </div>
  )
}

export default App
