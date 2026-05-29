const Statistics = ({ expenses }) => {
  const calculateTotal = (type) => {
    return expenses
      .filter(exp => exp.type === type)
      .reduce((sum, exp) => sum + exp.amount, 0)
  }

  const dailyTotal = calculateTotal('daily')
  const monthlyTotal = calculateTotal('monthly')
  const yearlyTotal = calculateTotal('yearly')
  const grandTotal = dailyTotal + monthlyTotal + yearlyTotal

  const stats = [
    { label: 'Daily Total', value: dailyTotal, color: 'bg-blue-500', icon: '📅' },
    { label: 'Monthly Total', value: monthlyTotal, color: 'bg-green-500', icon: '📊' },
    { label: 'Yearly Total', value: yearlyTotal, color: 'bg-purple-500', icon: '📈' },
    { label: 'Grand Total', value: grandTotal, color: 'bg-orange-500', icon: '💰' },
  ]

  return (
    <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-6 mb-8">
      {stats.map((stat, index) => (
        <div
          key={index}
          className={`${stat.color} rounded-lg shadow-lg p-6 text-white`}
        >
          <div className="flex justify-between items-start">
            <div>
              <p className="text-sm opacity-90 mb-2">{stat.label}</p>
              <p className="text-3xl font-bold">
                Rp {stat.value.toLocaleString('id-ID')}
              </p>
            </div>
            <span className="text-3xl">{stat.icon}</span>
          </div>
        </div>
      ))}
    </div>
  )
}

export default Statistics
